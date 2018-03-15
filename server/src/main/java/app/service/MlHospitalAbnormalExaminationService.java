package app.service;

import app.dto.MedicineLiverHospitalAbnormalExaminationDTO;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public interface MlHospitalAbnormalExaminationService {

    void saveHospitalExam(MedicineLiverHospitalAbnormalExaminationDTO medicineLiverHospitalAbnormalExaminationDTO);

    MedicineLiverHospitalAbnormalExaminationDTO getHospitalExamByPatientId(int mlPatientId);
}
