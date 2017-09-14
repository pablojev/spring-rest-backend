package pl.pawel.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pawel.entity.Animal;

/**
 * Created by pablojev on 26.07.2017.
 */
public interface AnimalRepository extends CrudRepository<Animal, Long> {

}
