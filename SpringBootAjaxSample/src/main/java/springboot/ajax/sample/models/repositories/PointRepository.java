package springboot.ajax.sample.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.ajax.sample.models.entities.Point;

/**
 * ポイントリポジトリー
 */
@Repository
public interface PointRepository
        extends JpaRepository<Point, Integer> {
}