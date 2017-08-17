package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.ComplexAIHBeforeTreatmentDTO;
import app.service.ComplexAIHBeforeTreatmentService;

/**
 * @author Administrator
 *  @category 治疗前复杂AIH情况
 */
@RestController
@RequestMapping(path = "/api/complexAIHBeforeTreatment")
public class ComplexAIHBeforeTreatmentController {

    @Autowired
    private ComplexAIHBeforeTreatmentService complexAIHBeforeTreatmentService;
    
    /**
     * 存储治疗前复杂AIH情况
     * @param complexAIHBeforeTreatmentDTO
     */
    @PostMapping(path = "")
    public void saveComplexAIHBeforeTreatment(
            @RequestBody ComplexAIHBeforeTreatmentDTO complexAIHBeforeTreatmentDTO) {
        complexAIHBeforeTreatmentService
                .saveComplexAIHBeforeTreatment(complexAIHBeforeTreatmentDTO);
    }

    /**
     * 根据patientId得到治疗前复杂AIH情况
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public ComplexAIHBeforeTreatmentDTO getComplexAIHBeforeTreatment(@PathVariable int patientId) {
        return complexAIHBeforeTreatmentService.getComplexAIHBeforeTreatment(patientId);
    }

    /**
     * 根据patientId得到治疗前复杂AIH完成情况
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return complexAIHBeforeTreatmentService.getCompleteByPatientId(patientId);
    }
}
