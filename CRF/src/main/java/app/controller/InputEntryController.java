package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.dto.PatientInputModularEntryDTO;
import app.service.PatientInputModularEntryService;

@RestController
@RequestMapping(path = "/api/inputEntry")
public class InputEntryController {

    @Autowired
    private PatientInputModularEntryService patientInputModularEntryService;

    /**
     * 存储输入框题录入的内容
     * 
     * @param patientInputModularEntryDTO
     */
    @PostMapping(path = "")
    public void saveInputEntry(
            @RequestBody PatientInputModularEntryDTO patientInputModularEntryDTO) {
        patientInputModularEntryService.saveInputEntry(patientInputModularEntryDTO);
    }

    /**
     * 根据患者ID和信息录入表ID得到该患者的指定信息录入表输入框类的录入信息情况
     * 
     * @param patientId
     * @param informationId
     * @return
     */
    @GetMapping(path = "")
    public List<PatientInputModularEntryDTO> getInputEntry(@RequestParam int patientId,
            @RequestParam int informationId) {
        return patientInputModularEntryService.getInputEntryByPatientIdAndInformationId(patientId,
                informationId);
    }

}
