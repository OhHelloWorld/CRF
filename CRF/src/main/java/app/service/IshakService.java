package app.service;

import app.dto.IshakDTO;

public interface IshakService {

    public void saveIshak(IshakDTO ishakDTO);

    public IshakDTO getIshakByPatientId(int patientId);
}
