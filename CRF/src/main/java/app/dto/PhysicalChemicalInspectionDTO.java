package app.dto;


/**
 * @author Administrator �������DTO
 */
public class PhysicalChemicalInspectionDTO {

    private int id;
    private int patientId;
    private float totalBileAcid;
    private float liverFunctionAlbumin;
    private float liverFunctionGlobulin;
    private float liverFunctionALT;
    private float liverFunctionAST;
    private float liverFunctionGGT;
    private float liverFunctionALP;
    private float liverFunctionTotalCholesterol;
    private float liverFunctionTotalBilirubin;
    private float liverFunctionDirectBilirubin;
    private float liverFunctionRglobulin;
    private float renalFunctionBUN;
    private float renalFunctionCr;
    private float clottingPT;
    private float clottingINR;
    private float bloodRoutineRBC;
    private float bloodRoutineHb;
    private float bloodRoutineWBC;
    private float bloodRoutineNeutrophils;
    private float bloodRoutineLymphocytes;
    private float bloodRoutineEosinophils;
    private float bloodRoutinePlatelets;
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
    private float humoralImmunityIgG;
    private float humoralImmunityIgA;
    private float humoralImmunityIgM;
    private float humoralImmunityImmuneComplexf;
    private float humoralImmunityComplementC3;
    private float humoralImmunityComplementC4;
    private float humoralImmunityIgE;
    private float humoralImmunityKlightChain;
    private float humoralImmunityNlightChain;
    private float cellularImmunityCD3;
    private float cellularImmunityCD4;
    private float cellularImmunityCD8;
    private float cellularImmunityCD56;
    private float cellularImmunityCD2;
    private float cellularImmunityCD4CD8;
    private String rheumaticImmuneRelatedAntibodies;
    private int CTMRI;
    private float liverHardnessFibroscan;
    private float liverHardnessFibrotest;
    private String liverPuncturePathology;
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

    public float getTotalBileAcid() {
        return totalBileAcid;
    }

    public void setTotalBileAcid(float totalBileAcid) {
        this.totalBileAcid = totalBileAcid;
    }

    public float getLiverFunctionAlbumin() {
        return liverFunctionAlbumin;
    }

    public void setLiverFunctionAlbumin(float liverFunctionAlbumin) {
        this.liverFunctionAlbumin = liverFunctionAlbumin;
    }

    public float getLiverFunctionGlobulin() {
        return liverFunctionGlobulin;
    }

    public void setLiverFunctionGlobulin(float liverFunctionGlobulin) {
        this.liverFunctionGlobulin = liverFunctionGlobulin;
    }

    public float getLiverFunctionALT() {
        return liverFunctionALT;
    }

    public void setLiverFunctionALT(float liverFunctionALT) {
        this.liverFunctionALT = liverFunctionALT;
    }

    public float getLiverFunctionAST() {
        return liverFunctionAST;
    }

    public void setLiverFunctionAST(float liverFunctionAST) {
        this.liverFunctionAST = liverFunctionAST;
    }

    public float getLiverFunctionGGT() {
        return liverFunctionGGT;
    }

    public void setLiverFunctionGGT(float liverFunctionGGT) {
        this.liverFunctionGGT = liverFunctionGGT;
    }

    public float getLiverFunctionALP() {
        return liverFunctionALP;
    }

    public void setLiverFunctionALP(float liverFunctionALP) {
        this.liverFunctionALP = liverFunctionALP;
    }

    public float getLiverFunctionTotalCholesterol() {
        return liverFunctionTotalCholesterol;
    }

    public void setLiverFunctionTotalCholesterol(float liverFunctionTotalCholesterol) {
        this.liverFunctionTotalCholesterol = liverFunctionTotalCholesterol;
    }

    public float getLiverFunctionTotalBilirubin() {
        return liverFunctionTotalBilirubin;
    }

    public void setLiverFunctionTotalBilirubin(float liverFunctionTotalBilirubin) {
        this.liverFunctionTotalBilirubin = liverFunctionTotalBilirubin;
    }

    public float getLiverFunctionDirectBilirubin() {
        return liverFunctionDirectBilirubin;
    }

    public void setLiverFunctionDirectBilirubin(float liverFunctionDirectBilirubin) {
        this.liverFunctionDirectBilirubin = liverFunctionDirectBilirubin;
    }

    public float getLiverFunctionRglobulin() {
        return liverFunctionRglobulin;
    }

    public void setLiverFunctionRglobulin(float liverFunctionRglobulin) {
        this.liverFunctionRglobulin = liverFunctionRglobulin;
    }

    public float getRenalFunctionBUN() {
        return renalFunctionBUN;
    }

    public void setRenalFunctionBUN(float renalFunctionBUN) {
        this.renalFunctionBUN = renalFunctionBUN;
    }

    public float getRenalFunctionCr() {
        return renalFunctionCr;
    }

    public void setRenalFunctionCr(float renalFunctionCr) {
        this.renalFunctionCr = renalFunctionCr;
    }

    public float getClottingPT() {
        return clottingPT;
    }

    public void setClottingPT(float clottingPT) {
        this.clottingPT = clottingPT;
    }

    public float getClottingINR() {
        return clottingINR;
    }

    public void setClottingINR(float clottingINR) {
        this.clottingINR = clottingINR;
    }

    public float getBloodRoutineRBC() {
        return bloodRoutineRBC;
    }

    public void setBloodRoutineRBC(float bloodRoutineRBC) {
        this.bloodRoutineRBC = bloodRoutineRBC;
    }

