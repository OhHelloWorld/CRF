package app.service;

import app.dto.MedicineLiverRoutineBloodDTO;

/**
 * Created by 10210 on 2017/9/14.
 */
public interface MlRoutineBloodService {

    public void addRoutineBlood(MedicineLiverRoutineBloodDTO mDTO);

    public MedicineLiverRoutineBloodDTO getRoutineByPid(Long pId);
}
