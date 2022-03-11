package com.shop.webshop.service.impl;

import com.shop.webshop.dto.orderdto.OrderCreateDto;
import com.shop.webshop.dto.orderdto.OrderFullDto;
import com.shop.webshop.mapper.OrderMapper;
import com.shop.webshop.model.Order;
import com.shop.webshop.repository.OrderRepository;
import com.shop.webshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderFullDto create(OrderCreateDto orderCreateDto) {
        Order order = OrderMapper.orderToEntity(orderCreateDto);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.orderToFullDto(savedOrder);
    }


    @Override
    public OrderFullDto findById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with id: " + id + " not found!"));
        return OrderMapper.orderToFullDto(order);
    }

    @Override
    public List<OrderFullDto> findAll() {
        List<OrderFullDto> orderList = new ArrayList<>();
        orderRepository.findAll().forEach(entity -> {
            orderList.add(OrderMapper.orderToFullDto(entity));
        });
        return orderList;
    }

    @Override
    public OrderFullDto update(OrderCreateDto orderCreateDto) {
        Order order = OrderMapper.orderToEntity(orderCreateDto);
        Order updatedOrder = orderRepository.save(order);
        return OrderMapper.orderToFullDto(updatedOrder);
    }

    @Override
    public void delete(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with id: " + id + " not found!"));
        orderRepository.delete(order);
    }
}
