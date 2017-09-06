package app.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.dto.AdmissionDiagnosisDTO;
import app.dto.DischargeDiagnosisDTO;
import app.entities.AdmissionDiagnosisDO;
import app.entities.DischargeDiagnosisDO;
import app.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.Utils.UserMsgTool;
import app.dto.PageDTO;
import app.dto.PatientDTO;
import app.entities.PatientDO;
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
 * @author Administrator PatientServiceImpl
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

    @Autowired
    private UserProjectRoleRepo userProjectRoleRepo;

//    @Autowired
//    private AdmissionDiagnosisRepo admissionDiagnosisRepo;
//
//    @Autowired
//    private DischargeDiagnosisRepo dischargeDiagnosisRepo;

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

    public Boolean getCompleteById(int id) {
        return patientRepo.getCompleteById(id)?patientRepo.getCompleteById(id):null;
    }

    @Override
    public PageDTO<PatientDTO> getAllPatient(int projectId, Pageable pageable) {
        List<PatientDTO> patientDTOs = new ArrayList<>();
        Page<PatientDO> patientDOs = patientRepo.getAll(projectId,new UserMsgTool().getCurrentUser().getHospital().getId(),pageable);
        if(patientDOs.hasContent() && patientDOs != null) {
            for (PatientDO patientDO : patientDOs) {
                patientDTOs.add(convertToPatientDTO(patientDO));
            }
        }
        PageDTO<PatientDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(patientDTOs);
        pageDTO.setTotalNumber(patientDOs.getTotalPages());
        return pageDTO;
    }

    @Override
    public PageDTO<PatientDTO> getPatientByQueryStr(int projectId, String queryStr, Pageable pageable) {
        List<PatientDTO> patientDTOs = new ArrayList<>();
        Page<PatientDO> patientDOs = patientRepo.getPatientByQueryStr(projectId, queryStr, pageable);
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
        patientDO.setAbbreviation(patientDTO.getAbbreviation());
        patientDO.setAdmissionDate(patientDTO.getAdmissionDate());
        List<AdmissionDiagnosisDO> admissionDiagnosisDOS = new ArrayList<>();
        List<DischargeDiagnosisDO> dischargeDiagnosisDOS = new ArrayList<>();
        if (patientDTO.getAdmissionDiagnosisDTOS()!=null) {
            for (AdmissionDiagnosisDTO admissionDiagnosisDTO : patientDTO.getAdmissionDiagnosisDTOS()) {
                AdmissionDiagnosisDO admissionDiagnosisDO = new AdmissionDiagnosisDO();
                admissionDiagnosisDO.setDiagnosis(admissionDiagnosisDTO.getDiagnosis());
                admissionDiagnosisDO.setDiagnosisDate(admissionDiagnosisDTO.getDiagnosisDate());
                admissionDiagnosisDO.setPatientDO(patientDO);
                admissionDiagnosisDOS.add(admissionDiagnosisDO);
            }
        }
        if(patientDTO.getDischargeDiagnosisDTOS()!=null) {
            for (DischargeDiagnosisDTO dischargeDiagnosisDTO : patientDTO.getDischargeDiagnosisDTOS()) {
                DischargeDiagnosisDO dischargeDiagnosisDO = new DischargeDiagnosisDO();
                dischargeDiagnosisDO.setDiagnosisDate(dischargeDiagnosisDTO.getDiagnosisDate());
                dischargeDiagnosisDO.setDiagnosis(dischargeDiagnosisDTO.getDiagnosis());
                dischargeDiagnosisDO.setPatientDO(patientDO);
                dischargeDiagnosisDOS.add(dischargeDiagnosisDO);
            }
        }
        patientDO.setAdmissionDiagnosisDOS(admissionDiagnosisDOS);
        patientDO.setDischargeDiagnosisDOS(dischargeDiagnosisDOS);
        patientDO.setCareer(patientDTO.getCareer());
        patientDO.setDepartment(patientDTO.getDepartment());
        patientDO.setDischargeDate(patientDTO.getDischargeDate());
        patientDO.setHospitalizedNumber(patientDTO.getHospitalizedNumber());
        patientDO.setHospitalizedDepartment(patientDTO.getHospitalizedDepartment());
        patientDO.setHospitalizedAge(patientDTO.getHospitalizedAge());
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
        patientDO.setHospitalId(new UserMsgTool().getCurrentUser().getHospital().getId());
        patientDO.setProjectId(patientDTO.getProjectId());
        return patientDO;
    }

    public PatientDTO convertToPatientDTO(PatientDO patientDO) {
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
        patientDTO.setAbbreviation(patientDO.getAbbreviation());
        patientDTO.setDepartment(patientDO.getDepartment());
        patientDTO.setAdmissionDate(patientDO.getAdmissionDate());
        patientDTO.setDischargeDate(patientDO.getDischargeDate());
        patientDTO.setHospitalizedNumber(patientDO.getHospitalizedNumber());
        patientDTO.setHospitalizedDepartment(patientDO.getHospitalizedDepartment());
        patientDTO.setHospitalizedAge(patientDO.getHospitalizedAge());
        patientDTO.setCareer(patientDO.getCareer());
        List<AdmissionDiagnosisDTO> admissionDiagnosisDTOS = new ArrayList<>();
        List<DischargeDiagnosisDTO> dischargeDiagnosisDTOS = new ArrayList<>();
        for (AdmissionDiagnosisDO admissionDiagnosisDO : patientDO.getAdmissionDiagnosisDOS()) {
            AdmissionDiagnosisDTO admissionDiagnosisDTO = new AdmissionDiagnosisDTO();
            admissionDiagnosisDTO.setDiagnosis(admissionDiagnosisDO.getDiagnosis());
            admissionDiagnosisDTO.setDiagnosisDate(admissionDiagnosisDO.getDiagnosisDate());
            admissionDiagnosisDTO.setId(admissionDiagnosisDO.getId());
            admissionDiagnosisDTO.setPatientId(admissionDiagnosisDO.getPatientDO().getId());
            admissionDiagnosisDTOS.add(admissionDiagnosisDTO);
        }
        for (DischargeDiagnosisDO dischargeDiagnosisDO : patientDO.getDischargeDiagnosisDOS()) {
            DischargeDiagnosisDTO dischargeDiagnosisDTO = new DischargeDiagnosisDTO();
            dischargeDiagnosisDTO.setPatientId(dischargeDiagnosisDO.getPatientDO().getId());
            dischargeDiagnosisDTO.setId(dischargeDiagnosisDO.getId());
            dischargeDiagnosisDTO.setDiagnosisDate(dischargeDiagnosisDO.getDiagnosisDate());
            dischargeDiagnosisDTO.setDiagnosis(dischargeDiagnosisDO.getDiagnosis());
            dischargeDiagnosisDTOS.add(dischargeDiagnosisDTO);
        }
        patientDTO.setAdmissionDiagnosisDTOS(admissionDiagnosisDTOS);
        patientDTO.setDischargeDiagnosisDTOS(dischargeDiagnosisDTOS);
        if (patientDO.getProjectId() == 1) {
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
        } else {
            patientDTO.setComplete(true);
        }
        patientDTO.setHospitalId(patientDO.getHospitalId());
        patientDTO.setProjectId(patientDO.getProjectId());

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
        patientDO.setAbbreviation(patientDTO.getAbbreviation());
        patientDO.setDepartment(patientDTO.getDepartment());
        patientDO.setAdmissionDate(patientDTO.getAdmissionDate());
        patientDO.setDischargeDate(patientDTO.getDischargeDate());
        patientDO.setHospitalizedNumber(patientDTO.getHospitalizedNumber());
        patientDO.setHospitalizedDepartment(patientDTO.getHospitalizedDepartment());
        patientDO.setHospitalizedAge(patientDTO.getHospitalizedAge());
        patientDO.setCareer(patientDTO.getCareer());
        List<AdmissionDiagnosisDO> admissionDiagnosisDOS = new ArrayList<>();
        List<DischargeDiagnosisDO> dischargeDiagnosisDOS = new ArrayList<>();
        for (AdmissionDiagnosisDTO admissionDiagnosisDTO : patientDTO.getAdmissionDiagnosisDTOS()) {
            AdmissionDiagnosisDO admissionDiagnosisDO = new AdmissionDiagnosisDO();
            admissionDiagnosisDO.setDiagnosis(admissionDiagnosisDTO.getDiagnosis());
            admissionDiagnosisDO.setDiagnosisDate(admissionDiagnosisDTO.getDiagnosisDate());
            admissionDiagnosisDO.setPatientDO(patientDO);
            admissionDiagnosisDO.setId(admissionDiagnosisDTO.getId());
            admissionDiagnosisDOS.add(admissionDiagnosisDO);
        }
        for (DischargeDiagnosisDTO dischargeDiagnosisDTO : patientDTO.getDischargeDiagnosisDTOS()) {
            DischargeDiagnosisDO dischargeDiagnosisDO = new DischargeDiagnosisDO();
            dischargeDiagnosisDO.setDiagnosisDate(dischargeDiagnosisDTO.getDiagnosisDate());
            dischargeDiagnosisDO.setDiagnosis(dischargeDiagnosisDTO.getDiagnosis());
            dischargeDiagnosisDO.setPatientDO(patientDO);
            dischargeDiagnosisDO.setId(dischargeDiagnosisDTO.getId());
            dischargeDiagnosisDOS.add(dischargeDiagnosisDO);
        }
        patientDO.setAdmissionDiagnosisDOS(admissionDiagnosisDOS);
        patientDO.setDischargeDiagnosisDOS(dischargeDiagnosisDOS);
        patientDO.setHospitalId(new UserMsgTool().getCurrentUser().getHospital().getId());
        patientDO.setProjectId(patientDTO.getProjectId());
        return patientDO;
    }

}
