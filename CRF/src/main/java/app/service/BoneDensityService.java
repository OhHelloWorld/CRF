package app.service;

import app.dto.BoneDensityDTO;

public interface BoneDensityService {

    public void saveBoneDensity(BoneDensityDTO boneDensityDTO);

    public BoneDensityDTO getBoneDensity(int patientId);

    public boolean getCompleteByPatientId(int patientId);

}
