package app.service;

import app.dto.PatientDTO;

public interface PatientService {

    /**
     * 存储患者一般资料
     * 
     * @param patientDTO
     */
    public void savePatientGeneralInformation(PatientDTO patientDTO);

    /**
     * 根据id得到患者一般资料
     * 
     * @param id
     * @return
     */
    public PatientDTO getPatientGeneralInformation(int id);

}
