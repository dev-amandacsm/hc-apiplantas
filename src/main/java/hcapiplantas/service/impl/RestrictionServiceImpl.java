package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.entity.Restriction;
import hcapiplantas.repository.RestrictionRepository;
import hcapiplantas.service.RestrictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestrictionServiceImpl implements RestrictionService {

    @Autowired
    private RestrictionRepository repository;

    @Override
    public Restriction getRestrictionById(Long id) throws DataNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(id.toString()));
    }

    @Override
    public Iterable<Restriction> getAllRestrictions() {
        return repository.findAll();
    }

    @Override
    public Restriction createRestriction(Restriction restriction) throws DataAlreadyExistsException {
        if(repository.findByGroupName(restriction.getGroupName()).isEmpty())
            return repository.save(restriction);
        throw new DataAlreadyExistsException(restriction.getGroupName());
    }

    @Override
    public Restriction updateRestriction(Long id, Restriction restriction) throws DataNotFoundException {
        Restriction existingRestriction = getRestrictionById(id);
        existingRestriction.setGroupName(restriction.getGroupName());
        return repository.save(existingRestriction);
    }

    @Override
    public Optional<Restriction> getRestrictionByGroupName(String groupName){
        return repository.findByGroupName(groupName);
    }

}
