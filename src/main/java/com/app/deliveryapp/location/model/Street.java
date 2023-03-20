package com.app.deliveryapp.location.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private City city;

    @OneToOne
    private State state;

}