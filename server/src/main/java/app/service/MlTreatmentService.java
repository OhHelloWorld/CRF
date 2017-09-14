package app.service;

import app.dto.MedicineLiverTreatmentDTO;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public interface MlTreatmentService {

    void saveMlTreatment(MedicineLiverTreatmentDTO medicineLiverTreatmentDTO);

    MedicineLiverTreatmentDTO getTreatmentByPatientId(int mlPatientId);
}
