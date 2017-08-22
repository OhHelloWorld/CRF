package app.dto;

import java.util.Date;

/**
 * @author Administrator
 */
public class PhysicalChemicalInspectionDTO {

    private int id;
    private int patientId;
    private String totalBileAcid;
    private Date totalBileAcidDate;
    private String liverFunctionAlbumin;
    private Date liverFunctionAlbuminDate;
    private String liverFunctionGlobulin;
    private Date liverFunctionGlobulinDate;
    private String liverFunctionALT;
    private Date liverFunctionALTDate;
    private String liverFunctionAST;
    private Date liverFunctionASTDate;
    private String liverFunctionGGT;
    private Date liverFunctionGGTDate;
    private String liverFunctionALP;
    private Date liverFunctionALPDate;
    private String liverFunctionTotalCholesterol;
    private Date liverFunctionTotalCholesterolDate;
    private String liverFunctionTotalBilirubin;
    private Date liverFunctionTotalBilirubinDate;
    private String liverFunctionDirectBilirubin;
    private Date liverFunctionDirectBilirubinDate;
    private String liverFunctionRglobulin;
    private Date liverFunctionRglobulinDate;
    private String renalFunctionBUN;
    private Date renalFunctionBUNDate;
    private String renalFunctionCr;
    private Date renalFunctionCrDate;
    private String clottingPT;
    private Date clottingPTDate;
    private String clottingINR;
    private Date clottingINRDate;
    private String bloodRoutineRBC;
    private Date bloodRoutineRBCDate;
    private String bloodRoutineHb;
    private Date bloodRoutineHbDate;
    private String bloodRoutineWBC;
    private Date bloodRoutineWBCDate;
    private String bloodRoutineNeutrophils;
    private Date bloodRoutineNeutrophilsDate;
    private String bloodRoutineLymphocytes;
    private Date bloodRoutineLymphocytesDate;
    private String bloodRoutineEosinophils;
    private Date bloodRoutineEosinophilsDate;
    private String bloodRoutinePlatelets;
    private Date bloodRoutinePlateletsDate;
    private String liverDiseaseAutoantibodiesAMA;
    private Date liverDiseaseAutoantibodiesAMADate;
    private String liverDiseaseAutoantibodiesAMAM2;
    private Date liverDiseaseAutoantibodiesAMAM2Date;
    private String liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody;
    private Date liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate;
    private String liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies;
    private Date liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate;
    private String liverDiseaseAutoantibodiesHepatocyteSoluteAntigen;
    private Date liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate;
    private String liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen;
    private Date liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate;
    private String liverDiseaseAutoantibodiesOther;
    private Date liverDiseaseAutoantibodiesOtherDate;
    private String ANAHomogeneous;
    private Date aNAHomogeneousDate;
    private String ANAParticle;
    private Date aNAParticleDate;
    private String ANAPeripheral;
    private Date aNAPeripheralDate;
    private String ANANucleolus;
    private Date aNANucleolusDate;
    private String ANANucleolusEnhancement;
    private Date aNANucleolusEnhancementDate;
    private String ANANuclear;
    private Date aNANuclearDate;
    private String ANACentromere;
    private Date aNACentromereDate;
    private String ANAOther;
    private Date aNAOtherDate;
    private String humoralImmunityIgG;
    private Date humoralImmunityIgGDate;
    private String humoralImmunityIgA;
    private Date humoralImmunityIgADate;
    private String humoralImmunityIgM;
    private Date humoralImmunityIgMDate;
    private String humoralImmunityImmuneComplexf;
    private Date humoralImmunityImmuneComplexfDate;
    private String humoralImmunityComplementC3;
    private Date humoralImmunityComplementC3Date;
    private String humoralImmunityComplementC4;
    private Date humoralImmunityComplementC4Date;
    private String humoralImmunityIgE;
    private Date humoralImmunityIgEDate;
    private String humoralImmunityKlightChain;
    private Date humoralImmunityKlightChainDate;
    private String humoralImmunityNlightChain;
    private Date humoralImmunityNlightChainDate;
    private String cellularImmunityCD3;
    private Date cellularImmunityCD3Date;
    private String cellularImmunityCD4;
    private Date cellularImmunityCD4Date;
    private String cellularImmunityCD8;
    private Date cellularImmunityCD8Date;
    private String cellularImmunityCD56;
    private Date cellularImmunityCD56Date;
    private String cellularImmunityCD2;
    private Date cellularImmunityCD2Date;
    private String cellularImmunityCD4CD8;
    private Date cellularImmunityCD4CD8Date;
    private String rheumaticImmuneRelatedAntibodies;
    private int CTMRI;
    private String liverHardnessFibroscan;
    private Date liverHardnessFibroscanDate;
    private String liverHardnessFibrotest;
    private Date liverHardnessFibrotestDate;
    private String liverPuncturePathology;
    private String copperProtein;
    private Date copperProteinDate;
    private String aFP;
    private Date aFPDate;
    private String carcinoembryonicAntigenCEA;
    private Date carcinoembryonicAntigenCEADate;
    private String ca125;
    private Date ca125Date;
    private String hbsag;
    private Date hbsagDate;
    private String hbsab;
    private Date hbsabDate;
    private String hbeag;
    private Date hbeagDate;
    private String hbeab;
    private Date hbeabDate;
    private String hbcab;
    private Date hbcabDate;
    private String hbvRna;
    private Date hbvRnaDate;
    private String antiHCVantibody;
    private Date antiHCVantibodyDate;
    private String hcvRna;
    private Date hcvRnaDate;
    private String protein;
    private Date proteinDate;
    private String redBloodCell;
    private Date redBloodCellDate;
    private String whiteBloodCell;
    private Date whiteBloodCellDate;
    private String bilirubin;
    private Date bilirubinDate;
    private String ca199;
    private Date ca199Date;
    private boolean followUp;
    private Date followUpDate;
    private String imageUrl;

