package com.app.deliveryapp.general.service;


import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface GeneralService {
    boolean isStringInvalid(String string);

    Response prepareResponse(ResponseCodeAndMessage codeAndMessage, Object data);

    Response prepareResponse(String responseCode, String responseMessage, Object data);

    Pageable getPageableObject(int size, int page);

    Pageable getPageableObject(int size, int page, Sort sort);

    void createDTOFromModel(Object from, Object to);

    Response getResponse(String responseCode, String responseMessage, Object data);
}
