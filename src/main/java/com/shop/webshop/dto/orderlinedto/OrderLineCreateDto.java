package com.shop.webshop.dto.orderlinedto;

import com.shop.webshop.model.Order;
import com.shop.webshop.model.Product;

public class OrderLineCreateDto {
    private Order order;
    private Product product;
    private Integer numberOfProducts;
    private Double productPrice;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

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
