package com.shop.webshop.service;

import com.shop.webshop.dto.categorydto.CategoryCreateDto;
import com.shop.webshop.dto.categorydto.CategoryFullDto;

import java.util.List;

public interface CategoryService {

    CategoryFullDto create(CategoryCreateDto categoryCreateDto);

    CategoryFullDto findById(Integer id);

    List<CategoryFullDto> findAll();

    CategoryFullDto update(CategoryCreateDto categoryCreateDto);

    void delete(Integer id);
}
