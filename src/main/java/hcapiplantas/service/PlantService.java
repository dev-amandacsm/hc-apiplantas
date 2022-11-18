package hcapiplantas.service;

import hcapiplantas.exception.*;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.dto.PlantResponseDto;
import hcapiplantas.model.entity.Plant;

import java.util.Optional;

public interface PlantService {
    Plant createPlant(PlantRequestDto plantRequestDto) throws CategoryNotFoundException, SymptomNotFoundException, RestrictionNotFoundException, DataAlreadyExistsException;

    Optional<Plant> getPlantByPopularName(String popularName);

    Optional<Plant> getPlantByScientificName(String scientificName);

    Plant getPlantById(Long id) throws DataNotFoundException;

    void deletePlant(Long id) throws DataNotFoundException;
}
