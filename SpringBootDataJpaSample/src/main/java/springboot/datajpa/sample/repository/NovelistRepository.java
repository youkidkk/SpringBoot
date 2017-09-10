package springboot.datajpa.sample.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.datajpa.sample.entity.Novelist;

@SuppressWarnings("javadoc")
public interface NovelistRepository extends CrudRepository<Novelist, Integer> {

    public Novelist findByName(String name);

}
