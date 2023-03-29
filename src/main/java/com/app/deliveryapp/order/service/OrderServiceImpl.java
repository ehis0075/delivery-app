package com.app.deliveryapp.order.service;

import com.app.deliveryapp.order.dto.CreateOrderDTO;
import com.app.deliveryapp.order.dto.OrderResponseDTO;
import com.app.deliveryapp.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponseDTO createOrder(CreateOrderDTO requestDTO) {

        return null;
    }
}
