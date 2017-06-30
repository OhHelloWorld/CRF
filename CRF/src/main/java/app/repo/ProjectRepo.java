package app.repo;

import app.entities.ProjectDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface ProjectRepo extends CrudRepository<ProjectDO, Long>{

    @Query(value = "select p.* from project p , user_project_role upr where upr.user_id = ?1 and upr.project_id = p.id", nativeQuery = true)
    List<ProjectDO> getListProject(Long userId);

    ProjectDO findByProjectName(String projectName);
}
