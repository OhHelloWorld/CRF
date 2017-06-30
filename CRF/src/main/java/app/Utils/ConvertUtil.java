package app.Utils;

import app.dto.*;
import app.entities.*;
import app.repo.ProjectRoleRepo;
import app.repo.UserProjectRoleRepo;
import app.service.FourDiagnosticInformationService;
import app.service.PhysicalChemicalInspectionService;
import app.service.TonguePulseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 52400 on 2017/6/20.
 */

@Service
public class ConvertUtil {

    @Autowired
    private FourDiagnosticInformationService fourDiaService;

    @Autowired
    private TonguePulseService tonguePulseService;

    @Autowired
    private UserMsgTool userTool;

    @Autowired
    private ProjectRoleRepo projectRoleRepo;

    @Autowired
    private UserProjectRoleRepo userProjectRoleRepo;

    @Autowired
    private PhysicalChemicalInspectionService physicalService;

    public  TonguePulseDO convertToTonguePulseDO(TonguePulseDTO tonguePulseDTO) {
        TonguePulseDO tonguePulseDO = new TonguePulseDO();
        tonguePulseDO.setComplete(tonguePulseDTO.isComplete());
        tonguePulseDO.setLeftPulse(tonguePulseDTO.getLeftPulse());
        tonguePulseDO.setMossy(tonguePulseDTO.getMossy());
        tonguePulseDO.setMossyPart(tonguePulseDTO.getMossyPart());
        tonguePulseDO.setMossyPartialDescription(tonguePulseDTO.getMossyPartialDescription());
        tonguePulseDO.setPatientId(tonguePulseDTO.getPatientId());
        tonguePulseDO.setRightPulse(tonguePulseDTO.getRightPulse());
        tonguePulseDO.setSublingualVaricoseVeins(tonguePulseDTO.getSublingualVaricoseVeins());
        tonguePulseDO.setTongue(tonguePulseDTO.getTongue());
        tonguePulseDO.setTongueBody(tonguePulseDTO.getTongueBody());
        tonguePulseDO.setTongueColor(tonguePulseDTO.getTongueColor());
        tonguePulseDO.setTongueColorPart(tonguePulseDTO.getTongueColorPart());
        tonguePulseDO.setTongueColorPartialDescription(
                tonguePulseDTO.getTongueColorPartialDescription());
        tonguePulseDO.setTonguePart(tonguePulseDTO.getTonguePart());
        tonguePulseDO.setTonguePartialDescription(tonguePulseDTO.getTonguePartialDescription());
        return tonguePulseDO;
    }

    public  TonguePulseDTO convertToTonguePulseDTO(TonguePulseDO tDo) {
        TonguePulseDTO tDto = new TonguePulseDTO();
        tDto.setId(tDo.getId());
        tDto.setComplete(tDo.isComplete());
        tDto.setLeftPulse(tDo.getLeftPulse());
        tDto.setMossy(tDo.getMossy());
        tDto.setMossyPart(tDo.getMossyPart());
        tDto.setMossyPartialDescription(tDo.getMossyPartialDescription());
        tDto.setPatientId(tDo.getPatientId());
        tDto.setRightPulse(tDo.getRightPulse());
        tDto.setSublingualVaricoseVeins(tDo.getSublingualVaricoseVeins());
        tDto.setTongue(tDo.getTongue());
        tDto.setTongueBody(tDo.getTongueBody());
        tDto.setTongueColor(tDo.getTongueColor());
        tDto.setTongueColorPart(tDo.getTongueColorPart());
        tDto.setTongueColorPartialDescription(tDo.getTongueColorPartialDescription());
        tDto.setTonguePart(tDo.getTonguePart());
        tDto.setTonguePartialDescription(tDo.getTonguePartialDescription());
        return tDto;
    }

