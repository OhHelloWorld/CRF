package app.service;

import app.dto.ComplexAIHAfterTreatmentDTO;

public interface ComplexAIHAfterTreatmentService {

    public void saveComplexAIHAfterTreatment(
            ComplexAIHAfterTreatmentDTO complexAIHAfterTreatmentDTO);

    public ComplexAIHAfterTreatmentDTO getComplexAIHAfterTreatment(int patientId);

    public boolean getCompleteByPatientId(int patientId);
}