    public String getCopperProtein() {
        return copperProtein;
    }

    public void setCopperProtein(String copperProtein) {
        this.copperProtein = copperProtein;
    }

    public Date getTotalBileAcidDate() {
        return totalBileAcidDate;
    }

    public void setTotalBileAcidDate(Date totalBileAcidDate) {
        this.totalBileAcidDate = totalBileAcidDate;
    }

    public Date getLiverFunctionAlbuminDate() {
        return liverFunctionAlbuminDate;
    }

    public void setLiverFunctionAlbuminDate(Date liverFunctionAlbuminDate) {
        this.liverFunctionAlbuminDate = liverFunctionAlbuminDate;
    }

    public Date getLiverFunctionGlobulinDate() {
        return liverFunctionGlobulinDate;
    }

    public void setLiverFunctionGlobulinDate(Date liverFunctionGlobulinDate) {
        this.liverFunctionGlobulinDate = liverFunctionGlobulinDate;
    }

    public Date getLiverFunctionALTDate() {
        return liverFunctionALTDate;
    }

    public void setLiverFunctionALTDate(Date liverFunctionALTDate) {
        this.liverFunctionALTDate = liverFunctionALTDate;
    }

    public Date getLiverFunctionASTDate() {
        return liverFunctionASTDate;
    }

    public void setLiverFunctionASTDate(Date liverFunctionASTDate) {
        this.liverFunctionASTDate = liverFunctionASTDate;
    }

    public Date getLiverFunctionGGTDate() {
        return liverFunctionGGTDate;
    }

    public void setLiverFunctionGGTDate(Date liverFunctionGGTDate) {
        this.liverFunctionGGTDate = liverFunctionGGTDate;
    }

    public Date getLiverFunctionALPDate() {
        return liverFunctionALPDate;
    }

    public void setLiverFunctionALPDate(Date liverFunctionALPDate) {
        this.liverFunctionALPDate = liverFunctionALPDate;
    }

    public Date getLiverFunctionTotalCholesterolDate() {
        return liverFunctionTotalCholesterolDate;
    }

    public void setLiverFunctionTotalCholesterolDate(Date liverFunctionTotalCholesterolDate) {
        this.liverFunctionTotalCholesterolDate = liverFunctionTotalCholesterolDate;
    }

    public Date getLiverFunctionTotalBilirubinDate() {
        return liverFunctionTotalBilirubinDate;
    }

    public void setLiverFunctionTotalBilirubinDate(Date liverFunctionTotalBilirubinDate) {
        this.liverFunctionTotalBilirubinDate = liverFunctionTotalBilirubinDate;
    }

    public Date getLiverFunctionDirectBilirubinDate() {
        return liverFunctionDirectBilirubinDate;
    }

    public void setLiverFunctionDirectBilirubinDate(Date liverFunctionDirectBilirubinDate) {
        this.liverFunctionDirectBilirubinDate = liverFunctionDirectBilirubinDate;
    }

    public Date getLiverFunctionRglobulinDate() {
        return liverFunctionRglobulinDate;
    }

    public void setLiverFunctionRglobulinDate(Date liverFunctionRglobulinDate) {
        this.liverFunctionRglobulinDate = liverFunctionRglobulinDate;
    }

    public Date getRenalFunctionBUNDate() {
        return renalFunctionBUNDate;
    }

    public void setRenalFunctionBUNDate(Date renalFunctionBUNDate) {
        this.renalFunctionBUNDate = renalFunctionBUNDate;
    }

    public Date getRenalFunctionCrDate() {
        return renalFunctionCrDate;
    }

    public void setRenalFunctionCrDate(Date renalFunctionCrDate) {
        this.renalFunctionCrDate = renalFunctionCrDate;
    }

    public Date getClottingPTDate() {
        return clottingPTDate;
    }

    public void setClottingPTDate(Date clottingPTDate) {
        this.clottingPTDate = clottingPTDate;
    }

    public Date getClottingINRDate() {
        return clottingINRDate;
    }

    public void setClottingINRDate(Date clottingINRDate) {
        this.clottingINRDate = clottingINRDate;
    }

