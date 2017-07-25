package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.ChineseMedicinePrescriptionDTO;
import app.service.MedicinePrescriptionService;

/**
 * @author Administrator
 * @category 药物方案信息
 */
@RestController
@RequestMapping(path = "/api/medicine")
public class MedicinePrescriptionController {

    @Autowired
    private MedicinePrescriptionService medicinePrescriptionService;

    /**
     * 存储药物方案信息
     * 
     * @param chineseMedicinePrescriptionDTO
     */
    @PostMapping(path = "")
    public void saveMedicinePrescription(
            @RequestBody ChineseMedicinePrescriptionDTO chineseMedicinePrescriptionDTO) {
        medicinePrescriptionService.saveMedicinePrescription(chineseMedicinePrescriptionDTO);
    }

    /**
     * 根据patientId得到药物方案信息
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public ChineseMedicinePrescriptionDTO getMedicinePrescription(@PathVariable int patientId) {
        return medicinePrescriptionService.getMedicinePrescription(patientId);
    }

    /**
     * 根据patientId得到药物方案完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return medicinePrescriptionService.getCompleteByPatientId(patientId);
    }
}
