package hcapiplantas.service;

import hcapiplantas.exception.CategoryNotFoundException;
import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.RestrictionNotFoundException;
import hcapiplantas.exception.SymptomNotFoundException;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.dto.PlantResponseDto;
import hcapiplantas.model.entity.Plant;

import java.util.Optional;

public interface PlantService {
    Plant createPlant(PlantRequestDto plantRequestDto) throws CategoryNotFoundException, SymptomNotFoundException, RestrictionNotFoundException, DataAlreadyExistsException;

    Optional<Plant> getPlantByPopularName(String popularName);

    Optional<Plant> getPlantByScientificName(String scientificName);
}