    public Date getBloodRoutineRBCDate() {
        return bloodRoutineRBCDate;
    }

    public void setBloodRoutineRBCDate(Date bloodRoutineRBCDate) {
        this.bloodRoutineRBCDate = bloodRoutineRBCDate;
    }

    public Date getBloodRoutineHbDate() {
        return bloodRoutineHbDate;
    }

    public void setBloodRoutineHbDate(Date bloodRoutineHbDate) {
        this.bloodRoutineHbDate = bloodRoutineHbDate;
    }

    public Date getBloodRoutineWBCDate() {
        return bloodRoutineWBCDate;
    }

    public void setBloodRoutineWBCDate(Date bloodRoutineWBCDate) {
        this.bloodRoutineWBCDate = bloodRoutineWBCDate;
    }

    public Date getBloodRoutineNeutrophilsDate() {
        return bloodRoutineNeutrophilsDate;
    }

    public void setBloodRoutineNeutrophilsDate(Date bloodRoutineNeutrophilsDate) {
        this.bloodRoutineNeutrophilsDate = bloodRoutineNeutrophilsDate;
    }

    public Date getBloodRoutineLymphocytesDate() {
        return bloodRoutineLymphocytesDate;
    }

    public void setBloodRoutineLymphocytesDate(Date bloodRoutineLymphocytesDate) {
        this.bloodRoutineLymphocytesDate = bloodRoutineLymphocytesDate;
    }

    public Date getBloodRoutineEosinophilsDate() {
        return bloodRoutineEosinophilsDate;
    }

    public void setBloodRoutineEosinophilsDate(Date bloodRoutineEosinophilsDate) {
        this.bloodRoutineEosinophilsDate = bloodRoutineEosinophilsDate;
    }

    public Date getBloodRoutinePlateletsDate() {
        return bloodRoutinePlateletsDate;
    }

    public void setBloodRoutinePlateletsDate(Date bloodRoutinePlateletsDate) {
        this.bloodRoutinePlateletsDate = bloodRoutinePlateletsDate;
    }

    public Date getLiverDiseaseAutoantibodiesAMADate() {
        return liverDiseaseAutoantibodiesAMADate;
    }

    public void setLiverDiseaseAutoantibodiesAMADate(Date liverDiseaseAutoantibodiesAMADate) {
        this.liverDiseaseAutoantibodiesAMADate = liverDiseaseAutoantibodiesAMADate;
    }

    public Date getLiverDiseaseAutoantibodiesAMAM2Date() {
        return liverDiseaseAutoantibodiesAMAM2Date;
    }

    public void setLiverDiseaseAutoantibodiesAMAM2Date(Date liverDiseaseAutoantibodiesAMAM2Date) {
        this.liverDiseaseAutoantibodiesAMAM2Date = liverDiseaseAutoantibodiesAMAM2Date;
    }

    public Date getLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate() {
        return liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate;
    }

    public void setLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate(Date liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate) {
        this.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate = liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate;
    }

    public Date getLiverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate() {
        return liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate;
    }

    public void setLiverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate(Date liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate) {
        this.liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate = liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate;
    }

    public Date getLiverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate() {
        return liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate;
    }

    public void setLiverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate(Date liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate) {
        this.liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate = liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate;
    }

    public Date getLiverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate() {
        return liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate;
    }

    public void setLiverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate(Date liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate) {
        this.liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate = liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate;
    }

    public Date getLiverDiseaseAutoantibodiesOtherDate() {
        return liverDiseaseAutoantibodiesOtherDate;
    }

    public void setLiverDiseaseAutoantibodiesOtherDate(Date liverDiseaseAutoantibodiesOtherDate) {
        this.liverDiseaseAutoantibodiesOtherDate = liverDiseaseAutoantibodiesOtherDate;
    }

    public Date getaNAHomogeneousDate() {
        return aNAHomogeneousDate;
    }

    public void setaNAHomogeneousDate(Date aNAHomogeneousDate) {
        this.aNAHomogeneousDate = aNAHomogeneousDate;
    }

    public Date getaNAParticleDate() {
        return aNAParticleDate;
    }

    public void setaNAParticleDate(Date aNAParticleDate) {
        this.aNAParticleDate = aNAParticleDate;
    }

    public Date getaNAPeripheralDate() {
        return aNAPeripheralDate;
    }

    public void setaNAPeripheralDate(Date aNAPeripheralDate) {
        this.aNAPeripheralDate = aNAPeripheralDate;
    }

    public Date getaNANucleolusDate() {
        return aNANucleolusDate;
    }

    public void setaNANucleolusDate(Date aNANucleolusDate) {
        this.aNANucleolusDate = aNANucleolusDate;
    }

    public Date getaNANucleolusEnhancementDate() {
        return aNANucleolusEnhancementDate;
    }

    public void setaNANucleolusEnhancementDate(Date aNANucleolusEnhancementDate) {
        this.aNANucleolusEnhancementDate = aNANucleolusEnhancementDate;
    }

