package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.ComplexAIHAfterTreatmentDTO;
import app.service.ComplexAIHAfterTreatmentService;

/**
 * @author Administrator
 * @category 治疗后复杂AIH信息
 */
@RestController
@RequestMapping(path = "/api/complexAIHAfterTreatment")
public class ComplexAIHAfterTreatmentController {

    @Autowired
    private ComplexAIHAfterTreatmentService complexAIHAfterTreatmentService;

    /**
     * 存储治疗后复杂AIH信息
     * 
     * @param complexAIHAfterTreatmentDTO
     */
    @PostMapping(path = "")
    public void saveComplexAIHBeforeTreatment(
            @RequestBody ComplexAIHAfterTreatmentDTO complexAIHAfterTreatmentDTO) {
        complexAIHAfterTreatmentService.saveComplexAIHAfterTreatment(complexAIHAfterTreatmentDTO);
    }

    /**
     * 根据patientId得到治疗后复杂AIH信息
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public ComplexAIHAfterTreatmentDTO getComplexAIHAfterTreatment(@PathVariable int patientId) {
        return complexAIHAfterTreatmentService.getComplexAIHAfterTreatment(patientId);
    }

    /**
     * 根据patientId得到治疗后复杂AIH信息完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return complexAIHAfterTreatmentService.getCompleteByPatientId(patientId);
    }
}
