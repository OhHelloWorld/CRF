package app.service;

import app.dto.PageDTO;
import app.dto.PatientDTO;
import org.springframework.data.domain.Pageable;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface CaseService {

    PageDTO<PatientDTO> getCaseByProjectId(Long projectId, Long hospitalId, Pageable pageable);

    PageDTO<PatientDTO> getCaseByProjectIdAndCaseName(Long projectId, String caseName,
            Pageable pageable);

    PageDTO<PatientDTO> getCaseByProjectId(Long projectId, Pageable pageable);
}
