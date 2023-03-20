package com.app.deliveryapp.general.dto;

import lombok.Data;

@Data
public class Response {
    private String responseCode;

    private String responseMessage;

    private Object data;
}
