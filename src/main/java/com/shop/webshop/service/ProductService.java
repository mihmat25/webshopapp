package com.shop.webshop.service;

import com.shop.webshop.dto.productdto.ProductCreateDto;
import com.shop.webshop.dto.productdto.ProductFullDto;

public interface ProductService {
    ProductFullDto create(ProductCreateDto productCreateDto);
}
