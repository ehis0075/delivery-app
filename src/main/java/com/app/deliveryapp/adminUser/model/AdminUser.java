package com.app.deliveryapp.adminUser.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

}
