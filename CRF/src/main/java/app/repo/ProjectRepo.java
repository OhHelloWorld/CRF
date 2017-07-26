package app.repo;

import app.entities.ProjectDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface ProjectRepo extends CrudRepository<ProjectDO, Long> {

    @Query(value = "select p.* from project p , user_project_role upr where upr.user_id = ?1 and upr.accept = 1 and upr.project_id = p.id",
            nativeQuery = true)
    List<ProjectDO> getListProject(Long userId);

    ProjectDO findByProjectName(String projectName);

    @Query(value = "select * from project where project_name like %?1%", nativeQuery = true)
    List<ProjectDO> getListProjectByMsg(String msg);

    @Query(value = "select count(*) from patient where gender like '%男%'", nativeQuery = true)
    int getMan();

    @Query(value = "select count(*) from patient where gender like '%女%'", nativeQuery = true)
    int getWoman();

    @Query(value = "select count(*) from patient where complete = 1", nativeQuery = true)
    int getSaveCount();

    @Query(value = "select count(*) from patient where complete = 0", nativeQuery = true)
    int getPushCount();

    @Query(value = "select count(*) from patient", nativeQuery = true)
    int getAllCount();

    @Query(value = "select count(*) from patient where hospital_id=?1", nativeQuery = true)
    int getHospitalCount(Long hospitalId);

    @Query(value = "select count(*) from patient where hospital_id=?1 and gender like '%男%'",
            nativeQuery = true)
    int getHospitalMan(Long hospitalId);

    @Query(value = "select count(*) from patient where hospital_id=?1 and gender like '%女%'",
            nativeQuery = true)
    int getHospitalWoman(Long hospitalId);
}

