package app.controller;

import app.dto.CaseDTO;
import app.service.CaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
@RestController
@RequestMapping(path = "/api/case")
@Api(value = "病例")
public class CaseController {

    @Autowired
    private CaseService caseService;


    @GetMapping(value = "/{projectId}/{hospitalId}")
    @ApiOperation(value = "得到一个项目下医院下的病例")
    public List<CaseDTO> getCaseByProjectId(@PathVariable Long projectId, @PathVariable Long hospitalId) {
        return caseService.getCaseByProjectId(projectId, hospitalId);
    }

    @GetMapping(value = "")
    @ApiOperation(value = "通过项目id和病例名字项目下医院下的病例")
    public List<CaseDTO> getCaseByProjectId(@RequestParam Long projectId, @RequestParam String caseName) {
        return caseService.getCaseByProjectIdAndCaseName(projectId, caseName);
    }

    @GetMapping(value = "/{projectId}")
    @ApiOperation(value = "通过项目id得到的病例")
    public List<CaseDTO> getCaseByProjectId(@PathVariable Long projectId) {
        return caseService.getCaseByProjectId(projectId);
    }


}
