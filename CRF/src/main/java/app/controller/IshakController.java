package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.IshakDTO;
import app.service.IshakService;

@RestController
@RequestMapping(path = "/api/ishak")
public class IshakController {

    @Autowired
    private IshakService ishakService;

    @PostMapping(path = "")
    public void saveIshak(@RequestBody IshakDTO ishakDTO) {
        ishakService.saveIshak(ishakDTO);
    }

    @GetMapping(path = "/{patientId}")
    public IshakDTO getIshakByPatientId(@PathVariable int patientId) {
        return ishakService.getIshakByPatientId(patientId);
    }
}