    public Date getaNANuclearDate() {
        return aNANuclearDate;
    }

    public void setaNANuclearDate(Date aNANuclearDate) {
        this.aNANuclearDate = aNANuclearDate;
    }

    public Date getaNACentromereDate() {
        return aNACentromereDate;
    }

    public void setaNACentromereDate(Date aNACentromereDate) {
        this.aNACentromereDate = aNACentromereDate;
    }

    public Date getaNAOtherDate() {
        return aNAOtherDate;
    }

    public void setaNAOtherDate(Date aNAOtherDate) {
        this.aNAOtherDate = aNAOtherDate;
    }

    public Date getHumoralImmunityIgGDate() {
        return humoralImmunityIgGDate;
    }

    public void setHumoralImmunityIgGDate(Date humoralImmunityIgGDate) {
        this.humoralImmunityIgGDate = humoralImmunityIgGDate;
    }

    public Date getHumoralImmunityIgADate() {
        return humoralImmunityIgADate;
    }

    public void setHumoralImmunityIgADate(Date humoralImmunityIgADate) {
        this.humoralImmunityIgADate = humoralImmunityIgADate;
    }

    public Date getHumoralImmunityIgMDate() {
        return humoralImmunityIgMDate;
    }

    public void setHumoralImmunityIgMDate(Date humoralImmunityIgMDate) {
        this.humoralImmunityIgMDate = humoralImmunityIgMDate;
    }

    public Date getHumoralImmunityImmuneComplexfDate() {
        return humoralImmunityImmuneComplexfDate;
    }

    public void setHumoralImmunityImmuneComplexfDate(Date humoralImmunityImmuneComplexfDate) {
        this.humoralImmunityImmuneComplexfDate = humoralImmunityImmuneComplexfDate;
    }

    public Date getHumoralImmunityComplementC3Date() {
        return humoralImmunityComplementC3Date;
    }

    public void setHumoralImmunityComplementC3Date(Date humoralImmunityComplementC3Date) {
        this.humoralImmunityComplementC3Date = humoralImmunityComplementC3Date;
    }

    public Date getHumoralImmunityComplementC4Date() {
        return humoralImmunityComplementC4Date;
    }

    public void setHumoralImmunityComplementC4Date(Date humoralImmunityComplementC4Date) {
        this.humoralImmunityComplementC4Date = humoralImmunityComplementC4Date;
    }

    public Date getHumoralImmunityIgEDate() {
        return humoralImmunityIgEDate;
    }

    public void setHumoralImmunityIgEDate(Date humoralImmunityIgEDate) {
        this.humoralImmunityIgEDate = humoralImmunityIgEDate;
    }

    public Date getHumoralImmunityKlightChainDate() {
        return humoralImmunityKlightChainDate;
    }

    public void setHumoralImmunityKlightChainDate(Date humoralImmunityKlightChainDate) {
        this.humoralImmunityKlightChainDate = humoralImmunityKlightChainDate;
    }

    public Date getHumoralImmunityNlightChainDate() {
        return humoralImmunityNlightChainDate;
    }

    public void setHumoralImmunityNlightChainDate(Date humoralImmunityNlightChainDate) {
        this.humoralImmunityNlightChainDate = humoralImmunityNlightChainDate;
    }

    public Date getCellularImmunityCD3Date() {
        return cellularImmunityCD3Date;
    }

    public void setCellularImmunityCD3Date(Date cellularImmunityCD3Date) {
        this.cellularImmunityCD3Date = cellularImmunityCD3Date;
    }

    public Date getCellularImmunityCD4Date() {
        return cellularImmunityCD4Date;
    }

    public void setCellularImmunityCD4Date(Date cellularImmunityCD4Date) {
        this.cellularImmunityCD4Date = cellularImmunityCD4Date;
    }

    public Date getCellularImmunityCD8Date() {
        return cellularImmunityCD8Date;
    }

    public void setCellularImmunityCD8Date(Date cellularImmunityCD8Date) {
        this.cellularImmunityCD8Date = cellularImmunityCD8Date;
    }

    public Date getCellularImmunityCD56Date() {
        return cellularImmunityCD56Date;
    }

    public void setCellularImmunityCD56Date(Date cellularImmunityCD56Date) {
        this.cellularImmunityCD56Date = cellularImmunityCD56Date;
    }

    public Date getCellularImmunityCD2Date() {
        return cellularImmunityCD2Date;
    }

    public void setCellularImmunityCD2Date(Date cellularImmunityCD2Date) {
        this.cellularImmunityCD2Date = cellularImmunityCD2Date;
    }

    public Date getCellularImmunityCD4CD8Date() {
        return cellularImmunityCD4CD8Date;
    }

    public void setCellularImmunityCD4CD8Date(Date cellularImmunityCD4CD8Date) {
        this.cellularImmunityCD4CD8Date = cellularImmunityCD4CD8Date;
    }

