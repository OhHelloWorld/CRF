package app.repo;

import app.dto.MedicineLiverRoutineBloodDTO;
import app.entities.MedicineLiverRoutineBloodDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 10210 on 2017/9/14.
 */
public interface MlRoutineBooldRepo extends CrudRepository<MedicineLiverRoutineBloodDO, Long>{

    @Query(value = "select * from medicine_liver_routine_blood where patient_id = ?1" +
            " order by id desc limit 1;", nativeQuery = true)
    public MedicineLiverRoutineBloodDO getRoutineByPid(Long pId);
}
