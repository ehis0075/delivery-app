package com.app.deliveryapp.Deliverylocation.dto;


import lombok.Data;

@Data
public class CreateUpdateLocationRequestDTO {

    private String houseNo;

    private String streetName;

    private String cityName;

    private String stateName;

    private String country;

    private String postalCode;
}
