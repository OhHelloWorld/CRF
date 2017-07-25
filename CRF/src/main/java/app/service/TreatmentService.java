package app.service;

import java.util.List;

import app.dto.TreatmentProgramsDTO;

public interface TreatmentService {

    public void saveTreatment(TreatmentProgramsDTO treatmentProgramsDTO);

    public TreatmentProgramsDTO getTreatment(int patientId);

    public List<Float> getQdsDose(int patientId);

    public List<Float> getQdslDose(int patientId);

    public List<Float> getJjqDose(int patientId);

    public List<Float> getBdndDose(int patientId);

    public List<Float> getLcplDose(int patientId);

    public List<Float> getMtxDose(int patientId);

    public List<Float> getCysaDose(int patientId);

    public List<Float> getCtxDose(int patientId);

    public List<Float> getMtmkDose(int patientId);

    public List<Float> getQsxsDose(int patientId);

    public List<Float> getXqydDose(int patientId);

    public List<Float> getFnbtDose(int patientId);

    public List<Float> getBzbtDose(int patientId);

    public boolean getCompleteByPatientId(int patientId);
}
