package app.repo;

import app.entities.FinalDiagnosisSpecialCircumstancesDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 10210 on 2017/7/12.
 */
public interface FinalDiaSpeCirRepo
        extends CrudRepository<FinalDiagnosisSpecialCircumstancesDO, Integer> {

    @Query(value = "select * from final_diagnosis_special_circumstances where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public FinalDiagnosisSpecialCircumstancesDO getInformation(Long id);

    @Query(value = "select complete from final_diagnosis_special_circumstances where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);

}
