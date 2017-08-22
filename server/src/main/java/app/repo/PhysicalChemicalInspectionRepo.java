package app.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.PhysicalChemicalInspectionDO;

public interface PhysicalChemicalInspectionRepo
        extends CrudRepository<PhysicalChemicalInspectionDO, Integer> {

    @Query(value = "select * from physical_chemical_inspection where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public PhysicalChemicalInspectionDO getPhysicalByPatientId(int patientId);

    @Query(value = "select complete from physical_chemical_inspection where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public Boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from physical_chemical_inspection where follow_up = 1 and patient_id = ?1",
            nativeQuery = true)
    public List<PhysicalChemicalInspectionDO> getFollowphy(int patientId);

    @Query(value = "select * from physical_chemical_inspection where patient_id = ?1 and follow_up = 0 order by id desc limit 1",
            nativeQuery = true)
    public PhysicalChemicalInspectionDO getDefaultPhy(int patientId);
}
