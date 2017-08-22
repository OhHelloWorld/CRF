package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.dto.LiverPathologyDTO;
import app.service.LiverPathologyService;

/**
 * @author Administrator
 * @category 肝脏理化检查表
 */
@RestController
@RequestMapping(path = "/api/liverPathology")
public class LiverPathologyController {

    @Autowired
    private LiverPathologyService liverPathologyService;

    /**
     * 存储肝脏理化检查
     * 
     * @param liverPathologyDTO
     * @return
     */
    @PostMapping(path = "")
    public int saveLiverPathology(@RequestBody LiverPathologyDTO liverPathologyDTO) {
        return liverPathologyService.saveLiverPathology(liverPathologyDTO);
    }

    /**
     * 根据patientId得到肝脏理化检查信息
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public @ResponseBody LiverPathologyDTO getLiverPathology(@PathVariable int patientId) {
        return liverPathologyService.getLiverPathology(patientId);
    }

    /**
     * 根据patientId得到肝脏理化检查信息完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return liverPathologyService.getCompleteByPatientId(patientId);
    }

    /**
     * 根据patientId得到评分系统的选择情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/choose/{patientId}")
    public List<Boolean> getChooseAll(@PathVariable int patientId) {
        return liverPathologyService.getChoose(patientId);
    }
}
