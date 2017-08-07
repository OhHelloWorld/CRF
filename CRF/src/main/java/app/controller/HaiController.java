package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.dto.HaiDTO;
import app.service.HaiService;


@RestController
@RequestMapping(path = "/api/hai")
public class HaiController {

    @Autowired
    private HaiService haiService;

    @PostMapping(path = "")
    public void saveHai(@RequestBody HaiDTO haiDTO) {
        haiService.saveHai(haiDTO);
    }

    @GetMapping(path = "/{patientId}")
    public HaiDTO getHaiByPatientId(@PathVariable int patientId) {
        return haiService.getHaiByPatientId(patientId);
    }
}
