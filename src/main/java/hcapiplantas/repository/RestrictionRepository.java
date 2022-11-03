package hcapiplantas.repository;

import hcapiplantas.model.entity.Restriction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictionRepository extends CrudRepository<Restriction, Long> {

}
