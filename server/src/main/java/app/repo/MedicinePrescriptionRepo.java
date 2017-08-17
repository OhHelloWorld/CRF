package app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.ChineseMedicinePrescriptionDO;

public interface MedicinePrescriptionRepo
        extends CrudRepository<ChineseMedicinePrescriptionDO, Integer> {

    @Query(value = "select * from chinese_medicine_prescription where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public ChineseMedicinePrescriptionDO getMedicinePrescription(int patientId);

    @Query(value = "select complete from chinese_medicine_prescription where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from chinese_medicine_prescription where follow_up = 1 and patient_id = ?1",
            nativeQuery = true)
    public List<ChineseMedicinePrescriptionDO> getFollowMedicine(int patientId);

    @Query(value = "select * from chinese_medicine_prescription where patient_id = ?1 and follow_up = 0 order by id desc limit 1",
            nativeQuery = true)
    public ChineseMedicinePrescriptionDO getDefaultMedicine(int patientId);
}
