package app.service;

import app.dto.MedicineLiverSuspectedDrugDTO;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public interface MlDrugHistoryService {

    void saveDrugHistory(MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO);

    MedicineLiverSuspectedDrugDTO getDrugByPatientId(int mlPatientId);
}
