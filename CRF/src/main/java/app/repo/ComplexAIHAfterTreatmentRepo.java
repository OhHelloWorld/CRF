package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.ComplexAIHAfterTreatmentDO;

public interface ComplexAIHAfterTreatmentRepo
        extends CrudRepository<ComplexAIHAfterTreatmentDO, Integer> {

    @Query(value = "select * from complex_AIH_after_treatment where patient_id =?1 order by id desc limit 1",
            nativeQuery = true)
    public ComplexAIHAfterTreatmentDO getComplexAIHAfterTreatment(int patientId);

    @Query(value = "select complete from complex_AIH_after_treatment where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from complex_AIH_after_treatment where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public ComplexAIHAfterTreatmentDO getDefaultComplexAIHAfterTreatment(int patientId);
}
