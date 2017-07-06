package app.dto;


/**
 * @author Administrator �������DTO
 */
public class PhysicalChemicalInspectionDTO {

    private int id;
    private int patientId;
    private String totalBileAcid;
    private String liverFunctionAlbumin;
    private String liverFunctionGlobulin;
    private String liverFunctionALT;
    private String liverFunctionAST;
    private String liverFunctionGGT;
    private String liverFunctionALP;
    private String liverFunctionTotalCholesterol;
    private String liverFunctionTotalBilirubin;
    private String liverFunctionDirectBilirubin;
    private String liverFunctionRglobulin;
    private String renalFunctionBUN;
    private String renalFunctionCr;
    private String clottingPT;
    private String clottingINR;
    private String bloodRoutineRBC;
    private String bloodRoutineHb;
    private String bloodRoutineWBC;
    private String bloodRoutineNeutrophils;
    private String bloodRoutineLymphocytes;
    private String bloodRoutineEosinophils;
    private String bloodRoutinePlatelets;
    private String liverDiseaseAutoantibodiesAMA;
    private String liverDiseaseAutoantibodiesAMAM2;
    private String liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody;
    private String liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies;
    private String liverDiseaseAutoantibodiesHepatocyteSoluteAntigen;
    private String liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen;
    private String liverDiseaseAutoantibodiesOther;
    private String ANAHomogeneous;
    private String ANAParticle;
    private String ANAPeripheral;
    private String ANANucleolus;
    private String ANANucleolusEnhancement;
    private String ANANuclear;
    private String ANACentromere;
    private String ANAOther;
    private String humoralImmunityIgG;
    private String humoralImmunityIgA;
    private String humoralImmunityIgM;
    private String humoralImmunityImmuneComplexf;
    private String humoralImmunityComplementC3;
    private String humoralImmunityComplementC4;
    private String humoralImmunityIgE;
    private String humoralImmunityKlightChain;
    private String humoralImmunityNlightChain;
    private String cellularImmunityCD3;
    private String cellularImmunityCD4;
    private String cellularImmunityCD8;
    private String cellularImmunityCD56;
    private String cellularImmunityCD2;
    private String cellularImmunityCD4CD8;
    private String rheumaticImmuneRelatedAntibodies;
    private int CTMRI;
    private String liverHardnessFibroscan;
    private String liverHardnessFibrotest;
    private String liverPuncturePathology;
    private String copperProtein;

    public String getCopperProtein() {
        return copperProtein;
    }

    public void setCopperProtein(String copperProtein) {
        this.copperProtein = copperProtein;
    }

    private String aFP;
    private String carcinoembryonicAntigenCEA;
    private String ca125;
    private String hbsag;
    private String hbsab;
    private String hbeag;
    private String hbeab;
    private String hbcab;
    private String hbvRna;
    private String antiHCVantibody;
    private String hcvRna;
    private String protein;
    private String redBloodCell;
    private String whiteBloodCell;
    private String bilirubin;
    private String ca199;

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
