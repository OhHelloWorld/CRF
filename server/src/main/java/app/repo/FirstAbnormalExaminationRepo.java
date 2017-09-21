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
    public MedicineLiverFirstAbnormalExaminationDO getMsgByPID(Long pId);

    @Query(value = "select * from medicine_liver_first_abnormal_examination " +
            " where patient_id=?1 and first = 0", nativeQuery = true)
    public List<MedicineLiverFirstAbnormalExaminationDO> getAllMlfaeData(Long pId);

    @Query(value = "select complete from medicine_liver_first_abnormal_examination where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    public Boolean getCompleteByPatientId(int mlPatientId);

    @Query(value = "select * from medicine_liver_first_abnormal_examination where patient_id = ?1 and first = 0 order by id desc limit 1",nativeQuery = true)
    public MedicineLiverFirstAbnormalExaminationDO getHosData(int mlPatientId);

}
