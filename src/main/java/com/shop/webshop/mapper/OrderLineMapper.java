package com.shop.webshop.mapper;

import com.shop.webshop.dto.productdto.OrderLineCreateDto;
import com.shop.webshop.dto.productdto.OrderLineFullDto;
import com.shop.webshop.model.Order;
import com.shop.webshop.model.OrderLine;

public class OrderLineMapper {
    public static OrderLine orderLine(OrderLineCreateDto orderLineCreateDto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setOrder(orderLineCreateDto.getOrder());
        orderLine.setProduct(orderLineCreateDto.getProduct());
        orderLine.setNumberOfProducts(orderLineCreateDto.getNumberOfProducts());
        orderLine.setProductPrice(orderLineCreateDto.getProductPrice());

        return orderLine;
    }

    public static OrderLineFullDto orderLineFullDto(OrderLine orderLine) {
        OrderLineFullDto orderLineFullDto = new OrderLineFullDto();
        orderLineFullDto.setOrder(orderLine.getOrder());
        orderLineFullDto.setProduct(orderLine.getProduct());
        orderLineFullDto.setProductPrice(orderLine.getProductPrice());
        orderLineFullDto.setNumberOfProducts(orderLine.getNumberOfProducts());

        return orderLineFullDto;
    }
}
