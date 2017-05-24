package app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.PatientDTO;
import app.entities.PatientDO;
import app.repo.PatientRepo;
import app.service.PatientService;

/**
 * @author Administrator ����serviceImpl
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public void savePatientGeneralInformation(PatientDTO patientDTO) {
        patientRepo.save(convertToPatientDO(patientDTO));
    }

    public PatientDTO getPatientGeneralInformation(int id) {

        return convertToPatientDTO(patientRepo.getPatientInformationById(id));
    }

    /**
     * ��patientDTOת��ΪpatientDO
     */
    private PatientDO convertToPatientDO(PatientDTO patientDTO) {
        PatientDO patientDO = new PatientDO();
        patientDO.setIdentifier(patientDTO.getIdentifier());
        patientDO.setAge(patientDTO.getAge());
        patientDO.setChineseMedicineDiagnosis(patientDTO.getChineseMedicineDiagnosis());
        patientDO.setChineseMedicineTreatment(patientDTO.getChineseMedicineTreatment());
        patientDO.setCirrhosisDiagnosisTime(patientDTO.getCirrhosisDiagnosisTime());
        patientDO.setComplete(patientDTO.isComplete());
        patientDO.setDrink(patientDTO.isDrink());
        patientDO.setFamilyHistory(patientDTO.isFamilyHistory());
        patientDO.setGender(patientDTO.getGender());
        patientDO.setHeight(patientDTO.getHeight());
        patientDO.setHepatitisDiagnosisTime(patientDTO.getHepatitisDiagnosisTime());
        patientDO.setName(patientDTO.getName());
        patientDO.setSmoke(patientDTO.isSmoke());
        patientDO.setWeight(patientDTO.getWeight());
        patientDO.setWesternMedicineDiagnosis(patientDTO.getWesternMedicineDiagnosis());
        patientDO.setWesternMedicineTreatment(patientDTO.getWesternMedicineTreatment());
        return patientDO;
    }

    /**
     * ��patientDOת��ΪpatientDTO
     * 
     * @param patientDO
     * @return
     */
    private PatientDTO convertToPatientDTO(PatientDO patientDO) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setIdentifier(patientDO.getIdentifier());
        patientDTO.setId(patientDO.getId());
        patientDTO.setAge(patientDO.getAge());
        patientDTO.setChineseMedicineDiagnosis(patientDO.getChineseMedicineDiagnosis());
        patientDTO.setChineseMedicineTreatment(patientDO.getChineseMedicineTreatment());
        patientDTO.setCirrhosisDiagnosisTime(patientDO.getCirrhosisDiagnosisTime());
        patientDTO.setComplete(patientDO.isComplete());
        patientDTO.setDrink(patientDO.isDrink());
        patientDTO.setFamilyHistory(patientDO.isFamilyHistory());
        patientDTO.setGender(patientDO.getGender());
        patientDTO.setHeight(patientDO.getHeight());
        patientDTO.setHepatitisDiagnosisTime(patientDO.getHepatitisDiagnosisTime());
        patientDTO.setName(patientDO.getName());
        patientDTO.setSmoke(patientDO.isSmoke());
        patientDTO.setWeight(patientDO.getWeight());
        patientDTO.setWesternMedicineDiagnosis(patientDO.getWesternMedicineDiagnosis());
        patientDTO.setWesternMedicineTreatment(patientDO.getWesternMedicineTreatment());
        return patientDTO;
    }
}
