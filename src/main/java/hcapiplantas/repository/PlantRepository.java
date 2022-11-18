package hcapiplantas.repository;

import hcapiplantas.model.entity.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {

    Optional<Plant> findByPopularName(String popularName);

    Optional<Plant> findByScientificName(String scientificName);
}
