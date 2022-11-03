package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
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
    public Symptom getSymptomById(Long id) throws DataNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(id.toString()));
    }

    @Override
    public Symptom createSymptom(Symptom symptom) throws DataAlreadyExistsException {
        if(repository.findByName(symptom.getName()).isEmpty())
            return repository.save(symptom);
        throw new DataAlreadyExistsException(symptom.getName());
    }

    @Override
    public Symptom updateCategory(Long id, Symptom symptom) throws DataNotFoundException {
        Symptom existingSymptom = getSymptomById(id);
        existingSymptom.setName(symptom.getName());
        return repository.save(existingSymptom);
    }
}
