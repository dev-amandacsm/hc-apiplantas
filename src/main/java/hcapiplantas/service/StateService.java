package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.StateRequestDto;
import hcapiplantas.model.entity.State;

public interface StateService {
    State createState(StateRequestDto request) throws DataAlreadyExistsException;

    State getStateById(String acronym) throws DataNotFoundException;

    void deleteState(String acronym) throws DataNotFoundException;
}
