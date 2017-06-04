package app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import app.dto.PageDTO;
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
    public int savePatientGeneralInformation(@RequestBody PatientDTO patientDTO) {
        return patientService.savePatientGeneralInformation(patientDTO);
    }

    /**
     * 根据id更新病人的基本资料
     *
     */
    @PutMapping(path="")
    public void updatePatientInfo(@RequestBody PatientDTO patient){
        patientService.editPatient(patient);
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
    public PageDTO<PatientDTO> getAllPatient(@PageableDefault(value = 15) Pageable pageable) {
        return patientService.getAllPatient(pageable);
    }

    /**
     * 查询
     * 
     * @param queryStr
     * @param pageable
     * @return
     */
    @GetMapping(path = "/q")
    public PageDTO<PatientDTO> getPatientByQueryStr(@RequestParam("queryStr") String queryStr,
            @PageableDefault(value = 15) Pageable pageable) {
        return patientService.getPatientByQueryStr(queryStr, pageable);
    }

}
