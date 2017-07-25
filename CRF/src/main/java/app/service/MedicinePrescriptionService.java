package app.service;

import app.dto.ChineseMedicinePrescriptionDTO;

public interface MedicinePrescriptionService {

    public void saveMedicinePrescription(
            ChineseMedicinePrescriptionDTO chineseMedicinePrescriptionDTO);

    public ChineseMedicinePrescriptionDTO getMedicinePrescription(int patientId);

    public boolean getCompleteByPatientId(int patientId);
}
