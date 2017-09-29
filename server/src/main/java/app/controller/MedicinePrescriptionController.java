package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 得到所有中药方剂随访表内容
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/follow/{patientId}")
    public List<ChineseMedicinePrescriptionDTO> getFollowMedicine(@PathVariable int patientId) {
        return medicinePrescriptionService.getFollowMedicine(patientId);
    }

    /**
     * 得到最新医院录入中药方剂内容
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/default/{patientId}")
    public ChineseMedicinePrescriptionDTO getDefaultMedicine(@PathVariable int patientId) {
        return medicinePrescriptionService.getDefaultMedicine(patientId);
    }

    /**
     * 根据日期得到随访数据
     * @param date
     * @return
     */
    @GetMapping(path = "/follow")
    public ChineseMedicinePrescriptionDTO getFollowChineseByDate(@RequestParam  String date){
        return medicinePrescriptionService.getFollowChineseByDate(date);
    }
}
