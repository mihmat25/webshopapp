package com.shop.webshop.service.impl;

import com.shop.webshop.dto.orderdto.OrderCreateDto;
import com.shop.webshop.dto.orderdto.OrderFullDto;
import com.shop.webshop.exceptions.OutOfStockException;
import com.shop.webshop.mapper.OrderMapper;
import com.shop.webshop.model.*;
import com.shop.webshop.repository.OrderLineRepository;
import com.shop.webshop.repository.OrderRepository;
import com.shop.webshop.repository.ProductRepository;
import com.shop.webshop.repository.UserRepository;
import com.shop.webshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderLineRepository orderLineRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository, OrderLineRepository orderLineRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.orderLineRepository = orderLineRepository;
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
    public OrderFullDto addToCart(Integer orderId, Integer productId, Integer quantity) {
        Order order = orderRepository.getById(orderId);
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
        orderLine.setProductPrice(p.getPrice());

        List<OrderLine> newOrderLines = order.getOrderLines();
        newOrderLines.add(orderLine);
        order.setOrderLines(newOrderLines);

        double totalCost = 0.0;
        for (OrderLine orderLine1 : order.getOrderLines()) {
            double cost = orderLine1.getProductPrice() * orderLine1.getNumberOfProducts();
            totalCost += cost;
        }
        order.setTotalCost(totalCost);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.orderToFullDto(savedOrder);
    }

    public OrderFullDto checkOut(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("order not found"));
        order.setDateOfSubmission(LocalDateTime.now());
        for (OrderLine orderLine1 : order.getOrderLines()) {
            int currentStock = orderLine1.getProduct().getStock();
            int newStock = currentStock - orderLine1.getNumberOfProducts();
            if (newStock >= 0) {
                orderLine1.getProduct().setStock(newStock);
                productRepository.save(orderLine1.getProduct());
            } else {
                orderLine1.setNumberOfProducts(0);
                orderLineRepository.save(orderLine1);
                throw new OutOfStockException();
            }
        }
        order.setStatus(Status.CLOSED);
        Order newOrder = new Order();
        newOrder.setStatus(Status.ACTIVE);
        User user = userRepository.findByCurrentOrder(order);
        user.setCurrentOrder(newOrder);
        newOrder.setUser(user);
        userRepository.save(user);
        return OrderMapper.orderToFullDto(order);
    }
}
