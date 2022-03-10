package com.shop.webshop.mapper;

import com.shop.webshop.dto.productdto.CategoryCreateDto;
import com.shop.webshop.dto.productdto.CategoryFullDto;
import com.shop.webshop.model.Category;

public class CategoryMapper {
    public static Category category(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());

        return category;
    }

    public static CategoryFullDto categoryFullDto(Category category) {
        CategoryFullDto categoryFullDto = new CategoryFullDto();
        categoryFullDto.setName(categoryFullDto.getName());

        return categoryFullDto;
    }
}
