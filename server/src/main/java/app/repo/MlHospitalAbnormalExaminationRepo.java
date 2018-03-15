package app.repo;

import app.entities.MedicineLiverHospitalAbnormalExaminationDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public interface MlHospitalAbnormalExaminationRepo extends CrudRepository<MedicineLiverHospitalAbnormalExaminationDO,Integer>{

    @Query(value = "select * from medicine_liver_hospital_abnormal_examination where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverHospitalAbnormalExaminationDO getHospitalAbnormalExamByPatientId(int mlPatientId);

    @Query(value = "select complete from medicine_liver_hospital_abnormal_examination where patient_id = ?1 order by id limit 1",nativeQuery = true)
    Boolean getCompleteByPatientId(int mlPatientId);
}
