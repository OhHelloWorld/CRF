package app.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import app.entities.BoneDensityDO;
import app.entities.ChineseMedicinePrescriptionDO;
import app.entities.ComplexAIHAfterTreatmentDO;
import app.entities.ComplexAIHBeforeTreatmentDO;
import app.entities.FinalDiagnosisSpecialCircumstancesDO;
import app.entities.FourDiagnosticInformationDO;
import app.entities.HaiDO;
import app.entities.IshakDO;
import app.entities.LiverPathologyDO;
import app.entities.PatientDO;
import app.entities.PhysicalChemicalInspectionDO;
import app.entities.SimpleAIHDO;
import app.entities.TonguePulseDO;
import app.entities.TreatmentProgramsDO;
import app.repo.BoneDensityRepo;
import app.repo.ComplexAIHAfterTreatmentRepo;
import app.repo.ComplexAIHBeforeTreatmentRepo;
import app.repo.FinalDiaSpeCirRepo;
import app.repo.FourDiagnosticInformationRepo;
import app.repo.HaiRepo;
import app.repo.IshakRepo;
import app.repo.LiverPathologyRepo;
import app.repo.MedicinePrescriptionRepo;
import app.repo.PatientRepo;
import app.repo.PhysicalChemicalInspectionRepo;
import app.repo.SimpleAIHRepo;
import app.repo.TonguePulseRepo;
import app.repo.TreatmentRepo;

@Component
public class CreateAllExcel{

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private TonguePulseRepo tongueRepo;

    @Autowired
    private FourDiagnosticInformationRepo fourDiagnosticInformationRepo;

    @Autowired
    private PhysicalChemicalInspectionRepo physicalChemicalRepo;

    @Autowired
    private LiverPathologyRepo liverPathologyRepo;

    @Autowired
    private IshakRepo ishakRepo;

    @Autowired
    private HaiRepo haiRepo;

    @Autowired
    private BoneDensityRepo boneDensityRepo;

    @Autowired
    private SimpleAIHRepo simpleAIHRepo;

    @Autowired
    private ComplexAIHBeforeTreatmentRepo complexAIHBeforeTreatmentRepo;

    @Autowired
    private ComplexAIHAfterTreatmentRepo complexAIHAfterTreatmentRepo;

    @Autowired
    private TreatmentRepo treatmentRepo;

    @Autowired
    private MedicinePrescriptionRepo medicinePrescriptionRepo;

    @Autowired
    private FinalDiaSpeCirRepo finalDiaSpeCirRepo;

    @Value("${excel_path}")
    private String excelPath;