    public  PhysicalChemicalInspectionDO convertToPhysicalChemicalInspectionDO(
            PhysicalChemicalInspectionDTO pDto) {
        PhysicalChemicalInspectionDO pDo = new PhysicalChemicalInspectionDO();
        pDo.setANACentromere(pDto.getANACentromere());
        pDo.setANAHomogeneous(pDto.getANAHomogeneous());
        pDo.setANANuclear(pDto.getANANuclear());
        pDo.setANANucleolus(pDto.getANANucleolus());
        pDo.setANANucleolusEnhancement(pDto.getANANucleolusEnhancement());
        pDo.setANAOther(pDto.getANAOther());
        pDo.setANAParticle(pDto.getANAParticle());
        pDo.setANAPeripheral(pDto.getANAPeripheral());
        pDo.setBloodRoutineEosinophils(pDto.getBloodRoutineEosinophils());
        pDo.setBloodRoutineHb(pDto.getBloodRoutineHb());
        pDo.setBloodRoutineLymphocytes(pDto.getBloodRoutineLymphocytes());
        pDo.setBloodRoutineNeutrophils(pDto.getBloodRoutineNeutrophils());
        pDo.setBloodRoutinePlatelets(pDto.getBloodRoutinePlatelets());
        pDo.setBloodRoutineRBC(pDto.getBloodRoutineRBC());
        pDo.setBloodRoutineWBC(pDto.getBloodRoutineWBC());
        pDo.setCellularImmunityCD2(pDto.getCellularImmunityCD2());
        pDo.setCellularImmunityCD3(pDto.getCellularImmunityCD3());
        pDo.setCellularImmunityCD4(pDto.getCellularImmunityCD4());
        pDo.setCellularImmunityCD4CD8(pDto.getCellularImmunityCD4CD8());
        pDo.setCellularImmunityCD56(pDto.getCellularImmunityCD56());
        pDo.setCellularImmunityCD8(pDto.getCellularImmunityCD8());
        pDo.setClottingINR(pDto.getClottingINR());
        pDo.setClottingPT(pDto.getClottingPT());
        pDo.setComplete(pDto.isComplete());
        pDo.setCTMRI(pDto.getCTMRI());
        pDo.setHumoralImmunityComplementC3(pDto.getHumoralImmunityComplementC3());
        pDo.setHumoralImmunityComplementC4(pDto.getHumoralImmunityComplementC4());
        pDo.setHumoralImmunityIgA(pDto.getHumoralImmunityIgA());
        pDo.setHumoralImmunityIgE(pDto.getHumoralImmunityIgE());
        pDo.setHumoralImmunityIgG(pDto.getHumoralImmunityIgG());
        pDo.setHumoralImmunityIgM(pDto.getHumoralImmunityIgM());
        pDo.setHumoralImmunityImmuneComplexf(pDto.getHumoralImmunityImmuneComplexf());
        pDo.setHumoralImmunityKlightChain(pDto.getHumoralImmunityKlightChain());
        pDo.setHumoralImmunityNlightChain(pDto.getHumoralImmunityNlightChain());
        pDo.setLiverDiseaseAutoantibodiesAMA(pDto.getLiverDiseaseAutoantibodiesAMA());
        pDo.setLiverDiseaseAutoantibodiesAMAM2(pDto.getLiverDiseaseAutoantibodiesAMAM2());
        pDo.setLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibody(
                pDto.getLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibody());
        pDo.setLiverDiseaseAutoantibodiesHepatocyteSoluteAntigen(
                pDto.getLiverDiseaseAutoantibodiesHepatocyteSoluteAntigen());
        pDo.setLiverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies(
                pDto.getLiverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies());
        pDo.setLiverDiseaseAutoantibodiesOther(pDto.getLiverDiseaseAutoantibodiesOther());
        pDo.setLiverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen(
                pDto.getLiverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen());
        pDo.setLiverFunctionAlbumin(pDto.getLiverFunctionAlbumin());
        pDo.setLiverFunctionALP(pDto.getLiverFunctionALP());
        pDo.setLiverFunctionALT(pDto.getLiverFunctionALT());
        pDo.setLiverFunctionAST(pDto.getLiverFunctionAST());
        pDo.setLiverFunctionDirectBilirubin(pDto.getLiverFunctionDirectBilirubin());
        pDo.setLiverFunctionGGT(pDto.getLiverFunctionGGT());
        pDo.setLiverFunctionGlobulin(pDto.getLiverFunctionGlobulin());
        pDo.setLiverFunctionRglobulin(pDto.getLiverFunctionRglobulin());
        pDo.setLiverFunctionTotalBilirubin(pDto.getLiverFunctionTotalBilirubin());
        pDo.setLiverFunctionTotalCholesterol(pDto.getLiverFunctionTotalCholesterol());
        pDo.setLiverHardnessFibroscan(pDto.getLiverHardnessFibroscan());
        pDo.setLiverHardnessFibrotest(pDto.getLiverHardnessFibrotest());
        pDo.setLiverPuncturePathology(pDto.getLiverPuncturePathology());
        pDo.setPatientId(pDto.getPatientId());
        pDo.setRenalFunctionBUN(pDto.getRenalFunctionBUN());
        pDo.setRenalFunctionCr(pDto.getRenalFunctionCr());
        pDo.setRheumaticImmuneRelatedAntibodies(pDto.getRheumaticImmuneRelatedAntibodies());
        pDo.setTotalBileAcid(pDto.getTotalBileAcid());
        return pDo;
    }

