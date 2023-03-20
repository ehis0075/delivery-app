package com.app.deliveryapp.location.service.city;

import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.location.dto.CreateUpdateCityRequestDTO;
import com.app.deliveryapp.location.model.City;
import com.app.deliveryapp.location.model.State;
import com.app.deliveryapp.location.repository.CityRepository;
import com.app.deliveryapp.location.repository.StateRepository;
import com.app.deliveryapp.util.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final StateRepository stateRepository;

    public CityServiceImpl(CityRepository cityRepository, StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public City createCity(CreateUpdateCityRequestDTO requestDTO) {

        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getStateName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "state name cannot be null or empty!");
        }

        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getCityName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "city name cannot be null or empty!");
        }

        if (!stateRepository.existsByName(requestDTO.getStateName())) {
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "state with name " + requestDTO.stateName + " cannot be found");
        }

        State state = stateRepository.findByName(requestDTO.getStateName());

        City city = new City();
        city.setName(requestDTO.getCityName());
        city.setState(state);

        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }
}
