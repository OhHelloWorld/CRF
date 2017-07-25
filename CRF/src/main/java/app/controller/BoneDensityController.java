package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
     * @param boneDensityDTO
     */
    @PostMapping(path = "")
    public void saveBoneDensity(@RequestBody BoneDensityDTO boneDensityDTO) {
        boneDensityService.saveBoneDensity(boneDensityDTO);
    }
    
    /**
     * 根据patientId得到骨密度信息
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public @ResponseBody BoneDensityDTO geBoneDensity(@PathVariable int patientId) {
        return boneDensityService.getBoneDensity(patientId);
    }
    /**
     * 根据patientId得到骨密度信息完成情况
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return boneDensityService.getCompleteByPatientId(patientId);
    }
}
