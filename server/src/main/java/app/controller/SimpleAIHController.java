package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.SimpleAIHDTO;
import app.service.SimpleAIHService;

/**
 * @author Administrator
 * @category 简单AIH表
 */
@RestController
@RequestMapping(path = "/api/simpleAIH")
public class SimpleAIHController {

    @Autowired
    private SimpleAIHService simpleAIHService;

    /**
     * 存储简化AIH信息
     * 
     * @param simpleAIHDTO
     */
    @PostMapping(path = "")
    public void saveSimpleAIH(@RequestBody SimpleAIHDTO simpleAIHDTO) {
        simpleAIHService.saveSimpleAIH(simpleAIHDTO);
    }

    /**
     * 根据patientId得到简化AIH信息
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public SimpleAIHDTO getSimpleAIH(@PathVariable int patientId) {
        return simpleAIHService.getSimpleAIH(patientId);
    }

    /**
     * 根据patientId得到简化AIH信息完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return simpleAIHService.getCompleteByPatientId(patientId);
    }
}
