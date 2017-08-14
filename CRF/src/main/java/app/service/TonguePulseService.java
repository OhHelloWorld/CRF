package app.service;

import java.util.List;

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

    public List<TonguePulseDTO> getFollowTongue(int patientId);

    public TonguePulseDTO getDefaultTongue(int patientId);
}
