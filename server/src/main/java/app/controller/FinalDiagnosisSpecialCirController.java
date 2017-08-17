package app.controller;

import app.dto.FinalDiagnosisSpecialCircumstancesDTO;
import app.service.FinalDiaSpeCirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Administrator
 * @category 最后诊断及特殊情况信息
 */
@RestController
@RequestMapping(path = "/api/finalDiagnosisSpecialCircumstances")
public class FinalDiagnosisSpecialCirController {

    @Autowired
    FinalDiaSpeCirService fdscService;

    /**
     * save finalDiagnosisSpecialCircumstances informations
     */
    @PostMapping(path = "")
    public void saveFinalDiagnosisSpecialCircumstances(
            @RequestBody FinalDiagnosisSpecialCircumstancesDTO finalDTO) {
        fdscService.saveFinalDiagnosisSpecialCircumstances(finalDTO);
    }

    /**
     * get finalDiagnosisSpecialCircumstances informations by patientId
     */
    @GetMapping(path = "/{id}")
    public FinalDiagnosisSpecialCircumstancesDTO getInformation(@PathVariable Long id) {
        return fdscService.getInformation(id);
    }

    /**
     * 根据patientId得到最后诊断及特殊情况完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return fdscService.getCompleteByPatientId(patientId);
    }

}
