package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.PageDTO;
import app.dto.PatientDTO;
import app.entities.PatientDO;
import app.repo.PatientRepo;
import app.service.FourDiagnosticInformationService;
import app.service.PatientService;
import app.service.PhysicalChemicalInspectionService;
import app.service.TonguePulseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private FourDiagnosticInformationService fourDiaService;

    @Autowired
    private TonguePulseService tonguePulseService;

    @Autowired
    private PhysicalChemicalInspectionService physicalService;

    @Autowired
    private ConvertUtil convertUtil;

    @Transactional
    public int savePatientGeneralInformation(PatientDTO patientDTO) {
        return patientRepo.save(convertUtil.convertToPatientDO(patientDTO)).getId();
    }

    public PatientDTO getPatientGeneralInformation(int id) {

        return convertUtil.convertToPatientDTO(patientRepo.getPatientInformationById(id));
    }

    public boolean getCompleteById(int id) {
        try {
            return patientRepo.getCompleteById(id);
        } catch (Exception e) {
            return false;
        }
    }

    public PageDTO<PatientDTO> getAllPatient(Pageable pageable) {
        List<PatientDTO> patientDTOs = new ArrayList<>();
        Page<PatientDO> patientDOs = patientRepo.getAll(pageable);
        for (PatientDO patientDO : patientDOs) {
            patientDTOs.add(convertUtil.convertToPatientDTO(patientDO));
        }
        PageDTO<PatientDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(patientDTOs);
        pageDTO.setTotalNumber(patientDOs.getTotalPages());
        return pageDTO;
    }

    @Override
    public PageDTO<PatientDTO> getPatientByQueryStr(String queryStr, Pageable pageable) {
        List<PatientDTO> patientDTOs = new ArrayList<>();
        Page<PatientDO> patientDOs = patientRepo.getPatientByQueryStr(queryStr, pageable);
        for (PatientDO patientDO : patientDOs) {
            patientDTOs.add(convertUtil.convertToPatientDTO(patientDO));
        }
        PageDTO<PatientDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(patientDTOs);
        pageDTO.setTotalNumber(patientDOs.getTotalPages());
        return pageDTO;
    }

    @Transactional
    public void editPatient(PatientDTO patientDTO) {
        PatientDO patientDO = patientRepo.findOne(patientDTO.getId());
        editToPatientDO(patientDO, patientDTO);
        patientRepo.save(patientDO);
    }



    private PatientDO editToPatientDO(PatientDO patientDO, PatientDTO patientDTO) {
        patientDO.setIdentifier(patientDTO.getIdentifier());
        patientDO.setId(patientDTO.getId());
        patientDO.setAge(patientDTO.getAge());
        patientDO.setChineseMedicineDiagnosis(patientDTO.getChineseMedicineDiagnosis());
        patientDO.setChineseMedicineTreatment(patientDTO.getChineseMedicineTreatment());
        patientDO.setCirrhosisDiagnosisTime(patientDTO.getCirrhosisDiagnosisTime());
        patientDO.setComplete(patientDTO.isComplete());
        patientDO.setDrink(patientDTO.isDrink());
        patientDO.setFamilyHistory(patientDTO.isFamilyHistory());
        patientDO.setGender(patientDTO.getGender());
        patientDO.setHeight(patientDTO.getHeight());
        patientDO.setHepatitisDiagnosisTime(patientDTO.getHepatitisDiagnosisTime());
        patientDO.setName(patientDTO.getName());
        patientDO.setSmoke(patientDTO.isSmoke());
        patientDO.setWeight(patientDTO.getWeight());
        patientDO.setWesternMedicineDiagnosis(patientDTO.getWesternMedicineDiagnosis());
        patientDO.setWesternMedicineTreatment(patientDTO.getWesternMedicineTreatment());
        return patientDO;
    }

}
