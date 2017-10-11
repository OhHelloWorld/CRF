package app.controller;

import java.io.IOException;
import java.util.List;

import app.Utils.SaveImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import app.dto.PhysicalChemicalInspectionDTO;
import app.service.PhysicalChemicalInspectionService;

/**
 * @author Administrator
 * @category 理化检查表
 */
@RestController
@RequestMapping(path = "/api/physical")
public class PhysicalChemicalInspectionController {

    @Autowired
    private PhysicalChemicalInspectionService physicalChemicalInspectionService;

    @Autowired
    private SaveImage saveImage;

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

    /**
     * 得到患者的理化检查完成情况
     * 
     * @param patientId
     * @return
     */
    @GetMapping(path = "/complete/{patientId}")
    public boolean getCompleteByPatientId(@PathVariable int patientId) {
        return physicalChemicalInspectionService.getCompleteByPatientId(patientId);
    }

    /**
     * 上传图片
     * 
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping(path = "/upload")
    public String savePhysicalImage(@RequestParam("file") MultipartFile file) throws IOException {
        saveImage.saveImage(file);
        return "" + file.hashCode();
    }

    @GetMapping(path = "/follow/{patientId}")
    public List<PhysicalChemicalInspectionDTO> getFollowPhy(@PathVariable int patientId) {
        return physicalChemicalInspectionService.getFollowPhy(patientId);
    }

    @GetMapping(path = "/default/{patientId}")
    public PhysicalChemicalInspectionDTO getDefaultPhy(@PathVariable int patientId) {
        return physicalChemicalInspectionService.getDefaultPhy(patientId);
    }

    @GetMapping(path = "/singleFollow/{id}")
    public PhysicalChemicalInspectionDTO getSingleFollowById(@PathVariable int id){
        return physicalChemicalInspectionService.getSinleFollowById(id);
    }

    @PutMapping(path = "")
    public void updatePhysical(@RequestBody PhysicalChemicalInspectionDTO physicalChemicalInspectionDTO){
        physicalChemicalInspectionService.updatePhysical(physicalChemicalInspectionDTO);
    }

    @GetMapping(path = "/follow")
    public PhysicalChemicalInspectionDTO getFollowPhyByDate(@RequestParam String date){
        return physicalChemicalInspectionService.getFollowPhyByDate(date);
    }


}
