package hcapiplantas.service.impl;

import hcapiplantas.exception.*;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.dto.SymptomRequestDto;
import hcapiplantas.model.entity.Plant;
import hcapiplantas.model.entity.Restriction;
import hcapiplantas.model.entity.Symptom;
import hcapiplantas.repository.CategoryRepository;
import hcapiplantas.repository.PlantRepository;
import hcapiplantas.repository.RestrictionRepository;
import hcapiplantas.repository.SymptomRepository;
import hcapiplantas.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private RestrictionRepository restrictionRepository;

    @Override
    public Plant createPlant(PlantRequestDto plantRequestDto) throws CategoryNotFoundException, RestrictionNotFoundException, SymptomNotFoundException, DataAlreadyExistsException {
        if(repository.findByPopularName(plantRequestDto.getPopularName()).isPresent()){
            throw new DataAlreadyExistsException(plantRequestDto.getPopularName());
        }

        if(repository.findByScientificName(plantRequestDto.getScientificName()).isPresent()){
            throw new DataAlreadyExistsException(plantRequestDto.getScientificName());
        }

        Plant plantEntity = new Plant();
        plantEntity.setPopularName(plantRequestDto.getPopularName());
        plantEntity.setScientificName(plantRequestDto.getScientificName());
        plantEntity.setRecipe(plantRequestDto.getRecipe());
        plantEntity.setCategory(categoryRepository.findById(plantRequestDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(plantRequestDto.getCategoryId().toString())));

        for(Restriction r : plantRequestDto.getRestrictions()){
            Optional<Restriction> restriction = restrictionRepository.findByGroupName(r.getGroupName());
            if(restriction.isEmpty()){
                throw new RestrictionNotFoundException(r.getGroupName());
            }
            plantEntity.addRestriction(restriction.get());
        }

        for(SymptomRequestDto s : plantRequestDto.getSymptoms()){
            Optional<Symptom> symptom = symptomRepository.findByName(s.getName());
            if(symptom.isEmpty()){
                throw new SymptomNotFoundException(s.getName());
            }
            plantEntity.addSymptom(symptom.get());
        }

        return repository.save(plantEntity);

    }

    @Override
    public Optional<Plant> getPlantByPopularName(String popularName){
        return repository.findByPopularName(popularName);
    }

    @Override
    public Optional<Plant> getPlantByScientificName(String scientificName) {
        return repository.findByScientificName(scientificName);
    }

    @Override
    public Plant getPlantById(Long id) throws DataNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(id.toString()));
    }

    @Override
    public void deletePlant(Long id) throws DataNotFoundException {
        Plant plant = this.getPlantById(id);
        repository.delete(plant);
    }

    @Override
    public List<Plant> getPlantBySymptom(String symptom) throws DataNotFoundException, SymptomNotFoundException {
        Symptom symptomEntity = symptomRepository.findByName(symptom).orElseThrow(() -> new SymptomNotFoundException(symptom));
        List<Plant> plants = repository.findBySymptoms(symptomEntity);
        if(plants.isEmpty())
            throw new DataNotFoundException(symptom);
        return plants;
    }

    @Override
    public List<Plant> getAll() {
        List<Plant> plants = new ArrayList<>();
        repository.findAll().forEach(plants::add);
        return plants;
    }
}