    public  PhysicalChemicalInspectionDTO convertToPhysicalDTO(PhysicalChemicalInspectionDO pDo) {
        PhysicalChemicalInspectionDTO pDto = new PhysicalChemicalInspectionDTO();
        pDto.setANACentromere(pDo.getANACentromere());
        pDto.setANAHomogeneous(pDo.getANAHomogeneous());
        pDto.setANANuclear(pDo.getANANuclear());
        pDto.setANANucleolus(pDo.getANANucleolus());
        pDto.setANANucleolusEnhancement(pDo.getANANucleolusEnhancement());
        pDto.setANAOther(pDo.getANAOther());
        pDto.setANAParticle(pDo.getANAParticle());
        pDto.setANAPeripheral(pDo.getANAPeripheral());
        pDto.setBloodRoutineEosinophils(pDo.getBloodRoutineEosinophils());
        pDto.setBloodRoutineHb(pDo.getBloodRoutineHb());
        pDto.setBloodRoutineLymphocytes(pDo.getBloodRoutineLymphocytes());
        pDto.setBloodRoutineNeutrophils(pDo.getBloodRoutineNeutrophils());
        pDto.setBloodRoutinePlatelets(pDo.getBloodRoutinePlatelets());
        pDto.setBloodRoutineRBC(pDo.getBloodRoutineRBC());
        pDto.setBloodRoutineWBC(pDo.getBloodRoutineWBC());
        pDto.setCellularImmunityCD2(pDo.getCellularImmunityCD2());
        pDto.setCellularImmunityCD3(pDo.getCellularImmunityCD3());
        pDto.setCellularImmunityCD4(pDo.getCellularImmunityCD4());
        pDto.setCellularImmunityCD4CD8(pDo.getCellularImmunityCD4CD8());
        pDto.setCellularImmunityCD56(pDo.getCellularImmunityCD56());
        pDto.setCellularImmunityCD8(pDo.getCellularImmunityCD8());
        pDto.setClottingINR(pDo.getClottingINR());
        pDto.setClottingPT(pDo.getClottingPT());
        pDto.setComplete(pDo.isComplete());
        pDto.setCTMRI(pDo.getCTMRI());
        pDto.setHumoralImmunityComplementC3(pDo.getHumoralImmunityComplementC3());
        pDto.setHumoralImmunityComplementC4(pDo.getHumoralImmunityComplementC4());
        pDto.setHumoralImmunityIgA(pDo.getHumoralImmunityIgA());
        pDto.setHumoralImmunityIgE(pDo.getHumoralImmunityIgE());
        pDto.setHumoralImmunityIgG(pDo.getHumoralImmunityIgG());
        pDto.setHumoralImmunityIgM(pDo.getHumoralImmunityIgM());
        pDto.setHumoralImmunityImmuneComplexf(pDo.getHumoralImmunityImmuneComplexf());
        pDto.setHumoralImmunityKlightChain(pDo.getHumoralImmunityKlightChain());
        pDto.setHumoralImmunityNlightChain(pDo.getHumoralImmunityNlightChain());
        pDto.setLiverDiseaseAutoantibodiesAMA(pDo.getLiverDiseaseAutoantibodiesAMA());
        pDto.setLiverDiseaseAutoantibodiesAMAM2(pDo.getLiverDiseaseAutoantibodiesAMAM2());
        pDto.setLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibody(
                pDo.getLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibody());
        pDto.setLiverDiseaseAutoantibodiesHepatocyteSoluteAntigen(
                pDo.getLiverDiseaseAutoantibodiesHepatocyteSoluteAntigen());
        pDto.setLiverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies(
                pDo.getLiverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies());
        pDto.setLiverDiseaseAutoantibodiesOther(pDo.getLiverDiseaseAutoantibodiesOther());
        pDto.setLiverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen(
                pDo.getLiverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen());
        pDto.setLiverFunctionAlbumin(pDo.getLiverFunctionAlbumin());
        pDto.setLiverFunctionALP(pDo.getLiverFunctionALP());
        pDto.setLiverFunctionALT(pDo.getLiverFunctionALT());
        pDto.setLiverFunctionAST(pDo.getLiverFunctionAST());
        pDto.setLiverFunctionDirectBilirubin(pDo.getLiverFunctionDirectBilirubin());
        pDto.setLiverFunctionGGT(pDo.getLiverFunctionGGT());
        pDto.setLiverFunctionGlobulin(pDo.getLiverFunctionGlobulin());
        pDto.setLiverFunctionRglobulin(pDo.getLiverFunctionRglobulin());
        pDto.setLiverFunctionTotalBilirubin(pDo.getLiverFunctionTotalBilirubin());
        pDto.setLiverFunctionTotalCholesterol(pDo.getLiverFunctionTotalCholesterol());
        pDto.setLiverHardnessFibroscan(pDo.getLiverHardnessFibroscan());
        pDto.setLiverHardnessFibrotest(pDo.getLiverHardnessFibrotest());
        pDto.setLiverPuncturePathology(pDo.getLiverPuncturePathology());
        pDto.setPatientId(pDo.getPatientId());
        pDto.setRenalFunctionBUN(pDo.getRenalFunctionBUN());
        pDto.setRenalFunctionCr(pDo.getRenalFunctionCr());
        pDto.setRheumaticImmuneRelatedAntibodies(pDo.getRheumaticImmuneRelatedAntibodies());
        pDto.setTotalBileAcid(pDo.getTotalBileAcid());
        return pDto;
    }

