package com.shop.webshop.service;

import com.shop.webshop.dto.productdto.ProductCreateDto;
import com.shop.webshop.dto.productdto.ProductFullDto;
import com.shop.webshop.model.Product;

import java.util.List;

public interface ProductService {
    ProductFullDto create(ProductCreateDto productCreateDto);

    ProductFullDto findById(Integer id);

    List<ProductFullDto> findAll();

    ProductFullDto update(ProductCreateDto productCreateDto);

    void delete(Integer id);

    Product addProductToCategory(Integer productId, Integer categoryId);
}
