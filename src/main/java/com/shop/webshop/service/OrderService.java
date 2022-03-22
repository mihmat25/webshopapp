package com.shop.webshop.service;

import com.shop.webshop.dto.orderdto.OrderCreateDto;
import com.shop.webshop.dto.orderdto.OrderFullDto;
import com.shop.webshop.model.Order;

import java.util.List;

public interface OrderService {


    OrderFullDto create(OrderCreateDto orderCreateDto);

    OrderFullDto findById(Integer id);

    List<OrderFullDto> findAll();

//    OrderFullDto update(OrderFullDto orderFullDto);

    OrderFullDto addToCart(Integer orderId, Integer productId, Integer quantity);

    OrderFullDto checkOut(Integer orderId);
}
