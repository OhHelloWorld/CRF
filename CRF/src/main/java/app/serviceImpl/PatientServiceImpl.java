package app.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dto.PageDTO;
import app.dto.PatientDTO;
import app.entities.PatientDO;
import app.repo.PatientRepo;
import app.service.BoneDensityService;
import app.service.ComplexAIHAfterTreatmentService;
import app.service.ComplexAIHBeforeTreatmentService;
import app.service.FinalDiaSpeCirService;
import app.service.FourDiagnosticInformationService;
import app.service.LiverPathologyService;
import app.service.MedicinePrescriptionService;
import app.service.PatientService;
import app.service.PhysicalChemicalInspectionService;
import app.service.SimpleAIHService;
import app.service.TonguePulseService;
import app.service.TreatmentService;

/**
 * @author Administrator ����serviceImpl
 */
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
    private BoneDensityService boneDensityService;

    @Autowired
    private ComplexAIHBeforeTreatmentService complexAIHBeforeTreatmentService;

    @Autowired
    private ComplexAIHAfterTreatmentService complexAIHAfterTreatmentService;

    @Autowired
    private FinalDiaSpeCirService finalDiaSpeCirService;

    @Autowired
    private LiverPathologyService liverPathologyService;

    @Autowired
    private MedicinePrescriptionService medicinePrescriptionService;

    @Autowired
    private SimpleAIHService simpleAIHService;

    @Autowired
    private TreatmentService treatmentService;

    @Transactional
    public int savePatientGeneralInformation(PatientDTO patientDTO) {
        return patientRepo.save(convertToPatientDO(patientDTO)).getId();
    }

    public PatientDTO getPatientGeneralInformation(int id) {

        if (patientRepo.getPatientInformationById(id) == null) {
            return null;
        } else {
            return convertToPatientDTO(patientRepo.getPatientInformationById(id));
        }
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
            patientDTOs.add(convertToPatientDTO(patientDO));
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
            patientDTOs.add(convertToPatientDTO(patientDO));
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

    private PatientDO convertToPatientDO(PatientDTO patientDTO) {
        PatientDO patientDO = new PatientDO();
        patientDO.setIdentifier(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()));
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

    private PatientDTO convertToPatientDTO(PatientDO patientDO) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patientDO.getId());
        patientDTO.setIdentifier(patientDO.getIdentifier());
        patientDTO.setNation(patientDO.getNation());
        patientDTO.setDrink(patientDO.isDrink());
        patientDTO.setFamilyHistory(patientDO.getFamilyHistory());
        patientDTO.setGender(patientDO.getGender());
        patientDTO.setHeight(patientDO.getHeight());
        patientDTO.setName(patientDO.getName());
        patientDTO.setSmoke(patientDO.isSmoke());
        patientDTO.setWeight(patientDO.getWeight());
        patientDTO.setBirthday(patientDO.getBirthday());
        patientDTO.setBmi(patientDO.getBmi());
        patientDTO.setDegreeOfEducation(patientDO.getDegreeOfEducation());
        patientDTO.setFirstTimeLiverInjury(patientDO.getFirstTimeLiverInjury());
        patientDTO.setInvestigateHospital(patientDO.getInvestigateHospital());
        patientDTO.setTelephone(patientDO.getTelephone());
        patientDTO.setDurationOfVisit(patientDO.getDurationOfVisit());
        patientDTO.setFirstVisitAge(patientDO.getFirstVisitAge());
        patientDTO.setFirstVisitTime(patientDO.getFirstVisitTime());
        patientDTO.setSmokeDrinkFamHis(patientDO.getSmokeDrinkFamHis());
        patientDTO.setConcurrentAutoDate(patientDO.getConcurrentAutoDate());
        patientDTO.setConcurrentAutoDisease(patientDO.getConcurrentAutoDisease());
        patientDTO.setConAutoDisFirstOrNot(patientDO.isConAutoDisFirstOrNot());
        patientDTO.setComplete(
                patientDO.isComplete() && fourDiaService.getCompleteByPatientId(patientDO.getId())
                        && tonguePulseService.getCompleteByPatientId(patientDO.getId())
                        && physicalService.getCompleteByPatientId(patientDO.getId())
                        && boneDensityService.getCompleteByPatientId(patientDO.getId())
                        && complexAIHBeforeTreatmentService
                                .getCompleteByPatientId(patientDO.getId())
                        && complexAIHAfterTreatmentService.getCompleteByPatientId(patientDO.getId())
                        && finalDiaSpeCirService.getCompleteByPatientId(patientDO.getId())
                        && liverPathologyService.getCompleteByPatientId(patientDO.getId())
                        && medicinePrescriptionService.getCompleteByPatientId(patientDO.getId())
                        && simpleAIHService.getCompleteByPatientId(patientDO.getId())
                        && treatmentService.getCompleteByPatientId(patientDO.getId()));
        return patientDTO;
    }

    private PatientDO editToPatientDO(PatientDO patientDO, PatientDTO patientDTO) {
        patientDO.setId(patientDTO.getId());
        patientDO.setIdentifier(patientDTO.getIdentifier());
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
