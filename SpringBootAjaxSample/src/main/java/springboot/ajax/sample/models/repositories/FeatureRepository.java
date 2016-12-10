package springboot.ajax.sample.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.ajax.sample.models.entities.Feature;

/**
 * フィーチャーリポジトリー
 */
@Repository
public interface FeatureRepository
		extends JpaRepository<Feature, Integer> {
}