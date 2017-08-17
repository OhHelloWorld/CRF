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
