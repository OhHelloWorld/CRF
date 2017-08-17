package app.service;

import java.util.List;

import app.dto.BoneDensityDTO;

public interface BoneDensityService {

    public void saveBoneDensity(BoneDensityDTO boneDensityDTO);

    public BoneDensityDTO getBoneDensity(int patientId);

    public boolean getCompleteByPatientId(int patientId);

    public List<BoneDensityDTO> getFollowBone(int patientId);

    public BoneDensityDTO getDefaultBone(int patientId);

}