    public Date getLiverHardnessFibroscanDate() {
        return liverHardnessFibroscanDate;
    }

    public void setLiverHardnessFibroscanDate(Date liverHardnessFibroscanDate) {
        this.liverHardnessFibroscanDate = liverHardnessFibroscanDate;
    }

    public Date getLiverHardnessFibrotestDate() {
        return liverHardnessFibrotestDate;
    }

    public void setLiverHardnessFibrotestDate(Date liverHardnessFibrotestDate) {
        this.liverHardnessFibrotestDate = liverHardnessFibrotestDate;
    }

    public Date getCopperProteinDate() {
        return copperProteinDate;
    }

    public void setCopperProteinDate(Date copperProteinDate) {
        this.copperProteinDate = copperProteinDate;
    }

    public Date getaFPDate() {
        return aFPDate;
    }

    public void setaFPDate(Date aFPDate) {
        this.aFPDate = aFPDate;
    }

    public Date getCarcinoembryonicAntigenCEADate() {
        return carcinoembryonicAntigenCEADate;
    }

    public void setCarcinoembryonicAntigenCEADate(Date carcinoembryonicAntigenCEADate) {
        this.carcinoembryonicAntigenCEADate = carcinoembryonicAntigenCEADate;
    }

    public Date getCa125Date() {
        return ca125Date;
    }

    public void setCa125Date(Date ca125Date) {
        this.ca125Date = ca125Date;
    }

    public Date getHbsagDate() {
        return hbsagDate;
    }

    public void setHbsagDate(Date hbsagDate) {
        this.hbsagDate = hbsagDate;
    }

    public Date getHbsabDate() {
        return hbsabDate;
    }

    public void setHbsabDate(Date hbsabDate) {
        this.hbsabDate = hbsabDate;
    }

    public Date getHbeagDate() {
        return hbeagDate;
    }

    public void setHbeagDate(Date hbeagDate) {
        this.hbeagDate = hbeagDate;
    }

    public Date getHbeabDate() {
        return hbeabDate;
    }

    public void setHbeabDate(Date hbeabDate) {
        this.hbeabDate = hbeabDate;
    }

    public Date getHbcabDate() {
        return hbcabDate;
    }

    public void setHbcabDate(Date hbcabDate) {
        this.hbcabDate = hbcabDate;
    }

    public Date getHbvRnaDate() {
        return hbvRnaDate;
    }

    public void setHbvRnaDate(Date hbvRnaDate) {
        this.hbvRnaDate = hbvRnaDate;
    }

    public Date getAntiHCVantibodyDate() {
        return antiHCVantibodyDate;
    }

    public void setAntiHCVantibodyDate(Date antiHCVantibodyDate) {
        this.antiHCVantibodyDate = antiHCVantibodyDate;
    }

    public Date getHcvRnaDate() {
        return hcvRnaDate;
    }

    public void setHcvRnaDate(Date hcvRnaDate) {
        this.hcvRnaDate = hcvRnaDate;
    }

    public Date getProteinDate() {
        return proteinDate;
    }

    public void setProteinDate(Date proteinDate) {
        this.proteinDate = proteinDate;
    }

    public Date getRedBloodCellDate() {
        return redBloodCellDate;
    }

    public void setRedBloodCellDate(Date redBloodCellDate) {
        this.redBloodCellDate = redBloodCellDate;
    }

    public Date getWhiteBloodCellDate() {
        return whiteBloodCellDate;
    }

    public void setWhiteBloodCellDate(Date whiteBloodCellDate) {
        this.whiteBloodCellDate = whiteBloodCellDate;
    }

    public Date getBilirubinDate() {
        return bilirubinDate;
    }

    public void setBilirubinDate(Date bilirubinDate) {
        this.bilirubinDate = bilirubinDate;
    }

    public Date getCa199Date() {
        return ca199Date;
    }

