package com.app.deliveryapp.deliveryLocation.model;


import com.app.deliveryapp.location.model.Location;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DeliveryLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Location location;
}
