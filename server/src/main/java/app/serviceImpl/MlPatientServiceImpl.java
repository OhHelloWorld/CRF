package app.serviceImpl;

import app.Utils.UserMsgTool;
import app.dto.AdmissionDiagnosisDTO;
import app.dto.DischargeDiagnosisDTO;
import app.dto.MlPatientDTO;
import app.dto.PageDTO;
import app.entities.AdmissionDiagnosisDO;
import app.entities.DischargeDiagnosisDO;
import app.entities.MlPatientDO;
import app.repo.*;
import app.service.MlPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator PatientServiceImpl
 */
@Service
public class MlPatientServiceImpl implements MlPatientService {

    @Autowired
    private MlPatientRepo mlpatientRepo;

    @Autowired
    private UserProjectRoleRepo userProjectRoleRepo;

    @Autowired
    private AdmissionDiagnosisRepo admissionDiagnosisRepo;

    @Autowired
    private DischargeDiagnosisRepo dischargeDiagnosisRepo;

    @Autowired
    private MlDiseaseHistoryRepo mlDiseaseHistoryRepo;

    @Autowired
    private MlAllergyHistoryRepo mlAllergyHistoryRepo;

    @Autowired
    private MlDrinkRepo mlDrinkRepo;

    @Autowired
    private MlDrugHistoryRepo mlDrugHistoryRepo;

    @Autowired
    private MlSymptomsRepo mlSymptomsRepo;

    @Autowired
    private FirstAbnormalExaminationRepo firstAbnormalExaminationRepo;

    @Autowired
    private ExcludeOtherRepo excludeOtherRepo;

    @Autowired
    private MlRoutineBooldRepo mlRoutineBooldRepo;

    @Autowired
    private ImagingEndoScopyRepo imagingEndoScopyRepo;

    @Autowired
    private MlLiverHistologicalRepo mlLiverHistologicalRepo;

    @Autowired
    private MlLiverInjuryRepo mlLiverInjuryRepo;

    @Autowired
    private MlTreatmentRepo mlTreatmentRepo;

    @Autowired
    private MlDiseaseOutcomeRepo mlDiseaseOutcomeRepo;

    @Autowired
    private MlBiologicalSamplesRepo mlBiologicalSamplesRepo;


    @Transactional
    public int saveMlPatientGeneralInformation(MlPatientDTO mlPatientDTO) {
        return mlpatientRepo.save(convertToMlPatientDO(mlPatientDTO)).getId();
    }

    public MlPatientDTO getMlPatientGeneralInformation(int id) {
        return mlpatientRepo.getMlPatientInformationById(id) != null ? convertToMlPatientDTO(mlpatientRepo.getMlPatientInformationById(id)) : null;
    }

    public Boolean getCompleteById(int id) {
        return mlpatientRepo.getCompleteById(id) ? mlpatientRepo.getCompleteById(id) : null;
    }

    @Override
    public PageDTO<MlPatientDTO> getAllPatient(int projectId, Pageable pageable) {
        List<MlPatientDTO> mlPatientDTOs = new ArrayList<>();
        Page<MlPatientDO> mlPatientDOs = mlpatientRepo.getAll(projectId, new UserMsgTool().getCurrentUser().getHospital().getId(), pageable);
        if (mlPatientDOs.hasContent() && mlPatientDOs != null) {
            for (MlPatientDO mlPatientDO : mlPatientDOs) {
                mlPatientDTOs.add(convertToMlPatientDTO(mlPatientDO));
            }
        }
        PageDTO<MlPatientDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(mlPatientDTOs);
        pageDTO.setTotalNumber(mlPatientDOs.getTotalPages());
        return pageDTO;
    }

    @Override
    public PageDTO<MlPatientDTO> getMlPatientByQueryStr(int projectId, String queryStr, Pageable pageable) {
        List<MlPatientDTO> mlPatientDTOs = new ArrayList<>();
        Page<MlPatientDO> mlPatientDOs = mlpatientRepo.getMlPatientByQueryStr(projectId, queryStr, pageable);
        for (MlPatientDO mlPatientDO : mlPatientDOs) {
            mlPatientDTOs.add(convertToMlPatientDTO(mlPatientDO));
        }
        PageDTO<MlPatientDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(mlPatientDTOs);
        pageDTO.setTotalNumber(mlPatientDOs.getTotalPages());
        return pageDTO;
    }

