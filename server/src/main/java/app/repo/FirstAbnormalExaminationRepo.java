package app.repo;

import app.entities.MedicineLiverFirstAbnormalExaminationDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.validation.ReportAsSingleViolation;

/**
 * Created by 10210 on 2017/9/7.
 */
public interface FirstAbnormalExaminationRepo extends CrudRepository<MedicineLiverFirstAbnormalExaminationDO, Long>{

    @Query(value = "select * from medicine_liver_first_abnormal_examination " +
            "where patient_id = ?1 order by id desc limit 1", nativeQuery = true)
    public MedicineLiverFirstAbnormalExaminationDO getMsgByPID(Long pId);

}
