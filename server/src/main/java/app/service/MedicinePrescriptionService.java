package app.service;

import java.util.List;

import app.dto.ChineseMedicinePrescriptionDTO;

public interface MedicinePrescriptionService {

    void saveMedicinePrescription(
            ChineseMedicinePrescriptionDTO chineseMedicinePrescriptionDTO);

    ChineseMedicinePrescriptionDTO getMedicinePrescription(int patientId);

    boolean getCompleteByPatientId(int patientId);

    List<ChineseMedicinePrescriptionDTO> getFollowMedicine(int patientId);

    ChineseMedicinePrescriptionDTO getDefaultMedicine(int patientId);

    ChineseMedicinePrescriptionDTO getFollowChineseByDate(String date);
}
