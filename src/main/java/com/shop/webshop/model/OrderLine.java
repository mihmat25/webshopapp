package com.shop.webshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OrderLine {

    @Column(name = "product")
    private Product product;

    @Column(name = "number_of_products")
    private Integer numberOfProducts;

    @Column(name = "product_price")
    private Double productPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
