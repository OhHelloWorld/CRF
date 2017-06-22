package app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.PatientInputModularEntryDO;

public interface PatientInputModularEntryRepo
        extends CrudRepository<PatientInputModularEntryDO, Integer> {

    @Query(value = "select * from patient_input_modular_entry where patient_id=?1 and information_id=?2",
            nativeQuery = true)
    public List<PatientInputModularEntryDO> getPatientInputModularEntryDOs(int patientId,
            int informationId);

}
