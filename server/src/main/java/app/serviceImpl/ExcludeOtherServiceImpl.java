package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.MedicineLiverExcludeOtherDTO;
import app.repo.ExcludeOtherRepo;
import app.service.ExcludeOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10210 on 2017/9/14.
 */
@Service
public class ExcludeOtherServiceImpl implements ExcludeOtherService{

    @Autowired
    private ExcludeOtherRepo excludeOtherRepo;

    @Autowired
    private ConvertUtil convertUtil;

    @Override
    public void addExcludeOther(MedicineLiverExcludeOtherDTO medicineLiverExcludeOtherDTO) {
        excludeOtherRepo.save(convertUtil.excludeConverToDO(medicineLiverExcludeOtherDTO));
    }

    @Override
    public MedicineLiverExcludeOtherDTO getByPatientId(Long pId) {
        return convertUtil.excludeConverToDTO(excludeOtherRepo.getByPatientId(pId));
    }
}
