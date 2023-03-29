package com.app.deliveryapp.order.repository;

import com.app.deliveryapp.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
