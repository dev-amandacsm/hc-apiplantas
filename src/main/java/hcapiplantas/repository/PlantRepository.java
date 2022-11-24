package hcapiplantas.repository;

import hcapiplantas.model.entity.Category;
import hcapiplantas.model.entity.Plant;
import hcapiplantas.model.entity.Symptom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {

    Optional<Plant> findByPopularName(String popularName);

    Optional<Plant> findByScientificName(String scientificName);

    List<Plant> findBySymptoms(Symptom symptom);

    List<Plant> findByCategory(Category category);
}
