//package app.repo;
//
//import app.entities.AdmissionDiagnosisDO;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
///**
// * Created by Administrator on 2017/8/31 0031.
// */
//public interface AdmissionDiagnosisRepo extends CrudRepository<AdmissionDiagnosisDO,Integer>{
//
//    @Query(value = "select * from admission_diagnosis where patient_id=?1",nativeQuery = true)
//    List<AdmissionDiagnosisDO> getAdmissioniByPatientId(int patientId);
//}
