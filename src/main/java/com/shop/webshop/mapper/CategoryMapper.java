package com.shop.webshop.mapper;

import com.shop.webshop.dto.categorydto.CategoryCreateDto;
import com.shop.webshop.dto.categorydto.CategoryFullDto;
import com.shop.webshop.model.Category;

public class CategoryMapper {
    public static Category categoryToEntity(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());

        return category;
    }

    public static CategoryFullDto categoryToFullDto(Category category) {
        CategoryFullDto categoryFullDto = new CategoryFullDto();
        categoryFullDto.setId(category.getId());
        categoryFullDto.setName(category.getName());

        return categoryFullDto;
    }
}
