package com.app.deliveryapp.location.service.state;

import com.app.deliveryapp.location.dto.CreateUpdateStateRequestDTO;
import com.app.deliveryapp.location.model.State;
import com.app.deliveryapp.location.model.Street;

import java.util.List;

public interface StateService {

    State createState(CreateUpdateStateRequestDTO requestDTO);

    State findByName(String name);

    List<State> getAllStates();


}