    public void createAllExcel() throws Exception {
        List<PatientDO> patientDOs = (List<PatientDO>) patientRepo.findAll();
        FourDiagnosticInformationDO fourDiaDO;
        TonguePulseDO tonguePulseDO;
        PhysicalChemicalInspectionDO pInspectionDO;
        LiverPathologyDO liverPathologyDO;
        IshakDO ishakDO;
        HaiDO haiDO;
        BoneDensityDO boneDensityDO;
        SimpleAIHDO simpleAIHDO;
        ComplexAIHBeforeTreatmentDO complexAIHBeforeTreatmentDO;
        ComplexAIHAfterTreatmentDO complexAIHAfterTreatmentDO;
        TreatmentProgramsDO treatmentProgramsDO;
        ChineseMedicinePrescriptionDO cMedicinePrescriptionDO;
        FinalDiagnosisSpecialCircumstancesDO fCircumstancesDO;

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("病例");
        Row row = null;

        row = sheet.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("性别");
        row.createCell(2).setCellValue("出生日期");
        row.createCell(3).setCellValue("民族");
        row.createCell(4).setCellValue("体重（kg）");
        row.createCell(5).setCellValue("身高（cm）");
        row.createCell(6).setCellValue("BMI");
        row.createCell(7).setCellValue("文化程度");
        row.createCell(8).setCellValue("首次出现肝损伤时间");
        row.createCell(9).setCellValue("调查医院");
        row.createCell(10).setCellValue("联系电话");
        row.createCell(11).setCellValue("就诊时病程");
        row.createCell(12).setCellValue("初次诊断年龄");
        row.createCell(13).setCellValue("初次诊断年月");
        row.createCell(14).setCellValue("吸烟");
        row.createCell(15).setCellValue("饮酒");
        row.createCell(16).setCellValue("家族史");
        row.createCell(17).setCellValue("相关备注");
        row.createCell(18).setCellValue("并发自身免疫性疾病");
        row.createCell(19).setCellValue("并发自身免疫性疾病时间");
        row.createCell(20).setCellValue("首发");
        row.createCell(21).setCellValue("乏力");
        row.createCell(22).setCellValue("皮肤瘙痒");
        row.createCell(23).setCellValue("两目干涩");
        row.createCell(24).setCellValue("视物模糊");
        row.createCell(25).setCellValue("抑郁");
        row.createCell(26).setCellValue("烦躁易怒");
        row.createCell(27).setCellValue("失眠");
        row.createCell(28).setCellValue("耳鸣");
        row.createCell(29).setCellValue("口干");
        row.createCell(30).setCellValue("口苦");
        row.createCell(31).setCellValue("口臭");
        row.createCell(32).setCellValue("恶心");
        row.createCell(33).setCellValue("嗳气");
        row.createCell(34).setCellValue("脘腹胀满");
        row.createCell(35).setCellValue("胁肋痛-刺痛");
        row.createCell(36).setCellValue("胁肋痛-胀痛");
        row.createCell(37).setCellValue("胁肋痛-隐痛");
        row.createCell(38).setCellValue("胁肋痛-不适");
        row.createCell(39).setCellValue("纳差");
        row.createCell(40).setCellValue("畏寒肢冷");
        row.createCell(41).setCellValue("肢体困重");
        row.createCell(42).setCellValue("腰痠脚软");
        row.createCell(43).setCellValue("手足烦热");
        row.createCell(44).setCellValue("尿黄");
        row.createCell(45).setCellValue("便秘");
        row.createCell(46).setCellValue("便溏");
        row.createCell(47).setCellValue("自汗");
        row.createCell(48).setCellValue("盗汗");
        row.createCell(49).setCellValue("下肢水肿");
        row.createCell(50).setCellValue("面晦暗");
        row.createCell(51).setCellValue("目黄");
        row.createCell(52).setCellValue("身黄");
        row.createCell(53).setCellValue("蜘蛛痣数量");
        row.createCell(54).setCellValue("肝掌");
        row.createCell(55).setCellValue("腹壁脉络曲张");
        row.createCell(56).setCellValue("黄色瘤");
        row.createCell(57).setCellValue("舌质及部位");
        row.createCell(58).setCellValue("舌体");
        row.createCell(59).setCellValue("苔质及部位");
        row.createCell(60).setCellValue("舌苔色及部位");
        row.createCell(61).setCellValue("舌下静脉曲张");
        row.createCell(62).setCellValue("左脉象");
        row.createCell(63).setCellValue("右脉象");
        row.createCell(64).setCellValue("总胆汁酸(μmol/l)");
        row.createCell(65).setCellValue("铜蓝蛋白(mg/dl)");
        row.createCell(66).setCellValue("肝功能-白蛋白(g/L)");
        row.createCell(67).setCellValue("肝功能-球蛋白(g/L)");
        row.createCell(68).setCellValue("肝功能-ALT(IU/L)");
        row.createCell(69).setCellValue("肝功能-AST(IU/L)");
        row.createCell(70).setCellValue("肝功能-GGT(IU/L)");
        row.createCell(71).setCellValue("肝功能--ALP(IU/L)");
        row.createCell(72).setCellValue("肝功能-总胆固醇(mmol/l)");
        row.createCell(73).setCellValue("肝功能-总胆红素(μmol/L)");
        row.createCell(74).setCellValue("肝功能-直接胆红素(μmol/L)");
        row.createCell(75).setCellValue("肝功能-γ球蛋白(%)");
        row.createCell(76).setCellValue("肾功能-BUN(mmol/L)");
        row.createCell(77).setCellValue("肾功能-Cr(μmol/L)");
        row.createCell(78).setCellValue("凝血-PT(秒)");
        row.createCell(79).setCellValue("凝血-INR");
        row.createCell(80).setCellValue("血常规-RBC(×10 12L)");
        row.createCell(81).setCellValue("血常规-HB(g/L)");
        row.createCell(82).setCellValue("血常规-WBC(×10 9L)");
        row.createCell(83).setCellValue("血常规-中性粒细胞(×10 9L)");
        row.createCell(84).setCellValue("血常规-淋巴细胞(×10 9L)");
        row.createCell(85).setCellValue("血常规-嗜酸性粒细胞(×10 9L)");
        row.createCell(86).setCellValue("血常规-血小板(×10 9L)");
        row.createCell(87).setCellValue("肝病自身抗体-AMA");
        row.createCell(88).setCellValue("肝病自身抗体-AMA-M2");
        row.createCell(89).setCellValue("肝病自身抗体-抗平滑肌抗体");
        row.createCell(90).setCellValue("肝病自身抗体-肝肾微粒体抗体");
        row.createCell(91).setCellValue("肝病自身抗体-肝细胞溶质抗原");
        row.createCell(92).setCellValue("肝病自身抗体-可溶性肝-胰抗原");
        row.createCell(93).setCellValue("肝病自身抗体-其他");
        row.createCell(94).setCellValue("ANA-均质型");
        row.createCell(95).setCellValue("ANA-颗粒型");
        row.createCell(96).setCellValue("ANA-周边型");
        row.createCell(97).setCellValue("ANA-核仁型");
        row.createCell(98).setCellValue("ANA-核仁增强型");
        row.createCell(99).setCellValue("ANA-核点型");
        row.createCell(100).setCellValue("ANA-着丝点型");
        row.createCell(101).setCellValue("ANA-其他");
        row.createCell(102).setCellValue("体液免疫-IgG(g/L)");
        row.createCell(103).setCellValue("体液免疫-IgA(g/L)");
        row.createCell(104).setCellValue("体液免疫-IgM(g/L)");
        row.createCell(105).setCellValue("体液免疫-免疫复合物");
        row.createCell(106).setCellValue("体液免疫-补体C3");
        row.createCell(107).setCellValue("体液免疫-补体C4(g/L)");
        row.createCell(108).setCellValue("体液免疫-IgE(IU/ml)");
        row.createCell(109).setCellValue("体液免疫-k-轻链(mg/dl)");
        row.createCell(110).setCellValue("体液免疫-λ-轻链(mg/dl)");
        row.createCell(111).setCellValue("细胞免疫-CD3(%)");
        row.createCell(112).setCellValue("细胞免疫-CD4(%)");
        row.createCell(113).setCellValue("细胞免疫-CD8(%)");
        row.createCell(114).setCellValue("细胞免疫-CD56+16(NK)(%)");
        row.createCell(115).setCellValue("细胞免疫-CD2(%)");
        row.createCell(116).setCellValue("细胞免疫-CD4/CD8");
        row.createCell(117).setCellValue("风湿免疫相关抗体");
        row.createCell(118).setCellValue("腹部超声CT/MRI");
        row.createCell(119).setCellValue("肝脏硬度检查值-Fibroscan值");
        row.createCell(120).setCellValue("肝脏硬度检查值-Fibrotest值");
        row.createCell(121).setCellValue("肝穿刺病理检查");
        row.createCell(122).setCellValue("肿瘤标记物-afp(ng/ml)");
        row.createCell(123).setCellValue("肿瘤标记物-癌胚抗原CEA(ng/ml)");
        row.createCell(124).setCellValue("肿瘤标记物-ca199(U/ml)");
        row.createCell(125).setCellValue("肿瘤标记物-ca125(U/ml)");
        row.createCell(126).setCellValue("乙肝-hbsag(IU/ml)");
        row.createCell(127).setCellValue("乙肝-hbsab(mlU/ml)");
        row.createCell(128).setCellValue("乙肝-hbeag(S/CO)");
        row.createCell(129).setCellValue("乙肝-hbeab(S/CO)");
        row.createCell(130).setCellValue("乙肝-hbcab(S/CO)");
        row.createCell(131).setCellValue("乙肝-HBV-RNA(copies/ml)");
        row.createCell(132).setCellValue("丙肝-抗HCV抗体(S/CO)");
        row.createCell(133).setCellValue("丙肝-HCV-RNA");
        row.createCell(134).setCellValue("尿液分析-红细胞(p/ul)");
        row.createCell(135).setCellValue("尿液分析-白细胞(p/ul)");
        row.createCell(136).setCellValue("尿液分析-胆红素");
        row.createCell(137).setCellValue("尿液分析-蛋白质");
        row.createCell(138).setCellValue("GS-小叶内炎症");
        row.createCell(139).setCellValue("GS-界面型肝炎");
        row.createCell(140).setCellValue("GS-汇管区炎症");
        row.createCell(141).setCellValue("GS-淋巴细胞浆细胞浸润");
        row.createCell(142).setCellValue("GS-纤维组织增生");
        row.createCell(143).setCellValue("GS-胆管炎症/损伤");
        row.createCell(144).setCellValue("GS-肝细胞脂肪变性");
        row.createCell(145).setCellValue("GS-玫瑰花结样改变");
        row.createCell(146).setCellValue("GS-HBsAg染色");
        row.createCell(147).setCellValue("GS-HBcAg染色");
        row.createCell(148).setCellValue("GS-HCV染色");
        row.createCell(149).setCellValue("GS-其他");
        row.createCell(150).setCellValue("GS-诊断(分期分级)");
        row.createCell(151).setCellValue("GS-备注");
        row.createCell(152).setCellValue("Ishak-门脉区炎症");
        row.createCell(152).setCellValue("Ishak-小叶内活动度");
        row.createCell(153).setCellValue("Ishak-界面炎");
        row.createCell(154).setCellValue("Ishak-融合性坏死");
        row.createCell(155).setCellValue("Ishak-纤维化评分");
        row.createCell(156).setCellValue("HAI-门脉区炎症");
        row.createCell(157).setCellValue("HAI-小叶内活动度");
        row.createCell(158).setCellValue("HAI-界面炎");
        row.createCell(159).setCellValue("腰椎1-4 骨密度");
        row.createCell(160).setCellValue("腰椎1-4 T值");
        row.createCell(161).setCellValue("股骨颈 骨密度");
        row.createCell(162).setCellValue("股骨颈 T值");
        row.createCell(163).setCellValue("大粗隆 骨密度");
        row.createCell(164).setCellValue("大粗隆 T值");
        row.createCell(165).setCellValue("全髋 骨密度");
        row.createCell(166).setCellValue("全髋 T值");
        row.createCell(167).setCellValue("诊断");
        row.createCell(168).setCellValue("备注(何时何部位)");
        row.createCell(169).setCellValue("ANA或SMA");
        row.createCell(170).setCellValue("ANA/SMA");
        row.createCell(171).setCellValue("Anti-LKM-l");
        row.createCell(172).setCellValue("Anti-SLA");
        row.createCell(173).setCellValue("IgG");
        row.createCell(174).setCellValue("肝组织学");
        row.createCell(175).setCellValue("排除病毒性肝炎");
        row.createCell(176).setCellValue("评分");
        row.createCell(177).setCellValue("治疗前-性别");
        row.createCell(178).setCellValue("治疗前-药物史");
        row.createCell(179).setCellValue("治疗前-ALP(正常上限的倍数):AST(或ALT)(正常上限的倍数)");
        row.createCell(180).setCellValue("治疗前-平均酒精摄入量");
        row.createCell(181).setCellValue("治疗前-血清球蛋白或IgG与正常值的比值");
        row.createCell(182).setCellValue("治疗前-肝脏组织学检查");
        row.createCell(183).setCellValue("治疗前-其他免疫疾病");
        row.createCell(184).setCellValue("治疗前-ANA,SMA或LKM-l");
        row.createCell(185).setCellValue("治疗前-AMA阳性");
        row.createCell(186).setCellValue("治疗前-肝炎病毒标志物");
        row.createCell(187).setCellValue("治疗前-其他可用的参数");
        row.createCell(188).setCellValue("治疗后-性别");
        row.createCell(189).setCellValue("治疗后-药物史");
        row.createCell(190).setCellValue("治疗后-ALP(正常上限的倍数):AST(或ALT)(正常上限的倍数)");
        row.createCell(191).setCellValue("治疗后-平均酒精摄入量");
        row.createCell(192).setCellValue("治疗后-血清球蛋白或IgG与正常值的比值");
        row.createCell(193).setCellValue("治疗后-肝脏组织学检查");
        row.createCell(194).setCellValue("治疗后-其他免疫疾病");
        row.createCell(195).setCellValue("治疗后-ANA,SMA或LKM-l");
        row.createCell(196).setCellValue("治疗后-AMA阳性");
        row.createCell(197).setCellValue("治疗后-肝炎病毒标志物");
        row.createCell(198).setCellValue("治疗后-其他可用的参数");
        row.createCell(199).setCellValue("治疗后-对治疗的反应");
        row.createCell(200).setCellValue("强的松开始用药时间");
        row.createCell(201).setCellValue("强的松日剂量");
        row.createCell(202).setCellValue("强的松疗程");
        row.createCell(203).setCellValue("强的松龙开始用药时间");
        row.createCell(204).setCellValue("强的松龙日剂量");
        row.createCell(205).setCellValue("强的松龙疗程");
        row.createCell(206).setCellValue("甲基强的松龙开始用药时间");
        row.createCell(207).setCellValue("甲基强的松龙日剂量");
        row.createCell(208).setCellValue("甲基强的松龙疗程");
        row.createCell(209).setCellValue("布地奈德开始用药时间");
        row.createCell(210).setCellValue("布地奈德日剂量");
        row.createCell(211).setCellValue("布地奈德疗程");
        row.createCell(212).setCellValue("硫锉嘌呤开始用药时间");
        row.createCell(213).setCellValue("硫锉嘌呤日剂量");
        row.createCell(214).setCellValue("硫锉嘌呤疗程");
        row.createCell(215).setCellValue("免疫抑制剂-MTX开始用药时间");
        row.createCell(216).setCellValue("免疫抑制剂-MTX日剂量");
        row.createCell(217).setCellValue("免疫抑制剂-MTX疗程");
        row.createCell(218).setCellValue("免疫抑制剂-CysA开始用药时间");
        row.createCell(219).setCellValue("免疫抑制剂-CysA日剂量");
        row.createCell(220).setCellValue("免疫抑制剂-CysA疗程");
        row.createCell(221).setCellValue("免疫抑制剂-CTX开始用药时间");
        row.createCell(222).setCellValue("免疫抑制剂-CTX日剂量");
        row.createCell(223).setCellValue("免疫抑制剂-CTX疗程");
        row.createCell(224).setCellValue("吗替麦考酚酯开始用药时间");
        row.createCell(225).setCellValue("吗替麦考酚酯日剂量");
        row.createCell(226).setCellValue("吗替麦考酚酯疗程");
        row.createCell(227).setCellValue("秋水仙素开始用药时间");
        row.createCell(228).setCellValue("秋水仙素日剂量");
        row.createCell(229).setCellValue("秋水仙素疗程");
        row.createCell(230).setCellValue("熊去氧胆酸开始用药时间");
        row.createCell(231).setCellValue("熊去氧胆酸日剂量");
        row.createCell(232).setCellValue("熊去氧胆酸疗程");
        row.createCell(233).setCellValue("非诺贝特开始用药时间");
        row.createCell(234).setCellValue("非诺贝特日剂量");
        row.createCell(235).setCellValue("非诺贝特疗程");
        row.createCell(236).setCellValue("苯扎贝特开始用药时间");
        row.createCell(237).setCellValue("苯扎贝特日剂量");
        row.createCell(238).setCellValue("苯扎贝特疗程");
        row.createCell(239).setCellValue("肝移植时间");
        row.createCell(240).setCellValue("肝移植结果与原因");
        row.createCell(241).setCellValue("中药方剂开始服药时间");
        row.createCell(242).setCellValue("中药方剂描述");
        row.createCell(243).setCellValue("中药方剂疗程");
        row.createCell(244).setCellValue("中成药1开始服药时间");
        row.createCell(245).setCellValue("中成药1描述");
        row.createCell(246).setCellValue("中成药1疗程");
        row.createCell(247).setCellValue("中成药2开始服药时间");
        row.createCell(248).setCellValue("中成药2描述");
        row.createCell(249).setCellValue("中成药2疗程");
        row.createCell(250).setCellValue("PBC临床分期");
        row.createCell(251).setCellValue("AIH临床分期");
        row.createCell(252).setCellValue("特殊情况");


        for (int i = 0; i < patientDOs.size(); i++) {
            fourDiaDO = fourDiagnosticInformationRepo.getDefaultFourDia(patientDOs.get(i).getId());
            tonguePulseDO = tongueRepo.getDefaultTongue(patientDOs.get(i).getId());
            pInspectionDO = physicalChemicalRepo.getDefaultPhy(patientDOs.get(i).getId());
            liverPathologyDO =
                    liverPathologyRepo.getDefaultLiverpathology(patientDOs.get(i).getId());
            ishakDO = ishakRepo.getDefaultIshak(patientDOs.get(i).getId());
            haiDO = haiRepo.getDefaultHai(patientDOs.get(i).getId());
            boneDensityDO = boneDensityRepo.getDefaultBone(patientDOs.get(i).getId());
            simpleAIHDO = simpleAIHRepo.getDefaultSimpleAIH(patientDOs.get(i).getId());
            complexAIHBeforeTreatmentDO = complexAIHBeforeTreatmentRepo
                    .getDefaultComplexAIHBeforeTreatment(patientDOs.get(i).getId());
            complexAIHAfterTreatmentDO = complexAIHAfterTreatmentRepo
                    .getDefaultComplexAIHAfterTreatment(patientDOs.get(i).getId());
            treatmentProgramsDO = treatmentRepo.getDefaultTreat(patientDOs.get(i).getId());
            cMedicinePrescriptionDO =
                    medicinePrescriptionRepo.getDefaultMedicine(patientDOs.get(i).getId());
            fCircumstancesDO = finalDiaSpeCirRepo.getDefaultFinalDia(patientDOs.get(i).getId());

            row = sheet.createRow(i + 1);

            // 患者基本信息
            row.createCell(0).setCellValue(patientDOs.get(i).getName());
            row.createCell(1).setCellValue(patientDOs.get(i).getGender());
            row.createCell(2).setCellValue(patientDOs.get(i).getBirthday().toString());
            row.createCell(3).setCellValue(patientDOs.get(i).getNation());
            row.createCell(4).setCellValue(patientDOs.get(i).getWeight());
            row.createCell(5).setCellValue(patientDOs.get(i).getHeight());
            row.createCell(6).setCellValue(patientDOs.get(i).getBmi());
            row.createCell(7).setCellValue(patientDOs.get(i).getDegreeOfEducation());
            row.createCell(8).setCellValue(patientDOs.get(i).getFirstTimeLiverInjury().toString());
            row.createCell(9).setCellValue(patientDOs.get(i).getInvestigateHospital());
            row.createCell(10).setCellValue(patientDOs.get(i).getTelephone());
            row.createCell(11).setCellValue(patientDOs.get(i).getDurationOfVisit());
            row.createCell(12).setCellValue(patientDOs.get(i).getFirstVisitAge());
            row.createCell(13).setCellValue(patientDOs.get(i).getFirstVisitTime().toString());
            if (patientDOs.get(i).isSmoke()) {
                row.createCell(14).setCellValue("是");
            } else {
                row.createCell(14).setCellValue("否");
            }
            if (patientDOs.get(i).isDrink()) {
                row.createCell(15).setCellValue("是");
            } else {
                row.createCell(15).setCellValue("否");
            }
            row.createCell(16).setCellValue(patientDOs.get(i).getFamilyHistory());
            row.createCell(17).setCellValue(patientDOs.get(i).getSmokeDrinkFamHis());
            if (patientDOs.get(i).getConcurrentAutoDisease()) {
                row.createCell(18).setCellValue("是");
            } else {
                row.createCell(18).setCellValue("否");
            }
            if (patientDOs.get(i).getConcurrentAutoDate() != null) {
                row.createCell(19)
                        .setCellValue(patientDOs.get(i).getConcurrentAutoDate().toString());
            } else {
                row.createCell(19).setCellValue("");
            }
            if (patientDOs.get(i).isConAutoDisFirstOrNot()) {
                row.createCell(20).setCellValue("是");
            } else {
                row.createCell(20).setCellValue("否");
            }

            // 四诊信息
            if (fourDiaDO != null) {

                switch (fourDiaDO.getFatigue()) {
                    case 0:
                        row.createCell(21).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(21).setCellValue("肢体乏力，勉强坚持日常生活");
                        break;
                    case 2:
                        row.createCell(21).setCellValue("肢体稍倦，可坚持轻体力工作");
                        break;
                    case 3:
                        row.createCell(21).setCellValue("全身无力，终日不愿活动");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getSkinItching()) {
                    case 0:
                        row.createCell(22).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(22).setCellValue("偶有，不影响日常生活");
                        break;
                    case 2:
                        row.createCell(22).setCellValue("时常有，轻度影响日常生活");
                        break;
                    case 3:
                        row.createCell(22).setCellValue("整日瘙痒，影响日常生活");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getTwoEyesDry()) {
                    case 0:
                        row.createCell(23).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(23).setCellValue("自觉有时目干");
                        break;
                    case 2:
                        row.createCell(23).setCellValue("经常两目干涩");
                        break;
                    case 3:
                        row.createCell(23).setCellValue("整日两目干涩");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getBlurredVision()) {
                    case 0:
                        row.createCell(24).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(24).setCellValue("久视后视物不清");
                        break;
                    case 2:
                        row.createCell(24).setCellValue("视物不清");
                        break;
                    case 3:
                        row.createCell(24).setCellValue("视物困难");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getDepression()) {
                    case 0:
                        row.createCell(25).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(25).setCellValue("有时情绪低落");
                        break;
                    case 2:
                        row.createCell(25).setCellValue("经常情绪低落");
                        break;
                    case 3:
                        row.createCell(25).setCellValue("有厌世倾向");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getIrritability()) {
                    case 0:
                        row.createCell(26).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(26).setCellValue("偶见烦躁");
                        break;
                    case 2:
                        row.createCell(26).setCellValue("经常烦躁不安");
                        break;
                    case 3:
                        row.createCell(26).setCellValue("一触即怒");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getInsomnia()) {
                    case 0:
                        row.createCell(27).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(27).setCellValue("睡眠不足6小时");
                        break;
                    case 2:
                        row.createCell(27).setCellValue("睡眠不足4小时");
                        break;
                    case 3:
                        row.createCell(27).setCellValue("彻夜难眠");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getEasyWakeUp()) {
                    case 0:
                        row.createCell(28).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(28).setCellValue("每夜眠后醒1-2次");
                        break;
                    case 2:
                        row.createCell(28).setCellValue("每夜眠后醒3-4次");
                        break;
                    case 3:
                        row.createCell(28).setCellValue("每夜醒5次以上");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getTinnitus()) {
                    case 0:
                        row.createCell(29).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(29).setCellValue("偶见轻微耳鸣");
                        break;
                    case 2:
                        row.createCell(29).setCellValue("阵发耳鸣，休息后缓解");
                        break;
                    case 3:
                        row.createCell(29).setCellValue("耳鸣持续不解");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getDryMouth()) {
                    case 0:
                        row.createCell(30).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(30).setCellValue("偶有或晨起口干");
                        break;
                    case 2:
                        row.createCell(30).setCellValue("时感口干");
                        break;
                    case 3:
                        row.createCell(30).setCellValue("整日口干");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getMouthPain()) {
                    case 0:
                        row.createCell(31).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(31).setCellValue("偶有或晨起口苦");
                        break;
                    case 2:
                        row.createCell(31).setCellValue("时有口苦");
                        break;
                    case 3:
                        row.createCell(31).setCellValue("整日口苦");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getBadBreath()) {
                    case 0:
                        row.createCell(32).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(32).setCellValue("偶有或晨起口臭");
                        break;
                    case 2:
                        row.createCell(32).setCellValue("时有口臭");
                        break;
                    case 3:
                        row.createCell(32).setCellValue("整日口臭");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getNausea()) {
                    case 0:
                        row.createCell(33).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(33).setCellValue("偶有恶心");
                        break;
                    case 2:
                        row.createCell(33).setCellValue("每日恶心");
                        break;
                    case 3:
                        row.createCell(33).setCellValue("恶心频作");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getBelching()) {
                    case 0:
                        row.createCell(34).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(34).setCellValue("偶有嗳气");
                        break;
                    case 2:
                        row.createCell(34).setCellValue("食后嗳气频频");
                        break;
                    case 3:
                        row.createCell(34).setCellValue("整日嗳气");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getAbdominalDistention()) {
                    case 0:
                        row.createCell(35).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(35).setCellValue("进食后脘闷腹胀");
                        break;
                    case 2:
                        row.createCell(35).setCellValue("少量进食后即脘闷腹胀");
                        break;
                    case 3:
                        row.createCell(35).setCellValue("整日脘闷腹胀");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getFlankPainStinging()) {
                    case 0:
                        row.createCell(36).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(36).setCellValue("偶有");
                        break;
                    case 2:
                        row.createCell(36).setCellValue("常有");
                        break;
                    case 3:
                        row.createCell(36).setCellValue("持续");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getFlankPainSwell()) {
                    case 0:
                        row.createCell(37).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(37).setCellValue("偶有");
                        break;
                    case 2:
                        row.createCell(37).setCellValue("常有");
                        break;
                    case 3:
                        row.createCell(37).setCellValue("持续");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getFlankPainDull()) {
                    case 0:
                        row.createCell(38).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(38).setCellValue("偶有");
                        break;
                    case 2:
                        row.createCell(38).setCellValue("常有");
                        break;
                    case 3:
                        row.createCell(38).setCellValue("持续");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getFlankPainDiscomfort()) {
                    case 0:
                        row.createCell(39).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(39).setCellValue("偶有");
                        break;
                    case 2:
                        row.createCell(39).setCellValue("常有");
                        break;
                    case 3:
                        row.createCell(39).setCellValue("持续");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getAnorexia()) {
                    case 0:
                        row.createCell(40).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(40).setCellValue("胃纳轻度减少");
                        break;
                    case 2:
                        row.createCell(40).setCellValue("胃纳明显减少");
                        break;
                    case 3:
                        row.createCell(40).setCellValue("不欲食");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getAphrodisiacCold()) {
                    case 0:
                        row.createCell(41).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(41).setCellValue("手足不温");
                        break;
                    case 2:
                        row.createCell(41).setCellValue("加衣被方可缓解");
                        break;
                    case 3:
                        row.createCell(41).setCellValue("加衣被不缓解");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getLimb()) {
                    case 0:
                        row.createCell(42).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(42).setCellValue("下肢偶有沉重感");
                        break;
                    case 2:
                        row.createCell(42).setCellValue("肢体沉重");
                        break;
                    case 3:
                        row.createCell(42).setCellValue("肢体沉重，懒动");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getBackacheFootSoft()) {
                    case 0:
                        row.createCell(43).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(43).setCellValue("偶有腰痠脚软");
                        break;
                    case 2:
                        row.createCell(43).setCellValue("经常腰痠脚软");
                        break;
                    case 3:
                        row.createCell(43).setCellValue("整日腰痠脚软");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getHandFootFanHot()) {
                    case 0:
                        row.createCell(44).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(44).setCellValue("轻度手足烦热");
                        break;
                    case 2:
                        row.createCell(44).setCellValue("热甚，但能忍受");
                        break;
                    case 3:
                        row.createCell(44).setCellValue("热甚，情绪烦躁");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getUrineYellow()) {
                    case 0:
                        row.createCell(45).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(45).setCellValue("色黄");
                        break;
                    case 2:
                        row.createCell(45).setCellValue("色深黄");
                        break;
                    case 3:
                        row.createCell(45).setCellValue("色黄赤");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getConstipation()) {
                    case 0:
                        row.createCell(46).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(46).setCellValue("2日1行便之不爽");
                        break;
                    case 2:
                        row.createCell(46).setCellValue("3日一行");
                        break;
                    case 3:
                        row.createCell(46).setCellValue(">3日一行");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getLooseStools()) {
                    case 0:
                        row.createCell(47).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(47).setCellValue("大便不成形");
                        break;
                    case 2:
                        row.createCell(47).setCellValue("稀便，每日2-3次");
                        break;
                    case 3:
                        row.createCell(47).setCellValue("稀便，4次以上");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getPerspiration()) {
                    case 0:
                        row.createCell(48).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(48).setCellValue("偶有汗出");
                        break;
                    case 2:
                        row.createCell(48).setCellValue("经常汗出");
                        break;
                    case 3:
                        row.createCell(48).setCellValue("动辄汗出");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getLowerExtremityEdema()) {
                    case 0:
                        row.createCell(49).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(49).setCellValue("踝关节以下");
                        break;
                    case 2:
                        row.createCell(49).setCellValue("膝关节以下");
                        break;
                    case 3:
                        row.createCell(49).setCellValue("膝关节以上");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getFaceDull()) {
                    case 0:
                        row.createCell(50).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(50).setCellValue("色暗少光泽");
                        break;
                    case 2:
                        row.createCell(50).setCellValue("色晦暗");
                        break;
                    case 3:
                        row.createCell(50).setCellValue("色深褐无光");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getEyeYellow()) {
                    case 0:
                        row.createCell(51).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(51).setCellValue("色淡黄");
                        break;
                    case 2:
                        row.createCell(51).setCellValue("色黄");
                        break;
                    case 3:
                        row.createCell(51).setCellValue("色深黄");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getBodyYellow()) {
                    case 0:
                        row.createCell(52).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(52).setCellValue("色淡黄");
                        break;
                    case 2:
                        row.createCell(52).setCellValue("色黄");
                        break;
                    case 3:
                        row.createCell(52).setCellValue("色深黄");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getSpiderNevus()) {
                    case 0:
                        row.createCell(53).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(53).setCellValue("偶见蜘蛛痣");
                        break;
                    case 2:
                        row.createCell(53).setCellValue("有2~4个蜘蛛痣");
                        break;
                    case 3:
                        row.createCell(53).setCellValue("5个以上蜘蛛痣");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getLiverPalm()) {
                    case 0:
                        row.createCell(54).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(54).setCellValue("可疑肝掌");
                        break;
                    case 2:
                        row.createCell(54).setCellValue("肝掌");
                        break;
                    case 3:
                        row.createCell(54).setCellValue("明显肝掌");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getAbdominalVeins()) {
                    case 0:
                        row.createCell(55).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(55).setCellValue("隐约可见");
                        break;
                    case 2:
                        row.createCell(55).setCellValue("清晰可见");
                        break;
                    case 3:
                        row.createCell(55).setCellValue("满腹脉络曲张");
                        break;
                    default:
                        break;
                }

                switch (fourDiaDO.getYellowTumor()) {
                    case 0:
                        row.createCell(56).setCellValue("无");
                        break;
                    case 1:
                        row.createCell(56).setCellValue("隐约可见");
                        break;
                    case 2:
                        row.createCell(56).setCellValue("清晰可见");
                        break;
                    case 3:
                        row.createCell(56).setCellValue("明显突出皮肤");
                        break;
                    default:
                        break;
                }

            }

            // 舌脉象
            if (tonguePulseDO != null) {
                if (tonguePulseDO.getTonguePart().length() >= 2) {
                    row.createCell(57)
                            .setCellValue(tonguePulseDO.getTongue() + " 部位："
                                    + tonguePulseDO.getTonguePart().substring(1) + "-"
                                    + tonguePulseDO.getTonguePartialDescription());
                } else {
                    row.createCell(57).setCellValue(tonguePulseDO.getTongue());
                }
                if (tonguePulseDO.getTongueBody().length() >= 2) {
                    row.createCell(58).setCellValue(tonguePulseDO.getTongueBody().substring(1));
                } else {
                    row.createCell(58).setCellValue("");
                }
                if (tonguePulseDO.getMossyPart().length() >= 2
                        && tonguePulseDO.getMossy().length() >= 2) {
                    row.createCell(59)
                            .setCellValue(tonguePulseDO.getMossy().substring(1) + " 部位："
                                    + tonguePulseDO.getMossyPart().substring(1) + "-"
                                    + tonguePulseDO.getMossyPartialDescription());
                } else if (tonguePulseDO.getMossyPart().length() >= 2) {
                    row.createCell(59).setCellValue(tonguePulseDO.getMossy().substring(1));
                } else {
                    row.createCell(59).setCellValue("");
                }
                if (tonguePulseDO.getTongueColor().length() >= 2
                        && tonguePulseDO.getTongueColorPart().length() >= 2) {
                    row.createCell(60)
                            .setCellValue(tonguePulseDO.getTongueColor().substring(1) + " 部位："
                                    + tonguePulseDO.getTongueColorPart().substring(1) + "-"
                                    + tonguePulseDO.getTongueColorPartialDescription());
                } else if (tonguePulseDO.getTongueColorPart().length() >= 2) {
                    row.createCell(60).setCellValue(tonguePulseDO.getTongueColor().substring(1));
                } else {
                    row.createCell(60).setCellValue("");
                }
                if (tonguePulseDO.getSublingualVaricoseVeins().length() >= 2) {
                    row.createCell(61)
                            .setCellValue(tonguePulseDO.getSublingualVaricoseVeins().substring(1));
                } else {
                    row.createCell(61).setCellValue("");
                }
                if (tonguePulseDO.getLeftPulse().length() >= 2) {
                    row.createCell(62).setCellValue(tonguePulseDO.getLeftPulse().substring(1));
                } else {
                    row.createCell(62).setCellValue("");
                }
                if (tonguePulseDO.getRightPulse().length() >= 2) {
                    row.createCell(63).setCellValue(tonguePulseDO.getRightPulse().substring(1));
                } else {
                    row.createCell(63).setCellValue("");
                }
            }

            // 理化检查
            if (pInspectionDO != null) {
                row.createCell(64).setCellValue(pInspectionDO.getTotalBileAcid());
                row.createCell(65).setCellValue(pInspectionDO.getCopperProtein());
                row.createCell(66).setCellValue(pInspectionDO.getLiverFunctionAlbumin());
                row.createCell(67).setCellValue(pInspectionDO.getLiverFunctionGlobulin());
                row.createCell(68).setCellValue(pInspectionDO.getLiverFunctionALT());
                row.createCell(69).setCellValue(pInspectionDO.getLiverFunctionAST());
                row.createCell(70).setCellValue(pInspectionDO.getLiverFunctionGGT());
                row.createCell(71).setCellValue(pInspectionDO.getLiverFunctionALP());
                row.createCell(72).setCellValue(pInspectionDO.getLiverFunctionTotalCholesterol());
                row.createCell(73).setCellValue(pInspectionDO.getLiverFunctionTotalBilirubin());
                row.createCell(74).setCellValue(pInspectionDO.getLiverFunctionDirectBilirubin());
                row.createCell(75).setCellValue(pInspectionDO.getLiverFunctionRglobulin());
                row.createCell(76).setCellValue(pInspectionDO.getRenalFunctionBUN());
                row.createCell(77).setCellValue(pInspectionDO.getRenalFunctionCr());
                row.createCell(78).setCellValue(pInspectionDO.getClottingPT());
                row.createCell(79).setCellValue(pInspectionDO.getClottingINR());
                row.createCell(80).setCellValue(pInspectionDO.getBloodRoutineRBC());
                row.createCell(81).setCellValue(pInspectionDO.getBloodRoutineHb());
                row.createCell(82).setCellValue(pInspectionDO.getBloodRoutineWBC());
                row.createCell(83).setCellValue(pInspectionDO.getBloodRoutineNeutrophils());
                row.createCell(84).setCellValue(pInspectionDO.getBloodRoutineLymphocytes());
                row.createCell(85).setCellValue(pInspectionDO.getBloodRoutineEosinophils());
                row.createCell(86).setCellValue(pInspectionDO.getBloodRoutinePlatelets());
                row.createCell(87).setCellValue(pInspectionDO.getLiverDiseaseAutoantibodiesAMA());
                row.createCell(88).setCellValue(pInspectionDO.getLiverDiseaseAutoantibodiesAMAM2());
                row.createCell(89).setCellValue(
                        pInspectionDO.getLiverDiseaseAutoantibodiesAntiSmoothMuscleAntibody());
                row.createCell(90).setCellValue(pInspectionDO
                        .getLiverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies());
                row.createCell(91).setCellValue(
                        pInspectionDO.getLiverDiseaseAutoantibodiesHepatocyteSoluteAntigen());
                row.createCell(92).setCellValue(
                        pInspectionDO.getLiverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen());
                row.createCell(93).setCellValue(pInspectionDO.getLiverDiseaseAutoantibodiesOther());
                row.createCell(94).setCellValue(pInspectionDO.getANAHomogeneous());
                row.createCell(95).setCellValue(pInspectionDO.getANAParticle());
                row.createCell(96).setCellValue(pInspectionDO.getANAPeripheral());
                row.createCell(97).setCellValue(pInspectionDO.getANANucleolus());
                row.createCell(98).setCellValue(pInspectionDO.getANANucleolusEnhancement());
                row.createCell(99).setCellValue(pInspectionDO.getANANuclear());
                row.createCell(100).setCellValue(pInspectionDO.getANACentromere());
                row.createCell(101).setCellValue(pInspectionDO.getANAOther());
                row.createCell(102).setCellValue(pInspectionDO.getHumoralImmunityIgG());
                row.createCell(103).setCellValue(pInspectionDO.getHumoralImmunityIgA());
                row.createCell(104).setCellValue(pInspectionDO.getHumoralImmunityIgM());
                row.createCell(105).setCellValue(pInspectionDO.getHumoralImmunityImmuneComplexf());
                row.createCell(106).setCellValue(pInspectionDO.getHumoralImmunityComplementC3());
                row.createCell(107).setCellValue(pInspectionDO.getHumoralImmunityComplementC4());
                row.createCell(108).setCellValue(pInspectionDO.getHumoralImmunityIgE());
                row.createCell(109).setCellValue(pInspectionDO.getHumoralImmunityKlightChain());
                row.createCell(110).setCellValue(pInspectionDO.getHumoralImmunityNlightChain());
                row.createCell(111).setCellValue(pInspectionDO.getCellularImmunityCD3());
                row.createCell(112).setCellValue(pInspectionDO.getCellularImmunityCD4());
                row.createCell(113).setCellValue(pInspectionDO.getCellularImmunityCD8());
                row.createCell(114).setCellValue(pInspectionDO.getCellularImmunityCD56());
                row.createCell(115).setCellValue(pInspectionDO.getCellularImmunityCD2());
                row.createCell(116).setCellValue(pInspectionDO.getCellularImmunityCD4CD8());
                row.createCell(117)
                        .setCellValue(pInspectionDO.getRheumaticImmuneRelatedAntibodies());
                row.createCell(118).setCellValue(pInspectionDO.getCTMRI());
                row.createCell(119).setCellValue(pInspectionDO.getLiverHardnessFibroscan());
                row.createCell(120).setCellValue(pInspectionDO.getLiverHardnessFibrotest());
                row.createCell(121).setCellValue(pInspectionDO.getLiverPuncturePathology());
                row.createCell(122).setCellValue(pInspectionDO.getaFP());
                row.createCell(123).setCellValue(pInspectionDO.getCarcinoembryonicAntigenCEA());
                row.createCell(124).setCellValue(pInspectionDO.getCa199());
                row.createCell(125).setCellValue(pInspectionDO.getCa125());
                row.createCell(126).setCellValue(pInspectionDO.getHbsag());
                row.createCell(127).setCellValue(pInspectionDO.getHbsab());
                row.createCell(128).setCellValue(pInspectionDO.getHbeag());
                row.createCell(129).setCellValue(pInspectionDO.getHbeab());
                row.createCell(130).setCellValue(pInspectionDO.getHbcab());
                row.createCell(131).setCellValue(pInspectionDO.getHbvRna());
                row.createCell(132).setCellValue(pInspectionDO.getAntiHCVantibody());
                row.createCell(133).setCellValue(pInspectionDO.getHcvRna());
                row.createCell(134).setCellValue(pInspectionDO.getRedBloodCell());
                row.createCell(135).setCellValue(pInspectionDO.getWhiteBloodCell());
                row.createCell(136).setCellValue(pInspectionDO.getBilirubin());
                row.createCell(137).setCellValue(pInspectionDO.getProtein());
            }

            // GS肝脏理化检查
            if (liverPathologyDO != null) {
                if (liverPathologyDO.getInflammationLeaflets() != 0) {
                    row.createCell(138)
                            .setCellValue(liverPathologyDO.getInflammationLeaflets() - 1);
                } else {
                    row.createCell(138).setCellValue("");
                }
                if (liverPathologyDO.getInterfacialInflammation() != 0) {
                    row.createCell(139)
                            .setCellValue(liverPathologyDO.getInterfacialInflammation() - 1);
                } else {
                    row.createCell(139).setCellValue("");
                }
                if (liverPathologyDO.getPortalAreaInflammation() != 0) {
                    row.createCell(140)
                            .setCellValue(liverPathologyDO.getPortalAreaInflammation() - 1);
                } else {
                    row.createCell(140).setCellValue("");
                }
                if (liverPathologyDO.getLymphocytePlasmaCellInfiltration() != 0) {
                    row.createCell(141).setCellValue(
                            liverPathologyDO.getLymphocytePlasmaCellInfiltration() - 1);
                } else {
                    row.createCell(141).setCellValue("");
                }
                if (liverPathologyDO.getFibrousTissueHyperplasia() != 0) {
                    row.createCell(142)
                            .setCellValue(liverPathologyDO.getFibrousTissueHyperplasia() - 1);
                } else {
                    row.createCell(142).setCellValue("");
                }
                if (liverPathologyDO.getInflammationBileDuct() != 0) {
                    row.createCell(143)
                            .setCellValue(liverPathologyDO.getInflammationBileDuct() - 1);
                } else {
                    row.createCell(143).setCellValue("");
                }
                if (liverPathologyDO.getHepatocellularSteatosis() != 0) {
                    row.createCell(144)
                            .setCellValue(liverPathologyDO.getHepatocellularSteatosis() - 1);
                } else {
                    row.createCell(144).setCellValue("");
                }
                if (liverPathologyDO.getRoseSample() == 1) {
                    row.createCell(145).setCellValue("阴性");
                } else {
                    row.createCell(145).setCellValue("阳性");
                }
                if (liverPathologyDO.getHbsAg() == 1) {
                    row.createCell(146).setCellValue("阴性");
                } else {
                    row.createCell(146).setCellValue("阳性");
                }
                if (liverPathologyDO.getHbcAg() == 1) {
                    row.createCell(147).setCellValue("阴性");
                } else {
                    row.createCell(147).setCellValue("阳性");
                }
                if (liverPathologyDO.getHcv() == 1) {
                    row.createCell(148).setCellValue("阴性");
                } else {
                    row.createCell(148).setCellValue("阳性");
                }
                if (liverPathologyDO.getOther() == 1) {
                    row.createCell(149).setCellValue("阴性");
                } else {
                    row.createCell(149).setCellValue("阳性");
                }
                if (liverPathologyDO.getDiagnosis() == 1) {
                    row.createCell(150).setCellValue("阴性");
                } else {
                    row.createCell(150).setCellValue("阳性");
                }
                row.createCell(151).setCellValue(liverPathologyDO.getRemarks());
            }

            // ishak评分
            if (ishakDO != null) {
                if (ishakDO.getPortalAreaInflammation() != 0) {
                    row.createCell(152).setCellValue(ishakDO.getPortalAreaInflammation() - 1);
                } else {
                    row.createCell(152).setCellValue("");
                }
                if (ishakDO.getLobularMobility() != 0) {
                    row.createCell(153).setCellValue(ishakDO.getLobularMobility() - 1);
                } else {
                    row.createCell(154).setCellValue("");
                }
                if (ishakDO.getInterfaceInflammation() != 0) {
                    row.createCell(154).setCellValue(ishakDO.getInterfaceInflammation() - 1);
                } else {
                    row.createCell(154).setCellValue("");
                }
                if (ishakDO.getConfluentNecrosis() != 0) {
                    row.createCell(155).setCellValue(ishakDO.getConfluentNecrosis() - 1);
                } else {
                    row.createCell(155).setCellValue("");
                }
                if (ishakDO.getFibrosis() != 0) {
                    row.createCell(156).setCellValue(ishakDO.getFibrosis() - 1);
                } else {
                    row.createCell(156).setCellValue("");
                }
            }

            // hai评分
            if (haiDO != null) {
                if (haiDO.getPortalAreaInflammation() != 0) {
                    row.createCell(157).setCellValue(haiDO.getPortalAreaInflammation() - 1);
                } else {
                    row.createCell(157).setCellValue("");
                }
                if (haiDO.getLobularMobility() == 1 || haiDO.getLobularMobility() == 2) {
                    row.createCell(158).setCellValue(haiDO.getLobularMobility() - 1);
                } else if (haiDO.getLobularMobility() == 3 || haiDO.getLobularMobility() == 4) {
                    row.createCell(158).setCellValue(haiDO.getLobularMobility());
                } else {
                    row.createCell(158).setCellValue("");
                }
                if (haiDO.getInterfaceInflammation() == 1
                        || haiDO.getInterfaceInflammation() == 2) {
                    row.createCell(159).setCellValue(haiDO.getInterfaceInflammation() - 1);
                } else if (haiDO.getInterfaceInflammation() == 7) {
                    row.createCell(159).setCellValue(10);
                } else if (haiDO.getInterfaceInflammation() == 0) {
                    row.createCell(159).setCellValue("");
                } else {
                    row.createCell(159).setCellValue(haiDO.getInterfaceInflammation());
                }
            }

            // 骨密度
            if (boneDensityDO != null) {
                if (boneDensityDO.getLumbarSpine() != null) {
                    row.createCell(160).setCellValue(boneDensityDO.getLumbarSpine());
                } else {
                    row.createCell(160).setCellValue("");
                }
                switch (boneDensityDO.getLumbarSpineT()) {
                    case 1:
                        row.createCell(161).setCellValue("未检测");
                        break;
                    case 2:
                        row.createCell(161).setCellValue(">1");
                        break;
                    case 3:
                        row.createCell(161).setCellValue("-1~-2.5");
                        break;
                    case 4:
                        row.createCell(161).setCellValue("<-2.5");
                        break;
                    default:
                        break;
                }
                if (boneDensityDO.getFemoralNeck() != null) {
                    row.createCell(162).setCellValue(boneDensityDO.getFemoralNeck());
                } else {
                    row.createCell(162).setCellValue("");
                }
                switch (boneDensityDO.getFemoralNeckT()) {
                    case 1:
                        row.createCell(163).setCellValue("未检测");
                        break;
                    case 2:
                        row.createCell(163).setCellValue(">1");
                        break;
                    case 3:
                        row.createCell(163).setCellValue("-1~-2.5");
                        break;
                    case 4:
                        row.createCell(163).setCellValue("<-2.5");
                        break;
                    default:
                        break;
                }
                if (boneDensityDO.getBigTrochanter() != null) {
                    row.createCell(164).setCellValue(boneDensityDO.getBigTrochanter());
                } else {
                    row.createCell(164).setCellValue("");
                }
                switch (boneDensityDO.getBigTrochanterT()) {
                    case 1:
                        row.createCell(165).setCellValue("未检测");
                        break;
                    case 2:
                        row.createCell(165).setCellValue(">1");
                        break;
                    case 3:
                        row.createCell(165).setCellValue("-1~-2.5");
                        break;
                    case 4:
                        row.createCell(165).setCellValue("<-2.5");
                        break;
                    default:
                        break;
                }
                if (boneDensityDO.getFullHip() != null) {
                    row.createCell(166).setCellValue(boneDensityDO.getFullHip());
                } else {
                    row.createCell(166).setCellValue("");
                }
                switch (boneDensityDO.getFullHipT()) {
                    case 1:
                        row.createCell(167).setCellValue("未检测");
                        break;
                    case 2:
                        row.createCell(167).setCellValue(">1");
                        break;
                    case 3:
                        row.createCell(167).setCellValue("-1~-2.5");
                        break;
                    case 4:
                        row.createCell(167).setCellValue("<-2.5");
                        break;
                    default:
                        break;
                }
                switch (boneDensityDO.getDiagnosis()) {
                    case 1:
                        row.createCell(168).setCellValue("骨量正常");
                        break;
                    case 2:
                        row.createCell(168).setCellValue("骨量减少");
                        break;
                    case 3:
                        row.createCell(168).setCellValue("骨质疏松");
                        break;
                    case 4:
                        row.createCell(168).setCellValue("严重骨质疏松");
                        break;
                    default:
                        break;
                }
                if (boneDensityDO.getRemarks() != null) {
                    row.createCell(169).setCellValue(boneDensityDO.getRemarks());
                } else {
                    row.createCell(169).setCellValue("");
                }
            }

            // 简单AIH
            if (simpleAIHDO != null) {
                switch (simpleAIHDO.getAnasma1()) {
                    case 1:
                        row.createCell(170).setCellValue("阴性");
                        break;
                    case 2:
                        row.createCell(170).setCellValue("阳性");
                        break;
                    default:
                        break;
                }
                switch (simpleAIHDO.getAnasma2()) {
                    case 1:
                        row.createCell(171).setCellValue("<1:100");
                        break;
                    case 2:
                        row.createCell(171).setCellValue("=1:100");
                        break;
                    case 3:
                        row.createCell(171).setCellValue(">1:100");
                        break;
                    default:
                        break;
                }
                switch (simpleAIHDO.getAntiLkm()) {
                    case 1:
                        row.createCell(172).setCellValue("阴性");
                        break;
                    case 2:
                        row.createCell(172).setCellValue("阳性");
                        break;
                    default:
                        break;
                }
                switch (simpleAIHDO.getAntiSla()) {
                    case 1:
                        row.createCell(173).setCellValue("阴性");
                        break;
                    case 2:
                        row.createCell(173).setCellValue("阳性");
                        break;
                    default:
                        break;
                }
                switch (simpleAIHDO.getLiver()) {
                    case 1:
                        row.createCell(174).setCellValue("符合AIH");
                        break;
                    case 2:
                        row.createCell(174).setCellValue("典型AIH表现");
                        break;
                    default:
                        break;
                }
                switch (simpleAIHDO.getEliminateViralHepatitis()) {
                    case 1:
                        row.createCell(175).setCellValue("否");
                        break;
                    case 2:
                        row.createCell(175).setCellValue("是");
                        break;
                    default:
                        break;
                }
                row.createCell(176).setCellValue(simpleAIHDO.getResult());
            }

            // 治疗前复杂complexAIH
            if (complexAIHBeforeTreatmentDO != null) {
                switch (complexAIHBeforeTreatmentDO.getWoman()) {
                    case 1:
                        row.createCell(177).setCellValue("男");
                        break;
                    case 2:
                        row.createCell(177).setCellValue("女");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getHistoryDrugs()) {
                    case 1:
                        row.createCell(178).setCellValue("阳性");
                        break;
                    case 2:
                        row.createCell(178).setCellValue("阴性");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getaLPAST()) {
                    case 1:
                        row.createCell(179).setCellValue("<1.5");
                        break;
                    case 2:
                        row.createCell(179).setCellValue("1.5~3.0");
                        break;
                    case 3:
                        row.createCell(179).setCellValue(">3.0");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getAlcoholIntake()) {
                    case 1:
                        row.createCell(180).setCellValue("<25g/天");
                        break;
                    case 2:
                        row.createCell(180).setCellValue(">60g/天");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getSerumGlobulinNormal()) {
                    case 1:
                        row.createCell(181).setCellValue(">2.0");
                        break;
                    case 2:
                        row.createCell(181).setCellValue("1.5~2.0");
                        break;
                    case 3:
                        row.createCell(181).setCellValue("1.0~1.5");
                        break;
                    case 4:
                        row.createCell(181).setCellValue("<1.0");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getLiverCheck()) {
                    case 1:
                        row.createCell(182).setCellValue("界面型肝炎");
                        break;
                    case 2:
                        row.createCell(182).setCellValue("主要为淋巴浆细胞浸润");
                        break;
                    case 3:
                        row.createCell(182).setCellValue("肝细胞呈玫瑰花结样改变");
                        break;
                    case 4:
                        row.createCell(182).setCellValue("无上述表现");
                        break;
                    case 5:
                        row.createCell(182).setCellValue("胆管改变");
                        break;
                    case 6:
                        row.createCell(182).setCellValue("其它改变");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getAna()) {
                    case 1:
                        row.createCell(183).setCellValue(">1:80");
                        break;
                    case 2:
                        row.createCell(183).setCellValue("1:80");
                        break;
                    case 3:
                        row.createCell(183).setCellValue("1:40");
                        break;
                    case 4:
                        row.createCell(183).setCellValue("<1:40");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getOtherImmuneDiseases()) {
                    case 1:
                        row.createCell(184).setCellValue("存在");
                        break;
                    case 2:
                        row.createCell(184).setCellValue("不存在");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getAmaPositive()) {
                    case 1:
                        row.createCell(185).setCellValue("是");
                        break;
                    case 2:
                        row.createCell(185).setCellValue("否");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getOtherAvailableParameters()) {
                    case 1:
                        row.createCell(186).setCellValue("其他特异性自身抗体阳性");
                        break;
                    case 2:
                        row.createCell(186).setCellValue("HLA DR3或DR4");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getHepatitisVirusMarkers()) {
                    case 1:
                        row.createCell(187).setCellValue("阳性");
                        break;
                    case 2:
                        row.createCell(187).setCellValue("阴性");
                        break;
                    default:
                        break;
                }
            }

            // 治疗后复杂complexAIH
            if (complexAIHAfterTreatmentDO != null) {
                switch (complexAIHBeforeTreatmentDO.getWoman()) {
                    case 1:
                        row.createCell(188).setCellValue("男");
                        break;
                    case 2:
                        row.createCell(188).setCellValue("女");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getHistoryDrugs()) {
                    case 1:
                        row.createCell(189).setCellValue("阳性");
                        break;
                    case 2:
                        row.createCell(189).setCellValue("阴性");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getaLPAST()) {
                    case 1:
                        row.createCell(190).setCellValue("<1.5");
                        break;
                    case 2:
                        row.createCell(190).setCellValue("1.5~3.0");
                        break;
                    case 3:
                        row.createCell(190).setCellValue(">3.0");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getAlcoholIntake()) {
                    case 1:
                        row.createCell(191).setCellValue("<25g/天");
                        break;
                    case 2:
                        row.createCell(191).setCellValue(">60g/天");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getSerumGlobulinNormal()) {
                    case 1:
                        row.createCell(192).setCellValue(">2.0");
                        break;
                    case 2:
                        row.createCell(192).setCellValue("1.5~2.0");
                        break;
                    case 3:
                        row.createCell(192).setCellValue("1.0~1.5");
                        break;
                    case 4:
                        row.createCell(192).setCellValue("<1.0");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getLiverCheck()) {
                    case 1:
                        row.createCell(193).setCellValue("界面型肝炎");
                        break;
                    case 2:
                        row.createCell(193).setCellValue("主要为淋巴浆细胞浸润");
                        break;
                    case 3:
                        row.createCell(193).setCellValue("肝细胞呈玫瑰花结样改变");
                        break;
                    case 4:
                        row.createCell(193).setCellValue("无上述表现");
                        break;
                    case 5:
                        row.createCell(193).setCellValue("胆管改变");
                        break;
                    case 6:
                        row.createCell(193).setCellValue("其它改变");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getAna()) {
                    case 1:
                        row.createCell(194).setCellValue(">1:80");
                        break;
                    case 2:
                        row.createCell(194).setCellValue("1:80");
                        break;
                    case 3:
                        row.createCell(194).setCellValue("1:40");
                        break;
                    case 4:
                        row.createCell(194).setCellValue("<1:40");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getOtherImmuneDiseases()) {
                    case 1:
                        row.createCell(195).setCellValue("存在");
                        break;
                    case 2:
                        row.createCell(195).setCellValue("不存在");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getAmaPositive()) {
                    case 1:
                        row.createCell(196).setCellValue("是");
                        break;
                    case 2:
                        row.createCell(196).setCellValue("否");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getOtherAvailableParameters()) {
                    case 1:
                        row.createCell(197).setCellValue("其他特异性自身抗体阳性");
                        break;
                    case 2:
                        row.createCell(197).setCellValue("HLA DR3或DR4");
                        break;
                    default:
                        break;
                }
                switch (complexAIHBeforeTreatmentDO.getHepatitisVirusMarkers()) {
                    case 1:
                        row.createCell(198).setCellValue("阳性");
                        break;
                    case 2:
                        row.createCell(198).setCellValue("阴性");
                        break;
                    default:
                        break;
                }
                switch (complexAIHAfterTreatmentDO.getResponseTreatment()) {
                    case 1:
                        row.createCell(199).setCellValue("完全");
                        break;
                    case 2:
                        row.createCell(199).setCellValue("复发");
                        break;
                    default:
                        break;
                }
            }

            // 治疗方案
            if (treatmentProgramsDO != null) {
                if (treatmentProgramsDO.getQdsTime() != null) {
                    row.createCell(200).setCellValue(treatmentProgramsDO.getQdsTime().toString());
                }
                row.createCell(201).setCellValue(treatmentProgramsDO.getQdsDose());
                row.createCell(202).setCellValue(treatmentProgramsDO.getQdsHeal());
                if (treatmentProgramsDO.getQdslTime() != null) {
                    row.createCell(203).setCellValue(treatmentProgramsDO.getQdslTime().toString());
                }
                row.createCell(204).setCellValue(treatmentProgramsDO.getQdslDose());
                row.createCell(205).setCellValue(treatmentProgramsDO.getQdslHeal());
                if (treatmentProgramsDO.getJjqTime() != null) {
                    row.createCell(206).setCellValue(treatmentProgramsDO.getJjqTime().toString());
                }
                row.createCell(207).setCellValue(treatmentProgramsDO.getJjqDose());
                row.createCell(208).setCellValue(treatmentProgramsDO.getJjqHeal());
                if (treatmentProgramsDO.getBdndTime() != null) {
                    row.createCell(209).setCellValue(treatmentProgramsDO.getBdndTime().toString());
                }
                row.createCell(210).setCellValue(treatmentProgramsDO.getBdndDose());
                row.createCell(211).setCellValue(treatmentProgramsDO.getBdndHeal());
                if (treatmentProgramsDO.getLcplTime() != null) {
                    row.createCell(212).setCellValue(treatmentProgramsDO.getLcplTime().toString());
                }
                row.createCell(213).setCellValue(treatmentProgramsDO.getLcplDose());
                row.createCell(214).setCellValue(treatmentProgramsDO.getLcplHeal());
                if (treatmentProgramsDO.getMtxTime() != null) {
                    row.createCell(215).setCellValue(treatmentProgramsDO.getMtxTime().toString());
                }
                row.createCell(216).setCellValue(treatmentProgramsDO.getMtxDose());
                row.createCell(217).setCellValue(treatmentProgramsDO.getMtxHeal());
                if (treatmentProgramsDO.getCysaTime() != null) {
                    row.createCell(218).setCellValue(treatmentProgramsDO.getCysaTime().toString());
                }
                row.createCell(219).setCellValue(treatmentProgramsDO.getCysaDose());
                row.createCell(220).setCellValue(treatmentProgramsDO.getCysaHeal());
                if (treatmentProgramsDO.getCtxTime() != null) {
                    row.createCell(221).setCellValue(treatmentProgramsDO.getCtxTime().toString());
                }
                row.createCell(222).setCellValue(treatmentProgramsDO.getCtxDose());
                row.createCell(223).setCellValue(treatmentProgramsDO.getCtxHeal());
                if (treatmentProgramsDO.getMtmkTime() != null) {
                    row.createCell(224).setCellValue(treatmentProgramsDO.getMtmkTime().toString());
                }
                row.createCell(225).setCellValue(treatmentProgramsDO.getMtmkDose());
                row.createCell(226).setCellValue(treatmentProgramsDO.getMtmkHeal());
                if (treatmentProgramsDO.getQsxsTime() != null) {
                    row.createCell(227).setCellValue(treatmentProgramsDO.getQsxsTime().toString());
                }
                row.createCell(228).setCellValue(treatmentProgramsDO.getQsxsDose());
                row.createCell(229).setCellValue(treatmentProgramsDO.getQsxsHeal());
                if (treatmentProgramsDO.getXqydTime() != null) {
                    row.createCell(230).setCellValue(treatmentProgramsDO.getXqydTime().toString());
                }
                row.createCell(231).setCellValue(treatmentProgramsDO.getXqydDose());
                row.createCell(232).setCellValue(treatmentProgramsDO.getXqydHeal());
                if (treatmentProgramsDO.getFnbtTime() != null) {
                    row.createCell(233).setCellValue(treatmentProgramsDO.getFnbtTime().toString());
                }
                row.createCell(234).setCellValue(treatmentProgramsDO.getFnbtDose());
                row.createCell(235).setCellValue(treatmentProgramsDO.getFnbtHeal());
                if (treatmentProgramsDO.getBzbtTime() != null) {
                    row.createCell(236).setCellValue(treatmentProgramsDO.getBzbtTime().toString());
                }
                row.createCell(237).setCellValue(treatmentProgramsDO.getBzbtDose());
                row.createCell(238).setCellValue(treatmentProgramsDO.getBzbtHeal());
                if (treatmentProgramsDO.getGyzTime() != null) {
                    row.createCell(239).setCellValue(treatmentProgramsDO.getGyzTime().toString());
                }
                if (treatmentProgramsDO.getGyzReason() != null) {
                    row.createCell(240).setCellValue(treatmentProgramsDO.getGyzResult()
                            + " 如果死亡，原因：" + treatmentProgramsDO.getGyzReason());
                } else {
                    row.createCell(240)
                            .setCellValue(treatmentProgramsDO.getGyzResult() + " 如果死亡，原因：没有死亡");
                }
            }

            if (cMedicinePrescriptionDO != null) {
                if (cMedicinePrescriptionDO.getChineseMedicineTime() != null) {
                    row.createCell(241).setCellValue(
                            cMedicinePrescriptionDO.getChineseMedicineTime().toString());
                }
                row.createCell(242)
                        .setCellValue(cMedicinePrescriptionDO.getChineseMedicineFormulasDose());
                row.createCell(243).setCellValue(cMedicinePrescriptionDO.getChineseMedicineHeal());
                if (cMedicinePrescriptionDO.getaProprietaryMedicineTime() != null) {
                    row.createCell(244)
                            .setCellValue(cMedicinePrescriptionDO.getaProprietaryMedicineTime());
                }
                row.createCell(245)
                        .setCellValue(cMedicinePrescriptionDO.getaProprietaryMedicineName());
                row.createCell(246)
                        .setCellValue(cMedicinePrescriptionDO.getaProprietaryMedicineHeal());
                if (cMedicinePrescriptionDO.getbProprietaryMedicineTime() != null) {
                    row.createCell(247).setCellValue(
                            cMedicinePrescriptionDO.getbProprietaryMedicineTime().toString());
                }
                row.createCell(248)
                        .setCellValue(cMedicinePrescriptionDO.getbProprietaryMedicineName());
                row.createCell(249)
                        .setCellValue(cMedicinePrescriptionDO.getbProprietaryMedicineHeal());
            }

            // 最后诊断
            if (fCircumstancesDO != null) {
                row.createCell(250).setCellValue(fCircumstancesDO.getPbcClinicalStage());
                row.createCell(251).setCellValue(fCircumstancesDO.getAihClinicalStage());
                StringBuilder s = new StringBuilder();
                if (fCircumstancesDO.isChildren()) {
                    s.append("儿童 ");
                }
                if (fCircumstancesDO.isGestationPeriod()) {
                    s.append("妊娠期 ");
                }
                if (fCircumstancesDO.isRepeatedRelapse()) {
                    s.append("多次复发 ");
                }
                if (fCircumstancesDO.isResistantToSteroidTreatment()) {
                    s.append("对激素耐药 ");
                }
                if (fCircumstancesDO.isPatientsWithChronicHepatitisB()) {
                    s.append("合并慢性乙型肝炎 ");
                }
                if (fCircumstancesDO.isPatientsWithChronicHepatitisC()) {
                    s.append("合并慢性丙型肝炎 ");
                }
                if (fCircumstancesDO.isOverlappingAIHPBC()) {
                    s.append("AIH-PBC重叠 ");
                }
                if (fCircumstancesDO.isOverlappingAIHPSC()) {
                    s.append("AIH-PSC重叠 ");
                }
                if (fCircumstancesDO.isAutoimmuneCholangitis()) {
                    s.append("自身免疫性胆管炎 ");
                }
                if (fCircumstancesDO.isFinalDiagnosisOther()) {
                    s.append("其他");
                }
                row.createCell(252).setCellValue(s.toString());

            }

        }

        if (!new File(excelPath).exists()) {
            new File(excelPath).mkdir();
        }
        FileOutputStream fileOut = new FileOutputStream(excelPath + new UserMsgTool().getCurrentUser().getRealName() + "patientInformation.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }

}
