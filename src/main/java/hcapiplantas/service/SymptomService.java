package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.model.entity.Symptom;

public interface SymptomService {
    Symptom createSymptom(Symptom symptom) throws DataAlreadyExistsException;
}
