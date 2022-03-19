package com.shop.webshop.mapper;

import com.shop.webshop.dto.orderdto.OrderCreateDto;
import com.shop.webshop.dto.orderdto.OrderFullDto;
import com.shop.webshop.dto.orderlinedto.OrderLineFullDto;
import com.shop.webshop.model.Order;
import com.shop.webshop.model.OrderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<OrderLineFullDto> orderLineFullDtoList = new ArrayList<>();

        OrderFullDto orderFullDto = new OrderFullDto();
        orderFullDto.setUserId(order.getUser().getId());
        orderFullDto.setUserAddress(order.getUserAddress());
        orderFullDto.setTotalCost(order.getTotalCost());
        orderFullDto.setDateOfSubmission(order.getDateOfSubmission());
        orderFullDto.setStatus(order.getStatus());
        for (OrderLine orderLine : order.getOrderLines()) {
            // orderLine -> orderLineFullDto
            OrderLineFullDto o = OrderLineMapper.orderLineToFullDto(orderLine);
            orderLineFullDtoList.add(o);
        }
        orderFullDto.setOrderLines(orderLineFullDtoList);


        // maparea tuturor orderline-urilor
//        order.getOrderLines().stream().map()

        return orderFullDto;

    }


}
