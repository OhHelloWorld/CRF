package app.service;

import app.dto.MedicineLiverFourDTO;

/**
 * Created by Administrator on 2017/11/27 0027.
 */
public interface MlFourService {

    void saveFour(MedicineLiverFourDTO fourDTO);

    MedicineLiverFourDTO getFourByPatientId(int patientId);

}
