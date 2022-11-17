package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.entity.Symptom;

import java.util.Optional;

public interface SymptomService {
    Symptom createSymptom(Symptom symptom) throws DataAlreadyExistsException;

    Symptom getSymptomById(Long id) throws DataNotFoundException;

    Symptom updateCategory(Long id, Symptom symptom) throws DataNotFoundException;

    Iterable<Symptom> getAllSymptoms();

    Optional<Symptom> getSymptomByName(String name) throws DataNotFoundException;
}
