package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.TonguePulseDTO;
import app.service.TonguePulseService;

/**
 * @author Administrator
 * @category 舌脉象信息
 */
@RestController
@RequestMapping(path = "/api/tonguePulse")
public class TonguePulseController {

    @Autowired
    private TonguePulseService tonguePulseService;

    /**
     * 存储舌脉象观察数据
     * 
     * @param tonguePulseDTO
     */
    @PostMapping(path = "")
    public void saveTonguePulse(@RequestBody TonguePulseDTO tonguePulseDTO) {
        tonguePulseService.saveTonguePulse(tonguePulseDTO);
    }

    /**
     * 根据患者id得到舌脉象数据
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public TonguePulseDTO getTonguePulseByPatientId(@PathVariable int patientId) {
        return tonguePulseService.getTonguePulseByPatientId(patientId);
    }

    /**
     * 得到患者舌脉象观察数据完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return tonguePulseService.getCompleteByPatientId(patientId);
    }
}
