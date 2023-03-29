package com.app.deliveryapp.order.dto;

import lombok.Data;

@Data
public class CreateOrderDTO {

    private String phoneNumber;

    private Long pickUpLocationId;

    private Long deliveryLocationId;
}
