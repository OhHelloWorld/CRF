package app.service;

import java.util.List;

import app.dto.BoneDensityDTO;

public interface BoneDensityService {

    void saveBoneDensity(BoneDensityDTO boneDensityDTO);

    BoneDensityDTO getBoneDensity(int patientId);

    boolean getCompleteByPatientId(int patientId);

    List<BoneDensityDTO> getFollowBone(int patientId);

    BoneDensityDTO getDefaultBone(int patientId);

    BoneDensityDTO getSingleFollowById(int id);

    void updateBone(BoneDensityDTO boneDensityDTO);
}
