package com.app.deliveryapp.location.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private State state;

}