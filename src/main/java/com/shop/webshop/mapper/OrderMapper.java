package com.shop.webshop.mapper;

import com.shop.webshop.dto.orderdto.OrderCreateDto;
import com.shop.webshop.dto.orderdto.OrderFullDto;
import com.shop.webshop.model.Order;

public class OrderMapper {
    public static Order orderToEntity(OrderCreateDto orderCreateDto) {

        Order order = new Order();
        order.setUser(orderCreateDto.getUser());
        order.setTotalCost(orderCreateDto.getTotalCost());
        order.setUserAddress(orderCreateDto.getUserAddress());
        order.setDateOfSubmission(orderCreateDto.getDateOfSubmission());
        order.setStatus(orderCreateDto.getStatus());

        return order;
    }

    public static OrderFullDto orderToFullDto(Order order) {

        OrderFullDto orderFullDto = new OrderFullDto();
        orderFullDto.setUser(order.getUser());
        orderFullDto.setUserAddress(order.getUserAddress());
        orderFullDto.setTotalCost(order.getTotalCost());
        orderFullDto.setDateOfSubmission(order.getDateOfSubmission());
        orderFullDto.setStatus(order.getStatus());

        return orderFullDto;
    }
}
