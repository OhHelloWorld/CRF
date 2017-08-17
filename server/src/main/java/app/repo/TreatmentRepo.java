package app.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.TreatmentProgramsDO;

public interface TreatmentRepo extends CrudRepository<TreatmentProgramsDO, Integer> {

    @Query(value = "select * from treatment_programs where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public TreatmentProgramsDO getTreatment(int patientId);

    @Query(value = "select qds_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getQdsDose(int patientId);

    @Query(value = "select qdsl_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getQdslDose(int patientId);

    @Query(value = "select jjq_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getJjqDose(int patientId);

    @Query(value = "select bdnd_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getBdndDose(int patientId);

    @Query(value = "select lcpl_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getLcplDose(int patientId);

    @Query(value = "select mtx_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getMtxDose(int patientId);

    @Query(value = "select cysa_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getCysaDose(int patientId);

    @Query(value = "select ctx_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getCtxDose(int patientId);

    @Query(value = "select mtmk_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getMtmkDose(int patientId);

    @Query(value = "select qsxs_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getQsxsDose(int patientId);

    @Query(value = "select xqyd_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getXqydDose(int patientId);

    @Query(value = "select fnbt_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getFnbtDose(int patientId);

    @Query(value = "select bzbt_dose from treatment_programs where patient_id=?1 order by id limit 7;",
            nativeQuery = true)
    public List<Float> getBzbtDose(int patientId);

    @Query(value = "select complete from treatment_programs where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);




    @Query(value = "select sum(qds_dose) from treatment_programs where patient_id = ?1",nativeQuery = true)
    public int getQdsDate(int patientId);

    @Query(value = "select qds_time from treatment_programs where patient_id = ?1 order by id limit 1",nativeQuery = true)
    public List<String> getStartTime(int patientId);

    @Query(value = "select qds_time from treatment_programs where patient_id = ?1 order by id limit 1",
            nativeQuery = true)
    public List<String> getStartTime(int patientId);

    @Query(value = "select qds_heal from treatment_programs where qds_time = ?1",
            nativeQuery = true)
    public List<Integer> getQdsWeeks(String startDate);

    @Query(value = "select qds_dose from treatment_programs where qds_time = ?1",
            nativeQuery = true)
    public List<Integer> getQdsDosage(String startDate);
}