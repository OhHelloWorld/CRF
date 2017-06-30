package app.service;

import app.dto.HospitalDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface HospitalService {

    List<HospitalDTO> getAllHospital();

    public void saveImag(MultipartFile file) throws IOException;

    public HospitalDTO addHospital(HospitalDTO hospitalDTO);
}
