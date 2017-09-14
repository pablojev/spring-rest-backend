package pl.pawel.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pawel.entity.Specie;

/**
 * Created by pablojev on 26.07.2017.
 */
public interface SpecieRepository extends CrudRepository<Specie, Long> {

}
