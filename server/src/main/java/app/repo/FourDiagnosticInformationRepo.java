package app.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.FourDiagnosticInformationDO;

@Repository
public interface FourDiagnosticInformationRepo
        extends CrudRepository<FourDiagnosticInformationDO, Integer> {

    @Query(value = "select * from four_diagnostic_information where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public FourDiagnosticInformationDO findFourDiagnosticInfoByPatientId(int patientId);

    @Query(value = "select complete from four_diagnostic_information where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from four_diagnostic_information where follow_up = 1 and patient_id = ?1",
            nativeQuery = true)
    public List<FourDiagnosticInformationDO> getFollowFourDia(int patientId);

    @Query(value = "select * from four_diagnostic_information where patient_id = ?1 and follow_up = 0 order by id desc limit 1",
            nativeQuery = true)
    public FourDiagnosticInformationDO getDefaultFourDia(int patientId);

}
