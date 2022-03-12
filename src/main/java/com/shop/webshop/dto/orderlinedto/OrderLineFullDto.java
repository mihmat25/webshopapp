package com.shop.webshop.dto.orderlinedto;

import com.shop.webshop.dto.productdto.ProductResponseDto;
import com.shop.webshop.model.Order;
import com.shop.webshop.model.Product;

public class OrderLineFullDto {
    private Integer id;

    // STRONG separation between layers
    // ce avem in dto/controller <- expuse catre exterior
    // NU dorim legaturi directe cu layer-ul de model
    // in dto avem doar dtos

    private Integer orderId;
    private Integer productId;
    private Integer numberOfProducts;
    private Double productPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
