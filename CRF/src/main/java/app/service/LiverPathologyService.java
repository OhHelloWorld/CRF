package app.service;

import java.util.List;

import app.dto.LiverPathologyDTO;

public interface LiverPathologyService {

    public int saveLiverPathology(LiverPathologyDTO liverPathologyDTO);

    public LiverPathologyDTO getLiverPathology(int patientId);

    public boolean getCompleteByPatientId(int patientId);

    public List<Boolean> getChoose(int patientId);
}
