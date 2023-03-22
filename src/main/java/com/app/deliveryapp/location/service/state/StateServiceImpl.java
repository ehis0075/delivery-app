package com.app.deliveryapp.location.service.state;

import com.app.deliveryapp.location.dto.CreateUpdateStateRequestDTO;
import com.app.deliveryapp.location.model.State;
import com.app.deliveryapp.location.repository.StateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


    @Override
    public State createState(CreateUpdateStateRequestDTO requestDTO) {

        State state = new State();
        state.setName(requestDTO.getStateName());

        return stateRepository.save(state);
    }

    @Override
    public State findByName(String name) {
        return stateRepository.findByName(name);
    }

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
}
