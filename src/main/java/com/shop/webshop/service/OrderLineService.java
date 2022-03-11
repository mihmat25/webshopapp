package com.shop.webshop.service;

import com.shop.webshop.dto.orderlinedto.OrderLineCreateDto;
import com.shop.webshop.dto.orderlinedto.OrderLineFullDto;

import java.util.List;

public interface OrderLineService {

    OrderLineFullDto create(OrderLineCreateDto orderLineCreateDto);

    OrderLineFullDto findById(Integer id);

    List<OrderLineFullDto> findAll();

    OrderLineFullDto update(OrderLineCreateDto orderLineCreateDto);

    void delete(Integer id);
}
