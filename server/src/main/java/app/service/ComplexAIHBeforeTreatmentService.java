package app.service;

import app.dto.ComplexAIHBeforeTreatmentDTO;

public interface ComplexAIHBeforeTreatmentService {

    public void saveComplexAIHBeforeTreatment(
            ComplexAIHBeforeTreatmentDTO complexAIHBeforeTreatmentDTO);

    public ComplexAIHBeforeTreatmentDTO getComplexAIHBeforeTreatment(int patientId);

    public boolean getCompleteByPatientId(int patientId);
}
