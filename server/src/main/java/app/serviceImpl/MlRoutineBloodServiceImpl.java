package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.MedicineLiverRoutineBloodDTO;
import app.repo.MlRoutineBooldRepo;
import app.service.MlCompleteService;
import app.service.MlRoutineBloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10210 on 2017/9/14.
 */
@Service
public class MlRoutineBloodServiceImpl implements MlRoutineBloodService, MlCompleteService {

    @Autowired
    private MlRoutineBooldRepo mlRoutineBooldRepo;

    @Autowired
    private ConvertUtil convertUtil;

    @Override
    public void addRoutineBlood(MedicineLiverRoutineBloodDTO mDTO) {
        mlRoutineBooldRepo.save(convertUtil.routineConverToDO(mDTO));
    }

    @Override
    public MedicineLiverRoutineBloodDTO getRoutineByPid(Long pId) {
        if (mlRoutineBooldRepo.getRoutineByPid(pId) != null) {
            return convertUtil.routineConverToDTO(mlRoutineBooldRepo.getRoutineByPid(pId));
        } else {
            return null;
        }
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlRoutineBooldRepo.getCompleteByPatientId(mlPatientId) != null ? mlRoutineBooldRepo.getCompleteByPatientId(mlPatientId) : false;
    }
}
