package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/follow/{patientId}")
    public List<TonguePulseDTO> getFollowTongue(@PathVariable int patientId) {
        return tonguePulseService.getFollowTongue(patientId);
    }

    @GetMapping(path = "/singleFollow/{id}")
    public TonguePulseDTO getSingleFollowTongueById(@PathVariable int id) {
        return tonguePulseService.getSingleFollowTongueById(id);
    }

    @GetMapping(path = "/default/{patientId}")
    public TonguePulseDTO getDefaultTongue(@PathVariable int patientId) {
        return tonguePulseService.getDefaultTongue(patientId);
    }

    @PutMapping(path = "")
    public void updateTongue(@RequestBody TonguePulseDTO tonguePulseDTO){
        tonguePulseService.updateTongue(tonguePulseDTO);
    }
}
