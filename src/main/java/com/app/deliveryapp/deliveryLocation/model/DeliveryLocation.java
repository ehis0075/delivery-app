package com.app.deliveryapp.deliveryLocation.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DeliveryLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long locationId;
}
