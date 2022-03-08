package com.shop.webshop.service.impl;

import com.shop.webshop.repository.OrderLineRepository;
import com.shop.webshop.service.OrderLineService;
import org.springframework.stereotype.Service;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public OrderLineServiceImpl(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }
}
