package com.shop.webshop.service.impl;

import com.shop.webshop.dto.productdto.ProductCreateDto;
import com.shop.webshop.dto.productdto.ProductFullDto;
import com.shop.webshop.mapper.ProductMapper;
import com.shop.webshop.model.Category;
import com.shop.webshop.model.Product;
import com.shop.webshop.repository.CategoryRepository;
import com.shop.webshop.repository.ProductRepository;
import com.shop.webshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductFullDto create(ProductCreateDto productCreateDto, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException(".."));
        Product product = ProductMapper.productToEntity(productCreateDto);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.productToFullDto(savedProduct);
    }

    @Override
    public ProductFullDto findById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id: " + id + " not found!"));
        return ProductMapper.productToFullDto(product);
    }

    @Override
    public List<ProductFullDto> findAll() {
        List<ProductFullDto> productList = new ArrayList<>();
        productRepository.findAll().forEach(entity -> {
            productList.add(ProductMapper.productToFullDto(entity));
        });
        return productList;
    }

    @Override
    public ProductFullDto update(ProductCreateDto productCreateDto) {
        Product product = ProductMapper.productToEntity(productCreateDto);
        Product updatedProduct = productRepository.save(product);
        return ProductMapper.productToFullDto(updatedProduct);
    }

    @Override
    public void delete(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id: " + id + " not found!"));
        productRepository.delete(product);
    }
}
