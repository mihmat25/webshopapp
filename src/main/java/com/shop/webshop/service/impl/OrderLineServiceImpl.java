package com.shop.webshop.service.impl;

import com.shop.webshop.dto.orderlinedto.OrderLineCreateDto;
import com.shop.webshop.dto.orderlinedto.OrderLineFullDto;
import com.shop.webshop.mapper.OrderLineMapper;
import com.shop.webshop.model.OrderLine;
import com.shop.webshop.repository.OrderLineRepository;
import com.shop.webshop.service.OrderLineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public OrderLineServiceImpl(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public OrderLineFullDto create(OrderLineCreateDto orderLineCreateDto) {
        OrderLine orderLine = OrderLineMapper.orderLineToEntity(orderLineCreateDto);
        OrderLine savedOrderLine = orderLineRepository.save(orderLine);
        return OrderLineMapper.orderLineToFullDto(savedOrderLine);
    }

    @Override
    public OrderLineFullDto findById(Integer id) {
        OrderLine orderLine = orderLineRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderLine with id: " + id + " not found!"));
        return OrderLineMapper.orderLineToFullDto(orderLine);
    }

    @Override
    public List<OrderLineFullDto> findAll() {
        List<OrderLineFullDto> orderLineList = new ArrayList<>();
        orderLineRepository.findAll().forEach(entity -> {
            orderLineList.add(OrderLineMapper.orderLineToFullDto(entity));
        });
        return orderLineList;
    }

    @Override
    public OrderLineFullDto update(OrderLineCreateDto orderLineCreateDto) {
        OrderLine orderLine = OrderLineMapper.orderLineToEntity(orderLineCreateDto);
        OrderLine updatedOrderLine = orderLineRepository.save(orderLine);
        return OrderLineMapper.orderLineToFullDto(updatedOrderLine);
    }

    @Override
    public void delete(Integer id) {
        OrderLine orderLine = orderLineRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderLine with id: " + id + " not found!"));
        orderLineRepository.delete(orderLine);
    }
}
