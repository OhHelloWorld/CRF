package app.service;

import app.dto.MedicineLiverAllergyHistoryDTO;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public interface MlAllergyHistoryService {

    void saveAllergyHistory(MedicineLiverAllergyHistoryDTO medicineLiverAllergyHistoryDTO);

    MedicineLiverAllergyHistoryDTO getAllergyByPatientId(int mlPatientId);
}
