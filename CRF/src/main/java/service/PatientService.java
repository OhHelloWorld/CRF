package service;

import dto.PatientDTO;

public interface PatientService {

    /**
     * 存储患者一般资料
     * 
     * @param patientDTO
     */
    public void savePatientGeneralInformation(PatientDTO patientDTO);
}
