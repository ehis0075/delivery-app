package com.app.deliveryapp.location.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String houseNo;

    @OneToOne
    private Street street;

    @OneToOne
    private City city;

    @OneToOne
    private State state;

}