package com.app.deliveryapp.Deliverylocation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String houseNo;

    private String street;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private LocalDateTime createdDate;

    private String createdBy;

}