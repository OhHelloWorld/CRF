package app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.PatientDTO;
import app.service.PatientService;

@RestController
@RequestMapping(path = "/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * 存储患者一般资料
     * 
     * @param patientDTO
     */
    @PostMapping(path = "")
    public void savePatientGeneralInformation(@RequestBody PatientDTO patientDTO) {
        patientService.savePatientGeneralInformation(patientDTO);
    }

    /**
     * ͨ根据id得到患者一般资料
     * 
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public PatientDTO getPatientGeneralInformation(@PathVariable int id) {
        return patientService.getPatientGeneralInformation(id);
    }

    /**
     * 得到患者的一般资料的填写状态
     * 
     * @param id
     * @return
     */
    @GetMapping(path = "/complete/{id}")
    public boolean getCompleteById(@PathVariable int id) {
        return patientService.getCompleteById(id);
    }

    /**
     * 得到所有患者的一般资料
     * 
     * @return
     */
    @GetMapping(path = "")
    public List<PatientDTO> getAllPatient() {
        return patientService.getAllPatient();
    }

}
