package app.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import app.dto.PhysicalChemicalInspectionDTO;
import app.entities.PhysicalChemicalInspectionDO;
import app.repo.PhysicalChemicalInspectionRepo;
import app.service.PhysicalChemicalInspectionService;

@Service
public class PhysicalChemicalInspectionServiceImpl implements PhysicalChemicalInspectionService {

    @Autowired
    private PhysicalChemicalInspectionRepo pRepo;

    @Value("${local_image_path}")
    private String localImagePath;

    @Transactional
    public void savePhysicalChemicalInspection(PhysicalChemicalInspectionDTO pDto) {
        pRepo.save(convertToPhysicalChemicalInspectionDO(pDto));
    }

    @Override
    public PhysicalChemicalInspectionDTO getPhysicalByPatientId(int patientId) {
        if (pRepo.getPhysicalByPatientId(patientId) != null) {
            return convertToPhysicalDTO(pRepo.getPhysicalByPatientId(patientId));
        } else {
            return null;
        }
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
        try {
            return pRepo.getCompleteByPatientId(patientId);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void savePhysicalImage(MultipartFile file) throws IOException {
        if (!new File(localImagePath).exists()) {
            new File(localImagePath).mkdir();
        }
        File saveFile = new File(localImagePath, file.hashCode() + ".jpg");
        try (FileOutputStream fos = new FileOutputStream(saveFile)) {
            fos.write(file.getBytes());
            fos.flush();
        } catch (IOException e) {
            throw new IOException("保存图片失败");
        }
    }

    private PhysicalChemicalInspectionDO convertToPhysicalChemicalInspectionDO(
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
        pDo.setFollowUp(pDto.isFollowUp());
        pDo.setFollowUpDate(pDto.getFollowUpDate());
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
        pDo.setImageUrl(pDto.getImageUrl());
        pDo.setaFPDate(pDto.getaFPDate());
        pDo.setaNACentromereDate(pDto.getaNACentromereDate());
        pDo.setaNAHomogeneousDate(pDto.getaNAHomogeneousDate());
        pDo.setaNANuclearDate(pDto.getaNANuclearDate());
        pDo.setaNANucleolusDate(pDto.getaNANucleolusDate());
        pDo.setaNANucleolusEnhancementDate(pDto.getaNANucleolusEnhancementDate());
        pDo.setaNAOtherDate(pDto.getaNAOtherDate());
        pDo.setaNAParticleDate(pDto.getaNAParticleDate());
        pDo.setaNAPeripheralDate(pDto.getaNAPeripheralDate());
        pDo.setAntiHCVantibodyDate(pDto.getAntiHCVantibodyDate());
        pDo.setBilirubinDate(pDto.getBilirubinDate());
        pDo.setBloodRoutineEosinophilsDate(pDto.getBloodRoutineEosinophilsDate());
        pDo.setBloodRoutineHbDate(pDto.getBloodRoutineHbDate());
        pDo.setBloodRoutineLymphocytesDate(pDto.getBloodRoutineLymphocytesDate());
        pDo.setBloodRoutineNeutrophilsDate(pDto.getBloodRoutineNeutrophilsDate());
        pDo.setBloodRoutinePlateletsDate(pDto.getBloodRoutinePlateletsDate());
        pDo.setBloodRoutineRBCDate(pDto.getBloodRoutineRBCDate());
        pDo.setBloodRoutineWBCDate(pDto.getBloodRoutineWBCDate());
        pDo.setBilirubinDate(pDto.getBilirubinDate());
        pDo.setBloodRoutineEosinophilsDate(pDto.getBloodRoutineEosinophilsDate());
        pDo.setCa125Date(pDto.getCa125Date());
        pDo.setCa199Date(pDto.getCa199Date());
        pDo.setCarcinoembryonicAntigenCEADate(pDto.getCarcinoembryonicAntigenCEADate());
        pDo.setCellularImmunityCD2Date(pDto.getCellularImmunityCD2Date());
        pDo.setCellularImmunityCD3Date(pDto.getCellularImmunityCD3Date());
        pDo.setCellularImmunityCD4CD8Date(pDto.getCellularImmunityCD4CD8Date());
        pDo.setCellularImmunityCD4Date(pDto.getCellularImmunityCD4Date());
        pDo.setCellularImmunityCD8Date(pDto.getCellularImmunityCD8Date());
        pDo.setCa125Date(pDto.getCa125Date());
        pDo.setCa199Date(pDto.getCa199Date());
        pDo.setCellularImmunityCD56Date(pDto.getCellularImmunityCD56Date());
        pDo.setCarcinoembryonicAntigenCEADate(pDto.getCarcinoembryonicAntigenCEADate());
        pDo.setCellularImmunityCD2Date(pDto.getCellularImmunityCD2Date());
        pDo.setClottingINRDate(pDto.getClottingINRDate());
        pDo.setClottingPTDate(pDto.getClottingPTDate());
        pDo.setCopperProteinDate(pDto.getCopperProteinDate());
        pDo.setHbcabDate(pDto.getHbcabDate());
        pDo.setHbeabDate(pDto.getHbeabDate());
        pDo.setHbeagDate(pDto.getHbeagDate());
        pDo.setHbsagDate(pDto.getHbsagDate());
        pDo.setHbsabDate(pDto.getHbsabDate());
        pDo.setHbvRnaDate(pDto.getHbvRnaDate());
        pDo.setHcvRnaDate(pDto.getHcvRnaDate());
        pDo.setHumoralImmunityComplementC3Date(pDto.getHumoralImmunityComplementC3Date());
        pDo.setHumoralImmunityComplementC4Date(pDto.getHumoralImmunityComplementC4Date());
        pDo.setHumoralImmunityIgADate(pDto.getHumoralImmunityIgADate());
        pDo.setHumoralImmunityIgEDate(pDto.getHumoralImmunityIgEDate());
        pDo.setHumoralImmunityIgGDate(pDto.getHumoralImmunityIgGDate());
        pDo.setHumoralImmunityIgMDate(pDto.getHumoralImmunityIgMDate());
        pDo.setHumoralImmunityImmuneComplexfDate(pDto.getHumoralImmunityImmuneComplexfDate());
        pDo.setHumoralImmunityKlightChainDate(pDto.getHumoralImmunityKlightChainDate());
        pDo.setHumoralImmunityNlightChainDate(pDto.getHumoralImmunityNlightChainDate());
        pDo.setLiverDiseaseAutoantibodiesAMADate(pDto.getLiverDiseaseAutoantibodiesAMADate());
        pDo.setLiverDiseaseAutoantibodiesAMAM2Date(pDto.getLiverDiseaseAutoantibodiesAMAM2Date());
        pDo.setLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate(pDto.getLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate());
        pDo.setLiverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate(pDto.getLiverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate());
        pDo.setLiverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate(pDto.getLiverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate());
        pDo.setLiverDiseaseAutoantibodiesOtherDate(pDto.getLiverDiseaseAutoantibodiesOtherDate());
        pDo.setLiverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate(pDto.getLiverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate());
        pDo.setLiverFunctionAlbuminDate(pDto.getLiverFunctionAlbuminDate());
        pDo.setLiverFunctionALPDate(pDto.getLiverFunctionALPDate());
        pDo.setLiverFunctionASTDate(pDto.getLiverFunctionASTDate());
        pDo.setLiverFunctionALTDate(pDto.getLiverFunctionALTDate());
        pDo.setLiverFunctionDirectBilirubinDate(pDto.getLiverFunctionDirectBilirubinDate());
        pDo.setLiverFunctionGGTDate(pDto.getLiverFunctionGGTDate());
        pDo.setLiverFunctionGlobulinDate(pDto.getLiverFunctionGlobulinDate());
        pDo.setLiverFunctionRglobulinDate(pDto.getLiverFunctionRglobulinDate());
        pDo.setLiverFunctionTotalCholesterolDate(pDto.getLiverFunctionTotalCholesterolDate());
        pDo.setLiverFunctionTotalBilirubinDate(pDto.getLiverFunctionTotalBilirubinDate());
        pDo.setLiverHardnessFibroscanDate(pDto.getLiverHardnessFibroscanDate());
        pDo.setLiverHardnessFibrotestDate(pDto.getLiverHardnessFibrotestDate());
        pDo.setProteinDate(pDto.getProteinDate());
        pDo.setRedBloodCellDate(pDto.getRedBloodCellDate());
        pDo.setRenalFunctionBUNDate(pDto.getRenalFunctionBUNDate());
        pDo.setRenalFunctionCrDate(pDto.getRenalFunctionCrDate());
        pDo.setTotalBileAcidDate(pDto.getTotalBileAcidDate());
        pDo.setWhiteBloodCellDate(pDto.getWhiteBloodCellDate());
        return pDo;
    }

    private PhysicalChemicalInspectionDTO convertToPhysicalDTO(PhysicalChemicalInspectionDO pDo) {
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
        pDto.setFollowUp(pDo.isFollowUp());
        pDto.setFollowUpDate(pDo.getFollowUpDate());
        pDto.setImageUrl(pDo.getImageUrl());
        pDto.setaFPDate(pDo.getaFPDate());
        pDto.setaNACentromereDate(pDo.getaNACentromereDate());
        pDto.setaNAHomogeneousDate(pDo.getaNAHomogeneousDate());
        pDto.setaNANuclearDate(pDo.getaNANuclearDate());
        pDto.setaNANucleolusDate(pDo.getaNANucleolusDate());
        pDto.setaNANucleolusEnhancementDate(pDo.getaNANucleolusEnhancementDate());
        pDto.setaNAOtherDate(pDo.getaNAOtherDate());
        pDto.setaNAParticleDate(pDo.getaNAParticleDate());
        pDto.setaNAPeripheralDate(pDo.getaNAPeripheralDate());
        pDto.setAntiHCVantibodyDate(pDo.getAntiHCVantibodyDate());
        pDto.setBilirubinDate(pDo.getBilirubinDate());
        pDto.setBloodRoutineEosinophilsDate(pDo.getBloodRoutineEosinophilsDate());
        pDto.setBloodRoutineHbDate(pDo.getBloodRoutineHbDate());
        pDto.setBloodRoutineLymphocytesDate(pDo.getBloodRoutineLymphocytesDate());
        pDto.setBloodRoutineNeutrophilsDate(pDo.getBloodRoutineNeutrophilsDate());
        pDto.setBloodRoutinePlateletsDate(pDo.getBloodRoutinePlateletsDate());
        pDto.setBloodRoutineRBCDate(pDo.getBloodRoutineRBCDate());
        pDto.setBloodRoutineWBCDate(pDo.getBloodRoutineWBCDate());
        pDto.setBilirubinDate(pDo.getBilirubinDate());
        pDto.setBloodRoutineEosinophilsDate(pDo.getBloodRoutineEosinophilsDate());
        pDto.setCa125Date(pDo.getCa125Date());
        pDto.setCa199Date(pDo.getCa199Date());
        pDto.setCarcinoembryonicAntigenCEADate(pDo.getCarcinoembryonicAntigenCEADate());
        pDto.setCellularImmunityCD2Date(pDo.getCellularImmunityCD2Date());
        pDto.setCellularImmunityCD3Date(pDo.getCellularImmunityCD3Date());
        pDto.setCellularImmunityCD4CD8Date(pDo.getCellularImmunityCD4CD8Date());
        pDto.setCellularImmunityCD4Date(pDo.getCellularImmunityCD4Date());
        pDto.setCellularImmunityCD8Date(pDo.getCellularImmunityCD8Date());
        pDto.setCa125Date(pDo.getCa125Date());
        pDto.setCa199Date(pDo.getCa199Date());
        pDto.setCellularImmunityCD56Date(pDo.getCellularImmunityCD56Date());
        pDto.setCarcinoembryonicAntigenCEADate(pDo.getCarcinoembryonicAntigenCEADate());
        pDto.setCellularImmunityCD2Date(pDo.getCellularImmunityCD2Date());
        pDto.setClottingINRDate(pDo.getClottingINRDate());
        pDto.setClottingPTDate(pDo.getClottingPTDate());
        pDto.setCopperProteinDate(pDo.getCopperProteinDate());
        pDto.setHbcabDate(pDo.getHbcabDate());
        pDto.setHbeabDate(pDo.getHbeabDate());
        pDto.setHbeagDate(pDo.getHbeagDate());
        pDto.setHbsagDate(pDo.getHbsagDate());
        pDto.setHbsabDate(pDo.getHbsabDate());
        pDto.setHbvRnaDate(pDo.getHbvRnaDate());
        pDto.setHcvRnaDate(pDo.getHcvRnaDate());
        pDto.setHumoralImmunityComplementC3Date(pDo.getHumoralImmunityComplementC3Date());
        pDto.setHumoralImmunityComplementC4Date(pDo.getHumoralImmunityComplementC4Date());
        pDto.setHumoralImmunityIgADate(pDo.getHumoralImmunityIgADate());
        pDto.setHumoralImmunityIgEDate(pDo.getHumoralImmunityIgEDate());
        pDto.setHumoralImmunityIgGDate(pDo.getHumoralImmunityIgGDate());
        pDto.setHumoralImmunityIgMDate(pDo.getHumoralImmunityIgMDate());
        pDto.setHumoralImmunityImmuneComplexfDate(pDo.getHumoralImmunityImmuneComplexfDate());
        pDto.setHumoralImmunityKlightChainDate(pDo.getHumoralImmunityKlightChainDate());
        pDto.setHumoralImmunityNlightChainDate(pDo.getHumoralImmunityNlightChainDate());
        pDto.setLiverDiseaseAutoantibodiesAMADate(pDo.getLiverDiseaseAutoantibodiesAMADate());
        pDto.setLiverDiseaseAutoantibodiesAMAM2Date(pDo.getLiverDiseaseAutoantibodiesAMAM2Date());
        pDto.setLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate(pDo.getLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate());
        pDto.setLiverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate(pDo.getLiverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate());
        pDto.setLiverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate(pDo.getLiverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate());
        pDto.setLiverDiseaseAutoantibodiesOtherDate(pDo.getLiverDiseaseAutoantibodiesOtherDate());
        pDto.setLiverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate(pDo.getLiverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate());
        pDto.setLiverFunctionAlbuminDate(pDo.getLiverFunctionAlbuminDate());
        pDto.setLiverFunctionALPDate(pDo.getLiverFunctionALPDate());
        pDto.setLiverFunctionASTDate(pDo.getLiverFunctionASTDate());
        pDto.setLiverFunctionALTDate(pDo.getLiverFunctionALTDate());
        pDto.setLiverFunctionDirectBilirubinDate(pDo.getLiverFunctionDirectBilirubinDate());
        pDto.setLiverFunctionGGTDate(pDo.getLiverFunctionGGTDate());
        pDto.setLiverFunctionGlobulinDate(pDo.getLiverFunctionGlobulinDate());
        pDto.setLiverFunctionRglobulinDate(pDo.getLiverFunctionRglobulinDate());
        pDto.setLiverFunctionTotalCholesterolDate(pDo.getLiverFunctionTotalCholesterolDate());
        pDto.setLiverFunctionTotalBilirubinDate(pDo.getLiverFunctionTotalBilirubinDate());
        pDto.setLiverHardnessFibroscanDate(pDo.getLiverHardnessFibroscanDate());
        pDto.setLiverHardnessFibrotestDate(pDo.getLiverHardnessFibrotestDate());
        pDto.setProteinDate(pDo.getProteinDate());
        pDto.setRedBloodCellDate(pDo.getRedBloodCellDate());
        pDto.setRenalFunctionBUNDate(pDo.getRenalFunctionBUNDate());
        pDto.setRenalFunctionCrDate(pDo.getRenalFunctionCrDate());
        pDto.setTotalBileAcidDate(pDo.getTotalBileAcidDate());
        pDto.setWhiteBloodCellDate(pDo.getWhiteBloodCellDate());
        return pDto;
    }

    @Override
    public List<PhysicalChemicalInspectionDTO> getFollowPhy(int patientId) {
        if (!pRepo.getFollowphy(patientId).isEmpty()) {
            List<PhysicalChemicalInspectionDTO> physicalChemicalInspectionDTOs = new ArrayList<>();
            List<PhysicalChemicalInspectionDO> physicalChemicalInspectionDOs =
                    pRepo.getFollowphy(patientId);
            for (PhysicalChemicalInspectionDO physicalChemicalInspectionDO : physicalChemicalInspectionDOs) {
                physicalChemicalInspectionDTOs
                        .add(convertToPhysicalDTO(physicalChemicalInspectionDO));
            }
            return physicalChemicalInspectionDTOs;
        } else {
            return null;
        }
    }

    @Override
    public PhysicalChemicalInspectionDTO getDefaultPhy(int patientId) {
        return pRepo.getDefaultPhy(patientId) != null
                ? convertToPhysicalDTO(pRepo.getDefaultPhy(patientId)) : null;
    }

}
