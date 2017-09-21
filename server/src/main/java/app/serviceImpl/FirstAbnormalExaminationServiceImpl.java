package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.Utils.GetColumnContentByColumn;
import app.dto.MedicineLiverFirstAbnormalExaminationDTO;
import app.entities.MedicineLiverFirstAbnormalExaminationDO;
import app.repo.FirstAbnormalExaminationRepo;
import app.service.FirstAbnormalExaminationService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10210 on 2017/9/7.
 */
@Service
public class FirstAbnormalExaminationServiceImpl implements FirstAbnormalExaminationService,MlCompleteService{

    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private FirstAbnormalExaminationRepo firstAbnormalExaminationRepo;

    @Override
    public void addMsg(MedicineLiverFirstAbnormalExaminationDTO mlfaeDTO) {
        MedicineLiverFirstAbnormalExaminationDO mlfaeDO = convertUtil.mlfaeConverToDO(mlfaeDTO);
        firstAbnormalExaminationRepo.save(mlfaeDO);
    }

    @Override
    public MedicineLiverFirstAbnormalExaminationDTO getMsgByPID(Long pId) {
        return convertUtil.mlfaeConvertoDTO(firstAbnormalExaminationRepo.getMsgByPID(pId));
    }

    @Override
    public List<MedicineLiverFirstAbnormalExaminationDTO> getAllMlfaeData(Long pId) {
        List<MedicineLiverFirstAbnormalExaminationDTO> mDTOlist = new ArrayList<>();
        for(MedicineLiverFirstAbnormalExaminationDO mDO: firstAbnormalExaminationRepo.getAllMlfaeData(pId)) {
            mDTOlist.add(convertUtil.mlfaeConvertoDTO(mDO));
        }
        mDTOlist.remove(0);
        return mDTOlist;
    }

    @Override
    public MedicineLiverFirstAbnormalExaminationDTO getHosData(int mlpatientId) {
        return firstAbnormalExaminationRepo.getHosData(mlpatientId)!=null?convertUtil.mlfaeConvertoDTO(firstAbnormalExaminationRepo.getHosData(mlpatientId)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return firstAbnormalExaminationRepo.getCompleteByPatientId(mlPatientId)!=null?firstAbnormalExaminationRepo.getCompleteByPatientId(mlPatientId):false;
    }
}
