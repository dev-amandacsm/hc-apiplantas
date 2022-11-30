package hcapiplantas.repository;

import hcapiplantas.model.entity.District;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistrictRepository extends CrudRepository<District, Long> {
    Optional<District> findByName(String name);
}
