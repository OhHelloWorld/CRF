package app.service;

import java.util.List;

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

    /**
     * 得到患者的一般资料的填写状态
     * 
     * @param id
     * @return
     */
    public boolean getCompleteById(int id);

    /**
     * 得到所有患者的一般资料
     * 
     * @return
     */
    public List<PatientDTO> getAllPatient();

    /**
     * 编辑患者的一般资料
     * 
     * @param patientDTO
     */
    public void editPatient(PatientDTO patientDTO);

}