    public void editMlPatient(MlPatientDTO mlPatientDTO) {
        MlPatientDO mlPatientDO = mlpatientRepo.findOne(mlPatientDTO.getId());
        mlPatientDO.setId(mlPatientDTO.getId());
        mlPatientDO.setIdentifier(mlPatientDTO.getIdentifier());
        mlPatientDO.setHospital(mlPatientDTO.getHospital());
        mlPatientDO.setNation(mlPatientDTO.getNation());
        mlPatientDO.setBmi(mlPatientDTO.getBmi());
        mlPatientDO.setGender(mlPatientDTO.getGender());
        mlPatientDO.setHeight(mlPatientDTO.getHeight());
        mlPatientDO.setName(mlPatientDTO.getName());
        mlPatientDO.setWeight(mlPatientDTO.getWeight());
        mlPatientDO.setBirthday(mlPatientDTO.getBirthday());
        mlPatientDO.setAbbreviation(mlPatientDTO.getAbbreviation());
        mlPatientDO.setDepartment(mlPatientDTO.getDepartment());
        mlPatientDO.setAdmissionDate(mlPatientDTO.getAdmissionDate());
        mlPatientDO.setDischargeDate(mlPatientDTO.getDischargeDate());
        mlPatientDO.setHospitalizedNumber(mlPatientDTO.getHospitalizedNumber());
        mlPatientDO.setHospitalizedAge(mlPatientDTO.getHospitalizedAge());
        mlPatientDO.setCareer(mlPatientDTO.getCareer());
        List<AdmissionDiagnosisDO> admissionDiagnosisDOS = new ArrayList<>();
        List<DischargeDiagnosisDO> dischargeDiagnosisDOS = new ArrayList<>();

        admissionDiagnosisRepo.deleteAdmissionByPatientId(mlPatientDTO.getId());
        dischargeDiagnosisRepo.deleteDischargeByPatientId(mlPatientDTO.getId());

        for (AdmissionDiagnosisDTO admissionDiagnosisDTO : mlPatientDTO.getAdmissionDiagnosisDTOS()) {
//            AdmissionDiagnosisDO admissionDiagnosisDO = admissionDiagnosisDTO.getId() != 0 ? admissionDiagnosisRepo.findOne(admissionDiagnosisDTO.getId()) : new AdmissionDiagnosisDO();
            AdmissionDiagnosisDO admissionDiagnosisDO = new AdmissionDiagnosisDO();
            admissionDiagnosisDO.setDiagnosis(admissionDiagnosisDTO.getDiagnosis());
            admissionDiagnosisDO.setDiagnosisDate(admissionDiagnosisDTO.getDiagnosisDate());
            admissionDiagnosisDO.setMlPatientDO(mlPatientDO);
            admissionDiagnosisDOS.add(admissionDiagnosisDO);
        }
        for (DischargeDiagnosisDTO dischargeDiagnosisDTO : mlPatientDTO.getDischargeDiagnosisDTOS()) {
//            DischargeDiagnosisDO dischargeDiagnosisDO = dischargeDiagnosisDTO.getId() != 0? dischargeDiagnosisRepo.findOne(dischargeDiagnosisDTO.getId()) : new DischargeDiagnosisDO();
            DischargeDiagnosisDO dischargeDiagnosisDO = new DischargeDiagnosisDO();
            dischargeDiagnosisDO.setDiagnosisDate(dischargeDiagnosisDTO.getDiagnosisDate());
            dischargeDiagnosisDO.setDiagnosis(dischargeDiagnosisDTO.getDiagnosis());
            dischargeDiagnosisDO.setMlPatientDO(mlPatientDO);
            dischargeDiagnosisDOS.add(dischargeDiagnosisDO);
        }
        mlPatientDO.setAdmissionDiagnosisDOS(admissionDiagnosisDOS);
        mlPatientDO.setDischargeDiagnosisDOS(dischargeDiagnosisDOS);
        mlPatientDO.setHospitalId(new UserMsgTool().getCurrentUser().getHospital().getId());
        mlPatientDO.setProjectId(mlPatientDTO.getProjectId());
        mlpatientRepo.save(mlPatientDO);
    }

