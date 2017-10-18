package app.Utils;

import app.dto.*;
import app.entities.*;
import app.repo.ImagingEndoScopyRepo;
import app.repo.OtherImagingEndoscopyRepo;
import app.repo.ProjectRoleRepo;
import app.repo.UserProjectRoleRepo;
import app.service.BoneDensityService;
import app.service.ComplexAIHAfterTreatmentService;
import app.service.ComplexAIHBeforeTreatmentService;
import app.service.FinalDiaSpeCirService;
import app.service.FourDiagnosticInformationService;
import app.service.LiverPathologyService;
import app.service.MedicinePrescriptionService;
import app.service.PhysicalChemicalInspectionService;
import app.service.SimpleAIHService;
import app.service.TonguePulseService;
import app.service.TreatmentService;

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
    private OtherImagingEndoscopyRepo otherImagingEndoscopyRepo;

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
        patientDTO.setHospitalId(patientDO.getHospitalId());
        patientDTO.setProjectId(patientDO.getProjectId());
        return patientDTO;
    }

    public TonguePulseDO convertToTonguePulseDO(TonguePulseDTO tonguePulseDTO) {
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

    public TonguePulseDTO convertToTonguePulseDTO(TonguePulseDO tDo) {
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

    public PhysicalChemicalInspectionDO convertToPhysicalChemicalInspectionDO(
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

        pDo.setaFP(pDto.getaFP());
        pDo.setCarcinoembryonicAntigenCEA(pDto.getCarcinoembryonicAntigenCEA());
        pDo.setCa125(pDto.getCa125());
        pDo.setCa199(pDto.getCa199());
        pDo.setHbsag(pDto.getHbsag());
        pDo.setHbsab(pDto.getHbsab());
        pDo.setHbeag(pDto.getHbeag());
        pDo.setHbeab(pDto.getHbeab());
        pDo.setHbcab(pDto.getHbcab());
        pDo.setHbvRna(pDto.getHbvRna());
        pDo.setAntiHCVantibody(pDto.getAntiHCVantibody());
        pDo.setHcvRna(pDto.getHcvRna());
        pDo.setProtein(pDto.getProtein());
        pDo.setRedBloodCell(pDto.getRedBloodCell());
        pDo.setWhiteBloodCell(pDto.getWhiteBloodCell());
        pDo.setBilirubin(pDto.getBilirubin());
        pDo.setCa199(pDto.getCa199());
        pDo.setCopperProtein(pDto.getCopperProtein());
        return pDo;
    }

    public PhysicalChemicalInspectionDTO convertToPhysicalDTO(PhysicalChemicalInspectionDO pDo) {
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
        pDto.setaFP(pDo.getaFP());
        pDto.setCarcinoembryonicAntigenCEA(pDo.getCarcinoembryonicAntigenCEA());
        pDto.setCa125(pDo.getCa125());
        pDto.setCa199(pDo.getCa199());
        pDto.setHbsag(pDo.getHbsag());
        pDto.setHbsab(pDo.getHbsab());
        pDto.setHbeag(pDo.getHbeag());
        pDto.setHbeab(pDo.getHbeab());
        pDto.setHbcab(pDo.getHbcab());
        pDto.setHbvRna(pDo.getHbvRna());
        pDto.setAntiHCVantibody(pDo.getAntiHCVantibody());
        pDto.setHcvRna(pDo.getHcvRna());
        pDto.setProtein(pDo.getProtein());
        pDto.setRedBloodCell(pDo.getRedBloodCell());
        pDto.setWhiteBloodCell(pDo.getWhiteBloodCell());
        pDto.setBilirubin(pDo.getBilirubin());
        pDto.setCa199(pDo.getCa199());
        pDto.setCopperProtein(pDo.getCopperProtein());
        return pDto;
    }



    public PatientDO convertToPatientDO(PatientDTO patientDTO) {
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
        userDTO.setHospital(convertHospitalDTO(userDO.getHospital()));
        userDTO.setEmail(userDO.getEmail());
        List<SysPermissionDTO> permissionDTOS = new ArrayList<>();
        for (SysPermissionDO sr : userDO.getSysRoleDO().getListPermission()) {
            permissionDTOS.add(convertToPermissionDTO(sr));
        }
        userDTO.setPermissionDTOS(permissionDTOS);
        return userDTO;
    }

    public UserDO convertToUserDO(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setRealName(userDTO.getRealName());
        userDO.setAccount(userDTO.getAccount());
        userDO.setPassword(userDTO.getPassword());
        userDO.setEmail(userDTO.getEmail());
        return userDO;
    }

    public ProjectDO convertToProjectDO(ProjectDTO projectDTO) {
        ProjectDO projectDO = new ProjectDO();
        projectDO.setCreate_time(new Date());
        projectDO.setIntroduction(projectDTO.getIntroduction());
        projectDO.setOrganizer(userTool.getCurrentUser().getRealName());
        projectDO.setProjectName(projectDTO.getProjectName());
        projectDO.setCollect(true);
        return projectDO;
    }

    public ProjectDTO convertToProjectDTO(ProjectDO projectDO) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(projectDO.getId());
        projectDTO.setCreate_time(projectDO.getCreate_time());
        projectDTO.setIntroduction(projectDO.getIntroduction());
        projectDTO.setOrganizer(projectDO.getOrganizer());
        projectDTO.setProjectName(projectDO.getProjectName());
        projectDTO.setCollect(projectDO.isCollect());
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        if (projectDO.getHospitalList() != null) {
            for (HospitalDO h : projectDO.getHospitalList()) {
                hospitalDTOS.add(convertHospitalDTO(h));
            }
        }
        projectDTO.setHospitals(hospitalDTOS);
        List<ProjectPermissionDTO> projectPermissionDTOS = new ArrayList<>();
        Long projectRoleId = userProjectRoleRepo
                .getRoleId(userTool.getCurrentUserId(), projectDO.getId()).getProjectRoleId();
        for (ProjectPermissionDO p : projectRoleRepo.findOne(projectRoleId)
                .getProjectPermissionDOS()) {
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
        hospitalDTO.setIntroduction(hospitalDO.getIntroduction());
        return hospitalDTO;
    }

    public HospitalDO convertHospitalDO(HospitalDTO hospitalDTO) {
        HospitalDO hospitalDO = new HospitalDO();
        hospitalDO.setHospitalName(hospitalDTO.getHospitalName());
        hospitalDO.setId(hospitalDTO.getId());
        hospitalDO.setAddress(hospitalDTO.getAddress());
        hospitalDO.setAddressDetail(hospitalDTO.getAddressDetail());
        hospitalDO.setManageRange(hospitalDTO.getManageRange());
        hospitalDO.setSpecialMajor(hospitalDTO.getSpecialMajor());
        hospitalDO.setIntroduction(hospitalDTO.getIntroduction());
        hospitalDO.setTelephone(hospitalDTO.getTelephone());
        hospitalDO.setImage_url(hospitalDTO.getImage_url());
        return hospitalDO;
    }

    public ProjectPermissionDO convertToProjectPermissionDO(
            ProjectPermissionDTO projectPermissionDTO) {
        ProjectPermissionDO projectPermissionDO = new ProjectPermissionDO();
        projectPermissionDO
                .setProjectPermissionName(projectPermissionDTO.getProjectPermissionName());
        return projectPermissionDO;
    }

    public ProjectPermissionDTO convertToProjectPermissionDTO(
            ProjectPermissionDO projectPermissionDO) {
        ProjectPermissionDTO projectPermissionDTO = new ProjectPermissionDTO();
        projectPermissionDTO.setId(projectPermissionDO.getId());
        projectPermissionDTO
                .setProjectPermissionName(projectPermissionDO.getProjectPermissionName());
        return projectPermissionDTO;
    }

    public MessageDTO convertToMessageDTO(MessageDO messageDO) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(messageDO.getId());
        messageDTO.setContent(messageDO.getContent());
        messageDTO.setReceived_user_id(messageDO.getReceivedUserId());
        messageDTO.setStatus(messageDO.isRead());
        return messageDTO;
    }

    /**
     * finalDiagnosisSpecialCircumstancesDo convert to finalDiagnosisSpecialCircumstancesDto
     */
    public FinalDiagnosisSpecialCircumstancesDTO finalDSCDoConvertToDto(FinalDiagnosisSpecialCircumstancesDO fdscDO) {
        FinalDiagnosisSpecialCircumstancesDTO fdscDTO = new FinalDiagnosisSpecialCircumstancesDTO();
        fdscDTO.setId(fdscDO.getId());
        fdscDTO.setPatientId(fdscDO.getPatientId());
        fdscDTO.setPbcClinicalStage(fdscDO.getPbcClinicalStage());
        fdscDTO.setAihClinicalStage(fdscDO.getAihClinicalStage());
        fdscDTO.setChildren(fdscDO.isChildren());
        fdscDTO.setGestationPeriod(fdscDO.isGestationPeriod());
        fdscDTO.setRepeatedRelapse(fdscDO.isRepeatedRelapse());
        fdscDTO.setResistantToSteroidTreatment(fdscDO.isResistantToSteroidTreatment());
        fdscDTO.setPatientsWithChronicHepatitisB(fdscDO.isPatientsWithChronicHepatitisB());
        fdscDTO.setPatientsWithChronicHepatitisC(fdscDO.isPatientsWithChronicHepatitisC());
        fdscDTO.setOverlappingAIHPBC(fdscDO.isOverlappingAIHPBC());
        fdscDTO.setOverlappingAIHPSC(fdscDO.isOverlappingAIHPSC());
        fdscDTO.setAutoimmuneCholangitis(fdscDO.isAutoimmuneCholangitis());
        fdscDTO.setFinalDiagnosisOther(fdscDO.isFinalDiagnosisOther());
        fdscDTO.setComplete(fdscDO.isComplete());
        return fdscDTO;
    }

    public TreatmentProgramsDTO tpDOconvertToTpDto(TreatmentProgramsDO treatmentProgramsDO) {
        TreatmentProgramsDTO treatmentProgramsDTO = new TreatmentProgramsDTO();
        treatmentProgramsDTO.setBdndDose(treatmentProgramsDO.getBdndDose());
        treatmentProgramsDTO.setBdndHeal(treatmentProgramsDO.getBdndHeal());
        treatmentProgramsDTO.setBdndTime(treatmentProgramsDO.getBdndTime());
        treatmentProgramsDTO.setComplete(treatmentProgramsDO.isComplete());
        treatmentProgramsDTO.setCtxDose(treatmentProgramsDO.getCtxDose());
        treatmentProgramsDTO.setCtxHeal(treatmentProgramsDO.getCtxHeal());
        treatmentProgramsDTO.setCtxTime(treatmentProgramsDO.getCtxTime());
        treatmentProgramsDTO.setCysaDose(treatmentProgramsDO.getCysaDose());
        treatmentProgramsDTO.setCysaHeal(treatmentProgramsDO.getCysaHeal());
        treatmentProgramsDTO.setCysaTime(treatmentProgramsDO.getCysaTime());
        treatmentProgramsDTO.setFnbtDose(treatmentProgramsDO.getFnbtDose());
        treatmentProgramsDTO.setFnbtHeal(treatmentProgramsDO.getFnbtHeal());
        treatmentProgramsDTO.setFnbtTime(treatmentProgramsDO.getFnbtTime());
        treatmentProgramsDTO.setFollowUp(treatmentProgramsDO.isFollowUp());
        treatmentProgramsDTO.setFollowUpDate(treatmentProgramsDO.getFollowUpDate());
        treatmentProgramsDTO.setGyzDetails(treatmentProgramsDO.getGyzDetails());
        treatmentProgramsDTO.setGyzReason(treatmentProgramsDO.getGyzReason());
        treatmentProgramsDTO.setGyzResult(treatmentProgramsDO.getGyzResult());
        treatmentProgramsDTO.setGyzTime(treatmentProgramsDO.getGyzTime());
        treatmentProgramsDTO.setId(treatmentProgramsDO.getId());
        treatmentProgramsDTO.setJjqDose(treatmentProgramsDO.getJjqDose());
        treatmentProgramsDTO.setJjqHeal(treatmentProgramsDO.getJjqHeal());
        treatmentProgramsDTO.setJjqTime(treatmentProgramsDO.getJjqTime());
        treatmentProgramsDTO.setLcplDose(treatmentProgramsDO.getLcplDose());
        treatmentProgramsDTO.setLcplHeal(treatmentProgramsDO.getLcplHeal());
        treatmentProgramsDTO.setLcplTime(treatmentProgramsDO.getLcplTime());
        treatmentProgramsDTO.setMtmkDose(treatmentProgramsDO.getMtmkDose());
        treatmentProgramsDTO.setMtmkHeal(treatmentProgramsDO.getMtxHeal());
        treatmentProgramsDTO.setMtmkTime(treatmentProgramsDO.getMtmkTime());
        treatmentProgramsDTO.setMtxTime(treatmentProgramsDO.getMtxTime());
        treatmentProgramsDTO.setMtxDose(treatmentProgramsDO.getMtxDose());
        treatmentProgramsDTO.setMtxHeal(treatmentProgramsDO.getMtxHeal());
        treatmentProgramsDTO.setPatientId(treatmentProgramsDO.getPatientId());
        treatmentProgramsDTO.setQdsDose(treatmentProgramsDO.getQdsDose());
        treatmentProgramsDTO.setQdsHeal(treatmentProgramsDO.getQdsHeal());
        treatmentProgramsDTO.setQdsTime(treatmentProgramsDO.getQdsTime());
        treatmentProgramsDTO.setQdslDose(treatmentProgramsDO.getQdslDose());
        treatmentProgramsDTO.setQdslHeal(treatmentProgramsDO.getQdslHeal());
        treatmentProgramsDTO.setQdslTime(treatmentProgramsDO.getQdslTime());
        treatmentProgramsDTO.setQsxsDose(treatmentProgramsDO.getQsxsDose());
        treatmentProgramsDTO.setQsxsHeal(treatmentProgramsDO.getQsxsHeal());
        treatmentProgramsDTO.setQsxsTime(treatmentProgramsDO.getQsxsTime());
        treatmentProgramsDTO.setXqydDose(treatmentProgramsDO.getXqydDose());
        treatmentProgramsDTO.setXqydHeal(treatmentProgramsDO.getXqydHeal());
        treatmentProgramsDTO.setXqydTime(treatmentProgramsDO.getXqydTime());
        treatmentProgramsDTO.setBzbtTime(treatmentProgramsDO.getBzbtTime());
        treatmentProgramsDTO.setBzbtDose(treatmentProgramsDO.getBzbtDose());
        treatmentProgramsDTO.setBzbtHeal(treatmentProgramsDO.getBzbtHeal());
        return treatmentProgramsDTO;
    }

    public TreatmentProgramsDO tpDTOconvertToTpEntity(TreatmentProgramsDTO treatmentProgramsDTO) {
        TreatmentProgramsDO treatmentProgramsDO = new TreatmentProgramsDO();
        treatmentProgramsDO.setBdndDose(treatmentProgramsDTO.getBdndDose());
        treatmentProgramsDO.setBdndHeal(treatmentProgramsDTO.getBdndHeal());
        treatmentProgramsDO.setBdndTime(treatmentProgramsDTO.getBdndTime());
        treatmentProgramsDO.setComplete(treatmentProgramsDTO.isComplete());
        treatmentProgramsDO.setCtxDose(treatmentProgramsDTO.getCtxDose());
        treatmentProgramsDO.setCtxHeal(treatmentProgramsDTO.getCtxHeal());
        treatmentProgramsDO.setCtxTime(treatmentProgramsDTO.getCtxTime());
        treatmentProgramsDO.setCysaDose(treatmentProgramsDTO.getCysaDose());
        treatmentProgramsDO.setCysaHeal(treatmentProgramsDTO.getCysaHeal());
        treatmentProgramsDO.setCysaTime(treatmentProgramsDTO.getCysaTime());
        treatmentProgramsDO.setFnbtDose(treatmentProgramsDTO.getFnbtDose());
        treatmentProgramsDO.setFnbtHeal(treatmentProgramsDTO.getFnbtHeal());
        treatmentProgramsDO.setFnbtTime(treatmentProgramsDTO.getFnbtTime());
        treatmentProgramsDO.setFollowUp(treatmentProgramsDTO.isFollowUp());
        treatmentProgramsDO.setFollowUpDate(treatmentProgramsDTO.getFollowUpDate());
        treatmentProgramsDO.setGyzDetails(treatmentProgramsDTO.getGyzDetails());
        treatmentProgramsDO.setGyzReason(treatmentProgramsDTO.getGyzReason());
        treatmentProgramsDO.setGyzResult(treatmentProgramsDTO.getGyzResult());
        treatmentProgramsDO.setGyzTime(treatmentProgramsDTO.getGyzTime());
        treatmentProgramsDO.setJjqDose(treatmentProgramsDTO.getJjqDose());
        treatmentProgramsDO.setJjqHeal(treatmentProgramsDTO.getJjqHeal());
        treatmentProgramsDO.setJjqTime(treatmentProgramsDTO.getJjqTime());
        treatmentProgramsDO.setLcplDose(treatmentProgramsDTO.getLcplDose());
        treatmentProgramsDO.setLcplHeal(treatmentProgramsDTO.getLcplHeal());
        treatmentProgramsDO.setLcplTime(treatmentProgramsDTO.getLcplTime());
        treatmentProgramsDO.setMtmkDose(treatmentProgramsDTO.getMtmkDose());
        treatmentProgramsDO.setMtmkHeal(treatmentProgramsDTO.getMtmkHeal());
        treatmentProgramsDO.setMtmkTime(treatmentProgramsDTO.getMtmkTime());
        treatmentProgramsDO.setPatientId(treatmentProgramsDTO.getPatientId());
        treatmentProgramsDO.setQdsDose(treatmentProgramsDTO.getQdsDose());
        treatmentProgramsDO.setQdsHeal(treatmentProgramsDTO.getQdsHeal());
        treatmentProgramsDO.setQdsTime(treatmentProgramsDTO.getQdsTime());
        treatmentProgramsDO.setQdslDose(treatmentProgramsDTO.getQdslDose());
        treatmentProgramsDO.setQdslHeal(treatmentProgramsDTO.getQdslHeal());
        treatmentProgramsDO.setQdslTime(treatmentProgramsDTO.getQdslTime());
        treatmentProgramsDO.setQsxsDose(treatmentProgramsDTO.getQsxsDose());
        treatmentProgramsDO.setQsxsHeal(treatmentProgramsDTO.getQsxsHeal());
        treatmentProgramsDO.setQsxsTime(treatmentProgramsDTO.getQsxsTime());
        treatmentProgramsDO.setXqydDose(treatmentProgramsDTO.getXqydDose());
        treatmentProgramsDO.setXqydHeal(treatmentProgramsDTO.getXqydHeal());
        treatmentProgramsDO.setXqydTime(treatmentProgramsDTO.getXqydTime());
        treatmentProgramsDO.setBzbtTime(treatmentProgramsDTO.getBzbtTime());
        treatmentProgramsDO.setBzbtDose(treatmentProgramsDTO.getBzbtDose());
        treatmentProgramsDO.setBzbtHeal(treatmentProgramsDTO.getBzbtHeal());
        treatmentProgramsDO.setMtxTime(treatmentProgramsDTO.getMtxTime());
        treatmentProgramsDO.setMtxDose(treatmentProgramsDTO.getMtxDose());
        treatmentProgramsDO.setMtxHeal(treatmentProgramsDTO.getMtxHeal());
        return treatmentProgramsDO;
    }

    public MedicineLiverFirstAbnormalExaminationDTO mlfaeConvertoDTO(MedicineLiverFirstAbnormalExaminationDO mdo) {
        MedicineLiverFirstAbnormalExaminationDTO mdto = new MedicineLiverFirstAbnormalExaminationDTO();
        mdto.setId(mdo.getId());
        mdto.setPatientId(mdo.getPatientId());
        mdto.setAlt(mdo.getAlt());
        mdto.setAst(mdo.getAst());
        mdto.setTab1CheckDate(mdo.getTab1CheckDate());
        mdto.setTab2CheckDate(mdo.getTab2CheckDate());
        mdto.setTab3CheckDate(mdo.getTab3CheckDate());
        mdto.setTab4CheckDate(mdo.getTab4CheckDate());
        mdto.setTab5CheckDate(mdo.getTab5CheckDate());
        mdto.setGgt(mdo.getGgt());
        mdto.setAlp(mdo.getAlp());
        mdto.setBileAcid(mdo.getBileAcid());
        mdto.setTbil(mdo.getTbil());
        mdto.setDbil(mdo.getDbil());
        mdto.setPt(mdo.getPt());
        mdto.setAlb(mdo.getAlb());
        mdto.setScr(mdo.getScr());
        mdto.setBun(mdo.getBun());
        mdto.setPlasmaGlucose(mdo.getPlasmaGlucose());
        mdto.setTp(mdo.getTp());
        mdto.setInr(mdo.getInr());
        mdto.setAfp(mdo.getAfp());
        return mdto;
    }

    public MedicineLiverFirstAbnormalExaminationDO mlfaeConverToDO(MedicineLiverFirstAbnormalExaminationDTO mlfaeDTO) {
        MedicineLiverFirstAbnormalExaminationDO mDO = new MedicineLiverFirstAbnormalExaminationDO();
        mDO.setId(mlfaeDTO.getId());
        mDO.setPatientId(mlfaeDTO.getPatientId());
        mDO.setTab1CheckDate(mlfaeDTO.getTab1CheckDate());
        mDO.setTab2CheckDate(mlfaeDTO.getTab2CheckDate());
        mDO.setTab3CheckDate(mlfaeDTO.getTab3CheckDate());
        mDO.setTab4CheckDate(mlfaeDTO.getTab4CheckDate());
        mDO.setTab5CheckDate(mlfaeDTO.getTab5CheckDate());
        mDO.setAlt(mlfaeDTO.getAlt());
        mDO.setAst(mlfaeDTO.getAst());
        mDO.setGgt(mlfaeDTO.getGgt());
        mDO.setAlp(mlfaeDTO.getAlp());
        mDO.setBileAcid(mlfaeDTO.getBileAcid());
        mDO.setTbil(mlfaeDTO.getTbil());
        mDO.setDbil(mlfaeDTO.getDbil());
        mDO.setPt(mlfaeDTO.getPt());
        mDO.setAlb(mlfaeDTO.getAlb());
        mDO.setScr(mlfaeDTO.getScr());
        mDO.setBun(mlfaeDTO.getBun());
        mDO.setPlasmaGlucose(mlfaeDTO.getPlasmaGlucose());
        mDO.setTp(mlfaeDTO.getTp());
        mDO.setInr(mlfaeDTO.getInr());
        mDO.setAfp(mlfaeDTO.getAfp());
        mDO.setFirst(mlfaeDTO.isFirst());
        mDO.setComplete(mlfaeDTO.isComplete());
        return mDO;
    }

    public MedicineLiverExcludeOtherDO excludeConverToDO(MedicineLiverExcludeOtherDTO mDTO){
        MedicineLiverExcludeOtherDO mDO = new MedicineLiverExcludeOtherDO();
        mDO.setPatientId(mDTO.getPatientId());
        mDO.setAntiHav(mDTO.getAntiHav());
        mDO.setAntiHavDate(mDTO.getAntiHavDate());
        mDO.setHbvdna(mDTO.getHbvdna());
        mDO.setHbvdnaDate(mDTO.getHbvdnaDate());
        mDO.setAntihcv(mDTO.getAntihcv());
        mDO.setAntihcvDate(mDTO.getAntihcvDate());
        mDO.setHcvrna(mDTO.getHcvrna());
        mDO.setHcvrnaDate(mDTO.getHcvrnaDate());
        mDO.setMononucleosis(mDTO.getMononucleosis());
        mDO.setMononucleosisDate(mDTO.getMononucleosisDate());
        mDO.setRheumatoid(mDTO.getRheumatoid());
        mDO.setCeruloplasmin(mDTO.getCeruloplasmin());
        mDO.setHepatitisBFiveDate(mDTO.getHepatitisBFiveDate());
        mDO.setHbsag(mDTO.getHbsag());
        mDO.setHbsab(mDTO.getHbsab());
        mDO.setHbcab(mDTO.getHbcab());
        mDO.setHbeag(mDTO.getHbeag());
        mDO.setHbeab(mDTO.getHbeab());
        mDO.setAutoimmuneAntibodyDate(mDTO.getAutoimmuneAntibodyDate());
        mDO.setAna(mDTO.getAna());
        mDO.setAma(mDTO.getAma());
        mDO.setAmam2(mDTO.getAmam2());
        mDO.setSma(mDTO.getSma());
        mDO.setLkm(mDTO.getLkm());
        mDO.setOtherVirusCheckDate(mDTO.getOtherVirusCheckDate());
        mDO.setCytomegalovirus(mDTO.getCytomegalovirus());
        mDO.setEbviruses(mDTO.getEbviruses());
        mDO.setHerpesSimplex(mDTO.getHerpesSimplex());
        mDO.setCeruloplasminDate(mDTO.getCeruloplasminDate());
        mDO.setRheumatoidDate(mDTO.getRheumatoidDate());
        mDO.setComplete(mDTO.isComplete());
        return mDO;
    }

    public MedicineLiverExcludeOtherDTO excludeConverToDTO(MedicineLiverExcludeOtherDO mDO) {
        MedicineLiverExcludeOtherDTO mDTO = new MedicineLiverExcludeOtherDTO();
        mDTO.setId(mDO.getId());
        mDTO.setPatientId(mDO.getPatientId());
        mDTO.setAntiHav(mDO.getAntiHav());
        mDTO.setAntiHavDate(mDO.getAntiHavDate());
        mDTO.setHbvdna(mDO.getHbvdna());
        mDTO.setHbvdnaDate(mDO.getHbvdnaDate());
        mDTO.setAntihcv(mDO.getAntihcv());
        mDTO.setAntihcvDate(mDO.getAntihcvDate());
        mDTO.setHcvrna(mDO.getHcvrna());
        mDTO.setHcvrnaDate(mDO.getHcvrnaDate());
        mDTO.setMononucleosis(mDO.getMononucleosis());
        mDTO.setMononucleosisDate(mDO.getMononucleosisDate());
        mDTO.setRheumatoid(mDO.getRheumatoid());
        mDTO.setCeruloplasmin(mDO.getCeruloplasmin());
        mDTO.setHepatitisBFiveDate(mDO.getHepatitisBFiveDate());
        mDTO.setHbsag(mDO.getHbsag());
        mDTO.setHbsab(mDO.getHbsab());
        mDTO.setHbcab(mDO.getHbcab());
        mDTO.setHbeag(mDO.getHbeag());
        mDTO.setHbeab(mDO.getHbeab());
        mDTO.setAutoimmuneAntibodyDate(mDO.getAutoimmuneAntibodyDate());
        mDTO.setAna(mDO.getAna());
        mDTO.setAma(mDO.getAma());
        mDTO.setAmam2(mDO.getAmam2());
        mDTO.setSma(mDO.getSma());
        mDTO.setLkm(mDO.getLkm());
        mDTO.setOtherVirusCheckDate(mDO.getOtherVirusCheckDate());
        mDTO.setCytomegalovirus(mDO.getCytomegalovirus());
        mDTO.setEbviruses(mDO.getEbviruses());
        mDTO.setHerpesSimplex(mDO.getHerpesSimplex());
        mDTO.setCeruloplasminDate(mDO.getCeruloplasminDate());
        mDTO.setRheumatoidDate(mDO.getRheumatoidDate());
        return mDTO;
    }

    public MedicineLiverRoutineBloodDO routineConverToDO(MedicineLiverRoutineBloodDTO mDTO) {
        MedicineLiverRoutineBloodDO mDO = new MedicineLiverRoutineBloodDO();
        mDO.setPatientId(mDTO.getPatientId());
        mDO.setRoutineBloodDate(mDTO.getRoutineBloodDate());
        mDO.setWbc(mDTO.getWbc());
        mDO.setHb(mDTO.getHb());
        mDO.setPlt(mDTO.getPlt());
        mDO.setNeutrophil(mDTO.getNeutrophil());
        mDO.setEosinophil(mDTO.getEosinophil());
        mDO.setTotalHemoglobin(mDTO.getTotalHemoglobin());
        mDO.setComplete(mDTO.isComplete());
        return mDO;
    }

    public MedicineLiverRoutineBloodDTO routineConverToDTO(MedicineLiverRoutineBloodDO mDO) {
        MedicineLiverRoutineBloodDTO mDTO = new MedicineLiverRoutineBloodDTO();
        mDTO.setId(mDO.getId());
        mDTO.setPatientId(mDO.getPatientId());
        mDTO.setRoutineBloodDate(mDO.getRoutineBloodDate());
        mDTO.setWbc(mDO.getWbc());
        mDTO.setHb(mDO.getHb());
        mDTO.setPlt(mDO.getPlt());
        mDTO.setNeutrophil(mDO.getNeutrophil());
        mDTO.setEosinophil(mDO.getEosinophil());
        mDTO.setTotalHemoglobin(mDO.getTotalHemoglobin());
        return mDTO;
    }

    public MedicineLiverImagingEndoscopyDO mlieConverToDO(MedicineLiverImagingEndoscopyDTO mDTO) {
        MedicineLiverImagingEndoscopyDO mDO = new MedicineLiverImagingEndoscopyDO();
        mDO.setPatientId(mDTO.getPatientId());
        mDO.setErcp(mDTO.getErcp());
        mDO.setErcpDate(mDTO.getErcpDate());
        mDO.setImage(mDTO.getImage());
        mDO.setErcpBiliaryTract(mDTO.getErcpBiliaryTract());
        mDO.setErcpEsophagealGastricVarices(mDTO.getErcpEsophagealGastricVarices());
        mDO.setMrcp(mDTO.getMrcp());
        mDO.setMrcpDate(mDTO.getMrcpDate());
        mDO.setMrcpBiliaryTract(mDTO.getMrcpBiliaryTract());
        mDO.setMrcpEsophagealGastricVarices(mDTO.getMrcpEsophagealGastricVarices());
        mDO.setLiverBultrasound(mDTO.getLiverBultrasound());
        mDO.setLiverBultrasoundDate(mDTO.getLiverBultrasoundDate());
        mDO.setLiverBultrasoundBiliaryTract(mDTO.getLiverBultrasoundBiliaryTract());
        mDO.setLiverBultrasoundEsophagealGastricVarices(mDTO.getLiverBultrasoundEsophagealGastricVarices());
        mDO.setLiverCt(mDTO.getLiverCt());
        mDO.setLiverCtDate(mDTO.getLiverCtDate());
        mDO.setLiverCtBiliaryTract(mDTO.getLiverCtBiliaryTract());
        mDO.setLiverCtEsophagealGastricVarices(mDTO.getLiverCtEsophagealGastricVarices());
        mDO.setFibroscan(mDTO.getFibroscan());
        mDO.setFibroscanDate(mDTO.getFibroscanDate());
        mDO.setFibroscanBiliaryTract(mDTO.getFibroscanBiliaryTract());
        mDO.setFibroscanEsophagealGastricVarices(mDTO.getFibroscanEsophagealGastricVarices());
        mDO.setLiverMri(mDTO.getLiverMri());
        mDO.setLiverMriDate(mDTO.getLiverMriDate());
        mDO.setLiverMriBiliaryTract(mDTO.getLiverMriBiliaryTract());
        mDO.setLiverMriEsophagealGastricVarices(mDTO.getLiverMriEsophagealGastricVarices());
        mDO.setGastroscope(mDTO.getGastroscope());
        mDO.setGastroscopeDate(mDTO.getGastroscopeDate());
        mDO.setGastroscopeBiliaryTract(mDTO.getGastroscopeBiliaryTract());
        mDO.setGastroscopeEsophagealGastricVarices(mDTO.getGastroscopeEsophagealGastricVarices());
        mDO.setComplete(mDTO.isComplete());
        mDO.setImageDescribe(mDTO.getImageDescribe());

        List<OtherImagingEndoscopyDO> otherImagingEndoscopyDOS = new ArrayList<>();
        List<OtherImagingEndoscopyDTO> otherImagingEndoscopyDTOS = mDTO.getOtherImagingEndoscopyDTOS();

        if(mDTO.getId() != 0){
            otherImagingEndoscopyRepo.deleteOtherByEId(mDTO.getId());
        }

        if (!otherImagingEndoscopyDTOS.isEmpty() && otherImagingEndoscopyDTOS != null) {
            for (OtherImagingEndoscopyDTO otherImagingEndoscopyDTO : otherImagingEndoscopyDTOS) {
                OtherImagingEndoscopyDO otherImagingEndoscopyDO = new OtherImagingEndoscopyDO();
                otherImagingEndoscopyDO.setBiliaryTract(otherImagingEndoscopyDTO.getBiliaryTract());
                otherImagingEndoscopyDO.setEsophagealGastricVarices(otherImagingEndoscopyDTO.getEsophagealGastricVarices());
                otherImagingEndoscopyDO.setItem(otherImagingEndoscopyDTO.getItem());
                otherImagingEndoscopyDO.setItemDate(otherImagingEndoscopyDTO.getItemDate());
                otherImagingEndoscopyDO.setResult(otherImagingEndoscopyDTO.getResult());
                otherImagingEndoscopyDO.setMedicineLiverImagingEndoscopyDO(mDO);
                otherImagingEndoscopyDOS.add(otherImagingEndoscopyDO);
            }
        }
        mDO.setOtherImagingEndoscopyDOS(otherImagingEndoscopyDOS);
        return mDO;
    }

    public MedicineLiverImagingEndoscopyDTO mlieConverToDTO(MedicineLiverImagingEndoscopyDO mDO) {
        MedicineLiverImagingEndoscopyDTO mDTO = new MedicineLiverImagingEndoscopyDTO();
        mDTO.setId(mDO.getId());
        mDTO.setPatientId(mDO.getPatientId());
        mDTO.setErcp(mDO.getErcp());
        mDTO.setImage(mDO.getImage());
        mDTO.setErcpDate(mDO.getErcpDate());
        mDTO.setErcpBiliaryTract(mDO.getErcpBiliaryTract());
        mDTO.setErcpEsophagealGastricVarices(mDO.getErcpEsophagealGastricVarices());
        mDTO.setMrcp(mDO.getMrcp());
        mDTO.setMrcpDate(mDO.getMrcpDate());
        mDTO.setMrcpBiliaryTract(mDO.getMrcpBiliaryTract());
        mDTO.setMrcpEsophagealGastricVarices(mDO.getMrcpEsophagealGastricVarices());
        mDTO.setLiverBultrasound(mDO.getLiverBultrasound());
        mDTO.setLiverBultrasoundDate(mDO.getLiverBultrasoundDate());
        mDTO.setLiverBultrasoundBiliaryTract(mDO.getLiverBultrasoundBiliaryTract());
        mDTO.setLiverBultrasoundEsophagealGastricVarices(mDO.getLiverBultrasoundEsophagealGastricVarices());
        mDTO.setLiverCt(mDO.getLiverCt());
        mDTO.setLiverCtDate(mDO.getLiverCtDate());
        mDTO.setLiverCtBiliaryTract(mDO.getLiverCtBiliaryTract());
        mDTO.setLiverCtEsophagealGastricVarices(mDO.getLiverCtEsophagealGastricVarices());
        mDTO.setFibroscan(mDO.getFibroscan());
        mDTO.setFibroscanDate(mDO.getFibroscanDate());
        mDTO.setFibroscanBiliaryTract(mDO.getFibroscanBiliaryTract());
        mDTO.setFibroscanEsophagealGastricVarices(mDO.getFibroscanEsophagealGastricVarices());
        mDTO.setLiverMri(mDO.getLiverMri());
        mDTO.setLiverMriDate(mDO.getLiverMriDate());
        mDTO.setLiverMriBiliaryTract(mDO.getLiverMriBiliaryTract());
        mDTO.setLiverMriEsophagealGastricVarices(mDO.getLiverMriEsophagealGastricVarices());
        mDTO.setGastroscope(mDO.getGastroscope());
        mDTO.setGastroscopeDate(mDO.getGastroscopeDate());
        mDTO.setGastroscopeBiliaryTract(mDO.getGastroscopeBiliaryTract());
        mDTO.setGastroscopeEsophagealGastricVarices(mDO.getGastroscopeEsophagealGastricVarices());
        mDTO.setImageDescribe(mDO.getImageDescribe());

        List<OtherImagingEndoscopyDTO> otherImagingEndoscopyDTOS = new ArrayList<>();
        List<OtherImagingEndoscopyDO> otherImagingEndoscopyDOS = mDO.getOtherImagingEndoscopyDOS();
        if(!otherImagingEndoscopyDOS.isEmpty() && otherImagingEndoscopyDOS != null) {
            for (OtherImagingEndoscopyDO otherImagingEndoscopyDO : otherImagingEndoscopyDOS) {
                OtherImagingEndoscopyDTO otherImagingEndoscopyDTO = new OtherImagingEndoscopyDTO();
                otherImagingEndoscopyDTO.setResult(otherImagingEndoscopyDO.getResult());
                otherImagingEndoscopyDTO.setItemDate(otherImagingEndoscopyDO.getItemDate());
                otherImagingEndoscopyDTO.setItem(otherImagingEndoscopyDO.getItem());
                otherImagingEndoscopyDTO.setBiliaryTract(otherImagingEndoscopyDO.getBiliaryTract());
                otherImagingEndoscopyDTO.setEsophagealGastricVarices(otherImagingEndoscopyDO.getEsophagealGastricVarices());
                otherImagingEndoscopyDTO.setId(otherImagingEndoscopyDO.getId());
                otherImagingEndoscopyDTO.setImagingEndoscopyId(otherImagingEndoscopyDO.getMedicineLiverImagingEndoscopyDO().getId());
                otherImagingEndoscopyDTOS.add(otherImagingEndoscopyDTO);
            }
        }
        mDTO.setOtherImagingEndoscopyDTOS(otherImagingEndoscopyDTOS);
        return mDTO;
    }


}
