package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import app.dto.TreatmentProgramsDTO;
import app.service.TreatmentService;

/**
 * @author Administrator
 * @category 治疗方案信息
 */
@RestController
@RequestMapping(path = "/api/treatment")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    /**
     * 存储治疗方案信息
     * 
     * @param treatmentProgramsDTO
     */
    @PostMapping(path = "")
    public void saveTreatment(@RequestBody TreatmentProgramsDTO treatmentProgramsDTO) {
        treatmentService.saveTreatment(treatmentProgramsDTO);
    }

    /**
     * 根据patientId得到治疗方案信息
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public TreatmentProgramsDTO getTreatment(@PathVariable int patientId) {
        return treatmentService.getTreatment(patientId);
    }

    /**
     * 根据patientId得到强的松剂量信息
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/qds/{patientId}")
    public List<String> getQdsDose(@PathVariable int patientId) {
        return treatmentService.getQdsDose(patientId);
    }

    /**
     * 根据patientId得到强的松龙剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/qdsl/{patientId}")
    public ArrayList<String> getQdslDose(@PathVariable int patientId) {
        return treatmentService.getQdslDose(patientId);
    }

    /**
     * 根据patientId得到甲基强剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/jjq/{patientId}")
    public List<String> getJjqDose(@PathVariable int patientId) {
        return treatmentService.getJjqDose(patientId);
    }

    /**
     * 根据patientId得到布地奈德剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/bdnd/{patientId}")
    public List<String> getBdndDose(@PathVariable int patientId) {
        return treatmentService.getBdndDose(patientId);
    }

    /**
     * 根据patientId得到硫锉嘌呤剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/lcpl/{patientId}")
    public List<String> getLcplDose(@PathVariable int patientId) {
        return treatmentService.getLcplDose(patientId);
    }

    /**
     * 根据patientId得到MTX剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/mtx/{patientId}")
    public List<String> getMtxDose(@PathVariable int patientId) {
        return treatmentService.getMtxDose(patientId);
    }

    /**
     * 根据patientId得到cysa剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/cysa/{patientId}")
    public List<String> getCysaDose(@PathVariable int patientId) {
        return treatmentService.getCysaDose(patientId);
    }

    /**
     * 根据patientId得到ctx剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/ctx/{patientId}")
    public List<String> getCtxDose(@PathVariable int patientId) {
        return treatmentService.getCtxDose(patientId);
    }

    /**
     * 根据patientId得到吗替麦考酚酯剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/mtmk/{patientId}")
    public List<String> getMtmkDose(@PathVariable int patientId) {
        return treatmentService.getMtmkDose(patientId);
    }

    /**
     * 根据patientId得到秋水仙素剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/qsxs/{patientId}")
    public List<String> getQsxsDose(@PathVariable int patientId) {
        return treatmentService.getQsxsDose(patientId);
    }

    /**
     * 根据patientId得到熊去氧胆酸剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/xqyd/{patientId}")
    public List<String> getXqydDose(@PathVariable int patientId) {
        return treatmentService.getXqydDose(patientId);
    }

    /**
     * 根据patientId得到非诺贝特剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/fnbt/{patientId}")
    public List<String> getFnbtDose(@PathVariable int patientId) {
        return treatmentService.getFnbtDose(patientId);
    }

    /**
     * 根据patientId得到苯扎贝特剂量
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/bzbt/{patientId}")
    public List<String> getBzbtDose(@PathVariable int patientId) {
        return treatmentService.getBzbtDose(patientId);
    }

    /**
     * 根据patientId得到治疗方案完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return treatmentService.getCompleteByPatientId(patientId);
    }

    @GetMapping(path = "/follow/{patientId}")
    public List<TreatmentProgramsDTO> getFollowTreat(@PathVariable int patientId) {
        return treatmentService.getFollowTreat(patientId);
    }

    @GetMapping(path = "/default/{patientId}")
    public TreatmentProgramsDTO getDefaultTreat(@PathVariable int patientId) {
        return treatmentService.getDefaultTreat(patientId);
    }

    @GetMapping(path = "/singleFollow/{id}")
    public TreatmentProgramsDTO getSingleFollowById(@PathVariable int id){
        return treatmentService.getSingleFollowById(id);
    }

    @PutMapping(path = "")
    public void updateTreatment(@RequestBody TreatmentProgramsDTO treatmentProgramsDTO){
        treatmentService.updateTreat(treatmentProgramsDTO);
    }

    @GetMapping(path = "/follow")
    public TreatmentProgramsDTO getFollowTreatByDate(@RequestParam String date){
        return treatmentService.getFollowTreatByDate(date);
    }
}
