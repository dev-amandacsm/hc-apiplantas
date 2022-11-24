package hcapiplantas.service;

import hcapiplantas.exception.*;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.entity.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantService {
    Plant createPlant(PlantRequestDto plantRequestDto) throws CategoryNotFoundException, SymptomNotFoundException, RestrictionNotFoundException, DataAlreadyExistsException;

    Optional<Plant> getPlantByPopularName(String popularName);

    Optional<Plant> getPlantByScientificName(String scientificName);

    Plant getPlantById(Long id) throws DataNotFoundException;

    void deletePlant(Long id) throws DataNotFoundException;

    List<Plant> getPlantBySymptom(String symptom) throws DataNotFoundException, SymptomNotFoundException;

    List<Plant> getAll();

    List<Plant> getPlantByCategory(String category) throws CategoryNotFoundException, DataNotFoundException;
}
