package com.shop.webshop.mapper;

import com.shop.webshop.dto.orderlinedto.OrderLineCreateDto;
import com.shop.webshop.dto.orderlinedto.OrderLineFullDto;
import com.shop.webshop.model.OrderLine;

public class OrderLineMapper {
    public static OrderLine orderLineToEntity(OrderLineCreateDto orderLineCreateDto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setOrder(orderLineCreateDto.getOrder());
        orderLine.setProduct(orderLineCreateDto.getProduct());
        orderLine.setNumberOfProducts(orderLineCreateDto.getNumberOfProducts());
        orderLine.setProductPrice(orderLineCreateDto.getProductPrice());

        return orderLine;
    }

    public static OrderLineFullDto orderLineToFullDto(OrderLine orderLine) {
        OrderLineFullDto orderLineFullDto = new OrderLineFullDto();
        orderLineFullDto.setOrder(orderLine.getOrder());
        orderLineFullDto.setProduct(orderLine.getProduct());
        orderLineFullDto.setProductPrice(orderLine.getProductPrice());
        orderLineFullDto.setNumberOfProducts(orderLine.getNumberOfProducts());

        return orderLineFullDto;
    }
}
