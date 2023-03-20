package com.app.deliveryapp.location.dto;


import lombok.Data;

@Data
public class CreateUpdateLocationRequestDTO {

    private String houseNo;

    private String streetName;

    private String cityName;

    private String stateName;
}
