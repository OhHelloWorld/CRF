package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.FourDiagnosticInformationDTO;
import app.service.FourDiagnosticInformationService;

@RestController
@RequestMapping(path = "/api/fourDiagnosticInfor")
public class FourDiagnosticInformationController {

    @Autowired
    private FourDiagnosticInformationService fourDiagnosticInformationService;

    /**
     * 存储四诊信息采集量化表
     * 
     * @param fDto
     */
    @PostMapping(path = "")
    public void saveFourDiagnosticInformation(@RequestBody FourDiagnosticInformationDTO fDto) {
        fourDiagnosticInformationService.saveFourDiagnosticInformation(fDto);
    }

    /**
     * 查找四诊信息采集量化数据
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public FourDiagnosticInformationDTO getFourDiagnosticInfo(@PathVariable int patientId) {
        return fourDiagnosticInformationService.getFourDiagnosticInfoByPatientId(patientId);
    }

    /**
     * 根据患者Id查找四诊信息采集量化数据完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteById(@PathVariable int patientId) {
        return fourDiagnosticInformationService.getCompleteByPatientId(patientId);
    }
}
