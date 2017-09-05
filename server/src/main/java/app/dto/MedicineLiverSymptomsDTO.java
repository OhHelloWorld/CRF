package app.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverSymptomsDTO {

    private int id;
    private int patientId;
    private int liverInjury;
    private int weak;//乏力
    private Date weakBeginDate;//乏力出现时间
    private Date weakDisappearDate;//乏力消失时间
    private int weakDischarge;//乏力出院时表现
    private int anorexia;//纳差
    private int anorexiaBeginDate;//纳差出现时间
    private Date anorexiaDisappearDate;//纳差消失时间
    private int anorexiaDischarge;//纳差出院表现
    private int abdominalDistention;//腹胀
    private Date abdominalDistentionBeginDate;//腹胀出现时间
    private Date abdominalDistentionDisappearDate;//腹胀消失时间
    private int abdominalDistentionDischarge;//腹胀出院表现
    private int jaundice;//黄疸
    private Date jaundiceBeginDate;//黄疸出现时间
    private Date jaundiceDisappearDate;//黄疸消失时间
    private int jaundiceDischarge;//黄疸出院时表现
    private int nausea;//恶心
    private Date nauseaBeginDate;//恶心出现时间
    private Date nauseaDisappearDate;//恶心消失时间
    private int nauseaDischarge;//恶心出院时表现
    private int vomit;//呕吐
    private Date vomitBeginDate;//呕吐出现时间
    private Date vomitDisappearDate;//呕吐消失时间
    private int vomitDischarge;//呕吐出院时表现
    private int gingivalBleeding;//齿龈出血
    private Date gingivalBleedingBeginDate;//齿龈出血出现时间
    private Date gingivalBleedingDisappearDate;//齿龈出血消失时间
    private int gingivalBleedingDischarge;//齿龈出血出院表现
    private int epistaxis;//鼻衄
    private Date epistaxisBeginDate;//鼻衄出现时间
    private Date epistaxisDisappearDate;//鼻衄消失时间
    private int epistaxisDischarge;//鼻衄出院时表现
    private int liverPain;//肝区疼痛
    private int liverPainBeginDate;//肝区疼痛出现时间
    private Date liverPainDisappearDate;//肝区疼痛消失时间
    private int liverPainDischarge;//肝区疼痛出院表现
    private int hepatomegaly;//肝肿大
    private Date hepatomegalyBeginDate;//肝肿大出现时间
    private Date hepatomegalyDisappearDate;//肝肿大消失时间
    private int hepatomegalyDischarge;//肝肿大出院表现
    private int splenomegaly;//脾肿大
    private Date splenomegalyBeginDate;//脾肿大出现时间
    private Date splenomegalyDisappearDate;//脾肿大消失时间
    private int splenomegalyDischarge;//脾肿大出院表现
    private int fever;//发热
    private Date feverBeginDate;//发热开始时间
    private Date feverDisappearDate;//发热消失时间
    private int feverDischarge;//发热出院表现
    private int rash;//皮疹
    private Date rashBeginDate;//皮疹出现时间
    private Date rashDisappearDate;//皮疹消失时间
    private int rashDischarge;//皮疹出院表现
    private int arthralgia;//关节痛
    private Date arthralgiaBeginDate;//关节痛出现时间
    private Date arthralgiaDisappearDate;//关节痛消失时间
    private int arthralgiaDischarge;//关节痛出院表现
    private int skinItch;//皮肤瘙痒
    private Date skinItchBeginDate;//皮肤瘙痒出现时间
    private Date skinItchDisappearDate;//皮肤瘙痒消失时间
    private int skinItchDischarge;//皮肤瘙痒出院表现
    private boolean complete;
    private List<MedicineLiverSymptomsOtherDTO> medicineLiverSymptomsOtherDTOs;
}
