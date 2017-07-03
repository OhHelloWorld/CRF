package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.CaseDTO;
import app.dto.PageDTO;
import app.entities.CaseDO;
import app.repo.CaseRepo;
import app.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public PageDTO<CaseDTO> getCaseByProjectId(Long projectId, Long hospitalId, Pageable pageable) {
        return getPageDTO(caseRepo.findByProjectIdAndHospitalId(projectId, hospitalId, pageable));
    }

    public PageDTO<CaseDTO> getCaseByProjectIdAndCaseName(Long projectId, String caseName, Pageable pageable) {
        return getPageDTO(caseRepo.findByProjectIdAndCaseName(projectId, caseName, pageable));
    }

    @Override
    public PageDTO<CaseDTO> getCaseByProjectId(Long projectId, Pageable pageable) {
        return getPageDTO(caseRepo.getByProjectId(projectId, pageable));
    }

    public PageDTO<CaseDTO> getPageDTO(Page<CaseDO> page) {
        PageDTO<CaseDTO> pageDTO = new PageDTO<>();
        List<CaseDTO> caseDTOList = new ArrayList<>();
        for(CaseDO c : page.getContent()) {
            caseDTOList.add(convertUtil.convertToCaseDTO(c));
        }
        pageDTO.setTotalNumber(page.getTotalPages());
        pageDTO.setContent(caseDTOList);
        return  pageDTO;
    }
}
