package app.service;

import java.util.List;

import app.dto.TonguePulseDTO;

public interface TonguePulseService {

    /**
     * 存储舌脉象数据
     * 
     * @param tonguePulseDTO
     */
    void saveTonguePulse(TonguePulseDTO tonguePulseDTO);

    /**
     * 根据患者id得到舌脉象数据
     * 
     * @param patientId
     */
    TonguePulseDTO getTonguePulseByPatientId(int patientId);

    /**
     * 得到患者舌脉象数据填写情况
     * 
     * @param patientId
     * @return
     */
    boolean getCompleteByPatientId(int patientId);

    List<TonguePulseDTO> getFollowTongue(int patientId);

    TonguePulseDTO getDefaultTongue(int patientId);

    TonguePulseDTO getSingleFollowTongueById(int id);

    void updateTongue(TonguePulseDTO tonguePulseDTO);

    TonguePulseDTO getFollowTongueByDate(String date);
}
