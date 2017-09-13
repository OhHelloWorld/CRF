package app.service;

import app.dto.MedicineLiverDiseaseOutcomeDTO;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public interface MlDiseaseOutcomeService {

    void saveMlDiseaseOutcome(MedicineLiverDiseaseOutcomeDTO medicineLiverDiseaseOutcomeDTO);

    MedicineLiverDiseaseOutcomeDTO getMlDiseaseOutcome(int mlPatientId);
}