    public float getBloodRoutineHb() {
        return bloodRoutineHb;
    }

    public void setBloodRoutineHb(float bloodRoutineHb) {
        this.bloodRoutineHb = bloodRoutineHb;
    }

    public float getBloodRoutineWBC() {
        return bloodRoutineWBC;
    }

    public void setBloodRoutineWBC(float bloodRoutineWBC) {
        this.bloodRoutineWBC = bloodRoutineWBC;
    }

    public float getBloodRoutineNeutrophils() {
        return bloodRoutineNeutrophils;
    }

    public void setBloodRoutineNeutrophils(float bloodRoutineNeutrophils) {
        this.bloodRoutineNeutrophils = bloodRoutineNeutrophils;
    }

    public float getBloodRoutineLymphocytes() {
        return bloodRoutineLymphocytes;
    }

    public void setBloodRoutineLymphocytes(float bloodRoutineLymphocytes) {
        this.bloodRoutineLymphocytes = bloodRoutineLymphocytes;
    }

    public float getBloodRoutineEosinophils() {
        return bloodRoutineEosinophils;
    }

    public void setBloodRoutineEosinophils(float bloodRoutineEosinophils) {
        this.bloodRoutineEosinophils = bloodRoutineEosinophils;
    }

    public float getBloodRoutinePlatelets() {
        return bloodRoutinePlatelets;
    }

    public void setBloodRoutinePlatelets(float bloodRoutinePlatelets) {
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

    public float getHumoralImmunityIgG() {
        return humoralImmunityIgG;
    }

    public void setHumoralImmunityIgG(float humoralImmunityIgG) {
        this.humoralImmunityIgG = humoralImmunityIgG;
    }

    public float getHumoralImmunityIgA() {
        return humoralImmunityIgA;
    }

    public void setHumoralImmunityIgA(float humoralImmunityIgA) {
        this.humoralImmunityIgA = humoralImmunityIgA;
    }

    public float getHumoralImmunityIgM() {
        return humoralImmunityIgM;
    }

    public void setHumoralImmunityIgM(float humoralImmunityIgM) {
        this.humoralImmunityIgM = humoralImmunityIgM;
    }

    public float getHumoralImmunityImmuneComplexf() {
        return humoralImmunityImmuneComplexf;
    }

    public void setHumoralImmunityImmuneComplexf(float humoralImmunityImmuneComplexf) {
        this.humoralImmunityImmuneComplexf = humoralImmunityImmuneComplexf;
    }

    public float getHumoralImmunityComplementC3() {
        return humoralImmunityComplementC3;
    }

    public void setHumoralImmunityComplementC3(float humoralImmunityComplementC3) {
        this.humoralImmunityComplementC3 = humoralImmunityComplementC3;
    }

    public float getHumoralImmunityComplementC4() {
        return humoralImmunityComplementC4;
    }

    public void setHumoralImmunityComplementC4(float humoralImmunityComplementC4) {
        this.humoralImmunityComplementC4 = humoralImmunityComplementC4;
    }

    public float getHumoralImmunityIgE() {
        return humoralImmunityIgE;
    }

    public void setHumoralImmunityIgE(float humoralImmunityIgE) {
        this.humoralImmunityIgE = humoralImmunityIgE;
    }

    public float getHumoralImmunityKlightChain() {
        return humoralImmunityKlightChain;
    }

    public void setHumoralImmunityKlightChain(float humoralImmunityKlightChain) {
        this.humoralImmunityKlightChain = humoralImmunityKlightChain;
    }

    public float getHumoralImmunityNlightChain() {
        return humoralImmunityNlightChain;
    }

    public void setHumoralImmunityNlightChain(float humoralImmunityNlightChain) {
        this.humoralImmunityNlightChain = humoralImmunityNlightChain;
    }

    public float getCellularImmunityCD3() {
        return cellularImmunityCD3;
    }

    public void setCellularImmunityCD3(float cellularImmunityCD3) {
        this.cellularImmunityCD3 = cellularImmunityCD3;
    }

    public float getCellularImmunityCD4() {
        return cellularImmunityCD4;
    }

    public void setCellularImmunityCD4(float cellularImmunityCD4) {
        this.cellularImmunityCD4 = cellularImmunityCD4;
    }

    public float getCellularImmunityCD8() {
        return cellularImmunityCD8;
    }

    public void setCellularImmunityCD8(float cellularImmunityCD8) {
        this.cellularImmunityCD8 = cellularImmunityCD8;
    }

    public float getCellularImmunityCD56() {
        return cellularImmunityCD56;
    }

    public void setCellularImmunityCD56(float cellularImmunityCD56) {
        this.cellularImmunityCD56 = cellularImmunityCD56;
    }

    public float getCellularImmunityCD2() {
        return cellularImmunityCD2;
    }

    public void setCellularImmunityCD2(float cellularImmunityCD2) {
        this.cellularImmunityCD2 = cellularImmunityCD2;
    }

    public float getCellularImmunityCD4CD8() {
        return cellularImmunityCD4CD8;
    }

    public void setCellularImmunityCD4CD8(float cellularImmunityCD4CD8) {
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

    public float getLiverHardnessFibroscan() {
        return liverHardnessFibroscan;
    }

    public void setLiverHardnessFibroscan(float liverHardnessFibroscan) {
        this.liverHardnessFibroscan = liverHardnessFibroscan;
    }

    public float getLiverHardnessFibrotest() {
        return liverHardnessFibrotest;
    }

    public void setLiverHardnessFibrotest(float liverHardnessFibrotest) {
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
