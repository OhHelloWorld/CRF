package app.service;

import org.springframework.data.domain.Pageable;

import app.dto.PageDTO;
import app.dto.PatientDTO;

import java.util.Date;
import java.util.Set;

public interface PatientService {

    /**
     * 存储患者一般资料
     * 
     * @param patientDTO
     */
    public int savePatientGeneralInformation(PatientDTO patientDTO);

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
    public Boolean getCompleteById(int id);

    /**
     * 得到所有患者的一般资料
     * 
     * @return
     */
    public PageDTO<PatientDTO> getAllPatient(int projectId,Pageable pageable);

    /**
     * 编辑患者的一般资料
     * 
     * @param patientDTO
     */
    public void editPatient(PatientDTO patientDTO);

    /**
     * 通过字符串进行查询
     * 
     * @param queryStr
     * @param pageable
     * @return
     */
    public PageDTO<PatientDTO> getPatientByQueryStr(int projectId ,String queryStr, Pageable pageable);

    /**
     * 得到所有随访的日期Set
     * @param patientId
     * @return
     */
    public Set<Date> getFollowDate(int patientId);


}
