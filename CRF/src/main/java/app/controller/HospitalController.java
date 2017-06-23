package app.controller;

import app.dto.HospitalDTO;
import app.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
