package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.ComplexAIHBeforeTreatmentDO;

public interface ComplexAIHBeforeTreatmentRepo
        extends CrudRepository<ComplexAIHBeforeTreatmentDO, Integer> {

    @Query(value = "select * from complex_AIH_before_treatment where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public ComplexAIHBeforeTreatmentDO getComplexAIHBeforeTreatment(int patientId);

    @Query(value = "select complete from complex_AIH_before_treatment where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public Boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from complex_AIH_before_treatment where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public ComplexAIHBeforeTreatmentDO getDefaultComplexAIHBeforeTreatment(int patientId);

}
