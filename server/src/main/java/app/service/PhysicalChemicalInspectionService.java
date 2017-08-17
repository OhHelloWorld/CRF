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
    public PhysicalChemicalInspectionDTO getPhysicalByPatientId(int patientId);

    /**
     * 得到患者理化测量数据填写情况
     * 
     * @param patientId
     * @return
     */
    public boolean getCompleteByPatientId(int patientId);

    public void savePhysicalImage(MultipartFile file) throws IOException;

    public List<PhysicalChemicalInspectionDTO> getFollowPhy(int patientId);

    public PhysicalChemicalInspectionDTO getDefaultPhy(int patientId);
}
