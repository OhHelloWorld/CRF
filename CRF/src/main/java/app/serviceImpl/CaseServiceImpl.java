package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.CaseDTO;
import app.entities.CaseDO;
import app.repo.CaseRepo;
import app.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepo caseRepo;

    @Autowired
    private ConvertUtil convertUtil;

    public List<CaseDTO> getCaseByProjectId(Long projectId, Long hospitalId) {
        List<CaseDTO> caseDTOList = new ArrayList<>();
        for(CaseDO c : caseRepo.findByProjectIdAndHospitalId(projectId, hospitalId)) {
            caseDTOList.add(convertUtil.convertToCaseDTO(c));
        }
        return caseDTOList;
    }

    public List<CaseDTO> getCaseByProjectIdAndCaseName(Long projectId, String caseName) {
        List<CaseDTO> caseDTOList = new ArrayList<>();
        for(CaseDO c : caseRepo.findByProjectIdAndCaseName(projectId, caseName)) {
            caseDTOList.add(convertUtil.convertToCaseDTO(c));
        }
        return caseDTOList;
    }
}
