package com.app.deliveryapp.location.controller;

import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import com.app.deliveryapp.location.dto.CreateUpdateStreetRequestDTO;
import com.app.deliveryapp.location.model.Street;
import com.app.deliveryapp.location.service.street.StreetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/streets")
public class StreetController {

    private final GeneralService generalService;

    private final StreetService streetService;

    public StreetController(GeneralService generalService, StreetService streetService) {
        this.generalService = generalService;
        this.streetService = streetService;
    }

    @PostMapping("/create")
    public Response createStreet(@RequestBody CreateUpdateStreetRequestDTO requestDTO) {

        Street data = streetService.createStreet(requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @GetMapping()
    public Response getAllStreet() {

        List<Street> data = streetService.getAllStreet();
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
