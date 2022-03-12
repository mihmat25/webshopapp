package com.shop.webshop.mapper;

import com.shop.webshop.dto.orderlinedto.OrderLineCreateDto;
import com.shop.webshop.dto.orderlinedto.OrderLineFullDto;
import com.shop.webshop.dto.productdto.ProductResponseDto;
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
        // set the id
        orderLineFullDto.setOrderId(orderLine.getOrder().getId());
        orderLineFullDto.setProductId(orderLine.getProduct().getId());
        orderLineFullDto.setProductPrice(orderLine.getProductPrice());
        orderLineFullDto.setNumberOfProducts(orderLine.getNumberOfProducts());

        return orderLineFullDto;
    }
}
