package hcapiplantas.repository;

import hcapiplantas.model.entity.Symptom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SymptomRepository extends CrudRepository<Symptom, Long> {

    Optional<Symptom> findByName(String name);

}
