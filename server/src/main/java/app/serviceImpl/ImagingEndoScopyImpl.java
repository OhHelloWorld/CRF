package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.MedicineLiverImagingEndoscopyDTO;
import app.entities.MedicineLiverImagingEndoscopyDO;
import app.repo.ImagingEndoScopyRepo;
import app.service.ImagingEndoScopyService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10210 on 2017/9/14.
 */
@Service
public class ImagingEndoScopyImpl implements ImagingEndoScopyService,MlCompleteService{

    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private ImagingEndoScopyRepo imagingEndoScopyRepo;

    @Override
    public void addImageingEndoSc(MedicineLiverImagingEndoscopyDTO mDTO) {
        imagingEndoScopyRepo.save(convertUtil.mlieConverToDO(mDTO));
    }

    @Override
    public MedicineLiverImagingEndoscopyDTO getByPid(Long pId) {
        return imagingEndoScopyRepo.getByPid(pId)!=null?convertUtil.mlieConverToDTO(imagingEndoScopyRepo.getByPid(pId)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return imagingEndoScopyRepo.getCompleteByPatientId(mlPatientId)!=null?imagingEndoScopyRepo.getCompleteByPatientId(mlPatientId):false;
    }
}
