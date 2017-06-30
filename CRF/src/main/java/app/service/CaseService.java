package app.service;

import app.dto.CaseDTO;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface CaseService {

    List<CaseDTO> getCaseByProjectId(Long projectId, Long hospitalId);

    public List<CaseDTO> getCaseByProjectIdAndCaseName(Long projectId, String caseName);
}
