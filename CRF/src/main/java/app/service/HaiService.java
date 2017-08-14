package app.service;

import app.dto.HaiDTO;

public interface HaiService {

    public void saveHai(HaiDTO haiDTO);

    public HaiDTO getHaiByPatientId(int patientId);
}
