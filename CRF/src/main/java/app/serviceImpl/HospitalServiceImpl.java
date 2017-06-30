package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.HospitalDTO;
import app.entities.HospitalDO;
import app.repo.HospitalRepo;
import app.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private ConvertUtil convertUtil;

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

    @Override
    public void saveImag(MultipartFile file) throws IOException {
        File saveFile = new File("../../../resources/image/", file.hashCode() + ".jpg");
        try (FileOutputStream fos = new FileOutputStream(saveFile)) {
            fos.write(file.getBytes());
            fos.flush();
        } catch (IOException e) {
            throw new IOException("保存图片失败");
        }
    }

    public HospitalDTO addHospital(HospitalDTO hospitalDTO) {
        HospitalDO hospitalDO = hospitalRepo.save(convertUtil.convertHospitalDO(hospitalDTO));
        return convertUtil.convertHospitalDTO(hospitalDO);
    }

    public HospitalDTO getHospitalById(Long hospitalId) {
        HospitalDTO hospitalDTO = convertUtil.convertHospitalDTO(hospitalRepo.findOne(hospitalId));
        return hospitalDTO;
    }
}
