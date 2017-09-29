package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.IshakDTO;
import app.service.IshakService;

/**
 * ishak评分
 */
@RestController
@RequestMapping(path = "/api/ishak")
public class IshakController {

    @Autowired
    private IshakService ishakService;

    /**
     * 保存ishak评分表内容
     * 
     * @param ishakDTO
     */
    @PostMapping(path = "")
    public void saveIshak(@RequestBody IshakDTO ishakDTO) {
        ishakService.saveIshak(ishakDTO);
    }

    /**
     * 根据patientId得到ishak评分表内容
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public IshakDTO getIshakByPatientId(@PathVariable int patientId) {
        return ishakService.getIshakByPatientId(patientId);
    }
}
