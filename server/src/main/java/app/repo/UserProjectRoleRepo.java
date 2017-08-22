package app.repo;

import app.entities.UserProjectRoleDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface UserProjectRoleRepo extends CrudRepository<UserProjectRoleDO, Long> {

    @Query(value = "select * from user_project_role where user_id = ?1 and project_id = ?2", nativeQuery = true)
    UserProjectRoleDO getRoleId(Long userId, Long projectId);

    List<UserProjectRoleDO> findByProjectId(Long projectId);

    @Query(value = "select user_id from user_project_role where project_id = ?1 and accept = 1",nativeQuery = true)
    List<Integer> getUserIdByProjectId(int projectId);


}
