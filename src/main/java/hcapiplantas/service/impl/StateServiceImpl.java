package hcapiplantas.service.impl;


import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.StateRequestDto;
import hcapiplantas.model.entity.State;
import hcapiplantas.repository.StateRepository;
import hcapiplantas.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository repository;

    @Override
    public State createState(StateRequestDto request) throws DataAlreadyExistsException {

        if(repository.findByAcronym(request.getAcronym()).isPresent())
            throw new DataAlreadyExistsException(request.getAcronym());
        if(repository.findByName(request.getName()).isPresent())
            throw new DataAlreadyExistsException(request.getName());

        State stateEntity = new State();
        stateEntity.setAcronym(request.getAcronym());
        stateEntity.setName(request.getName());

        return repository.save(stateEntity);
    }

    @Override
    public State getStateById(String acronym) throws DataNotFoundException {
        return repository.findByAcronym(acronym).orElseThrow(() -> new DataNotFoundException(acronym));
    }

    @Override
    public void deleteState(String acronym) throws DataNotFoundException {
        State state = this.getStateById(acronym);
        repository.delete(state);
    }

    @Override
    public List<State> getAllStates() {
        List<State> states = new ArrayList<>();
        repository.findAll().forEach(states::add);
        return states;
    }
}
