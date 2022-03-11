package com.shop.webshop.service;

import com.shop.webshop.dto.orderdto.OrderCreateDto;
import com.shop.webshop.dto.orderdto.OrderFullDto;

import java.util.List;

public interface OrderService {


    OrderFullDto create(OrderCreateDto orderCreateDto);

    OrderFullDto findById(Integer id);

    List<OrderFullDto> findAll();

    OrderFullDto update(OrderCreateDto orderCreateDto);

    void delete(Integer id);
}
