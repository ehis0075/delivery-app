package com.app.deliveryapp.location.service.street;

import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.location.dto.CreateUpdateStreetRequestDTO;
import com.app.deliveryapp.location.model.City;
import com.app.deliveryapp.location.model.State;
import com.app.deliveryapp.location.model.Street;
import com.app.deliveryapp.location.repository.CityRepository;
import com.app.deliveryapp.location.repository.StateRepository;
import com.app.deliveryapp.location.repository.StreetRepository;
import com.app.deliveryapp.util.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class StreetServiceImpl implements StreetService{

    private final StreetRepository streetRepository;

    private final CityRepository cityRepository;

    private final StateRepository stateRepository;

    public StreetServiceImpl(StreetRepository streetRepository, CityRepository cityRepository, StateRepository stateRepository) {
        this.streetRepository = streetRepository;
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }


    @Override
    public Street createStreet(CreateUpdateStreetRequestDTO requestDTO) {

        // validate that city name is not null
        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getCityName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "city name cannot be null or empty!");
        }

        // validate that city exist
        if (!cityRepository.existsByName(requestDTO.getCityName())) {
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "city with name " + requestDTO.getCityName() + " cannot be found");
        }

        City city = cityRepository.findByName(requestDTO.getCityName());

        // validate that state name is not null
        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getStateName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "state name cannot be null or empty!");
        }

        // validate that state exist
        if (!stateRepository.existsByName(requestDTO.getStateName())) {
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "state with name " + requestDTO.getStateName() + " cannot be found");
        }

        State state = stateRepository.findByName(requestDTO.getStateName());

        Street street = new Street();
        street.setName(requestDTO.getStreetName());
        street.setCity(city);
        street.setState(state);

        return streetRepository.save(street);
    }

    @Override
    public List<Street> getAllStreet() {
        return streetRepository.findAll();
    }
}
