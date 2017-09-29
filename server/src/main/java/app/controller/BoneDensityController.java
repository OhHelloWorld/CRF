package app.controller;

import java.util.List;

import app.entities.BoneDensityDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import app.dto.BoneDensityDTO;
import app.service.BoneDensityService;


/**
 * @author Administrator
 * @category 骨密度信息
 */
@RestController
@RequestMapping(path = "/api/boneDensity")
public class BoneDensityController {

    @Autowired
    private BoneDensityService boneDensityService;

    /**
     * 储存骨密度信息
     * 
     * @param boneDensityDTO
     */
    @PostMapping(path = "")
    public void saveBoneDensity(@RequestBody BoneDensityDTO boneDensityDTO) {
        boneDensityService.saveBoneDensity(boneDensityDTO);
    }

    /**
     * 根据patientId得到骨密度信息
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public @ResponseBody BoneDensityDTO geBoneDensity(@PathVariable int patientId) {
        return boneDensityService.getBoneDensity(patientId);
    }

    /**
     * 根据patientId得到骨密度信息完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return boneDensityService.getCompleteByPatientId(patientId);
    }

    /**
     * 得到所有的随访骨密度表
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/follow/{patientId}")
    public List<BoneDensityDTO> getFollowBone(@PathVariable int patientId) {
        return boneDensityService.getFollowBone(patientId);
    }

    /**
     * 得到最新的医院录入表信息
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/default/{patientId}")
    public BoneDensityDTO getDefaultBone(@PathVariable int patientId) {
        return boneDensityService.getDefaultBone(patientId);
    }

    /**
     * 根据id得到骨密度随访对象
     * @param id
     * @return
     */
    @GetMapping(path = "/singleFollow/{id}")
    public BoneDensityDTO getSingleFollowById(@PathVariable int id){
        return boneDensityService.getSingleFollowById(id);
    }

    /**
     * 骨密度更新
     * @param boneDensityDTO
     */
    @PutMapping(path = "")
    public void updateBone(@RequestBody BoneDensityDTO boneDensityDTO){
        boneDensityService.updateBone(boneDensityDTO);
    }

    /**
     * 根据日期找到某天的骨密度随访记录
     * @param date
     * @return
     */
    @GetMapping(path = "/follow")
    public BoneDensityDTO getFollowBoneByDate(@RequestParam String date){
        return boneDensityService.getFollowBoneByDate(date);
    }
}
