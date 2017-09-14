package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.MedicineLiverRoutineBloodDTO;
import app.repo.MlRoutineBooldRepo;
import app.service.MlRoutineBloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10210 on 2017/9/14.
 */
@Service
public class MlRoutineBloodServiceImpl implements MlRoutineBloodService{

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
        return convertUtil.routineConverToDTO(mlRoutineBooldRepo.getRoutineByPid(pId));
    }
}
