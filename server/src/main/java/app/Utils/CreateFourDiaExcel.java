package app.Utils;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import app.entities.FourDiagnosticInformationDO;

@Component
public class CreateFourDiaExcel {
    public void createFourDiaExcel(FourDiagnosticInformationDO fourDiaDO) throws Exception {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("四诊信息");
        Row row = null;
        for (int i = 0; i < 37; i++) {
            row = sheet.createRow(i);
            if (i != 0) {
                row.createCell(0).setCellValue(i);
            }
            switch (i) {
                case 0:
                    row.createCell(0).setCellValue("序号");
                    row.createCell(1).setCellValue("调查项");
                    row.createCell(2).setCellValue("结果");;
                    break;
                case 1:
                    row.createCell(1).setCellValue("乏力");
                    switch (fourDiaDO.getFatigue()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("肢体乏力，勉强坚持日常生活");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("肢体稍倦，可坚持轻体力工作");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("全身无力，终日不愿活动");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    row.createCell(1).setCellValue("皮肤瘙痒");
                    switch (fourDiaDO.getSkinItching()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有，不影响日常生活");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("时常有，轻度影响日常生活");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("整日瘙痒，影响日常生活");
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    row.createCell(1).setCellValue("两目干涩");
                    switch (fourDiaDO.getTwoEyesDry()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("自觉有时目干");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("经常两目干涩");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("整日两目干涩");
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    row.createCell(1).setCellValue("视物模糊");
                    switch (fourDiaDO.getBlurredVision()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("久视后视物不清");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("视物不清");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("视物困难");
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    row.createCell(1).setCellValue("抑郁");
                    switch (fourDiaDO.getDepression()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("有时情绪低落");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("经常情绪低落");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("有厌世倾向");
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    row.createCell(1).setCellValue("烦躁易怒");
                    switch (fourDiaDO.getIrritability()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶见烦躁");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("经常烦躁不安");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("一触即怒");
                            break;
                        default:
                            break;
                    }
                    break;
                case 7:
                    row.createCell(1).setCellValue("失眠");
                    switch (fourDiaDO.getInsomnia()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("睡眠不足6小时");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("睡眠不足4小时");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("彻夜难眠");
                            break;
                        default:
                            break;
                    }
                    break;
                case 8:
                    row.createCell(1).setCellValue("易醒");
                    switch (fourDiaDO.getEasyWakeUp()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("每夜眠后醒1-2次");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("每夜眠后醒3-4次");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("每夜醒5次以上");
                            break;
                        default:
                            break;
                    }
                    break;
                case 9:
                    row.createCell(1).setCellValue("耳鸣");
                    switch (fourDiaDO.getTinnitus()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶见轻微耳鸣");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("阵发耳鸣，休息后缓解");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("耳鸣持续不解");
                            break;
                        default:
                            break;
                    }
                    break;
                case 10:
                    row.createCell(1).setCellValue("口干");
                    switch (fourDiaDO.getDryMouth()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有或晨起口干");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("时感口干");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("整日口干");
                            break;
                        default:
                            break;
                    }
                    break;
                case 11:
                    row.createCell(1).setCellValue("口苦");
                    switch (fourDiaDO.getMouthPain()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有或晨起口苦");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("时有口苦");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("整日口苦");
                            break;
                        default:
                            break;
                    }
                    break;
                case 12:
                    row.createCell(1).setCellValue("口臭");
                    switch (fourDiaDO.getBadBreath()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有或晨起口臭");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("时有口臭");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("整日口臭");
                            break;
                        default:
                            break;
                    }
                    break;
                case 13:
                    row.createCell(1).setCellValue("恶心");
                    switch (fourDiaDO.getNausea()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有恶心");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("每日恶心");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("恶心频作");
                            break;
                        default:
                            break;
                    }
                    break;
                case 14:
                    row.createCell(1).setCellValue("嗳气");
                    switch (fourDiaDO.getBelching()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有嗳气");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("食后嗳气频频");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("整日嗳气");
                            break;
                        default:
                            break;
                    }
                    break;
                case 15:
                    row.createCell(1).setCellValue("脘腹胀满");
                    switch (fourDiaDO.getAbdominalDistention()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("进食后脘闷腹胀");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("少量进食后即脘闷腹胀");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("整日脘闷腹胀");
                            break;
                        default:
                            break;
                    }
                    break;
                case 16:
                    row.createCell(1).setCellValue("胁肋痛-刺痛");
                    switch (fourDiaDO.getFlankPainStinging()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("常有");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("持续");
                            break;
                        default:
                            break;
                    }
                    break;
                case 17:
                    row.createCell(1).setCellValue("胁肋痛-胀痛");
                    switch (fourDiaDO.getFlankPainSwell()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("常有");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("持续");
                            break;
                        default:
                            break;
                    }
                    break;
                case 18:
                    row.createCell(1).setCellValue("胁肋痛-隐痛");
                    switch (fourDiaDO.getFlankPainDull()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("常有");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("持续");
                            break;
                        default:
                            break;
                    }
                    break;
                case 19:
                    row.createCell(1).setCellValue("胁肋痛-不适");
                    switch (fourDiaDO.getFlankPainDiscomfort()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("常有");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("持续");
                            break;
                        default:
                            break;
                    }
                    break;
                case 20:
                    row.createCell(1).setCellValue("纳差");
                    switch (fourDiaDO.getAnorexia()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("胃纳轻度减少");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("胃纳明显减少");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("不欲食");
                            break;
                        default:
                            break;
                    }
                    break;
                case 21:
                    row.createCell(1).setCellValue("畏寒肢冷");
                    switch (fourDiaDO.getAphrodisiacCold()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("手足不温");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("加衣被方可缓解");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("加衣被不缓解");
                            break;
                        default:
                            break;
                    }
                    break;
                case 22:
                    row.createCell(1).setCellValue("肢体困重");
                    switch (fourDiaDO.getLimb()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("下肢偶有沉重感");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("肢体沉重");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("肢体沉重，懒动");
                            break;
                        default:
                            break;
                    }
                    break;
                case 23:
                    row.createCell(1).setCellValue("腰痠脚软");
                    switch (fourDiaDO.getBackacheFootSoft()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有腰痠脚软");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("经常腰痠脚软");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("整日腰痠脚软");
                            break;
                        default:
                            break;
                    }
                    break;
                case 24:
                    row.createCell(1).setCellValue("手足烦热");
                    switch (fourDiaDO.getHandFootFanHot()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("轻度手足烦热");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("热甚，但能忍受");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("热甚，情绪烦躁");
                            break;
                        default:
                            break;
                    }
                    break;
                case 25:
                    row.createCell(1).setCellValue("尿黄");
                    switch (fourDiaDO.getUrineYellow()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("色黄");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("色深黄");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("色黄赤");
                            break;
                        default:
                            break;
                    }
                    break;
                case 26:
                    row.createCell(1).setCellValue("便秘");
                    switch (fourDiaDO.getConstipation()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("2日1行便之不爽");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("3日一行");
                            break;
                        case 3:
                            row.createCell(2).setCellValue(">3日一行");
                            break;
                        default:
                            break;
                    }
                    break;
                case 27:
                    row.createCell(1).setCellValue("便溏");
                    switch (fourDiaDO.getLooseStools()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("大便不成形");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("稀便，每日2-3次");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("稀便，4次以上");
                            break;
                        default:
                            break;
                    }
                    break;
                case 28:
                    row.createCell(1).setCellValue("自汗");
                    switch (fourDiaDO.getPerspiration()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶有汗出");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("经常汗出");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("动辄汗出");
                            break;
                        default:
                            break;
                    }
                    break;
                case 29:
                    row.createCell(1).setCellValue("下肢水肿");
                    switch (fourDiaDO.getLowerExtremityEdema()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("踝关节以下");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("膝关节以下");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("膝关节以上");
                            break;
                        default:
                            break;
                    }
                    break;
                case 30:
                    row.createCell(1).setCellValue("面晦暗");
                    switch (fourDiaDO.getFaceDull()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("色暗少光泽");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("色晦暗");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("色深褐无光");
                            break;
                        default:
                            break;
                    }
                    break;
                case 31:
                    row.createCell(1).setCellValue("目黄");
                    switch (fourDiaDO.getEyeYellow()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("色淡黄");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("色黄");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("色深黄");
                            break;
                        default:
                            break;
                    }
                    break;
                case 32:
                    row.createCell(1).setCellValue("身黄");
                    switch (fourDiaDO.getBodyYellow()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("色淡黄");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("色黄");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("色深黄");
                            break;
                        default:
                            break;
                    }
                    break;
                case 33:
                    row.createCell(1).setCellValue("蜘蛛痣数量");
                    switch (fourDiaDO.getSpiderNevus()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("偶见蜘蛛痣");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("有2~4个蜘蛛痣");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("5个以上蜘蛛痣");
                            break;
                        default:
                            break;
                    }
                    break;
                case 34:
                    row.createCell(1).setCellValue("肝掌");
                    switch (fourDiaDO.getLiverPalm()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("可疑肝掌");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("肝掌");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("明显肝掌");
                            break;
                        default:
                            break;
                    }
                    break;
                case 35:
                    row.createCell(1).setCellValue("腹壁脉络曲张");
                    switch (fourDiaDO.getAbdominalVeins()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("隐约可见");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("清晰可见");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("满腹脉络曲张");
                            break;
                        default:
                            break;
                    }
                    break;
                case 36:
                    row.createCell(1).setCellValue("黄色瘤");
                    switch (fourDiaDO.getYellowTumor()) {
                        case 0:
                            row.createCell(2).setCellValue("无");
                            break;
                        case 1:
                            row.createCell(2).setCellValue("隐约可见");
                            break;
                        case 2:
                            row.createCell(2).setCellValue("清晰可见");
                            break;
                        case 3:
                            row.createCell(2).setCellValue("明显突出皮肤");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }

        FileOutputStream fileOut = new FileOutputStream("C:/excel/workbook.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }
}
