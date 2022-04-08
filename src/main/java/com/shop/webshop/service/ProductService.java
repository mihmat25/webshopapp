package com.shop.webshop.service;

import com.shop.webshop.dto.productdto.ProductCreateDto;
import com.shop.webshop.dto.productdto.ProductFullDto;

import java.util.List;

public interface ProductService {
    ProductFullDto create(ProductCreateDto productCreateDto, Integer categoryId);

    ProductFullDto findById(Integer id);

    List<ProductFullDto> findAll();

    ProductFullDto update(ProductCreateDto productCreateDto);

    void delete(Integer id);
}
