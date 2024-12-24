package com.cnkart.order.service;


import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cnkart.order.dto.OrderRequest;
import com.cnkart.order.model.Order;
import com.cnkart.order.repository.OrderRepository;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        order.setSkuCode(orderRequest.getSkuCode());

        orderRepository.save(order);
        
        return "Order Placed";

    }
}
