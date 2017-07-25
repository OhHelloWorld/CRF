package app.service;

import app.dto.LiverPathologyDTO;

public interface LiverPathologyService {

    public int saveLiverPathology(LiverPathologyDTO liverPathologyDTO);

    public LiverPathologyDTO getLiverPathology(int patientId);

    public boolean getCompleteByPatientId(int patientId);
}
