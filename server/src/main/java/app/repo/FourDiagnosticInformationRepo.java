package app.repo;


import java.util.Date;
import java.util.List;
import java.util.Set;

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
    public Boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from four_diagnostic_information where follow_up = 1 and patient_id = ?1",
            nativeQuery = true)
    public List<FourDiagnosticInformationDO> getFollowFourDia(int patientId);

    @Query(value = "select * from four_diagnostic_information where patient_id = ?1 and follow_up = 0 order by id desc limit 1",
            nativeQuery = true)
    public FourDiagnosticInformationDO getDefaultFourDia(int patientId);

    @Query(value = "select distinct follow_up_date from four_diagnostic_information where follow_up = 1 and patient_id = ?1",nativeQuery = true)
    public Set<Date> getFollowDate(int patientId);

    @Query(value = "select * from four_diagnostic_information where follow_up_date = ?1 order by id desc limit 1",nativeQuery = true)
    public FourDiagnosticInformationDO getFollowFourByDate(String date);

}
