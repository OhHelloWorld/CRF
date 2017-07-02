package app.repo;

import app.dto.PageDTO;
import app.dto.UserDTO;
import app.entities.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/20.
 */
public interface UserRepo extends CrudRepository<UserDO, Long> {

    UserDO findByAccount(String account);

    UserDO findByRealName(String realName);

    @Query(value = "select * from user u where " +
            "u.real_name like %?1% or " +
            "u.user_name like %?1% or" +
            " account like %?1%", nativeQuery = true)
    List<UserDO> findUserBySearchMsg(String msg);

    @Query(value = "select * from user where sys_role_id = 1 order by ?#{#pageable}", nativeQuery = true)
    Page<UserDO> getAllNormalUser(Pageable pageable);

    @Query(value = "select u.* from user u, user_project_role upr where u.id = upr.user_id and upr.project_id = ?1 order by ?#{#pageable}", nativeQuery = true)
    Page<UserDO> getUserByProjectDTO(Long projectId, Pageable pageable);
}
