package app.Utils;

import app.entities.*;
import app.repo.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
@Component
public class MlCreateAllExcel{

    @Autowired
    private MlPatientRepo mlPatientRepo;

    @Autowired
    private ExcludeOtherRepo mlExcludeOtherRepo;

    @Autowired
    private FirstAbnormalExaminationRepo mlFirstAbnormalExaminationRepo;

    @Autowired
    private ImagingEndoScopyRepo mlImagingEndoScopyRepo;

    @Autowired
    private MlAllergyHistoryRepo mlAllergyHistoryRepo;

    @Autowired
    private MlBiologicalSamplesRepo mlBiologicalSamplesRepo;

    @Autowired
    private MlDiseaseHistoryRepo mlDiseaseHistoryRepo;

    @Autowired
    private MlDiseaseOutcomeRepo mlDiseaseOutcomeRepo;

    @Autowired
    private MlDrinkRepo mlDrinkRepo;

    @Autowired
    private MlDrugHistoryRepo mlDrugHistoryRepo;

    @Autowired
    private MlLiverHistologicalRepo mlLiverHistologicalRepo;

    @Autowired
    private MlLiverInjuryRepo mlLiverInjuryRepo;

    @Autowired
    private MlRoutineBooldRepo mlRoutineBooldRepo;

    @Autowired
    private MlSymptomsRepo mlSymptomsRepo;

    @Autowired
    private MlTreatmentRepo mlTreatmentRepo;

    @Value("${excel_path}")
    private String excelPath;

