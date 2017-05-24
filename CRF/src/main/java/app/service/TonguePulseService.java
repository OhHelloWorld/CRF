package app.service;

import app.dto.TonguePulseDTO;

public interface TonguePulseService {

    /**
     * 存储舌脉象数据
     * 
     * @param tonguePulseDTO
     */
    public void saveTonguePulse(TonguePulseDTO tonguePulseDTO);

    /**
     * 根据患者id得到舌脉象数据
     * 
     * @param patientId
     */
    public TonguePulseDTO getTonguePulseByPatientId(int patientId);

    /**
     * 得到患者舌脉象数据填写情况
     * 
     * @param patientId
     * @return
     */
    public boolean getCompleteByPatientId(int patientId);
}
