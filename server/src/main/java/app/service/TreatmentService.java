package app.service;

import java.util.ArrayList;
import java.util.List;

import app.dto.TreatmentProgramsDTO;

public interface TreatmentService {

    public void saveTreatment(TreatmentProgramsDTO treatmentProgramsDTO);

    public TreatmentProgramsDTO getTreatment(int patientId);

    public List<String> getQdsDose(int patientId);

    public ArrayList<String> getQdslDose(int patientId);

    public List<String> getJjqDose(int patientId);

    public List<String> getBdndDose(int patientId);

    public List<String> getLcplDose(int patientId);

    public List<String> getMtxDose(int patientId);

    public List<String> getCysaDose(int patientId);

    public List<String> getCtxDose(int patientId);

    public List<String> getMtmkDose(int patientId);

    public List<String> getQsxsDose(int patientId);

    public List<String> getXqydDose(int patientId);

    public List<String> getFnbtDose(int patientId);

    public List<String> getBzbtDose(int patientId);

    public boolean getCompleteByPatientId(int patientId);

    public List<TreatmentProgramsDTO> getFollowTreat(int patientId);

    public TreatmentProgramsDTO getDefaultTreat(int patientId);

    TreatmentProgramsDTO getSingleFollowById(int id);

    void updateTreat(TreatmentProgramsDTO treatmentProgramsDTO);
}