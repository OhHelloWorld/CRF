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

    @Query(value = "select count(*) from patient where gender like '%男%' and project_id=?1",
            nativeQuery = true)
    int getMan(Long projectId);

    @Query(value = "select count(*) from patient where gender like '%女%' and project_id=?1",
            nativeQuery = true)
    int getWoman(Long projectId);

    @Query(value = "select count(*) from patient where complete = 1 and project_id = ?1",
            nativeQuery = true)
    int getSaveCount(Long projectId);

    @Query(value = "select count(*) from patient where complete = 0 and project_id = ?1",
            nativeQuery = true)
    int getPushCount(Long projectId);

    @Query(value = "select count(*) from patient where project_id = ?1", nativeQuery = true)
    int getAllCount(Long projectId);

    @Query(value = "select count(*) from patient where project_id = ?1 and hospital_id=?2",
            nativeQuery = true)
    int getHospitalCount(Long projectId, Long hospitalId);

    @Query(value = "select count(*) from patient where project_id = ?1 and hospital_id=?2 and gender like '%男%'",
            nativeQuery = true)
    int getHospitalMan(Long projectId, Long hospitalId);

    @Query(value = "select count(*) from patient where project_id = ?1 and hospital_id=?2 and gender like '%女%'",
            nativeQuery = true)
    int getHospitalWoman(Long projectId, Long hospitalId);

    @Query(value = "select count(*) from medicine_liver_patient where gender like '%男%' and project_id=?1",
            nativeQuery = true)
    int getMlMan(Long projectId);

    @Query(value = "select count(*) from medicine_liver_patient where gender like '%女%' and project_id=?1",
            nativeQuery = true)
    int getMlWoman(Long projectId);

    @Query(value = "select count(*) from medicine_liver_patient where complete = 1 and project_id = ?1",
            nativeQuery = true)
    int getMlSaveCount(Long projectId);

    @Query(value = "select count(*) from medicine_liver_patient where complete = 0 and project_id = ?1",
            nativeQuery = true)
    int getMlPushCount(Long projectId);

    @Query(value = "select count(*) from medicine_liver_patient where project_id = ?1", nativeQuery = true)
    int getMlAllCount(Long projectId);

    @Query(value = "select count(*) from medicine_liver_patient where project_id = ?1 and hospital_id=?2",
            nativeQuery = true)
    int getMlHospitalCount(Long projectId, Long hospitalId);

    @Query(value = "select count(*) from medicine_liver_patient where project_id = ?1 and hospital_id=?2 and gender like '%男%'",
            nativeQuery = true)
    int getMlHospitalMan(Long projectId, Long hospitalId);

    @Query(value = "select count(*) from medicine_liver_patient where project_id = ?1 and hospital_id=?2 and gender like '%女%'",
            nativeQuery = true)
    int getMlHospitalWoman(Long projectId, Long hospitalId);
}

