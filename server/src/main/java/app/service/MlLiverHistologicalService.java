package app.service;

import app.dto.MedicineLiverLiverHistologicalDTO;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public interface MlLiverHistologicalService {

    void saveMlLiverHistological(MedicineLiverLiverHistologicalDTO medicineLiverLiverHistologicalDTO);

    MedicineLiverLiverHistologicalDTO getMlLiverHistologicalByPatientId(int mlPatientId);
}
