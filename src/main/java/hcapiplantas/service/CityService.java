package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.CityRequestDto;
import hcapiplantas.model.entity.City;

import java.util.List;

public interface CityService {

    City createCity(CityRequestDto request) throws DataNotFoundException, DataAlreadyExistsException;

    City getCityById(String id) throws DataNotFoundException;

    List<City> getAllCities();

    void deleteCity(Long id) throws DataNotFoundException;
}
