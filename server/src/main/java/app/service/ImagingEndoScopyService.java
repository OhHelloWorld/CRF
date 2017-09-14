package app.service;

import app.dto.MedicineLiverImagingEndoscopyDTO;
import app.entities.MedicineLiverImagingEndoscopyDO;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by 10210 on 2017/9/14.
 */
public interface ImagingEndoScopyService {

    public void addImageingEndoSc(MedicineLiverImagingEndoscopyDTO mDO);

    public MedicineLiverImagingEndoscopyDTO getByPid(Long pId);
}