    public void setCa199Date(Date ca199Date) {
        this.ca199Date = ca199Date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFollowUp() {
        return followUp;
    }

    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getAntiHCVantibody() {
        return antiHCVantibody;
    }

    public void setAntiHCVantibody(String antiHCVantibody) {
        this.antiHCVantibody = antiHCVantibody;
    }

    public String getHcvRna() {
        return hcvRna;
    }

    public void setHcvRna(String hcvRna) {
        this.hcvRna = hcvRna;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getRedBloodCell() {
        return redBloodCell;
    }

    public void setRedBloodCell(String redBloodCell) {
        this.redBloodCell = redBloodCell;
    }

    public String getWhiteBloodCell() {
        return whiteBloodCell;
    }

    public void setWhiteBloodCell(String whiteBloodCell) {
        this.whiteBloodCell = whiteBloodCell;
    }

    public String getBilirubin() {
        return bilirubin;
    }

    public void setBilirubin(String bilirubin) {
        this.bilirubin = bilirubin;
    }

    public String getCa199() {
        return ca199;
    }

    public void setCa199(String ca199) {
        this.ca199 = ca199;
    }

    public String getCa125() {
        return ca125;
    }

    public void setCa125(String ca125) {
        this.ca125 = ca125;
    }

    public String getHbsag() {
        return hbsag;
    }

    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }

    public String getHbsab() {
        return hbsab;
    }

    public void setHbsab(String hbsab) {
        this.hbsab = hbsab;
    }

    public String getHbeag() {
        return hbeag;
    }

    public void setHbeag(String hbeag) {
        this.hbeag = hbeag;
    }

    public String getHbeab() {
        return hbeab;
    }

    public void setHbeab(String hbeab) {
        this.hbeab = hbeab;
    }

    public String getHbcab() {
        return hbcab;
    }

    public void setHbcab(String hbcab) {
        this.hbcab = hbcab;
    }

    public String getHbvRna() {
        return hbvRna;
    }

    public void setHbvRna(String hbvRna) {
        this.hbvRna = hbvRna;
    }

    public String getaFP() {
        return aFP;
    }

    public void setaFP(String aFP) {
        this.aFP = aFP;
    }

    public String getCarcinoembryonicAntigenCEA() {
        return carcinoembryonicAntigenCEA;
    }

    public void setCarcinoembryonicAntigenCEA(String carcinoembryonicAntigenCEA) {
        this.carcinoembryonicAntigenCEA = carcinoembryonicAntigenCEA;
    }

    private boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTotalBileAcid() {
        return totalBileAcid;
    }

    public void setTotalBileAcid(String totalBileAcid) {
        this.totalBileAcid = totalBileAcid;
    }

    public String getLiverFunctionAlbumin() {
        return liverFunctionAlbumin;
    }

    public void setLiverFunctionAlbumin(String liverFunctionAlbumin) {
        this.liverFunctionAlbumin = liverFunctionAlbumin;
    }

    public String getLiverFunctionGlobulin() {
        return liverFunctionGlobulin;
    }

    public void setLiverFunctionGlobulin(String liverFunctionGlobulin) {
        this.liverFunctionGlobulin = liverFunctionGlobulin;
    }

    public String getLiverFunctionALT() {
        return liverFunctionALT;
    }

    public void setLiverFunctionALT(String liverFunctionALT) {
        this.liverFunctionALT = liverFunctionALT;
    }

    public String getLiverFunctionAST() {
        return liverFunctionAST;
    }

    public void setLiverFunctionAST(String liverFunctionAST) {
        this.liverFunctionAST = liverFunctionAST;
    }

    public String getLiverFunctionGGT() {
        return liverFunctionGGT;
    }

    public void setLiverFunctionGGT(String liverFunctionGGT) {
        this.liverFunctionGGT = liverFunctionGGT;
    }

    public String getLiverFunctionALP() {
        return liverFunctionALP;
    }

    public void setLiverFunctionALP(String liverFunctionALP) {
        this.liverFunctionALP = liverFunctionALP;
    }

    public String getLiverFunctionTotalCholesterol() {
        return liverFunctionTotalCholesterol;
    }

    public void setLiverFunctionTotalCholesterol(String liverFunctionTotalCholesterol) {
        this.liverFunctionTotalCholesterol = liverFunctionTotalCholesterol;
    }

    public String getLiverFunctionTotalBilirubin() {
        return liverFunctionTotalBilirubin;
    }

    public void setLiverFunctionTotalBilirubin(String liverFunctionTotalBilirubin) {
        this.liverFunctionTotalBilirubin = liverFunctionTotalBilirubin;
    }

    public String getLiverFunctionDirectBilirubin() {
        return liverFunctionDirectBilirubin;
    }

    public void setLiverFunctionDirectBilirubin(String liverFunctionDirectBilirubin) {
        this.liverFunctionDirectBilirubin = liverFunctionDirectBilirubin;
    }

    public String getLiverFunctionRglobulin() {
        return liverFunctionRglobulin;
    }

    public void setLiverFunctionRglobulin(String liverFunctionRglobulin) {
        this.liverFunctionRglobulin = liverFunctionRglobulin;
    }

    public String getRenalFunctionBUN() {
        return renalFunctionBUN;
    }

    public void setRenalFunctionBUN(String renalFunctionBUN) {
        this.renalFunctionBUN = renalFunctionBUN;
    }

    public String getRenalFunctionCr() {
        return renalFunctionCr;
    }

    public void setRenalFunctionCr(String renalFunctionCr) {
        this.renalFunctionCr = renalFunctionCr;
    }

    public String getClottingPT() {
        return clottingPT;
    }

    public void setClottingPT(String clottingPT) {
        this.clottingPT = clottingPT;
    }

    public String getClottingINR() {
        return clottingINR;
    }

    public void setClottingINR(String clottingINR) {
        this.clottingINR = clottingINR;
    }

    public String getBloodRoutineRBC() {
        return bloodRoutineRBC;
    }

    public void setBloodRoutineRBC(String bloodRoutineRBC) {
        this.bloodRoutineRBC = bloodRoutineRBC;
    }

    public String getBloodRoutineHb() {
        return bloodRoutineHb;
    }

    public void setBloodRoutineHb(String bloodRoutineHb) {
        this.bloodRoutineHb = bloodRoutineHb;
    }

    public String getBloodRoutineWBC() {
        return bloodRoutineWBC;
    }

    public void setBloodRoutineWBC(String bloodRoutineWBC) {
        this.bloodRoutineWBC = bloodRoutineWBC;
    }

    public String getBloodRoutineNeutrophils() {
        return bloodRoutineNeutrophils;
    }

    public void setBloodRoutineNeutrophils(String bloodRoutineNeutrophils) {
        this.bloodRoutineNeutrophils = bloodRoutineNeutrophils;
    }

    public String getBloodRoutineLymphocytes() {
        return bloodRoutineLymphocytes;
    }

    public void setBloodRoutineLymphocytes(String bloodRoutineLymphocytes) {
        this.bloodRoutineLymphocytes = bloodRoutineLymphocytes;
    }

    public String getBloodRoutineEosinophils() {
        return bloodRoutineEosinophils;
    }

    public void setBloodRoutineEosinophils(String bloodRoutineEosinophils) {
        this.bloodRoutineEosinophils = bloodRoutineEosinophils;
    }

    public String getBloodRoutinePlatelets() {
        return bloodRoutinePlatelets;
    }

    public void setBloodRoutinePlatelets(String bloodRoutinePlatelets) {
        this.bloodRoutinePlatelets = bloodRoutinePlatelets;
    }

    public String getLiverDiseaseAutoantibodiesAMA() {
        return liverDiseaseAutoantibodiesAMA;
    }

    public void setLiverDiseaseAutoantibodiesAMA(String liverDiseaseAutoantibodiesAMA) {
        this.liverDiseaseAutoantibodiesAMA = liverDiseaseAutoantibodiesAMA;
    }

    public String getLiverDiseaseAutoantibodiesAMAM2() {
        return liverDiseaseAutoantibodiesAMAM2;
    }

    public void setLiverDiseaseAutoantibodiesAMAM2(String liverDiseaseAutoantibodiesAMAM2) {
        this.liverDiseaseAutoantibodiesAMAM2 = liverDiseaseAutoantibodiesAMAM2;
    }

    public String getLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibody() {
        return liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody;
    }

    public void setLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibody(
            String liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody) {
        this.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody =
                liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody;
    }

    public String getLiverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies() {
        return liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies;
    }

    public void setLiverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies(
            String liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies) {
        this.liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies =
                liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies;
    }

    public String getLiverDiseaseAutoantibodiesHepatocyteSoluteAntigen() {
        return liverDiseaseAutoantibodiesHepatocyteSoluteAntigen;
    }

    public void setLiverDiseaseAutoantibodiesHepatocyteSoluteAntigen(
            String liverDiseaseAutoantibodiesHepatocyteSoluteAntigen) {
        this.liverDiseaseAutoantibodiesHepatocyteSoluteAntigen =
                liverDiseaseAutoantibodiesHepatocyteSoluteAntigen;
    }

    public String getLiverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen() {
        return liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen;
    }

    public void setLiverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen(
            String liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen) {
        this.liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen =
                liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen;
    }

    public String getLiverDiseaseAutoantibodiesOther() {
        return liverDiseaseAutoantibodiesOther;
    }

    public void setLiverDiseaseAutoantibodiesOther(String liverDiseaseAutoantibodiesOther) {
        this.liverDiseaseAutoantibodiesOther = liverDiseaseAutoantibodiesOther;
    }

    public String getANAHomogeneous() {
        return ANAHomogeneous;
    }

    public void setANAHomogeneous(String aNAHomogeneous) {
        ANAHomogeneous = aNAHomogeneous;
    }

    public String getANAParticle() {
        return ANAParticle;
    }

    public void setANAParticle(String aNAParticle) {
        ANAParticle = aNAParticle;
    }

    public String getANAPeripheral() {
        return ANAPeripheral;
    }

    public void setANAPeripheral(String aNAPeripheral) {
        ANAPeripheral = aNAPeripheral;
    }

    public String getANANucleolus() {
        return ANANucleolus;
    }

    public void setANANucleolus(String aNANucleolus) {
        ANANucleolus = aNANucleolus;
    }

    public String getANANucleolusEnhancement() {
        return ANANucleolusEnhancement;
    }

    public void setANANucleolusEnhancement(String aNANucleolusEnhancement) {
        ANANucleolusEnhancement = aNANucleolusEnhancement;
    }

    public String getANANuclear() {
        return ANANuclear;
    }

    public void setANANuclear(String aNANuclear) {
        ANANuclear = aNANuclear;
    }

    public String getANACentromere() {
        return ANACentromere;
    }

    public void setANACentromere(String aNACentromere) {
        ANACentromere = aNACentromere;
    }

    public String getANAOther() {
        return ANAOther;
    }

    public void setANAOther(String aNAOther) {
        ANAOther = aNAOther;
    }

    public String getHumoralImmunityIgG() {
        return humoralImmunityIgG;
    }

    public void setHumoralImmunityIgG(String humoralImmunityIgG) {
        this.humoralImmunityIgG = humoralImmunityIgG;
    }

    public String getHumoralImmunityIgA() {
        return humoralImmunityIgA;
    }

    public void setHumoralImmunityIgA(String humoralImmunityIgA) {
        this.humoralImmunityIgA = humoralImmunityIgA;
    }

    public String getHumoralImmunityIgM() {
        return humoralImmunityIgM;
    }

    public void setHumoralImmunityIgM(String humoralImmunityIgM) {
        this.humoralImmunityIgM = humoralImmunityIgM;
    }

    public String getHumoralImmunityImmuneComplexf() {
        return humoralImmunityImmuneComplexf;
    }

    public void setHumoralImmunityImmuneComplexf(String humoralImmunityImmuneComplexf) {
        this.humoralImmunityImmuneComplexf = humoralImmunityImmuneComplexf;
    }

    public String getHumoralImmunityComplementC3() {
        return humoralImmunityComplementC3;
    }

    public void setHumoralImmunityComplementC3(String humoralImmunityComplementC3) {
        this.humoralImmunityComplementC3 = humoralImmunityComplementC3;
    }

    public String getHumoralImmunityComplementC4() {
        return humoralImmunityComplementC4;
    }

    public void setHumoralImmunityComplementC4(String humoralImmunityComplementC4) {
        this.humoralImmunityComplementC4 = humoralImmunityComplementC4;
    }

    public String getHumoralImmunityIgE() {
        return humoralImmunityIgE;
    }

    public void setHumoralImmunityIgE(String humoralImmunityIgE) {
        this.humoralImmunityIgE = humoralImmunityIgE;
    }

    public String getHumoralImmunityKlightChain() {
        return humoralImmunityKlightChain;
    }

    public void setHumoralImmunityKlightChain(String humoralImmunityKlightChain) {
        this.humoralImmunityKlightChain = humoralImmunityKlightChain;
    }

    public String getHumoralImmunityNlightChain() {
        return humoralImmunityNlightChain;
    }

    public void setHumoralImmunityNlightChain(String humoralImmunityNlightChain) {
        this.humoralImmunityNlightChain = humoralImmunityNlightChain;
    }

    public String getCellularImmunityCD3() {
        return cellularImmunityCD3;
    }

    public void setCellularImmunityCD3(String cellularImmunityCD3) {
        this.cellularImmunityCD3 = cellularImmunityCD3;
    }

    public String getCellularImmunityCD4() {
        return cellularImmunityCD4;
    }

    public void setCellularImmunityCD4(String cellularImmunityCD4) {
        this.cellularImmunityCD4 = cellularImmunityCD4;
    }

    public String getCellularImmunityCD8() {
        return cellularImmunityCD8;
    }

    public void setCellularImmunityCD8(String cellularImmunityCD8) {
        this.cellularImmunityCD8 = cellularImmunityCD8;
    }

    public String getCellularImmunityCD56() {
        return cellularImmunityCD56;
    }

    public void setCellularImmunityCD56(String cellularImmunityCD56) {
        this.cellularImmunityCD56 = cellularImmunityCD56;
    }

    public String getCellularImmunityCD2() {
        return cellularImmunityCD2;
    }

    public void setCellularImmunityCD2(String cellularImmunityCD2) {
        this.cellularImmunityCD2 = cellularImmunityCD2;
    }

    public String getCellularImmunityCD4CD8() {
        return cellularImmunityCD4CD8;
    }

    public void setCellularImmunityCD4CD8(String cellularImmunityCD4CD8) {
        this.cellularImmunityCD4CD8 = cellularImmunityCD4CD8;
    }

    public String getRheumaticImmuneRelatedAntibodies() {
        return rheumaticImmuneRelatedAntibodies;
    }

    public void setRheumaticImmuneRelatedAntibodies(String rheumaticImmuneRelatedAntibodies) {
        this.rheumaticImmuneRelatedAntibodies = rheumaticImmuneRelatedAntibodies;
    }

    public int getCTMRI() {
        return CTMRI;
    }

    public void setCTMRI(int cTMRI) {
        CTMRI = cTMRI;
    }

    public String getLiverHardnessFibroscan() {
        return liverHardnessFibroscan;
    }

    public void setLiverHardnessFibroscan(String liverHardnessFibroscan) {
        this.liverHardnessFibroscan = liverHardnessFibroscan;
    }

    public String getLiverHardnessFibrotest() {
        return liverHardnessFibrotest;
    }

    public void setLiverHardnessFibrotest(String liverHardnessFibrotest) {
        this.liverHardnessFibrotest = liverHardnessFibrotest;
    }

    public String getLiverPuncturePathology() {
        return liverPuncturePathology;
    }

    public void setLiverPuncturePathology(String liverPuncturePathology) {
        this.liverPuncturePathology = liverPuncturePathology;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
