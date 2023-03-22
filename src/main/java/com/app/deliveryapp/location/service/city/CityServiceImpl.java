package com.app.deliveryapp.location.service.city;

import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.location.dto.CreateUpdateCityRequestDTO;
import com.app.deliveryapp.location.model.City;
import com.app.deliveryapp.location.model.State;
import com.app.deliveryapp.location.repository.CityRepository;
import com.app.deliveryapp.location.repository.StateRepository;
import com.app.deliveryapp.location.service.state.StateService;
import com.app.deliveryapp.util.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final StateRepository stateRepository;

    private final StateService stateService;

    public CityServiceImpl(CityRepository cityRepository, StateRepository stateRepository, StateService stateService) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
        this.stateService = stateService;
    }

    @Override
    public City createCity(CreateUpdateCityRequestDTO requestDTO) {


        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getCityName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "city name cannot be null or empty!");
        }

        List<State> states = requestDTO.getStateNames().stream().map(stateService::findByName).collect(Collectors.toList());

        City city = new City();
        city.setName(requestDTO.getCityName());
        city.setStates(states);

        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }
}
