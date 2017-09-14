package app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import app.dto.PhysicalChemicalInspectionDTO;

public interface PhysicalChemicalInspectionService {

    /**
     * 存储量化检查结果
     * 
     * @param pDto
     */
    public void savePhysicalChemicalInspection(PhysicalChemicalInspectionDTO pDto);

    /**
     * 根据患者id得到理化检查数据
     * 
     * @param patientId
     * @return
     */
    PhysicalChemicalInspectionDTO getPhysicalByPatientId(int patientId);

    /**
     * 得到患者理化测量数据填写情况
     * 
     * @param patientId
     * @return
     */
    boolean getCompleteByPatientId(int patientId);

    void savePhysicalImage(MultipartFile file) throws IOException;

    List<PhysicalChemicalInspectionDTO> getFollowPhy(int patientId);

    PhysicalChemicalInspectionDTO getDefaultPhy(int patientId);

    PhysicalChemicalInspectionDTO getSinleFollowById(int id);

    void updatePhysical(PhysicalChemicalInspectionDTO physicalChemicalInspectionDTO);

    PhysicalChemicalInspectionDTO getFollowPhyByDate(String date);
}
