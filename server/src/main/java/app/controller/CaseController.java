package app.controller;

import app.dto.PageDTO;
import app.dto.PatientDTO;
import app.service.CaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 52400 on 2017/6/30.
 * 病例
 */
@RestController
@RequestMapping(path = "/api/case")
@Api(value = "病例")
public class CaseController {

    @Autowired
    private CaseService caseService;


    @GetMapping(value = "/{projectId}/{hospitalId}")
    @ApiOperation(value = "得到一个项目下医院下的病例")
    public PageDTO<PatientDTO> getCaseByProjectId(@PathVariable Long projectId,
            @PathVariable Long hospitalId, @PageableDefault(value = 5) Pageable pageable) {
        return caseService.getCaseByProjectId(projectId, hospitalId, pageable);
    }


    @GetMapping(value = "/search/{projectId}/{caseName}")
    @ApiOperation(value = "通过项目id和病例名字项目下医院下的病例")
    public PageDTO<PatientDTO> getCaseByProjectId(@PathVariable Long projectId,
            @PathVariable String caseName, @PageableDefault(value = 5) Pageable pageable) {
        return caseService.getCaseByProjectIdAndCaseName(projectId, caseName, pageable);
    }


    @GetMapping(value = "/{projectId}")
    @ApiOperation(value = "通过项目id得到的病例")
    public PageDTO<PatientDTO> getCaseByProjectId(@PathVariable Long projectId,
            @PageableDefault(value = 5) Pageable pageable) {
        return caseService.getCaseByProjectId(projectId, pageable);
    }


}
