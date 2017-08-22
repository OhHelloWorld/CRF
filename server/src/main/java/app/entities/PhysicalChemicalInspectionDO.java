package app.entities;

import java.util.Date;

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
 */
@Entity
@Table(name = "physical_chemical_inspection")
public class PhysicalChemicalInspectionDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int patientId;// 患者Id
    private String totalBileAcid;// 总胆汁酸
    private Date totalBileAcidDate;
    private String liverFunctionAlbumin;// 肝功能-白蛋白
    private Date liverFunctionAlbuminDate;
    private String liverFunctionGlobulin;// 肝功能-球蛋白
    private Date liverFunctionGlobulinDate;
    @Column(name = "liver_function_ALT")
    private String liverFunctionALT;// 肝功能-ALT
    @Column(name = "liver_function_ALT_date")
    private Date liverFunctionALTDate;
    @Column(name = "liver_function_AST")
    private String liverFunctionAST;// 肝功能-AST
    @Column(name = "liver_function_AST_date")
    private Date liverFunctionASTDate;
    @Column(name = "liver_function_GGT")
    private String liverFunctionGGT;// 肝功能-GGT
    @Column(name = "liver_function_GGT_date")
    private Date liverFunctionGGTDate;
    @Column(name = "liver_function_ALP")
    private String liverFunctionALP;// 肝功能--ALP
    @Column(name = "liver_function_ALP_date")
    private Date liverFunctionALPDate;
    private String liverFunctionTotalCholesterol;// 肝功能-总胆固醇
    private Date liverFunctionTotalCholesterolDate;
    private String liverFunctionTotalBilirubin;// 肝功能-总胆红素
    private Date liverFunctionTotalBilirubinDate;
    private String liverFunctionDirectBilirubin;// 肝功能-直接胆红素
    private Date liverFunctionDirectBilirubinDate;
    @Column(name = "liver_function_Rglobulin")
    private String liverFunctionRglobulin;// 肝功能-γ球蛋白
    @Column(name = "liver_function_Rglobulin_date")
    private Date liverFunctionRglobulinDate;
    @Column(name = "renal_function_BUN")
    private String renalFunctionBUN;// 肾功能-BUN
    @Column(name = "renal_function_BUN_date")
    private Date renalFunctionBUNDate;
    @Column(name = "renal_function_Cr")
    private String renalFunctionCr;// 肾功能-Cr
    @Column(name = "renal_function_Cr_date")
    private Date renalFunctionCrDate;
    @Column(name = "clotting_PT")
    private String clottingPT;// 凝血-PT
    @Column(name = "clotting_PT_date")
    private Date clottingPTDate;
    @Column(name = "clotting_INR")
    private String clottingINR;// 凝血-INR
    @Column(name = "clotting_INR_date")
    private Date clottingINRDate;
    @Column(name = "blood_routine_RBC")
    private String bloodRoutineRBC;// 血常规-RBC
    @Column(name = "blood_routine_RBC_date")
    private Date bloodRoutineRBCDate;
    @Column(name = "blood_routine_Hb")
    private String bloodRoutineHb;// 血常规-Hb
    @Column(name = "blood_routine_Hb_date")
    private Date bloodRoutineHbDate;
    @Column(name = "blood_routine_WBC")
    private String bloodRoutineWBC;// 血常规-WBC
    @Column(name = "blood_routine_WBC_date")
    private Date bloodRoutineWBCDate;
    private String bloodRoutineNeutrophils;// 血常规-中性粒细胞
    private Date bloodRoutineNeutrophilsDate;
    private String bloodRoutineLymphocytes;// 血常规-淋巴细胞
    private Date bloodRoutineLymphocytesDate;
    private String bloodRoutineEosinophils;// 血常规-嗜酸性粒细胞
    private Date bloodRoutineEosinophilsDate;
    private String bloodRoutinePlatelets;// 血常规-血小板
    private Date bloodRoutinePlateletsDate;
    @Column(name = "liver_disease_autoantibodies_AMA")
    private String liverDiseaseAutoantibodiesAMA;// 肝病自身抗体-AMA
    @Column(name = "liver_disease_autoantibodies_AMA_date")
    private Date liverDiseaseAutoantibodiesAMADate;
    @Column(name = "liver_disease_autoantibodies_AMA_M2")
    private String liverDiseaseAutoantibodiesAMAM2;// 肝病自身抗体-AMA-M2
    @Column(name = "liver_disease_autoantibodies_AMA_M2_date")
    private Date liverDiseaseAutoantibodiesAMAM2Date;
    private String liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody;// 肝病自身抗体-抗平滑肌抗体
    @Column(name = "liver_disease_autoantibodies_anti_smooth_muscle_antibody_date")
    private Date liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate;
    private String liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies;// 肝病自身抗体-肝肾微粒体抗体
    @Column(name = "liver_disease_autoantibodies_liver_kidney_microsomal_bodies_date")
    private Date liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate;
    private String liverDiseaseAutoantibodiesHepatocyteSoluteAntigen;// 肝病自身抗体-肝细胞溶质抗原
    @Column(name = "liver_disease_autoantibodies_hepatocyte_solute_antigen_date")
    private Date liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate;
    private String liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen;// 肝病自身抗体-可溶性肝-胰抗原
    @Column(name = "liver_disease_autoantibodies_soluble_liver_pancreatic_gen_date")
    private Date liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate;
    private String liverDiseaseAutoantibodiesOther;// 肝病自身抗体-其他
    @Column(name = "liver_disease_autoantibodies_other_date")
    private Date liverDiseaseAutoantibodiesOtherDate;
    @Column(name = "ANA_homogeneous")
    private String ANAHomogeneous;// ANA-均质型
    @Column(name = "ANA_homogeneous_date")
    private Date aNAHomogeneousDate;
    @Column(name = "ANA_particle")
    private String ANAParticle;// ANA-颗粒型
    @Column(name = "ANA_particle_date")
    private Date aNAParticleDate;
    @Column(name = "ANA_peripheral")
    private String ANAPeripheral;// ANA-周边型
    @Column(name = "ANA_peripheral_date")
    private Date aNAPeripheralDate;
    @Column(name = "ANA_nucleolus")
    private String ANANucleolus;// ANA-核仁型
    @Column(name = "ANA_nucleolus_date")
    private Date aNANucleolusDate;
    @Column(name = "ANA_nucleolus_enhancement")
    private String ANANucleolusEnhancement;// ANA-核仁增强型
    @Column(name = "ANA_nucleolus_enhancement_date")
    private Date aNANucleolusEnhancementDate;
    @Column(name = "ANA_nuclear")
    private String ANANuclear;// ANA-核点型
    @Column(name = "ANA_nuclear_date")
    private Date aNANuclearDate;
    @Column(name = "ANA_centromere")
    private String ANACentromere;// ANA-着丝点型
    @Column(name = "ANA_centromere_date")
    private Date aNACentromereDate;
    @Column(name = "ANA_other")
    private String ANAOther;// ANA-其他
    @Column(name = "ANA_other_date")
    private Date aNAOtherDate;
    @Column(name = "humoral_immunity_IgG")
    private String humoralImmunityIgG;// 体液免疫-IgG
    @Column(name = "humoral_immunity_IgG_date")
    private Date humoralImmunityIgGDate;
    @Column(name = "humoral_immunity_IgA")
    private String humoralImmunityIgA;// 体液免疫-IgA
    @Column(name = "humoral_immunity_IgA_date")
    private Date humoralImmunityIgADate;
    @Column(name = "humoral_immunity_IgM")
    private String humoralImmunityIgM;// 体液免疫-IgM
    @Column(name = "humoral_immunity_IgM_date")
    private Date humoralImmunityIgMDate;
    private String humoralImmunityImmuneComplexf;// 体液免疫-免疫复合物
    private Date humoralImmunityImmuneComplexfDate;
    private String humoralImmunityComplementC3;// 体液免疫-补体C3
    @Column(name = "humoral_immunity_complementC3_date")
    private Date humoralImmunityComplementC3Date;
    private String humoralImmunityComplementC4;// 体液免疫-补体C4
    @Column(name = "humoral_immunity_complementC4_date")
    private Date humoralImmunityComplementC4Date;
    @Column(name = "humoral_immunity_IgE")
    private String humoralImmunityIgE;// 体液免疫-IgE
    @Column(name = "humoral_immunity_IgE_date")
    private Date humoralImmunityIgEDate;
    @Column(name = "humoral_immunity_Klight_chain")
    private String humoralImmunityKlightChain;// 体液免疫-k轻链
    @Column(name = "humoral_immunity_Klight_chain_date")
    private Date humoralImmunityKlightChainDate;
    @Column(name = "humoral_immunity_Nlight_chain")
    private String humoralImmunityNlightChain;// 体液免疫-入轻链
    @Column(name = "humoral_immunity_Nlight_chain_date")
    private Date humoralImmunityNlightChainDate;
    @Column(name = "cellular_immunity_CD3")
    private String cellularImmunityCD3;// 细胞免疫-CD3
    @Column(name = "cellular_immunity_CD3_date")
    private Date cellularImmunityCD3Date;
    @Column(name = "cellular_immunity_CD4")
    private String cellularImmunityCD4;// 细胞免疫-CD4+
    @Column(name = "cellular_immunity_CD4_date")
    private Date cellularImmunityCD4Date;
    @Column(name = "cellular_immunity_CD8")
    private String cellularImmunityCD8;// 细胞免疫-CD8+
    @Column(name = "cellular_immunity_CD8_date")
    private Date cellularImmunityCD8Date;
    @Column(name = "cellular_immunity_CD56")
    private String cellularImmunityCD56;// 细胞免疫-CD56+16(NK)
    @Column(name = "cellular_immunity_CD56_date")
    private Date cellularImmunityCD56Date;
    @Column(name = "cellular_immunity_CD2")
    private String cellularImmunityCD2;// 细胞免疫-CD2
    @Column(name = "cellular_immunity_CD2_date")
    private Date cellularImmunityCD2Date;
    @Column(name = "cellular_immunity_CD4_CD8")
    private String cellularImmunityCD4CD8;// 细胞免疫-CD4/CD8
    @Column(name = "cellular_immunity_CD4_CD8_date")
    private Date cellularImmunityCD4CD8Date;
    private String rheumaticImmuneRelatedAntibodies;// 风湿免疫相关抗体
    @Column(name = "CT_MRI")
    private int CTMRI;// 腹部超声CT/MRI
    @Column(name = "liver_hardness_Fibroscan")
    private String liverHardnessFibroscan;// 肝脏硬度检查值-Fibroscan值
    @Column(name = "liver_hardness_Fibroscan_date")
    private Date liverHardnessFibroscanDate;
    @Column(name = "liver_hardness_Fibrotest")
    private String liverHardnessFibrotest;// 肝脏硬度检查值-Fibrotest值
    @Column(name = "liver_hardness_Fibrotest_date")
    private Date liverHardnessFibrotestDate;
    private String liverPuncturePathology;// 肝穿刺病理检查
    private boolean complete;// 是否完成
    @Column(name = "copper_protein")
    private String copperProtein;
    @Column(name = "copper_protein_date")
    private Date copperProteinDate;
    @Column(name = "a_f_p")
    private String aFP;
    @Column(name = "a_f_p_date")
    private Date aFPDate;
    @Column(name = "carcinoembryonic_antigenCEA")
    private String carcinoembryonicAntigenCEA;
    @Column(name = "carcinoembryonic_antigenCEA_date")
    private Date carcinoembryonicAntigenCEADate;
    private String ca125;
    @Column(name = "ca125_date")
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
    @Column(name = "hbv_rna")
    private String hbvRna;
    @Column(name = "hbv_rna_date")
    private Date hbvRnaDate;
    private String antiHCVantibody;
    private Date antiHCVantibodyDate;
    @Column(name = "hcv_rna")
    private String hcvRna;
    @Column(name = "hcv_rna_date")
    private Date hcvRnaDate;
    private String protein;
    private Date proteinDate;
    @Column(name = "red_blood_cell")
    private String redBloodCell;
    @Column(name = "red_blood_cell_date")
    private Date redBloodCellDate;
    @Column(name = "white_blood_cell")
    private String whiteBloodCell;
    @Column(name = "white_blood_cell_date")
    private Date whiteBloodCellDate;
    private String bilirubin;
    private Date bilirubinDate;
    private String ca199;
    @Column(name = "ca199_date")
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
