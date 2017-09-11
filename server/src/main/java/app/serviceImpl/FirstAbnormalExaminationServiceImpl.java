package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.MedicineLiverFirstAbnormalExaminationDTO;
import app.entities.MedicineLiverFirstAbnormalExaminationDO;
import app.repo.FirstAbnormalExaminationRepo;
import app.service.FirstAbnormalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10210 on 2017/9/7.
 */
@Service
public class FirstAbnormalExaminationServiceImpl implements FirstAbnormalExaminationService{

    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private FirstAbnormalExaminationRepo firstAbnormalExaminationRepo;

    @Override
    public void addMsg(MedicineLiverFirstAbnormalExaminationDTO mlfaeDTO) {
        MedicineLiverFirstAbnormalExaminationDO mlfaeDO = convertUtil.mlfaeConverToDO(mlfaeDTO);
        firstAbnormalExaminationRepo.save(mlfaeDO);
    }
}
