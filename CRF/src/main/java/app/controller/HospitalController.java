package app.controller;

import app.dto.HospitalDTO;
import app.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */

@RestController
@RequestMapping(path = "/api/hospitals")
@Api(value = "医院")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping(value = "")
    @ApiOperation(value = "得到所有的医院")
    public List<HospitalDTO> getAllHospital() {
        return hospitalService.getAllHospital();
    }

    public String uploadImagFile(@RequestParam("file") MultipartFile file) throws IOException {
        hospitalService.saveImag(file);
        return "" + file.hashCode();
    }

    @PostMapping(value = "")
    @ApiOperation(value = "添加医院")
    public HospitalDTO addHospital(@RequestBody HospitalDTO hospitalDTO) {
        return hospitalService.addHospital(hospitalDTO);
    }

    @GetMapping(value = "/{hospitalId}")
    @ApiOperation(value = "通过id获取医院")
    public HospitalDTO getHospitalById(@PathVariable Long hospitalId) {
        return hospitalService.getHospitalById(hospitalId);
    }

}
