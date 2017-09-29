package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import app.dto.FourDiagnosticInformationDTO;
import app.service.FourDiagnosticInformationService;

/**
 * @author Administrator
 * @category 四诊信息表
 */
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

    /**
     * 得到所有四诊信息的随访表信息
     *
     * @param patientId
     * @return
     */
    @GetMapping(path = "/follow/{patientId}")
    public List<FourDiagnosticInformationDTO> getFollowFourDia(@PathVariable int patientId) {
        return fourDiagnosticInformationService.getFollowFourDia(patientId);
    }

    /**
     * 根据ID得到某次随访数据
     * @param id
     * @return
     */
    @GetMapping(path = "/singleFollow/{id}")
    public FourDiagnosticInformationDTO getSingleFollowById(@PathVariable int id) {
        return fourDiagnosticInformationService.getSingleFollowById(id);
    }

    /**
     * 得到最新的医院录入表信息
     *
     * @param patientId
     * @return
     */
    @GetMapping(path = "/default/{patientId}")
    public FourDiagnosticInformationDTO getDefaultFourDia(@PathVariable int patientId) {
        return fourDiagnosticInformationService.getDefaultFourDia(patientId);
    }

    /**
     * 跟新四诊信息
     * @param fourDiagnosticInformationDTO
     */
    @PutMapping(path = "")
    public void updateFourDia(@RequestBody FourDiagnosticInformationDTO fourDiagnosticInformationDTO){
        fourDiagnosticInformationService.updateFourDia(fourDiagnosticInformationDTO);
    }

    /**
     * 根据日期得到随访数据
     * @param date
     * @return
     */
    @GetMapping(path = "/follow")
    public FourDiagnosticInformationDTO getFollowFourByDate(@RequestParam  String date){
        return fourDiagnosticInformationService.getFollowFourByDate(date);
    }
}
