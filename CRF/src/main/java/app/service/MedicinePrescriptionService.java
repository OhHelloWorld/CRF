package app.service;

import java.util.List;

import app.dto.ChineseMedicinePrescriptionDTO;

public interface MedicinePrescriptionService {

    public void saveMedicinePrescription(
            ChineseMedicinePrescriptionDTO chineseMedicinePrescriptionDTO);

    public ChineseMedicinePrescriptionDTO getMedicinePrescription(int patientId);

    public boolean getCompleteByPatientId(int patientId);

    public List<ChineseMedicinePrescriptionDTO> getFollowMedicine(int patientId);

    public ChineseMedicinePrescriptionDTO getDefaultMedicine(int patientId);
}
