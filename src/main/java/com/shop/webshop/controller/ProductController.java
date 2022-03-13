package com.shop.webshop.controller;

import com.shop.webshop.dto.productdto.ProductCreateDto;
import com.shop.webshop.dto.productdto.ProductFullDto;
import com.shop.webshop.mapper.ProductMapper;
import com.shop.webshop.model.Product;
import com.shop.webshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/webshopapp/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductFullDto> createProduct(@RequestBody ProductCreateDto productCreateDto) {
        ProductFullDto productFullDto = productService.create(productCreateDto);

        return ResponseEntity.ok(productFullDto);
    }

    @PutMapping("/addCategory")
    public ResponseEntity<ProductFullDto> addProductToCategory(@RequestParam Integer productId,
                                                               @RequestParam Integer categoryId) {
        Product product = productService.addProductToCategory(productId, categoryId);
        ProductFullDto productFullDto = ProductMapper.productToFullDto(product);

        return ResponseEntity.ok(productFullDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductFullDto>> findAll() {
        List<ProductFullDto> listOfProduct = productService.findAll();
        return ResponseEntity.ok(listOfProduct);
    }
}