    public  PatientDO convertToPatientDO(PatientDTO patientDTO) {
        PatientDO patientDO = new PatientDO();
        patientDO.setIdentifier(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()));
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

    public  PatientDTO convertToPatientDTO(PatientDO patientDO) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setIdentifier(patientDO.getIdentifier());
        patientDTO.setId(patientDO.getId());
        patientDTO.setAge(patientDO.getAge());
        patientDTO.setChineseMedicineDiagnosis(patientDO.getChineseMedicineDiagnosis());
        patientDTO.setChineseMedicineTreatment(patientDO.getChineseMedicineTreatment());
        patientDTO.setCirrhosisDiagnosisTime(patientDO.getCirrhosisDiagnosisTime());
        patientDTO.setComplete(
                patientDO.isComplete() && fourDiaService.getCompleteByPatientId(patientDO.getId())
                        && tonguePulseService.getCompleteByPatientId(patientDO.getId())
                        && physicalService.getCompleteByPatientId(patientDO.getId()));
        patientDTO.setDrink(patientDO.isDrink());
        patientDTO.setFamilyHistory(patientDO.isFamilyHistory());
        patientDTO.setGender(patientDO.getGender());
        patientDTO.setHeight(patientDO.getHeight());
        patientDTO.setHepatitisDiagnosisTime(patientDO.getHepatitisDiagnosisTime());
        patientDTO.setName(patientDO.getName());
        patientDTO.setSmoke(patientDO.isSmoke());
        patientDTO.setWeight(patientDO.getWeight());
        patientDTO.setWesternMedicineDiagnosis(patientDO.getWesternMedicineDiagnosis());
        patientDTO.setWesternMedicineTreatment(patientDO.getWesternMedicineTreatment());
        return patientDTO;
    }

    public SysRoleDO convertToRoleDO(SysRoleDTO roleDTO) {
        SysRoleDO roleDO = new SysRoleDO();
        roleDO.setSysRoleName(roleDO.getSysRoleName());
        return roleDO;
    }

    public SysRoleDTO convertoToRoleDTO(SysRoleDO roleDO) {
        SysRoleDTO roleDTO = new SysRoleDTO();
        roleDTO.setId(roleDO.getId());
        roleDTO.setSysRoleName(roleDO.getSysRoleName());
        return roleDTO;
    }

    public SysPermissionDTO convertToPermissionDTO(SysPermissionDO permissionDO) {
        SysPermissionDTO permissionDTO = new SysPermissionDTO();
        permissionDTO.setId(permissionDO.getId());
        permissionDTO.setSysPermissionName(permissionDO.getSysPermissionName());
        return permissionDTO;
    }

    public SysPermissionDO convertToPermissionDTO(SysPermissionDTO permissionDTO) {
        SysPermissionDO permissionDO = new SysPermissionDO();
        permissionDO.setSysPermissionName(permissionDTO.getSysPermissionName());
        return permissionDO;
    }

    public UserDTO convertToUserDTO(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setRealName(userDO.getRealName());
        userDTO.setId(userDO.getId());
        userDTO.setAccount(userDO.getAccount());
        userDTO.setHospitalId(userDO.getId());
        return userDTO;
    }

    public UserDO convertToUserDO(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setRealName(userDTO.getRealName());
        userDO.setAccount(userDTO.getAccount());
        userDO.setPassword(userDTO.getPassword());
        return userDO;
    }

    public ProjectDO convertToProjectDO(ProjectDTO projectDTO) {
        ProjectDO projectDO = new ProjectDO();
        projectDO.setCreate_time(new Date());
        projectDO.setIntroduction(projectDTO.getIntroduction());
        projectDO.setOrganizer(userTool.getCurrentUserAccount());
        projectDO.setProjectName(projectDTO.getProjectName());
        return projectDO;
    }

    public ProjectDTO convertToProjectDTO(ProjectDO projectDO)  {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(projectDO.getId());
        projectDTO.setCreate_time(projectDO.getCreate_time());
        projectDTO.setIntroduction(projectDO.getIntroduction());
        projectDTO.setOrganizer(projectDO.getOrganizer());
        projectDTO.setProjectName(projectDO.getProjectName());
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for(HospitalDO h : projectDO.getHospitalList()) {
            hospitalDTOS.add(convertHospitalDTO(h));
        }
        projectDTO.setHospitals(hospitalDTOS);
        List<ProjectPermissionDTO> projectPermissionDTOS = new ArrayList<>();
        Long projectRoleId =  userProjectRoleRepo.getRoleId(userTool.getCurrentUserId(),projectDO.getId()).getProjectRoleId();
        for(ProjectPermissionDO p : projectRoleRepo.findOne(projectRoleId).getProjectPermissionDOS()) {
            projectPermissionDTOS.add(convertToProjectPermissionDTO(p));
        }
        projectDTO.setCurrentUserPermissionInProject(projectPermissionDTOS);
        return projectDTO;
    }

    public ProjectRoleDO convertToProjectRoleDO(ProjectRoleDTO projectRoleDTO) {
        ProjectRoleDO projectRoleDO = new ProjectRoleDO();
        projectRoleDO.setProjectRoleName(projectRoleDTO.getProjectRoleName());
        return projectRoleDO;
    }

    public ProjectRoleDTO convertToProjectRoleDTO(ProjectRoleDO projectRoleDO) {
        ProjectRoleDTO projectRoleDTO = new ProjectRoleDTO();
        projectRoleDTO.setId(projectRoleDO.getId());
        projectRoleDTO.setProjectRoleName(projectRoleDO.getProjectRoleName());
        return projectRoleDTO;
    }

    public HospitalDTO convertHospitalDTO(HospitalDO hospitalDO) {
        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setHospitalName(hospitalDO.getHospitalName());
        hospitalDTO.setId(hospitalDO.getId());
        hospitalDTO.setAddress(hospitalDO.getAddress());
        hospitalDTO.setAddressDetail(hospitalDO.getAddressDetail());
        hospitalDTO.setImage_url(hospitalDO.getImage_url());
        hospitalDTO.setManageRange(hospitalDO.getManageRange());
        hospitalDTO.setSpecialMajor(hospitalDO.getSpecialMajor());
        hospitalDTO.setTelephone(hospitalDO.getTelephone());
        return hospitalDTO;
    }

    public HospitalDO convertHospitalDO(HospitalDTO hospitalDTO) {
        HospitalDO hospitalDO = new HospitalDO();
        hospitalDO.setHospitalName(hospitalDTO.getHospitalName());
        hospitalDO.setId(hospitalDTO.getId());
        hospitalDO.setAddress(hospitalDTO.getAddress());
        hospitalDO.setAddressDetail(hospitalDTO.getAddressDetail());
        hospitalDO.setImage_url(hospitalDTO.getImage_url());
        hospitalDO.setManageRange(hospitalDTO.getManageRange());
        hospitalDO.setSpecialMajor(hospitalDTO.getSpecialMajor());
        hospitalDO.setTelephone(hospitalDTO.getTelephone());
        return hospitalDO;
    }

    public ProjectPermissionDO convertToProjectPermissionDO(ProjectPermissionDTO projectPermissionDTO) {
        ProjectPermissionDO projectPermissionDO = new ProjectPermissionDO();
        projectPermissionDO.setProjectPermissionName(projectPermissionDTO.getProjectPermissionName());
        return projectPermissionDO;
    }

    public ProjectPermissionDTO convertToProjectPermissionDTO(ProjectPermissionDO projectPermissionDO) {
        ProjectPermissionDTO projectPermissionDTO = new ProjectPermissionDTO();
        projectPermissionDTO.setId(projectPermissionDO.getId());
        projectPermissionDTO.setProjectPermissionName(projectPermissionDO.getProjectPermissionName());
        return projectPermissionDTO;
    }

    public MessageDTO convertToMessageDTO(MessageDO messageDO) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setContent(messageDO.getContent());
        messageDTO.setReceived_user_id(messageDO.getReceived_user_id());
        messageDTO.setStatus(messageDO.getContent());
        return messageDTO;
    }
}
