package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 理化检查结果
 * 
 * @author JR
 *
 */
@Entity
@Table(name = "physical_chemical_inspection")
public class PhysicalChemicalInspectionDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int patientId;// 患者Id
    private String totalBileAcid;// 总胆汁酸
    private String liverFunctionAlbumin;// 肝功能-白蛋白
    private String liverFunctionGlobulin;// 肝功能-球蛋白
    @Column(name = "liver_function_ALT")
    private String liverFunctionALT;// 肝功能-ALT
    @Column(name = "liver_function_AST")
    private String liverFunctionAST;// 肝功能-AST
    @Column(name = "liver_function_GGT")
    private String liverFunctionGGT;// 肝功能-GGT
    @Column(name = "liver_function_ALP")
    private String liverFunctionALP;// 肝功能--ALP
    private String liverFunctionTotalCholesterol;// 肝功能-总胆固醇
    private String liverFunctionTotalBilirubin;// 肝功能-总胆红素
    private String liverFunctionDirectBilirubin;// 肝功能-直接胆红素
    @Column(name = "liver_function_Rglobulin")
    private String liverFunctionRglobulin;// 肝功能-γ球蛋白
    @Column(name = "renal_function_BUN")
    private String renalFunctionBUN;// 肾功能-BUN
    @Column(name = "renal_function_Cr")
    private String renalFunctionCr;// 肾功能-Cr
    @Column(name = "clotting_PT")
    private String clottingPT;// 凝血-PT
    @Column(name = "clotting_INR")
    private String clottingINR;// 凝血-INR
    @Column(name = "blood_routine_RBC")
    private String bloodRoutineRBC;// 血常规-RBC
    @Column(name = "blood_routine_Hb")
    private String bloodRoutineHb;// 血常规-Hb
    @Column(name = "blood_routine_WBC")
    private String bloodRoutineWBC;// 血常规-WBC
    private String bloodRoutineNeutrophils;// 血常规-中性粒细胞
    private String bloodRoutineLymphocytes;// 血常规-淋巴细胞
    private String bloodRoutineEosinophils;// 血常规-嗜酸性粒细胞
    private String bloodRoutinePlatelets;// 血常规-血小板
    @Column(name = "liver_disease_autoantibodies_AMA")
    private String liverDiseaseAutoantibodiesAMA;// 肝病自身抗体-AMA
    @Column(name = "liver_disease_autoantibodies_AMA_M2")
    private String liverDiseaseAutoantibodiesAMAM2;// 肝病自身抗体-AMA-M2
    private String liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody;// 肝病自身抗体-抗平滑肌抗体
    private String liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies;// 肝病自身抗体-肝肾微粒体抗体
    private String liverDiseaseAutoantibodiesHepatocyteSoluteAntigen;// 肝病自身抗体-肝细胞溶质抗原
    private String liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen;// 肝病自身抗体-可溶性肝-胰抗原
    private String liverDiseaseAutoantibodiesOther;// 肝病自身抗体-其他
    @Column(name = "ANA_homogeneous")
    private String ANAHomogeneous;// ANA-均质型
    @Column(name = "ANA_particle")
    private String ANAParticle;// ANA-颗粒型
    @Column(name = "ANA_peripheral")
    private String ANAPeripheral;// ANA-周边型
    @Column(name = "ANA_nucleolus")
    private String ANANucleolus;// ANA-核仁型
    @Column(name = "ANA_nucleolus_enhancement")
    private String ANANucleolusEnhancement;// ANA-核仁增强型
    @Column(name = "ANA_nuclear")
    private String ANANuclear;// ANA-核点型
    @Column(name = "ANA_centromere")
    private String ANACentromere;// ANA-着丝点型
    @Column(name = "ANA_other")
    private String ANAOther;// ANA-其他
    @Column(name = "humoral_immunity_IgG")
    private String humoralImmunityIgG;// 体液免疫-IgG
    @Column(name = "humoral_immunity_IgA")
    private String humoralImmunityIgA;// 体液免疫-IgA
    @Column(name = "humoral_immunity_IgM")
    private String humoralImmunityIgM;// 体液免疫-IgM
    private String humoralImmunityImmuneComplexf;// 体液免疫-免疫复合物
    private String humoralImmunityComplementC3;// 体液免疫-补体C3
    private String humoralImmunityComplementC4;// 体液免疫-补体C4
    @Column(name = "humoral_immunity_IgE")
    private String humoralImmunityIgE;// 体液免疫-IgE
    @Column(name = "humoral_immunity_Klight_chain")
    private String humoralImmunityKlightChain;// 体液免疫-k轻链
    @Column(name = "humoral_immunity_Nlight_chain")
    private String humoralImmunityNlightChain;// 体液免疫-入轻链
    @Column(name = "cellular_immunity_CD3")
    private String cellularImmunityCD3;// 细胞免疫-CD3
    @Column(name = "cellular_immunity_CD4")
    private String cellularImmunityCD4;// 细胞免疫-CD4+
    @Column(name = "cellular_immunity_CD8")
    private String cellularImmunityCD8;// 细胞免疫-CD8+
    @Column(name = "cellular_immunity_CD56")
    private String cellularImmunityCD56;// 细胞免疫-CD56+16(NK)
    @Column(name = "cellular_immunity_CD2")
    private String cellularImmunityCD2;// 细胞免疫-CD2
    @Column(name = "cellular_immunity_CD4_CD8")
    private String cellularImmunityCD4CD8;// 细胞免疫-CD4/CD8
    private String rheumaticImmuneRelatedAntibodies;// 风湿免疫相关抗体
    @Column(name = "CT_MRI")
    private int CTMRI;// 腹部超声CT/MRI
    @Column(name = "liver_hardness_Fibroscan")
    private String liverHardnessFibroscan;// 肝脏硬度检查值-Fibroscan值
    @Column(name = "liver_hardness_Fibrotest")
    private String liverHardnessFibrotest;// 肝脏硬度检查值-Fibrotest值
    private String liverPuncturePathology;// 肝穿刺病理检查
    private boolean complete;// 是否完成

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
