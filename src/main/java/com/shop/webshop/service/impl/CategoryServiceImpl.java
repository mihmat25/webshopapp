package com.shop.webshop.service.impl;

import com.shop.webshop.dto.categorydto.CategoryCreateDto;
import com.shop.webshop.dto.categorydto.CategoryFullDto;
import com.shop.webshop.mapper.CategoryMapper;
import com.shop.webshop.model.Category;
import com.shop.webshop.repository.CategoryRepository;
import com.shop.webshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryFullDto create(CategoryCreateDto categoryCreateDto) {
        Category category = CategoryMapper.categoryToEntity(categoryCreateDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.categoryToFullDto(savedCategory);
    }

    @Override
    public CategoryFullDto findById(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id: " + id + " not found!"));
        return CategoryMapper.categoryToFullDto(category);
    }


    @Override
    public List<CategoryFullDto> findAll() {
        List<CategoryFullDto> categoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(entity -> {
            categoryList.add(CategoryMapper.categoryToFullDto(entity));
        });
        return categoryList;
    }

    @Override
    public CategoryFullDto update(CategoryCreateDto categoryCreateDto) {
        Category category = CategoryMapper.categoryToEntity(categoryCreateDto);
        Category updatedCategory = categoryRepository.save(category);
        return CategoryMapper.categoryToFullDto(updatedCategory);
    }

    @Override
    public void delete(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id: " + id + " not found!"));
        categoryRepository.delete(category);
    }
}
