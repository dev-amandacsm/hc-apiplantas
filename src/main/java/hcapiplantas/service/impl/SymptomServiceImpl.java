package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.model.entity.Symptom;
import hcapiplantas.repository.SymptomRepository;
import hcapiplantas.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomServiceImpl implements SymptomService {

    @Autowired
    private SymptomRepository repository;

    @Override
    public Symptom createSymptom(Symptom symptom) throws DataAlreadyExistsException {
        if(repository.findByName(symptom.getName()).isEmpty())
            return repository.save(symptom);
        throw new DataAlreadyExistsException(symptom.getName());
    }
}