    private MlPatientDO convertToMlPatientDO(MlPatientDTO mlPatientDTO) {
        MlPatientDO mlPatientDO = new MlPatientDO();
        mlPatientDO.setIdentifier(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()));
        mlPatientDO.setAbbreviation(mlPatientDTO.getAbbreviation());
        mlPatientDO.setAdmissionDate(mlPatientDTO.getAdmissionDate());
        mlPatientDO.setHospital(mlPatientDTO.getHospital());
        mlPatientDO.setBmi(mlPatientDTO.getBmi());
        List<AdmissionDiagnosisDO> admissionDiagnosisDOS = new ArrayList<>();
        List<DischargeDiagnosisDO> dischargeDiagnosisDOS = new ArrayList<>();
        if (mlPatientDTO.getAdmissionDiagnosisDTOS() != null) {
            for (AdmissionDiagnosisDTO admissionDiagnosisDTO : mlPatientDTO.getAdmissionDiagnosisDTOS()) {
                AdmissionDiagnosisDO admissionDiagnosisDO = new AdmissionDiagnosisDO();
                admissionDiagnosisDO.setDiagnosis(admissionDiagnosisDTO.getDiagnosis());
                admissionDiagnosisDO.setDiagnosisDate(admissionDiagnosisDTO.getDiagnosisDate());
                admissionDiagnosisDO.setMlPatientDO(mlPatientDO);
                admissionDiagnosisDOS.add(admissionDiagnosisDO);
            }
        }
        if (mlPatientDTO.getDischargeDiagnosisDTOS() != null) {
            for (DischargeDiagnosisDTO dischargeDiagnosisDTO : mlPatientDTO.getDischargeDiagnosisDTOS()) {
                DischargeDiagnosisDO dischargeDiagnosisDO = new DischargeDiagnosisDO();
                dischargeDiagnosisDO.setDiagnosisDate(dischargeDiagnosisDTO.getDiagnosisDate());
                dischargeDiagnosisDO.setDiagnosis(dischargeDiagnosisDTO.getDiagnosis());
                dischargeDiagnosisDO.setMlPatientDO(mlPatientDO);
                dischargeDiagnosisDOS.add(dischargeDiagnosisDO);
            }
        }
        mlPatientDO.setAdmissionDiagnosisDOS(admissionDiagnosisDOS);
        mlPatientDO.setDischargeDiagnosisDOS(dischargeDiagnosisDOS);
        mlPatientDO.setCareer(mlPatientDTO.getCareer());
        mlPatientDO.setDepartment(mlPatientDTO.getDepartment());
        mlPatientDO.setDischargeDate(mlPatientDTO.getDischargeDate());
        mlPatientDO.setHospitalizedNumber(mlPatientDTO.getHospitalizedNumber());
        mlPatientDO.setHospitalizedAge(mlPatientDTO.getHospitalizedAge());
        mlPatientDO.setNation(mlPatientDTO.getNation());
        mlPatientDO.setGender(mlPatientDTO.getGender());
        mlPatientDO.setHeight(mlPatientDTO.getHeight());
        mlPatientDO.setName(mlPatientDTO.getName());
        mlPatientDO.setWeight(mlPatientDTO.getWeight());
        mlPatientDO.setComplete(mlPatientDTO.isComplete());
        mlPatientDO.setBirthday(mlPatientDTO.getBirthday());
        mlPatientDO.setHospitalId(new UserMsgTool().getCurrentUser().getHospital().getId());
        mlPatientDO.setProjectId(mlPatientDTO.getProjectId());
        return mlPatientDO;
    }

    @Override
    public MlPatientDTO convertToMlPatientDTO(MlPatientDO mlPatientDO) {
        MlPatientDTO mlPatientDTO = new MlPatientDTO();
        mlPatientDTO.setId(mlPatientDO.getId());
        mlPatientDTO.setIdentifier(mlPatientDO.getIdentifier());
        mlPatientDTO.setHospital(mlPatientDO.getHospital());
        mlPatientDTO.setNation(mlPatientDO.getNation());
        mlPatientDTO.setBmi(mlPatientDO.getBmi());
        mlPatientDTO.setGender(mlPatientDO.getGender());
        mlPatientDTO.setHeight(mlPatientDO.getHeight());
        mlPatientDTO.setName(mlPatientDO.getName());
        mlPatientDTO.setWeight(mlPatientDO.getWeight());
        mlPatientDTO.setBirthday(mlPatientDO.getBirthday());
        mlPatientDTO.setAbbreviation(mlPatientDO.getAbbreviation());
        mlPatientDTO.setDepartment(mlPatientDO.getDepartment());
        mlPatientDTO.setAdmissionDate(mlPatientDO.getAdmissionDate());
        mlPatientDTO.setDischargeDate(mlPatientDO.getDischargeDate());
        mlPatientDTO.setHospitalizedNumber(mlPatientDO.getHospitalizedNumber());
        mlPatientDTO.setHospitalizedAge(mlPatientDO.getHospitalizedAge());
        mlPatientDTO.setCareer(mlPatientDO.getCareer());
        List<AdmissionDiagnosisDTO> admissionDiagnosisDTOS = new ArrayList<>();
        List<DischargeDiagnosisDTO> dischargeDiagnosisDTOS = new ArrayList<>();
        for (AdmissionDiagnosisDO admissionDiagnosisDO : mlPatientDO.getAdmissionDiagnosisDOS()) {
            AdmissionDiagnosisDTO admissionDiagnosisDTO = new AdmissionDiagnosisDTO();
            admissionDiagnosisDTO.setId(admissionDiagnosisDO.getId());
            admissionDiagnosisDTO.setDiagnosis(admissionDiagnosisDO.getDiagnosis());
            admissionDiagnosisDTO.setDiagnosisDate(admissionDiagnosisDO.getDiagnosisDate());
            admissionDiagnosisDTO.setId(admissionDiagnosisDO.getId());
            admissionDiagnosisDTO.setMlPatientId(admissionDiagnosisDO.getMlPatientDO().getId());
            admissionDiagnosisDTOS.add(admissionDiagnosisDTO);
        }
        for (DischargeDiagnosisDO dischargeDiagnosisDO : mlPatientDO.getDischargeDiagnosisDOS()) {
            DischargeDiagnosisDTO dischargeDiagnosisDTO = new DischargeDiagnosisDTO();
            dischargeDiagnosisDTO.setId(dischargeDiagnosisDO.getId());
            dischargeDiagnosisDTO.setMlPatientId(dischargeDiagnosisDO.getMlPatientDO().getId());
            dischargeDiagnosisDTO.setId(dischargeDiagnosisDO.getId());
            dischargeDiagnosisDTO.setDiagnosisDate(dischargeDiagnosisDO.getDiagnosisDate());
            dischargeDiagnosisDTO.setDiagnosis(dischargeDiagnosisDO.getDiagnosis());
            dischargeDiagnosisDTOS.add(dischargeDiagnosisDTO);
        }
        mlPatientDTO.setAdmissionDiagnosisDTOS(admissionDiagnosisDTOS);
        mlPatientDTO.setDischargeDiagnosisDTOS(dischargeDiagnosisDTOS);

        int tempId = mlPatientDO.getId();
        Boolean com = formatBool(mlDiseaseHistoryRepo.getCompleteByPatientId(tempId)) && formatBool(mlAllergyHistoryRepo.getCompleteByPatientId(tempId)) && formatBool(mlDrinkRepo.getCompleteByPatientId(tempId)) && formatBool(mlDrugHistoryRepo.getCompleteByPatientId(tempId)) && formatBool(mlSymptomsRepo.getCompleteByPatientId(tempId)) && formatBool(firstAbnormalExaminationRepo.getCompleteByPatientId(tempId)) && formatBool(firstAbnormalExaminationRepo.getHosCompleteByPatientId(tempId)) && formatBool(excludeOtherRepo.getCompleteByPatientId(tempId)) && formatBool(mlRoutineBooldRepo.getCompleteByPatientId(tempId)) && formatBool(imagingEndoScopyRepo.getCompleteByPatientId(tempId)) && formatBool(mlLiverHistologicalRepo.getCompleteByPatientId(tempId)) && formatBool(mlLiverInjuryRepo.getCompleteByPatientId(tempId)) && formatBool(mlTreatmentRepo.getCompleteByPatientId(tempId)) && formatBool(mlDiseaseOutcomeRepo.getCompleteByPatientId(tempId)) && formatBool(mlBiologicalSamplesRepo.getCompleteByPatientId(tempId));

        mlPatientDTO.setComplete(com);
        mlPatientDTO.setHospitalId(mlPatientDO.getHospitalId());
        mlPatientDTO.setProjectId(mlPatientDO.getProjectId());
        return mlPatientDTO;
    }

    @Override
    public List<int[]> getMlPatientAgeData() {
        List<int[]> data = new ArrayList<>();
        int[] man = new int[8];
        int[] woman = new int[8];
        List<MlPatientDO> manPatients = mlpatientRepo.getMlPatientByGender("男");
        List<MlPatientDO> womanPatients = mlpatientRepo.getMlPatientByGender("女");

        for(MlPatientDO mlPatientDO : manPatients){
            man[judgeAge(mlPatientDO.getHospitalizedAge())]++;
        }

        for(MlPatientDO mlPatientDO : womanPatients){
            woman[judgeAge(mlPatientDO.getHospitalizedAge())]++;
        }

        data.add(man);
        data.add(woman);
        return data;
    }

    private boolean formatBool(Boolean temp){
        return temp == null?false:temp;
    }

    private int judgeAge(int age){
        if(age >=0 && age <10){
            return 0;
        }else if(age >=10 && age < 20) {
            return 1;
        }else if(age >=20 && age < 30){
            return 2;
        }else if(age >=30 && age < 40){
            return 3;
        }else if(age >=40 && age < 50){
            return 4;
        }else if(age >=50 && age <60){
            return 5;
        }else if(age >= 60 && age <70){
            return 6;
        }else if(age >=70 && age <80){
            return 7;
        }else{
            return -1;
        }
    }
}
