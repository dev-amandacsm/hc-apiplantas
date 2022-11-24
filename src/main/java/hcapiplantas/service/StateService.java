package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.model.dto.StateRequestDto;
import hcapiplantas.model.entity.State;

public interface StateService {
    State createState(StateRequestDto request) throws DataAlreadyExistsException;
}
