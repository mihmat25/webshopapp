package com.shop.webshop.service.impl;

import com.shop.webshop.dto.orderdto.OrderCreateDto;
import com.shop.webshop.dto.orderdto.OrderFullDto;
import com.shop.webshop.dto.orderlinedto.OrderLineFullDto;
import com.shop.webshop.dto.productdto.ProductFullDto;
import com.shop.webshop.mapper.OrderMapper;
import com.shop.webshop.model.Order;
import com.shop.webshop.model.OrderLine;
import com.shop.webshop.model.Product;
import com.shop.webshop.repository.OrderRepository;
import com.shop.webshop.repository.ProductRepository;
import com.shop.webshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
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

//    @Override
//    public OrderFullDto update(OrderFullDto orderFullDto) {
//        Order order = OrderMapper.orderToEntity(orderFullDto);
//        Order updatedOrder = orderRepository.save(order);
//        return OrderMapper.orderToFullDto(updatedOrder);
//    }

//    @Override
//    public OrderFullDto update(OrderFullDto orderFullDto) {
//        Order order = OrderMapper.orderToEntity(orderFullDto);
//        Order updatedOrder = orderRepository.save(order);
//        return OrderMapper.orderToFullDto(updatedOrder);
//    }

    @Override
    public void delete(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with id: " + id + " not found!"));
        orderRepository.delete(order);
    }

    @Override
    public OrderFullDto addToCart(Integer orderId, Integer productId, Integer quantity) {
        // get the order
        Order order = orderRepository.getById(orderId);
        // daca prod exsita incrementam cantitatea
        for (OrderLine ol : order.getOrderLines()) {
            if (ol.getProduct().getId() == productId) {
                ol.setNumberOfProducts(ol.getNumberOfProducts() + quantity);
                Order savedOrder = orderRepository.save(order);
                return OrderMapper.orderToFullDto(savedOrder);
            }
        }
        OrderLine orderLine = new OrderLine();
        orderLine.setNumberOfProducts(quantity);
        Product p = productRepository.getById(productId);
        orderLine.setProduct(p);
        orderLine.setOrder(order);
        // update product price on shopping cart checkout
        orderLine.setProductPrice(p.getPrice());

        List<OrderLine> newOrderLines = order.getOrderLines();
        newOrderLines.add(orderLine);
        order.setOrderLines(newOrderLines);

        Order savedOrder = orderRepository.save(order);
        return OrderMapper.orderToFullDto(savedOrder);
    }
}
