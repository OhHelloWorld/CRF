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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        PatientDO testDo = patientRepo.getPatientInformationById(id);
        PatientDTO testDTO = convertUtil.convertToPatientDTO(testDo);
        return testDTO;
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
        patientDO.setNation(patientDTO.getNation());
        patientDO.setDrink(patientDTO.isDrink());
        patientDO.setFamilyHistory(patientDTO.getFamilyHistory());
        patientDO.setGender(patientDTO.getGender());
        patientDO.setHeight(patientDTO.getHeight());
        patientDO.setName(patientDTO.getName());
        patientDO.setSmoke(patientDTO.isSmoke());
        patientDO.setWeight(patientDTO.getWeight());
        patientDO.setComplete(patientDTO.isComplete());
        patientDO.setBirthday(patientDTO.getBirthday());
        patientDO.setBmi(patientDTO.getBmi());
        patientDO.setDegreeOfEducation(patientDTO.getDegreeOfEducation());
        patientDO.setFirstTimeLiverInjury(patientDTO.getFirstTimeLiverInjury());
        patientDO.setInvestigateHospital(patientDTO.getInvestigateHospital());
        patientDO.setTelephone(patientDTO.getTelephone());
        patientDO.setDurationOfVisit(patientDTO.getDurationOfVisit());
        patientDO.setFirstVisitAge(patientDTO.getFirstVisitAge());
        patientDO.setFirstVisitTime(patientDTO.getFirstVisitTime());
        patientDO.setSmokeDrinkFamHis(patientDTO.getSmokeDrinkFamHis());
        patientDO.setConcurrentAutoDate(patientDTO.getConcurrentAutoDate());
        patientDO.setConcurrentAutoDisease(patientDTO.isConcurrentAutoDisease());
        patientDO.setConAutoDisFirstOrNot(patientDTO.isConAutoDisFirstOrNot());
        return patientDO;
    }

}
