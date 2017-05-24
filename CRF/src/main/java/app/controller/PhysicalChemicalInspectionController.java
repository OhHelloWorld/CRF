package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.PhysicalChemicalInspectionDTO;
import app.service.PhysicalChemicalInspectionService;

@RestController
@RequestMapping(path = "/api/physical")
public class PhysicalChemicalInspectionController {

    @Autowired
    private PhysicalChemicalInspectionService physicalChemicalInspectionService;

    /**
     * 存储理化检查结果
     * 
     * @param physicalChemicalInspectionDTO
     */
    @PostMapping(path = "")
    public void savePhysical(
            @RequestBody PhysicalChemicalInspectionDTO physicalChemicalInspectionDTO) {
        physicalChemicalInspectionService
                .savePhysicalChemicalInspection(physicalChemicalInspectionDTO);
    }

    /**
     * 根据患者id得到理化检查结果
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/{patientId}")
    public PhysicalChemicalInspectionDTO getPhysicalByPatientId(@PathVariable int patientId) {
        return physicalChemicalInspectionService.getPhysicalByPatientId(patientId);
    }
}
