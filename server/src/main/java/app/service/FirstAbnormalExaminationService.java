package app.service;

import app.dto.MedicineLiverFirstAbnormalExaminationDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by 10210 on 2017/9/7.
 */
public interface FirstAbnormalExaminationService {

    void addMsg(MedicineLiverFirstAbnormalExaminationDTO mlfaeDTO);

    MedicineLiverFirstAbnormalExaminationDTO getMsgByPID(Long pId);

    List<MedicineLiverFirstAbnormalExaminationDTO> getAllMlfaeData(Long pId);

    MedicineLiverFirstAbnormalExaminationDTO getHosData(int mlpatientId);

    Boolean getNoFirstCompleteByPatient(int mlPatientId);
}
