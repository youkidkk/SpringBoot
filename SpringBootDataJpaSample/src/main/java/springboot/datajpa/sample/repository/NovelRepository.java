package springboot.datajpa.sample.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.datajpa.sample.entity.Novel;

@SuppressWarnings("javadoc")
public interface NovelRepository extends CrudRepository<Novel, Integer> {

}
