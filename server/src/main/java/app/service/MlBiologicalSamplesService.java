package app.service;

import app.dto.MedicineLiverBiologicalSamplesDTO;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
public interface MlBiologicalSamplesService {

    void saveBiologicalSamples(MedicineLiverBiologicalSamplesDTO medicineLiverBiologicalSamplesDTO);

    MedicineLiverBiologicalSamplesDTO getSamplesByPatientId(int mlPatient);
}
