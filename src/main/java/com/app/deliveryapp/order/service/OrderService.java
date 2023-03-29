package com.app.deliveryapp.order.service;

import com.app.deliveryapp.order.dto.CreateOrderDTO;
import com.app.deliveryapp.order.dto.OrderResponseDTO;

public interface OrderService {

    OrderResponseDTO createOrder(CreateOrderDTO requestDTO);
}
