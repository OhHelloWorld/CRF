package app.service;

import app.dto.HospitalDTO;
import app.dto.PageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface HospitalService {

    PageDTO<HospitalDTO> getAllHospital(Pageable pageable);

    void saveImag(MultipartFile file) throws IOException;

    HospitalDTO addHospital(HospitalDTO hospitalDTO);

    HospitalDTO getHospitalById(Long hospitalId);

    PageDTO<HospitalDTO> getHospitalByProjectId(Long projectId, Pageable pageable);

    HospitalDTO updateHospital(HospitalDTO hospitalDTO);
}
