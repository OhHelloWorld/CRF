package app.repo;

import app.entities.ProjectRoleDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface ProjectRoleRepo extends CrudRepository<ProjectRoleDO, Long> {

    ProjectRoleDO findByProjectRoleName(String name);


}
