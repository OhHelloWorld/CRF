package app.repo;

import app.entities.UserDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/20.
 */
public interface UserRepo extends CrudRepository<UserDO, Long> {

    UserDO findByAccount(String account);

    @Query(value = "select * from user u where " +
            "u.real_name like %?1% or " +
            "u.user_name like %?1% or" +
            " account like %?1%", nativeQuery = true)
    List<UserDO> findUserBySearchMsg(String msg);
}
