package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.entity.Restriction;

import java.util.Map;
import java.util.Optional;

public interface RestrictionService {

    Restriction createRestriction(Restriction restriction) throws DataAlreadyExistsException;

    Restriction getRestrictionById(Long id) throws DataNotFoundException;

    Restriction updateRestriction(Long id, Restriction convertToEntity) throws DataNotFoundException;

    Iterable<Restriction> getAllRestrictions();

    Optional<Restriction> getRestrictionByGroupName(String groupName);
}
