package app.repo;

import app.entities.UserDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 52400 on 2017/6/20.
 */
public interface UserRepo extends CrudRepository<UserDO, Long> {

    UserDO findByAccount(String account);
}
