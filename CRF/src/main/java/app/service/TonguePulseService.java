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
}
