package app.service;

import app.dto.SimpleAIHDTO;

public interface SimpleAIHService {

    public void saveSimpleAIH(SimpleAIHDTO simpleAIHDTO);

    public SimpleAIHDTO getSimpleAIH(int patientId);

    public boolean getCompleteByPatientId(int patientId);
}
