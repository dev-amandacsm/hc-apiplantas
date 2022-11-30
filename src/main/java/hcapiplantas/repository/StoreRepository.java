package hcapiplantas.repository;

import hcapiplantas.model.entity.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
    Optional<Store> findByName(String name);
    @Query(value = "SELECT * FROM tb_loja LIMIT ?1", nativeQuery = true)
    List<Store> findAllLimited(Long numberOfResults);
}
