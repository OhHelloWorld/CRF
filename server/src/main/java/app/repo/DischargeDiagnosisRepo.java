package app.repo;

import app.entities.DischargeDiagnosisDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public interface DischargeDiagnosisRepo extends CrudRepository<DischargeDiagnosisDO,Integer>{

    @Query(value = "select * from admission_diagnosis where patient_id=?1",nativeQuery = true)
    List<DischargeDiagnosisDO> getDischargeByPatientId(int patientId);
}
