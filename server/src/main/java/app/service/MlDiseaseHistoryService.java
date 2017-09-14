package app.service;

import app.dto.MedicineLiverDiseaseHistoryDTO;

/**
 * Created by Administrator on 2017/9/4 0004.
 */
public interface MlDiseaseHistoryService {

    MedicineLiverDiseaseHistoryDTO getMlDiseaseHistory(int mlPatientId);

    void saveMlDiseaseHistory(MedicineLiverDiseaseHistoryDTO diseaseHistoryDTO);

}
