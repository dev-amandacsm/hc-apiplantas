package hcapiplantas.repository;

import hcapiplantas.model.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {
    Optional<State> findByAcronym(String acronym);

    Optional<State> findByName(String name);
}
