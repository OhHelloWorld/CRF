package app.service;

import app.dto.MedicineLiverSymptomsDTO;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
public interface MlSymptomsService {

    MedicineLiverSymptomsDTO getMlSymptomsByPatient(int mlPatient);

    void saveMlSymptoms(MedicineLiverSymptomsDTO medicineLiverSymptomsDTO);
}
