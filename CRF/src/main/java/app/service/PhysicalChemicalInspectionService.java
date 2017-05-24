package app.service;

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
}
