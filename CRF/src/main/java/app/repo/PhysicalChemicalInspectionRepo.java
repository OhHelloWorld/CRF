package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.PhysicalChemicalInspectionDO;

public interface PhysicalChemicalInspectionRepo
        extends CrudRepository<PhysicalChemicalInspectionDO, Integer> {

    @Query(value = "select * from physical_chemical_inspection where patient_id=?1",
            nativeQuery = true)
    public PhysicalChemicalInspectionDO getPhysicalByPatientId(int patientId);
}
