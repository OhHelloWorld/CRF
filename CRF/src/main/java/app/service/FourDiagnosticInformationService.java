package app.service;

import app.dto.FourDiagnosticInformationDTO;

public interface FourDiagnosticInformationService {

    /**
     * 存储四诊信息采集量化数据
     * 
     * @param fDto
     */
    public void saveFourDiagnosticInformation(FourDiagnosticInformationDTO fDto);

    /**
     * 根据患者Id查找四诊信息采集量化数据
     * 
     * @param patientId
     * @return
     */
    public FourDiagnosticInformationDTO getFourDiagnosticInfoByPatientId(int patientId);
}
