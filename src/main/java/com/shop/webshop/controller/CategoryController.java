package com.shop.webshop.controller;

import com.shop.webshop.dto.categorydto.CategoryCreateDto;
import com.shop.webshop.dto.categorydto.CategoryFullDto;
import com.shop.webshop.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webshopapp/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryFullDto> createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        CategoryFullDto createdCategory = categoryService.create(categoryCreateDto);
        return ResponseEntity.ok(createdCategory);
    }
}
