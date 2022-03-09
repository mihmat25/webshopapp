package com.shop.webshop.service.impl;

import com.shop.webshop.dto.productdto.ProductCreateDto;
import com.shop.webshop.dto.productdto.ProductFullDto;
import com.shop.webshop.mapper.productmapper.ProductMapper;
import com.shop.webshop.model.Product;
import com.shop.webshop.repository.ProductRepository;
import com.shop.webshop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductFullDto create(ProductCreateDto productCreateDto) {
        Product product = ProductMapper.productToEntity(productCreateDto);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.productToFullDto(savedProduct);
    }
}