    public void createAllExcel() throws Exception {

        List<MlPatientDO> mlPatientDOs = (List<MlPatientDO>) mlPatientRepo.findAll();

        MedicineLiverAllergyHistoryDO mlAllergyDO;
        MedicineLiverBiologicalSamplesDO mlBiologicalDO;
        MedicineLiverDiseaseHistoryDO mlDiseaseDO;
        MedicineLiverDiseaseOutcomeDO mlOutcomeDO;
        MedicineLiverDrinkDO mlDrinkDO;
        MedicineLiverExcludeOtherDO mlExcludeDO;
        MedicineLiverFirstAbnormalExaminationDO mlFirstDO;
        MedicineLiverFirstAbnormalExaminationDO mlHospitalDO;
        MedicineLiverImagingEndoscopyDO mlImagingDO;
        MedicineLiverLiverHistologicalDO mlHistologicalDO;
        MedicineLiverLiverInjuryDO mlInjuryDO;
        MedicineLiverRoutineBloodDO mlBloodDO;
        MedicineLiverSuspectedDrugDO mlDrugDO;
        MedicineLiverSymptomsDO mlSymptomsDO;
        MedicineLiverTreatmentDO mlTreatmentDO;

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("药肝病例");
        Row row = null;

        row = sheet.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("姓名拼音缩写");
        row.createCell(2).setCellValue("出生日期");
        row.createCell(3).setCellValue("民族");
        row.createCell(4).setCellValue("体重（kg）");
        row.createCell(5).setCellValue("身高（cm）");
        row.createCell(6).setCellValue("性别");
        row.createCell(7).setCellValue("职业");
        row.createCell(8).setCellValue("医院");
        row.createCell(9).setCellValue("科室");
        row.createCell(10).setCellValue("入院日期");
        row.createCell(11).setCellValue("入院时年龄");
        row.createCell(12).setCellValue("出院日期");
        row.createCell(13).setCellValue("住院号");
        row.createCell(14).setCellValue("住院科室");
        row.createCell(15).setCellValue("入院诊断-诊断时间");
        row.createCell(16).setCellValue("出院诊断-诊断时间");
        row.createCell(17).setCellValue("除药物性肝病以外，病例是否存在因本次入院的其他疾病史");
        row.createCell(18).setCellValue("既往病史");
        row.createCell(19).setCellValue("既往病史详情");
        row.createCell(20).setCellValue("既往过敏史");
        row.createCell(21).setCellValue("过敏原");
        row.createCell(22).setCellValue("饮酒史");
        row.createCell(23).setCellValue("饮酒种类-饮酒数量-饮酒年限-酒精度数");
        row.createCell(24).setCellValue("通用名-商品名-治疗疾病-用药方法-日剂量-开始日期-是否停药-停药时期-是否减量-既往该药暴露史-既往暴露引起肝损");
        row.createCell(25).setCellValue("肝损伤伴随的症状体征");
        row.createCell(26).setCellValue("乏力-描述");
        row.createCell(27).setCellValue("乏力-出现时间");
        row.createCell(28).setCellValue("乏力-消失时间");
        row.createCell(29).setCellValue("乏力-出院状态");
        row.createCell(30).setCellValue("纳差-描述");
        row.createCell(31).setCellValue("纳差-出现时间");
        row.createCell(32).setCellValue("纳差-消失时间");
        row.createCell(33).setCellValue("纳差-出院状态");
        row.createCell(34).setCellValue("膨胀-描述");
        row.createCell(35).setCellValue("膨胀-出现时间");
        row.createCell(36).setCellValue("膨胀-消失时间");
        row.createCell(37).setCellValue("膨胀-出院状态");
        row.createCell(38).setCellValue("黄疸-描述");
        row.createCell(39).setCellValue("黄疸-出现时间");
        row.createCell(40).setCellValue("黄疸-消失时间");
        row.createCell(41).setCellValue("黄疸-出院状态");
        row.createCell(42).setCellValue("恶心-描述");
        row.createCell(43).setCellValue("恶心-出现时间");
        row.createCell(44).setCellValue("恶心-消失时间");
        row.createCell(45).setCellValue("恶心-出院状态");
        row.createCell(46).setCellValue("呕吐-描述");
        row.createCell(47).setCellValue("呕吐-出现时间");
        row.createCell(48).setCellValue("呕吐-消失时间");
        row.createCell(49).setCellValue("呕吐-出院状态");
        row.createCell(50).setCellValue("齿龈出血-描述");
        row.createCell(51).setCellValue("齿龈出血-出现时间");
        row.createCell(52).setCellValue("齿龈出血-消失时间");
        row.createCell(53).setCellValue("齿龈出血-出院状态");
        row.createCell(54).setCellValue("鼻衄-描述");
        row.createCell(55).setCellValue("鼻衄-出现时间");
        row.createCell(56).setCellValue("鼻衄-消失时间");
        row.createCell(57).setCellValue("鼻衄-出院状态");
        row.createCell(58).setCellValue("肝区疼痛-");
        row.createCell(59).setCellValue("肝区疼痛-出现时间");
        row.createCell(60).setCellValue("肝区疼痛-消失时间");
        row.createCell(61).setCellValue("肝区疼痛-出院状态");
        row.createCell(62).setCellValue("肝肿大-描述");
        row.createCell(63).setCellValue("肝肿大-出现时间");
        row.createCell(64).setCellValue("肝肿大-消失时间");
        row.createCell(65).setCellValue("肝肿大-出院状态");
        row.createCell(66).setCellValue("脾肿大-描述");
        row.createCell(67).setCellValue("脾肿大-出现时间");
        row.createCell(68).setCellValue("脾肿大-消失时间");
        row.createCell(69).setCellValue("脾肿大-出院状态");
        row.createCell(70).setCellValue("发热-描述");
        row.createCell(71).setCellValue("发热-出现时间");
        row.createCell(72).setCellValue("发热-消失时间");
        row.createCell(73).setCellValue("发热-出院状态");
        row.createCell(74).setCellValue("皮疹-描述");
        row.createCell(75).setCellValue("皮疹-出现时间");
        row.createCell(76).setCellValue("皮疹-消失时间");
        row.createCell(77).setCellValue("皮疹-出院状态");
        row.createCell(78).setCellValue("关节痛-描述");
        row.createCell(79).setCellValue("关节痛-出现时间");
        row.createCell(80).setCellValue("关节痛-消失时间");
        row.createCell(81).setCellValue("关节痛-出院状态");
        row.createCell(82).setCellValue("皮肤瘙痒-描述");
        row.createCell(83).setCellValue("皮肤瘙痒-出现时间");
        row.createCell(84).setCellValue("皮肤瘙痒-消失时间");
        row.createCell(85).setCellValue("皮肤瘙痒-出院状态");
        row.createCell(86).setCellValue("症状体征-描述-出现时间-消失时间-出院时状态");
        row.createCell(87).setCellValue("首次-谷丙转氨酶（ALT）");
        row.createCell(88).setCellValue("首次-谷草转氨酶（AST）");
        row.createCell(89).setCellValue("首次-谷氨酰转肽酶（GGT）");
        row.createCell(90).setCellValue("首次-碱性磷酸酶（ALP或AKP）");
        row.createCell(91).setCellValue("首次-胆汁酸");
        row.createCell(92).setCellValue("首次-总胆红素（TBIL）");
        row.createCell(93).setCellValue("首次-直接胆红素（结合胆红素，DBIL）");
        row.createCell(94).setCellValue("首次-总蛋白（TP）");
        row.createCell(95).setCellValue("首次-白蛋白（ALB）");
        row.createCell(96).setCellValue("首次-血清肌酐（Scr）");
        row.createCell(97).setCellValue("首次-血清尿素氮（BUN）");
        row.createCell(98).setCellValue("首次-空腹血糖");
        row.createCell(99).setCellValue("首次-凝血酶原时间（PT）");
        row.createCell(100).setCellValue("首次-凝血酶原标准化比值（INR）");
        row.createCell(101).setCellValue("首次-甲胎蛋白（AFP）");
        row.createCell(102).setCellValue("所有-谷丙转氨酶（ALT）");
        row.createCell(103).setCellValue("所有-谷草转氨酶（AST）");
        row.createCell(104).setCellValue("所有-谷氨酰转肽酶（GGT）");
        row.createCell(105).setCellValue("所有-碱性磷酸酶（ALP或AKP）");
        row.createCell(106).setCellValue("所有-胆汁酸");
        row.createCell(107).setCellValue("所有-总胆红素（TBIL）");
        row.createCell(108).setCellValue("所有-直接胆红素（结合胆红素，DBIL）");
        row.createCell(109).setCellValue("所有-总蛋白（TP）");
        row.createCell(110).setCellValue("所有-白蛋白（ALB）");
        row.createCell(111).setCellValue("所有-血清肌酐（Scr）");
        row.createCell(112).setCellValue("所有-血清尿素氮（BUN）");
        row.createCell(113).setCellValue("所有-空腹血糖");
        row.createCell(114).setCellValue("所有-凝血酶原时间（PT）");
        row.createCell(115).setCellValue("所有-凝血酶原标准化比值（INR）");
        row.createCell(116).setCellValue("所有-甲胎蛋白（AFP）");
        row.createCell(117).setCellValue("甲肝抗体-Anti-HAV");
        row.createCell(118).setCellValue("乙肝病毒DNA-HBV-DNA");
        row.createCell(119).setCellValue("丙肝抗体-Anti-HCV");
        row.createCell(120).setCellValue("丙肝病毒RNA-HCV-RNA");
        row.createCell(121).setCellValue("单核细胞增多症-单核细胞增多症的检测");
        row.createCell(122).setCellValue("类风湿因子-类风湿因子");
        row.createCell(123).setCellValue("铜蓝蛋白-铜蓝蛋白");
        row.createCell(124).setCellValue("HBsAg");
        row.createCell(125).setCellValue("HBsAb");
        row.createCell(126).setCellValue("HBcAb");
        row.createCell(127).setCellValue("HBeAg");
        row.createCell(128).setCellValue("HBeAb");
        row.createCell(129).setCellValue("抗核抗体(ANA)");
        row.createCell(130).setCellValue("抗线粒体抗体(AMA)");
        row.createCell(131).setCellValue("抗线粒体抗体M2型(AMA-M2)");
        row.createCell(132).setCellValue("抗平滑肌抗体(SMA)");
        row.createCell(133).setCellValue("肝肾线粒体抗体(LKM)");
        row.createCell(134).setCellValue("巨细胞病毒");
        row.createCell(135).setCellValue("EB病毒");
        row.createCell(136).setCellValue("单纯疱疹病毒");
        row.createCell(137).setCellValue("白细胞总数（WBC）");
        row.createCell(138).setCellValue("血红蛋白（Hb）");
        row.createCell(139).setCellValue("总血红蛋白浓度");
        row.createCell(140).setCellValue("血小板（PLT）");
        row.createCell(141).setCellValue("中性粒细胞计数（N）");
        row.createCell(142).setCellValue("嗜酸性粒细胞计数（E）");
        row.createCell(143).setCellValue("肝脏B超");
        row.createCell(144).setCellValue("肝脏B超-排除胆道疾病");
        row.createCell(145).setCellValue("肝脏B超-排除食管胃底静脉曲张");
        row.createCell(146).setCellValue("肝脏CT");
        row.createCell(147).setCellValue("肝脏CT-排除胆道疾病");
        row.createCell(148).setCellValue("肝脏CT-排除食管胃底静脉曲张");
        row.createCell(149).setCellValue("肝脏MRI");
        row.createCell(150).setCellValue("肝脏MRI-排除胆道疾病");
        row.createCell(151).setCellValue("肝脏MRI-排除食管胃底静脉曲张");
        row.createCell(152).setCellValue("Fibroscan");
        row.createCell(153).setCellValue("Fibroscan-排除胆道疾病");
        row.createCell(154).setCellValue("Fibroscan-排除食管胃底静脉曲张");
        row.createCell(155).setCellValue("ERCP");
        row.createCell(156).setCellValue("ERCP-排除胆道疾病");
        row.createCell(157).setCellValue("ERCP-排除食管胃底静脉曲张");
        row.createCell(158).setCellValue("MRCP");
        row.createCell(159).setCellValue("MRCP-排除胆道疾病");
        row.createCell(160).setCellValue("MRCP-排除食管胃底静脉曲张");
        row.createCell(161).setCellValue("胃镜");
        row.createCell(162).setCellValue("胃镜-排除胆道疾病");
        row.createCell(163).setCellValue("胃镜-排除食管胃底静脉曲张");
        row.createCell(164).setCellValue("肝脏组织学检查");
        row.createCell(165).setCellValue("腹水");
        row.createCell(166).setCellValue("肝性脑病");
        row.createCell(167).setCellValue("延长INR（>1.5）或者凝血时间（>3秒正常时间以上）");
        row.createCell(168).setCellValue("药物引发的除肝脏以外的其他器官的衰竭：肺、肾、心脏、骨髓等");
        row.createCell(169).setCellValue("由于肝损伤的原因，患者住院时间是否延长");
        row.createCell(170).setCellValue("Hepatox网站上的RUCAM评分");
        row.createCell(171).setCellValue("是否有治疗措施");
        row.createCell(172).setCellValue("通用名-商品名-用药方法-日剂量-开始日期-结束日期");
        row.createCell(173).setCellValue("治疗措施-治疗措施详述-开始日期-结束日期");
        row.createCell(174).setCellValue("疾病转归");
        row.createCell(175).setCellValue("留置生物样本");

        if(mlPatientDOs.isEmpty()){
            return;
        }
        for (int i = 0; i < mlPatientDOs.size(); i++) {

            mlAllergyDO = mlAllergyHistoryRepo.getAllergyHistoryByPatientId(mlPatientDOs.get(i).getId());
            mlBiologicalDO = mlBiologicalSamplesRepo.getMlBiologicalByPatientId(mlPatientDOs.get(i).getId());
            mlDiseaseDO = mlDiseaseHistoryRepo.getMlDiseaseHistoryByPatientId(mlPatientDOs.get(i).getId());
            mlOutcomeDO = mlDiseaseOutcomeRepo.getMlDiseaseOutcome(mlPatientDOs.get(i).getId());
            mlDrinkDO = mlDrinkRepo.getMlDrinkByPatientId(mlPatientDOs.get(i).getId());
            mlExcludeDO = mlExcludeOtherRepo.getByPatientId((long) mlPatientDOs.get(i).getId());
            mlFirstDO = mlFirstAbnormalExaminationRepo.getMsgByPID((long) mlPatientDOs.get(i).getId());
            mlHospitalDO = mlFirstAbnormalExaminationRepo.getHosData(mlPatientDOs.get(i).getId());
            mlImagingDO = mlImagingEndoScopyRepo.getByPid((long) mlPatientDOs.get(i).getId());
            mlHistologicalDO = mlLiverHistologicalRepo.getMlLiverHistologicalByPatientId(mlPatientDOs.get(i).getId());
            mlInjuryDO = mlLiverInjuryRepo.getMlLiverInjuryByPatientId(mlPatientDOs.get(i).getId());
            mlBloodDO = mlRoutineBooldRepo.getRoutineByPid((long) mlPatientDOs.get(i).getId());
            mlDrugDO = mlDrugHistoryRepo.getMlDrugByPatientId(mlPatientDOs.get(i).getId());
            mlSymptomsDO = mlSymptomsRepo.getMlSysptomsByPatientId(mlPatientDOs.get(i).getId());
            mlTreatmentDO = mlTreatmentRepo.getTreatByPatientId(mlPatientDOs.get(i).getId());

            row = sheet.createRow(i + 1);

            //患者资料
            row.createCell(0).setCellValue(mlPatientDOs.get(i).getName());
            row.createCell(1).setCellValue(mlPatientDOs.get(i).getAbbreviation());
            row.createCell(2).setCellValue(mlPatientDOs.get(i).getBirthday());
            row.createCell(3).setCellValue(mlPatientDOs.get(i).getNation());
            row.createCell(4).setCellValue(mlPatientDOs.get(i).getHeight());
            row.createCell(5).setCellValue(mlPatientDOs.get(i).getWeight());
            row.createCell(6).setCellValue(mlPatientDOs.get(i).getGender());
            row.createCell(7).setCellValue(mlPatientDOs.get(i).getCareer());
            row.createCell(8).setCellValue(mlPatientDOs.get(i).getHospital());
            row.createCell(9).setCellValue(mlPatientDOs.get(i).getDepartment());
            row.createCell(10).setCellValue(mlPatientDOs.get(i).getAdmissionDate());
            row.createCell(11).setCellValue(mlPatientDOs.get(i).getHospitalizedAge());
            row.createCell(12).setCellValue(mlPatientDOs.get(i).getDischargeDate());
            row.createCell(13).setCellValue(mlPatientDOs.get(i).getHospitalizedNumber());
            row.createCell(14).setCellValue(mlPatientDOs.get(i).getHospitalizedDepartment());

            StringBuilder admissionDiagnosis = new StringBuilder();
            StringBuilder dischargeDiagnosis = new StringBuilder();
            if(!mlPatientDOs.get(i).getAdmissionDiagnosisDOS().isEmpty() && mlPatientDOs.get(i).getAdmissionDiagnosisDOS()!=null) {
                for (AdmissionDiagnosisDO admissionDiagnosisDO : mlPatientDOs.get(i).getAdmissionDiagnosisDOS()) {
                    admissionDiagnosis.append(admissionDiagnosisDO.getDiagnosis() + "-" + admissionDiagnosisDO.getDiagnosisDate() + ";");
                }
            }
            if(!mlPatientDOs.get(i).getDischargeDiagnosisDOS().isEmpty() && mlPatientDOs.get(i).getDischargeDiagnosisDOS()!=null) {
                for (DischargeDiagnosisDO dischargeDiagnosisDO : mlPatientDOs.get(i).getDischargeDiagnosisDOS()) {
                    dischargeDiagnosis.append(dischargeDiagnosisDO.getDiagnosis() + "-" + dischargeDiagnosisDO.getDiagnosisDate() + ";");
                }
            }
            row.createCell(15).setCellValue(admissionDiagnosis.toString());
            row.createCell(16).setCellValue(dischargeDiagnosis.toString());

            //既往疾病史
            if(mlDiseaseDO != null){
                row.createCell(17).setCellValue(mlDiseaseDO.getOtherHistory() == 1?"否":(mlDiseaseDO.getOtherHistory() == 2?"是":""));
                row.createCell(18).setCellValue(mlDiseaseDO.getPastDisease() == 1?"否":(mlDiseaseDO.getPastDisease() == 2?"是":(mlDiseaseDO.getPastDisease() == 3?"不详 ":"")));
//                StringBuilder mlDiseaseHistoryDetail = new StringBuilder();
//                if(!mlDiseaseDO.getMedicineLiverDiseaseHistoryDetailDOS().isEmpty() && mlDiseaseDO.getMedicineLiverDiseaseHistoryDetailDOS()!=null) {
//                    for (MedicineLiverDiseaseHistoryDetailDO medicineLiverDiseaseHistoryDetailDO : mlDiseaseDO.getMedicineLiverDiseaseHistoryDetailDOS()) {
//                        mlDiseaseHistoryDetail.append(medicineLiverDiseaseHistoryDetailDO.getDiseaseName() + "-" + medicineLiverDiseaseHistoryDetailDO.getDiagnosisDate() + "-" + medicineLiverDiseaseHistoryDetailDO.getCrueDate() + "-" + medicineLiverDiseaseHistoryDetailDO.getExistence() + ";");
//                    }
//                }
//                row.createCell(19).setCellValue(mlDiseaseHistoryDetail.toString());
            }

            //既往过敏史
            if(mlAllergyDO != null){
                row.createCell(20).setCellValue(mlAllergyDO.getAllergyHistory()==1?"无":(mlAllergyDO.getAllergyHistory()==2?"有":(mlAllergyDO.getAllergyHistory()==3?"不详":"")));
                row.createCell(21).setCellValue(mlAllergyDO.getAllergen());
            }

            //饮酒状况
            if(mlDrinkDO != null){
                row.createCell(22).setCellValue(mlDrinkDO.getDrinkHistory()==1?"长期饮酒":(mlDrinkDO.getDrinkHistory()==2?"偶尔饮酒":(mlDrinkDO.getDrinkHistory()==3?"不饮酒":(mlDrinkDO.getDrinkHistory()==4?"不详":""))));
                StringBuilder mlDrinkDetail = new StringBuilder();
                if(!mlDrinkDO.getMedicineLiverDrinkDetailDOS().isEmpty() && mlDrinkDO.getMedicineLiverDrinkDetailDOS()!=null) {
                    for (MedicineLiverDrinkDetailDO medicineLiverDrinkDetailDO : mlDrinkDO.getMedicineLiverDrinkDetailDOS()) {
                        mlDrinkDetail.append(medicineLiverDrinkDetailDO.getDrinkType() + "-" + medicineLiverDrinkDetailDO.getDrinkQuantity() + "-" + medicineLiverDrinkDetailDO.getDrinkLife() + "-" + medicineLiverDrinkDetailDO.getProof() + ";");
                    }
                }
                row.createCell(23).setCellValue(mlDrinkDetail.toString());
            }

            //可疑药物用药史
            if(mlDrugDO != null){
                StringBuilder drug = new StringBuilder();
                if(!mlDrugDO.getMedicineLiverSuspectedDrugDetailDOS().isEmpty() && mlDrugDO.getMedicineLiverSuspectedDrugDetailDOS()!=null) {
                    for (MedicineLiverSuspectedDrugDetailDO medicineLiverSuspectedDrugDetailDO : mlDrugDO.getMedicineLiverSuspectedDrugDetailDOS()) {
                        drug.append(medicineLiverSuspectedDrugDetailDO.getGenericName() + "-" + medicineLiverSuspectedDrugDetailDO.getTradeName() + "-" + medicineLiverSuspectedDrugDetailDO.getTreatComplaint() + "-" + medicineLiverSuspectedDrugDetailDO.getMedicationMethod() + "-" + medicineLiverSuspectedDrugDetailDO.getDose() + "-" + medicineLiverSuspectedDrugDetailDO.getBeginDate() + "-" + medicineLiverSuspectedDrugDetailDO.getDrugWithDrawal() + "-" + medicineLiverSuspectedDrugDetailDO.getDrugWithDrawalDate() + medicineLiverSuspectedDrugDetailDO.getDecrement() + "-" + medicineLiverSuspectedDrugDetailDO.getDrugExposure() + "-" + medicineLiverSuspectedDrugDetailDO.getExposureLiverDamage() + ";");
                    }
                }
                row.createCell(24).setCellValue(drug.toString());
            }

            //症状体征
            if(mlSymptomsDO != null){

                row.createCell(25).setCellValue(mlSymptomsDO.getLiverInjury()==1?"否":(mlSymptomsDO.getLiverInjury()==2?"有":(mlSymptomsDO.getLiverInjury()==3?"不详":"")));
                //乏力
                row.createCell(26).setCellValue(mlSymptomsDO.getWeak()==1?"轻度":(mlSymptomsDO.getWeak()==2?"中度":(mlSymptomsDO.getWeak()==3?"重度":(mlSymptomsDO.getWeak()==4?"不详":""))));
                row.createCell(27).setCellValue(mlSymptomsDO.getWeakBeginDate());
                row.createCell(28).setCellValue(mlSymptomsDO.getWeakDisappearDate());
                row.createCell(29).setCellValue(mlSymptomsDO.getWeakDischarge()==1?"轻度":(mlSymptomsDO.getWeakDischarge()==2?"中度":(mlSymptomsDO.getWeakDischarge()==3?"重度":(mlSymptomsDO.getWeakDischarge()==4?"不详":""))));

                //纳差
                row.createCell(30).setCellValue(mlSymptomsDO.getAnorexia()==1?"轻度":(mlSymptomsDO.getAnorexia()==2?"中度":(mlSymptomsDO.getAnorexia()==3?"重度":(mlSymptomsDO.getAnorexia()==4?"不详":""))));
                row.createCell(31).setCellValue(mlSymptomsDO.getAnorexiaBeginDate());
                row.createCell(32).setCellValue(mlSymptomsDO.getAnorexiaDisappearDate());
                row.createCell(33).setCellValue(mlSymptomsDO.getAnorexiaDischarge()==1?"轻度":(mlSymptomsDO.getAnorexiaDischarge()==2?"中度":(mlSymptomsDO.getAnorexiaDischarge()==3?"重度":(mlSymptomsDO.getAnorexiaDischarge()==4?"不详":""))));

                //腹胀
                row.createCell(34).setCellValue(mlSymptomsDO.getAbdominalDistention()==1?"轻度":(mlSymptomsDO.getAbdominalDistention()==2?"中度":(mlSymptomsDO.getAbdominalDistention()==3?"重度":(mlSymptomsDO.getAbdominalDistention()==4?"不详":""))));
                row.createCell(35).setCellValue(mlSymptomsDO.getAbdominalDistentionBeginDate());
                row.createCell(36).setCellValue(mlSymptomsDO.getAbdominalDistentionDisappearDate());
                row.createCell(37).setCellValue(mlSymptomsDO.getAbdominalDistentionDischarge()==1?"轻度":(mlSymptomsDO.getAbdominalDistentionDischarge()==2?"中度":(mlSymptomsDO.getAbdominalDistentionDischarge()==3?"重度":(mlSymptomsDO.getAbdominalDistentionDischarge()==4?"不详":""))));

                //黄疸
                row.createCell(38).setCellValue(mlSymptomsDO.getJaundice()==1?"轻度":(mlSymptomsDO.getJaundice()==2?"中度":(mlSymptomsDO.getJaundice()==3?"重度":(mlSymptomsDO.getJaundice()==4?"不详":""))));
                row.createCell(39).setCellValue(mlSymptomsDO.getJaundiceBeginDate());
                row.createCell(40).setCellValue(mlSymptomsDO.getJaundiceDisappearDate());
                row.createCell(41).setCellValue(mlSymptomsDO.getJaundiceDischarge()==1?"轻度":(mlSymptomsDO.getAbdominalDistentionDischarge()==2?"中度":(mlSymptomsDO.getAbdominalDistentionDischarge()==3?"重度":(mlSymptomsDO.getAbdominalDistentionDischarge()==4?"不详":""))));

                //恶心
                row.createCell(42).setCellValue(mlSymptomsDO.getNausea()==1?"轻度":(mlSymptomsDO.getNausea()==2?"中度":(mlSymptomsDO.getNausea()==3?"重度":(mlSymptomsDO.getNausea()==4?"不详":""))));
                row.createCell(43).setCellValue(mlSymptomsDO.getNauseaBeginDate());
                row.createCell(44).setCellValue(mlSymptomsDO.getNauseaDisappearDate());
                row.createCell(45).setCellValue(mlSymptomsDO.getNauseaDischarge()==1?"轻度":(mlSymptomsDO.getNauseaDischarge()==2?"中度":(mlSymptomsDO.getNauseaDischarge()==3?"重度":(mlSymptomsDO.getNauseaDischarge()==4?"不详":""))));

                //呕吐
                row.createCell(46).setCellValue(mlSymptomsDO.getVomit()==1?"轻度":(mlSymptomsDO.getVomit()==2?"中度":(mlSymptomsDO.getVomit()==3?"重度":(mlSymptomsDO.getVomit()==4?"不详":""))));
                row.createCell(47).setCellValue(mlSymptomsDO.getVomitBeginDate());
                row.createCell(48).setCellValue(mlSymptomsDO.getVomitDisappearDate());
                row.createCell(49).setCellValue(mlSymptomsDO.getVomitDischarge()==1?"轻度":(mlSymptomsDO.getVomitDischarge()==2?"中度":(mlSymptomsDO.getVomitDischarge()==3?"重度":(mlSymptomsDO.getVomitDischarge()==4?"不详":""))));

                //齿龈出血
                row.createCell(50).setCellValue(mlSymptomsDO.getGingivalBleeding()==1?"轻度":(mlSymptomsDO.getGingivalBleeding()==2?"中度":(mlSymptomsDO.getGingivalBleeding()==3?"重度":(mlSymptomsDO.getGingivalBleeding()==4?"不详":""))));
                row.createCell(51).setCellValue(mlSymptomsDO.getGingivalBleedingBeginDate());
                row.createCell(52).setCellValue(mlSymptomsDO.getGingivalBleedingDisappearDate());
                row.createCell(53).setCellValue(mlSymptomsDO.getGingivalBleedingDischarge()==1?"轻度":(mlSymptomsDO.getGingivalBleedingDischarge()==2?"中度":(mlSymptomsDO.getGingivalBleedingDischarge()==3?"重度":(mlSymptomsDO.getGingivalBleedingDischarge()==4?"不详":""))));

                //鼻衄
                row.createCell(54).setCellValue(mlSymptomsDO.getEpistaxis()==1?"轻度":(mlSymptomsDO.getEpistaxis()==2?"中度":(mlSymptomsDO.getEpistaxis()==3?"重度":(mlSymptomsDO.getEpistaxis()==4?"不详":""))));
                row.createCell(55).setCellValue(mlSymptomsDO.getEpistaxisBeginDate());
                row.createCell(56).setCellValue(mlSymptomsDO.getEpistaxisDisappearDate());
                row.createCell(57).setCellValue(mlSymptomsDO.getEpistaxisDischarge()==1?"轻度":(mlSymptomsDO.getEpistaxisDischarge()==2?"中度":(mlSymptomsDO.getEpistaxisDischarge()==3?"重度":(mlSymptomsDO.getEpistaxisDischarge()==4?"不详":""))));

                //肝区疼痛
                row.createCell(58).setCellValue(mlSymptomsDO.getLiverPain()==1?"轻度":(mlSymptomsDO.getLiverPain()==2?"中度":(mlSymptomsDO.getLiverPain()==3?"重度":(mlSymptomsDO.getLiverPain()==4?"不详":""))));
                row.createCell(59).setCellValue(mlSymptomsDO.getLiverPainBeginDate());
                row.createCell(60).setCellValue(mlSymptomsDO.getLiverPainDisappearDate());
                row.createCell(61).setCellValue(mlSymptomsDO.getLiverPainDischarge()==1?"轻度":(mlSymptomsDO.getLiverPainDischarge()==2?"中度":(mlSymptomsDO.getLiverPainDischarge()==3?"重度":(mlSymptomsDO.getLiverPainDischarge()==4?"不详":""))));

                //肝肿大
                row.createCell(62).setCellValue(mlSymptomsDO.getHepatomegaly()==1?"轻度":(mlSymptomsDO.getHepatomegaly()==2?"中度":(mlSymptomsDO.getHepatomegaly()==3?"重度":(mlSymptomsDO.getHepatomegaly()==4?"不详":""))));
                row.createCell(63).setCellValue(mlSymptomsDO.getHepatomegalyBeginDate());
                row.createCell(64).setCellValue(mlSymptomsDO.getHepatomegalyDisappearDate());
                row.createCell(65).setCellValue(mlSymptomsDO.getHepatomegalyDischarge()==1?"轻度":(mlSymptomsDO.getHepatomegalyDischarge()==2?"中度":(mlSymptomsDO.getHepatomegalyDischarge()==3?"重度":(mlSymptomsDO.getHepatomegalyDischarge()==4?"不详":""))));

                //脾肿大
                row.createCell(66).setCellValue(mlSymptomsDO.getSplenomegaly()==1?"轻度":(mlSymptomsDO.getSplenomegaly()==2?"中度":(mlSymptomsDO.getSplenomegaly()==3?"重度":(mlSymptomsDO.getSplenomegaly()==4?"不详":""))));
                row.createCell(67).setCellValue(mlSymptomsDO.getSplenomegalyBeginDate());
                row.createCell(68).setCellValue(mlSymptomsDO.getSplenomegalyDisappearDate());
                row.createCell(69).setCellValue(mlSymptomsDO.getSplenomegalyDischarge()==1?"轻度":(mlSymptomsDO.getSplenomegalyDischarge()==2?"中度":(mlSymptomsDO.getSplenomegalyDischarge()==3?"重度":(mlSymptomsDO.getSplenomegalyDischarge()==4?"不详":""))));

                //发热
                row.createCell(70).setCellValue(mlSymptomsDO.getFever()==1?"轻度":(mlSymptomsDO.getFever()==2?"中度":(mlSymptomsDO.getFever()==3?"重度":(mlSymptomsDO.getFever()==4?"不详":""))));
                row.createCell(71).setCellValue(mlSymptomsDO.getFeverBeginDate());
                row.createCell(72).setCellValue(mlSymptomsDO.getFeverDisappearDate());
                row.createCell(73).setCellValue(mlSymptomsDO.getFeverDischarge()==1?"轻度":(mlSymptomsDO.getFeverDischarge()==2?"中度":(mlSymptomsDO.getFeverDischarge()==3?"重度":(mlSymptomsDO.getFeverDischarge()==4?"不详":""))));

                //皮疹
                row.createCell(74).setCellValue(mlSymptomsDO.getRash()==1?"轻度":(mlSymptomsDO.getRash()==2?"中度":(mlSymptomsDO.getRash()==3?"重度":(mlSymptomsDO.getRash()==4?"不详":""))));
                row.createCell(75).setCellValue(mlSymptomsDO.getRashBeginDate());
                row.createCell(76).setCellValue(mlSymptomsDO.getRashDisappearDate());
                row.createCell(77).setCellValue(mlSymptomsDO.getRashDischarge()==1?"轻度":(mlSymptomsDO.getRashDischarge()==2?"中度":(mlSymptomsDO.getRashDischarge()==3?"重度":(mlSymptomsDO.getRashDischarge()==4?"不详":""))));

                //关节痛
                row.createCell(78).setCellValue(mlSymptomsDO.getArthralgia()==1?"轻度":(mlSymptomsDO.getArthralgia()==2?"中度":(mlSymptomsDO.getArthralgia()==3?"重度":(mlSymptomsDO.getArthralgia()==4?"不详":""))));
                row.createCell(79).setCellValue(mlSymptomsDO.getArthralgiaBeginDate());
                row.createCell(80).setCellValue(mlSymptomsDO.getArthralgiaDisappearDate());
                row.createCell(81).setCellValue(mlSymptomsDO.getArthralgiaDischarge()==1?"轻度":(mlSymptomsDO.getArthralgiaDischarge()==2?"中度":(mlSymptomsDO.getArthralgiaDischarge()==3?"重度":(mlSymptomsDO.getArthralgiaDischarge()==4?"不详":""))));

                //皮肤瘙痒
                row.createCell(82).setCellValue(mlSymptomsDO.getSkinItch()==1?"轻度":(mlSymptomsDO.getSkinItch()==2?"中度":(mlSymptomsDO.getSkinItch()==3?"重度":(mlSymptomsDO.getSkinItch()==4?"不详":""))));
                row.createCell(83).setCellValue(mlSymptomsDO.getSkinItchBeginDate());
                row.createCell(84).setCellValue(mlSymptomsDO.getSkinItchDisappearDate());
                row.createCell(85).setCellValue(mlSymptomsDO.getSkinItchDischarge()==1?"轻度":(mlSymptomsDO.getSkinItchDischarge()==2?"中度":(mlSymptomsDO.getSkinItchDischarge()==3?"重度":(mlSymptomsDO.getSkinItchDischarge()==4?"不详":""))));

                StringBuilder mlSymptomsOther = new StringBuilder();
                if(!mlSymptomsDO.getMedicineLiverSymptomsOtherDOs().isEmpty() && mlSymptomsDO.getMedicineLiverSymptomsOtherDOs() != null) {
                    for (MedicineLiverSymptomsOtherDO medicineLiverSymptomsOtherDO : mlSymptomsDO.getMedicineLiverSymptomsOtherDOs()) {
                        mlSymptomsOther.append(medicineLiverSymptomsOtherDO.getName() + "-" + medicineLiverSymptomsOtherDO.getDescription() + "-" + medicineLiverSymptomsOtherDO.getBeginDate() + "-" + medicineLiverSymptomsOtherDO.getDisappearDate() + "-" + medicineLiverSymptomsOtherDO.getDischargeSymptoms() + ";");
                    }
                }
                row.createCell(86).setCellValue(mlSymptomsOther.toString());
            }

            if(mlFirstDO != null){

                row.createCell(87).setCellValue(mlFirstDO.getAlt());
                row.createCell(88).setCellValue(mlFirstDO.getAst());
                row.createCell(89).setCellValue(mlFirstDO.getGgt());
                row.createCell(90).setCellValue(mlFirstDO.getAlp());
                row.createCell(91).setCellValue(mlFirstDO.getBileAcid());
                row.createCell(92).setCellValue(mlFirstDO.getTbil());
                row.createCell(93).setCellValue(mlFirstDO.getDbil());
                row.createCell(94).setCellValue(mlFirstDO.getTp());
                row.createCell(95).setCellValue(mlFirstDO.getAlb());
                row.createCell(96).setCellValue(mlFirstDO.getScr());
                row.createCell(97).setCellValue(mlFirstDO.getBun());
                row.createCell(98).setCellValue(mlFirstDO.getPlasmaGlucose());
                row.createCell(99).setCellValue(mlFirstDO.getPt());
                row.createCell(100).setCellValue(mlFirstDO.getInr());
                row.createCell(101).setCellValue(mlFirstDO.getAfp());
            }

            if(mlHospitalDO != null){
                row.createCell(102).setCellValue(mlHospitalDO.getAlt());
                row.createCell(103).setCellValue(mlHospitalDO.getAst());
                row.createCell(104).setCellValue(mlHospitalDO.getGgt());
                row.createCell(105).setCellValue(mlHospitalDO.getAlp());
                row.createCell(106).setCellValue(mlHospitalDO.getBileAcid());
                row.createCell(107).setCellValue(mlHospitalDO.getTbil());
                row.createCell(108).setCellValue(mlHospitalDO.getDbil());
                row.createCell(109).setCellValue(mlHospitalDO.getTp());
                row.createCell(110).setCellValue(mlHospitalDO.getAlb());
                row.createCell(111).setCellValue(mlHospitalDO.getScr());
                row.createCell(112).setCellValue(mlHospitalDO.getBun());
                row.createCell(113).setCellValue(mlHospitalDO.getPlasmaGlucose());
                row.createCell(114).setCellValue(mlHospitalDO.getPt());
                row.createCell(115).setCellValue(mlHospitalDO.getInr());
                row.createCell(116).setCellValue(mlHospitalDO.getAfp());
            }

            if(mlExcludeDO != null){
                row.createCell(117).setCellValue(mlExcludeDO.getAntiHav());
                row.createCell(118).setCellValue(mlExcludeDO.getHbvdna());
                row.createCell(119).setCellValue(mlExcludeDO.getAntihcv());
                row.createCell(120).setCellValue(mlExcludeDO.getHcvrna());
                row.createCell(121).setCellValue(mlExcludeDO.getMononucleosis());
                row.createCell(122).setCellValue(mlExcludeDO.getRheumatoid());
                row.createCell(123).setCellValue(mlExcludeDO.getCeruloplasmin());
                row.createCell(124).setCellValue(mlExcludeDO.getHbsag());
                row.createCell(125).setCellValue(mlExcludeDO.getHbsab());
                row.createCell(126).setCellValue(mlExcludeDO.getHbcab());
                row.createCell(127).setCellValue(mlExcludeDO.getHbeag());
                row.createCell(128).setCellValue(mlExcludeDO.getHbeab());
                row.createCell(129).setCellValue(mlExcludeDO.getAna());
                row.createCell(130).setCellValue(mlExcludeDO.getAma());
                row.createCell(131).setCellValue(mlExcludeDO.getAmam2());
                row.createCell(132).setCellValue(mlExcludeDO.getSma());
                row.createCell(133).setCellValue(mlExcludeDO.getLkm());
                row.createCell(134).setCellValue(mlExcludeDO.getCytomegalovirus());
                row.createCell(135).setCellValue(mlExcludeDO.getEbviruses());
                row.createCell(136).setCellValue(mlExcludeDO.getHerpesSimplex());
            }

            if(mlBloodDO != null){
                row.createCell(137).setCellValue(mlBloodDO.getWbc());
                row.createCell(138).setCellValue(mlBloodDO.getHb());
                row.createCell(139).setCellValue(mlBloodDO.getTotalHemoglobin());
                row.createCell(140).setCellValue(mlBloodDO.getPlt());
                row.createCell(141).setCellValue(mlBloodDO.getNeutrophil());
                row.createCell(142).setCellValue(mlBloodDO.getEosinophil());
            }

            if(mlImagingDO != null){
                row.createCell(143).setCellValue(mlImagingDO.getLiverBultrasound());
                row.createCell(144).setCellValue(mlImagingDO.getLiverBultrasoundBiliaryTract());
                row.createCell(145).setCellValue(mlImagingDO.getLiverBultrasoundEsophagealGastricVarices());
                row.createCell(146).setCellValue(mlImagingDO.getLiverCt());
                row.createCell(147).setCellValue(mlImagingDO.getLiverCtBiliaryTract());
                row.createCell(148).setCellValue(mlImagingDO.getLiverCtEsophagealGastricVarices());
                row.createCell(149).setCellValue(mlImagingDO.getLiverMri());
                row.createCell(150).setCellValue(mlImagingDO.getLiverMriBiliaryTract());
                row.createCell(151).setCellValue(mlImagingDO.getLiverMriEsophagealGastricVarices());
                row.createCell(152).setCellValue(mlImagingDO.getFibroscan());
                row.createCell(153).setCellValue(mlImagingDO.getFibroscanBiliaryTract());
                row.createCell(154).setCellValue(mlImagingDO.getFibroscanEsophagealGastricVarices());
                row.createCell(155).setCellValue(mlImagingDO.getErcp());
                row.createCell(156).setCellValue(mlImagingDO.getErcpBiliaryTract());
                row.createCell(157).setCellValue(mlImagingDO.getErcpEsophagealGastricVarices());
                row.createCell(158).setCellValue(mlImagingDO.getMrcp());
                row.createCell(159).setCellValue(mlImagingDO.getMrcpBiliaryTract());
                row.createCell(160).setCellValue(mlImagingDO.getMrcpEsophagealGastricVarices());
                row.createCell(161).setCellValue(mlImagingDO.getGastroscope());
                row.createCell(162).setCellValue(mlImagingDO.getGastroscopeBiliaryTract());
                row.createCell(163).setCellValue(mlImagingDO.getGastroscopeEsophagealGastricVarices());
            }

            if(mlHistologicalDO != null){
                row.createCell(164).setCellValue(mlHistologicalDO.getLiverHistologicalResult());
            }

            if(mlInjuryDO != null){
                row.createCell(165).setCellValue(mlInjuryDO.getAscites()==1?"是":(mlInjuryDO.getAscites()==2?"否":(mlInjuryDO.getAscites()==3?"未知":"")));
                row.createCell(166).setCellValue(mlInjuryDO.getHepaticEncephalopathy()==1?"是":(mlInjuryDO.getHepaticEncephalopathy()==2?"否":(mlInjuryDO.getHepaticEncephalopathy()==3?"未知":"")));
                row.createCell(167).setCellValue(mlInjuryDO.getExtendInr()==1?"是":(mlInjuryDO.getExtendInr()==2?"否":(mlInjuryDO.getExtendInr()==3?"未知":"")));
                row.createCell(168).setCellValue(mlInjuryDO.getFailure()==1?"是":(mlInjuryDO.getFailure()==2?"否":(mlInjuryDO.getFailure()==3?"未知":"")));
                row.createCell(169).setCellValue(mlInjuryDO.getExtendHospitalStay()==1?"是":(mlInjuryDO.getExtendHospitalStay()==2?"否":(mlInjuryDO.getExtendHospitalStay()==3?"未知":"")));
                row.createCell(170).setCellValue(mlInjuryDO.getRucam());
            }

            if(mlTreatmentDO != null){
                row.createCell(171).setCellValue(mlTreatmentDO.getTreatment()==1?"是":(mlTreatmentDO.getTreatment()==2?"否":(mlTreatmentDO.getTreatment()==3?"不详":"")));

                StringBuilder treatmentDetail = new StringBuilder();
                StringBuilder treatmentOther = new StringBuilder();
                if(!mlTreatmentDO.getMedicineLiverTreatmentDetailDOS().isEmpty() && mlTreatmentDO.getMedicineLiverTreatmentDetailDOS()!=null){
                    for(MedicineLiverTreatmentDetailDO medicineLiverTreatmentDetailDO : mlTreatmentDO.getMedicineLiverTreatmentDetailDOS()){
                        treatmentDetail.append(medicineLiverTreatmentDetailDO.getGenericName()+"-"+medicineLiverTreatmentDetailDO.getTradeName()+"-"+medicineLiverTreatmentDetailDO.getDetailMethod()+"-"+medicineLiverTreatmentDetailDO.getDose()+"-"+medicineLiverTreatmentDetailDO.getDetailStartDate()+"-"+medicineLiverTreatmentDetailDO.getDetailEndDate()+";");
                    }
                }
                if(!mlTreatmentDO.getMedicineLiverTreatmentOtherDOS().isEmpty() && mlTreatmentDO.getMedicineLiverTreatmentOtherDOS()!=null){
                    for(MedicineLiverTreatmentOtherDO medicineLiverTreatmentOtherDO : mlTreatmentDO.getMedicineLiverTreatmentOtherDOS()){
                        treatmentOther.append(medicineLiverTreatmentOtherDO.getMethod()+"-"+medicineLiverTreatmentOtherDO.getMethodDetail()+"-"+medicineLiverTreatmentOtherDO.getOtherStartDate()+"-"+medicineLiverTreatmentOtherDO.getOtherEndDate()+";");
                    }
                }
                row.createCell(172).setCellValue(treatmentDetail.toString());
                row.createCell(173).setCellValue(treatmentOther.toString());

            }

            if(mlOutcomeDO != null){
                row.createCell(174).setCellValue(mlOutcomeDO.getOutcome());
            }

            if(mlBiologicalDO != null){
                row.createCell(175).setCellValue(mlBiologicalDO.getBiologicalSamples());
            }

        }

        if (!new File(excelPath).exists()) {
            new File(excelPath).mkdir();
        }
        FileOutputStream fileOut = new FileOutputStream(excelPath + new UserMsgTool().getCurrentUser().getRealName() + "medicineLiver.xlsx");
        wb.write(fileOut);
        fileOut.close();

    }
}
