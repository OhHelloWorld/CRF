package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.PageDTO;
import app.dto.PatientDTO;
import app.entities.PatientDO;
import app.repo.CaseRepo;
import app.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepo caseRepo;

    @Autowired
    private ConvertUtil convertUtil;

    public PageDTO<PatientDTO> getCaseByProjectId(Long projectId, Long hospitalId,
                                                  Pageable pageable) {
        return getPageDTO(caseRepo.findByProjectIdAndHospitalId(projectId, hospitalId, pageable));
    }

    public PageDTO<PatientDTO> getCaseByProjectIdAndCaseName(Long projectId, String caseName,
                                                             Pageable pageable) {
        return getPageDTO(caseRepo.findByProjectIdAndCaseName(projectId, caseName, pageable));
    }

    @Override
    public PageDTO<PatientDTO> getCaseByProjectId(Long projectId, Pageable pageable) {
        return getPageDTO(caseRepo.getByProjectId(projectId, pageable));
    }

    public PageDTO<PatientDTO> getPageDTO(Page<PatientDO> page) {
        PageDTO<PatientDTO> pageDTO = new PageDTO<>();
        List<PatientDTO> patientDTOList = new ArrayList<>();
        for (PatientDO c : page.getContent()) {
            patientDTOList.add(convertUtil.convertToPatientDTO(c));
        }
        pageDTO.setTotalNumber(page.getTotalPages());
        pageDTO.setContent(patientDTOList);
        return pageDTO;
    }

}