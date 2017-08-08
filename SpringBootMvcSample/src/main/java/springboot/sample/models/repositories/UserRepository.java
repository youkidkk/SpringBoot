package springboot.sample.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.sample.models.entities.User;

import java.util.List;

/**
 * ユーザーリポジトリー
 */
@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {

    /**
     * アカウントIDによる取得
     * @param accountId
     * @return ユーザー
     */
    public List<User> findByAccountId(String accountId);

}