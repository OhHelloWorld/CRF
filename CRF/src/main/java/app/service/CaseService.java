package app.service;

import app.dto.CaseDTO;
import app.dto.PageDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface CaseService {

    PageDTO<CaseDTO> getCaseByProjectId(Long projectId, Long hospitalId, Pageable pageable);

    PageDTO<CaseDTO> getCaseByProjectIdAndCaseName(Long projectId, String caseName, Pageable pageable);

    PageDTO<CaseDTO> getCaseByProjectId(Long projectId, Pageable pageable);
}
