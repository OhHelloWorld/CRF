package app.repo;

import app.entities.UserDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 10210 on 2017/6/7.
 */
public interface LoginRepo extends CrudRepository<UserDO, Integer> {

    @Modifying
    @Transactional
    @Query(value = "select * from users where account = ?1 and password = ?2", nativeQuery = true)
    List<UserDO> inputCompareToDatabase(String account, String password);

    UserDO findByAccount(String account);

}
