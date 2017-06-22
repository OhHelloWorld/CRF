package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.HospitalDTO;
import app.entities.HospitalDO;
import app.repo.HospitalRepo;
import app.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private ConvertUtil convertUtil;;

    @Autowired
    private HospitalRepo hospitalRepo;

    @Override
    public List<HospitalDTO> getAllHospital() {
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for(HospitalDO h : hospitalRepo.findAll()) {
            hospitalDTOS.add(convertUtil.convertHospitalDTO(h));
        }
        return hospitalDTOS;
    }
}
