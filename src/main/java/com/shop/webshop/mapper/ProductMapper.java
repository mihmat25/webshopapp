package com.shop.webshop.mapper;

import com.shop.webshop.dto.productdto.ProductCreateDto;
import com.shop.webshop.dto.productdto.ProductFullDto;
import com.shop.webshop.model.Product;

public class ProductMapper {
    public static Product productToEntity(ProductCreateDto productCreateDto) {
        Product product = new Product();
        product.setName(productCreateDto.getName());
        product.setDescription(productCreateDto.getDescription());
        product.setThumbnail(productCreateDto.getThumbnail());
        product.setPrice(productCreateDto.getPrice());
        product.setStock(productCreateDto.getStock());

        return product;
    }

    public static ProductFullDto productToFullDto(Product product) {
        ProductFullDto productFullDto = new ProductFullDto();
        productFullDto.setId(product.getId());
        productFullDto.setName(product.getName());
        productFullDto.setDescription(product.getDescription());
        productFullDto.setThumbnail(product.getThumbnail());
        productFullDto.setCategoryId(product.getCategory().getId());
        productFullDto.setPrice(product.getPrice());
        productFullDto.setStock(product.getStock());

        return productFullDto;
    }

}
