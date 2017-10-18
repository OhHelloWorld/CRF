package app.service;

import app.dto.MlPatientDTO;
import app.entities.MlPatientDO;
import org.springframework.data.domain.Pageable;

import app.dto.PageDTO;

public interface MlPatientService {

    /**
     * 存储患者一般资料
     *
     * @param MlpatientDTO
     */
    int saveMlPatientGeneralInformation(MlPatientDTO MlpatientDTO);

    /**
     * 根据id得到患者一般资料
     *
     * @param id
     * @return
     */
    MlPatientDTO getMlPatientGeneralInformation(int id);

    /**
     * 得到患者的一般资料的填写状态
     *
     * @param id
     * @return
     */
    Boolean getCompleteById(int id);

    /**
     * 得到所有患者的一般资料
     *
     * @return
     */
    PageDTO<MlPatientDTO> getAllPatient(int projectId, Pageable pageable);

    /**
     * 编辑患者的一般资料
     *
     * @param mlPatientDTO
     */
    void editMlPatient(MlPatientDTO mlPatientDTO);

    /**
     * 通过字符串进行查询
     *
     * @param queryStr
     * @param pageable
     * @return
     */
    PageDTO<MlPatientDTO> getMlPatientByQueryStr(int projectId ,String queryStr, Pageable pageable);


    MlPatientDTO convertToMlPatientDTO(MlPatientDO mlPatientDO);
}
