package com.app.deliveryapp.location.controller;

import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import com.app.deliveryapp.location.model.State;
import com.app.deliveryapp.location.service.state.StateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/states")
public class StateController {

    private final GeneralService generalService;

    private final StateService stateService;

    public StateController(GeneralService generalService, StateService stateService) {
        this.generalService = generalService;
        this.stateService = stateService;
    }

    @PostMapping("/create")
    public Response createState(@RequestBody State requestDTO) {

        State data = stateService.createState(requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @GetMapping()
    public Response getAllStates() {

        List<State> data = stateService.getAllStates();
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
