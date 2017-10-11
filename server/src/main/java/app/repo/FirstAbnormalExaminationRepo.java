package app.repo;

import app.dto.MedicineLiverFirstAbnormalExaminationDTO;
import app.entities.MedicineLiverFirstAbnormalExaminationDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.validation.ReportAsSingleViolation;
import java.util.List;

/**
 * Created by 10210 on 2017/9/7.
 */
public interface FirstAbnormalExaminationRepo extends CrudRepository<MedicineLiverFirstAbnormalExaminationDO, Long>{

    @Query(value = "select * from medicine_liver_first_abnormal_examination " +
            "where patient_id = ?1 and first = 1 order by id desc limit 1", nativeQuery = true)
    MedicineLiverFirstAbnormalExaminationDO getMsgByPID(Long pId);

    @Query(value = "select * from medicine_liver_first_abnormal_examination " +
            " where patient_id=?1 and first = 0", nativeQuery = true)
    List<MedicineLiverFirstAbnormalExaminationDO> getAllMlfaeData(Long pId);

    @Query(value = "select complete from medicine_liver_first_abnormal_examination where patient_id = ?1 and first = 1 order by id desc limit 1",nativeQuery = true)
    Boolean getCompleteByPatientId(int mlPatientId);

    @Query(value = "select * from medicine_liver_first_abnormal_examination where patient_id = ?1 and first = 0 order by id desc limit 1",nativeQuery = true)
    MedicineLiverFirstAbnormalExaminationDO getHosData(int mlPatientId);

    @Query(value = "select complete from medicine_liver_first_abnormal_examination where patient_id = ?1 and first = 0 order by id desc limit 1",nativeQuery = true)
    Boolean getHosCompleteByPatientId(int mlPatientId);

    @Query(value = "select complete from medicine_liver_first_abnormal_examination where patient_id = ?1 and first = 0 order by id desc limit 1",nativeQuery = true)
    Boolean getNoFirstCompleteByPatientId(int mlPatientId);
}
