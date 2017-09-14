package app.service;

import app.dto.MedicineLiverLiverInjuryDTO;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public interface MlLiverInjuryService {

    void saveMlLiverInjury(MedicineLiverLiverInjuryDTO medicineLiverLiverInjuryDTO);

    MedicineLiverLiverInjuryDTO getMlLiverInjuryByPatientId(int mlPatientId);
}
