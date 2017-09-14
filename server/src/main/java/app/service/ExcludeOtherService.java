package app.service;

import app.dto.MedicineLiverExcludeOtherDTO;

/**
 * Created by 10210 on 2017/9/14.
 */
public interface ExcludeOtherService {

    public void addExcludeOther(MedicineLiverExcludeOtherDTO medicineLiverExcludeOtherDTO);

    public MedicineLiverExcludeOtherDTO getByPatientId(Long pId);
}
