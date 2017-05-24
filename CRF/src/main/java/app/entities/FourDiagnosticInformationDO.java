package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 四诊信息采集量化数据
 * 
 * @author JR
 *
 */
@Entity
@Table(name = "four_diagnostic_information")
public class FourDiagnosticInformationDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int patientId;// 患者Id
    private int fatigue;// 乏力
    private int skinItching;// 皮肤瘙痒
    private int twoEyesDry;// 两目干涩
    private int blurredVision;// 视物模糊
    private int depression;// 抑郁
    private int irritability;// 烦躁易怒
    private int insomnia;// 失眠
    private int easyWakeUp;// 易醒
    private int tinnitus;// 耳鸣
    private int dryMouth;// 口干
    private int mouthPain;// 口苦
    private int badBreath;// 口臭
    private int nausea;// 恶心
    private int belching;// 嗳气
    private int abdominalDistention;// 脘腹胀满
    private int flankPainStinging;// 胁肋痛-刺痛
    private int flankPainSwell;// 胁肋痛-胀痛ʹ
    private int flankPainDull;// 胁肋痛-隐痛
    private int flankPainDiscomfort;// 胁肋痛-不适
    private int anorexia;// 纳差
    private int aphrodisiacCold;// 畏寒肢冷
    private int limb;// 肢体困重
    private int backacheFootSoft;// 腰痠脚软
    private int handFootFanHot;// 手足烦热
    private int urineYellow;// 尿黄
    private int constipation;// 便秘
    private int looseStools;// 便溏
    private int perspiration;// 自汗
    private int nightSweats;// 盗汗
    private int lowerExtremityEdema;// 下肢水肿
    private int faceDull;// 面晦暗
    private int eyeYellow;// 目黄
    private int bodyYellow;// 身黄
    private int spiderNevus;// 蜘蛛痣数量
    private int liverPalm;// 肝掌
    private int abdominalVeins;// 腹壁脉络曲张
    private int yellowTumor;// 黄色瘤
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

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getSkinItching() {
        return skinItching;
    }

    public void setSkinItching(int skinItching) {
        this.skinItching = skinItching;
    }

    public int getTwoEyesDry() {
        return twoEyesDry;
    }

    public void setTwoEyesDry(int twoEyesDry) {
        this.twoEyesDry = twoEyesDry;
    }

    public int getBlurredVision() {
        return blurredVision;
    }

    public void setBlurredVision(int blurredVision) {
        this.blurredVision = blurredVision;
    }

    public int getDepression() {
        return depression;
    }

    public void setDepression(int depression) {
        this.depression = depression;
    }

    public int getIrritability() {
        return irritability;
    }

    public void setIrritability(int irritability) {
        this.irritability = irritability;
    }

    public int getInsomnia() {
        return insomnia;
    }

    public void setInsomnia(int insomnia) {
        this.insomnia = insomnia;
    }

    public int getEasyWakeUp() {
        return easyWakeUp;
    }

    public void setEasyWakeUp(int easyWakeUp) {
        this.easyWakeUp = easyWakeUp;
    }

    public int getTinnitus() {
        return tinnitus;
    }

    public void setTinnitus(int tinnitus) {
        this.tinnitus = tinnitus;
    }

    public int getDryMouth() {
        return dryMouth;
    }

    public void setDryMouth(int dryMouth) {
        this.dryMouth = dryMouth;
    }

    public int getMouthPain() {
        return mouthPain;
    }

    public void setMouthPain(int mouthPain) {
        this.mouthPain = mouthPain;
    }

    public int getBadBreath() {
        return badBreath;
    }

    public void setBadBreath(int badBreath) {
        this.badBreath = badBreath;
    }

    public int getNausea() {
        return nausea;
    }

    public void setNausea(int nausea) {
        this.nausea = nausea;
    }

    public int getBelching() {
        return belching;
    }

    public void setBelching(int belching) {
        this.belching = belching;
    }

    public int getAbdominalDistention() {
        return abdominalDistention;
    }

    public void setAbdominalDistention(int abdominalDistention) {
        this.abdominalDistention = abdominalDistention;
    }

    public int getFlankPainStinging() {
        return flankPainStinging;
    }

    public void setFlankPainStinging(int flankPainStinging) {
        this.flankPainStinging = flankPainStinging;
    }

    public int getFlankPainSwell() {
        return flankPainSwell;
    }

    public void setFlankPainSwell(int flankPainSwell) {
        this.flankPainSwell = flankPainSwell;
    }

    public int getFlankPainDull() {
        return flankPainDull;
    }

    public void setFlankPainDull(int flankPainDull) {
        this.flankPainDull = flankPainDull;
    }

    public int getFlankPainDiscomfort() {
        return flankPainDiscomfort;
    }

    public void setFlankPainDiscomfort(int flankPainDiscomfort) {
        this.flankPainDiscomfort = flankPainDiscomfort;
    }

    public int getAnorexia() {
        return anorexia;
    }

    public void setAnorexia(int anorexia) {
        this.anorexia = anorexia;
    }

    public int getAphrodisiacCold() {
        return aphrodisiacCold;
    }

    public void setAphrodisiacCold(int aphrodisiacCold) {
        this.aphrodisiacCold = aphrodisiacCold;
    }

    public int getLimb() {
        return limb;
    }

    public void setLimb(int limb) {
        this.limb = limb;
    }

    public int getBackacheFootSoft() {
        return backacheFootSoft;
    }

    public void setBackacheFootSoft(int backacheFootSoft) {
        this.backacheFootSoft = backacheFootSoft;
    }

    public int getHandFootFanHot() {
        return handFootFanHot;
    }

    public void setHandFootFanHot(int handFootFanHot) {
        this.handFootFanHot = handFootFanHot;
    }

    public int getUrineYellow() {
        return urineYellow;
    }

    public void setUrineYellow(int urineYellow) {
        this.urineYellow = urineYellow;
    }

    public int getConstipation() {
        return constipation;
    }

    public void setConstipation(int constipation) {
        this.constipation = constipation;
    }

    public int getLooseStools() {
        return looseStools;
    }

    public void setLooseStools(int looseStools) {
        this.looseStools = looseStools;
    }

    public int getPerspiration() {
        return perspiration;
    }

    public void setPerspiration(int perspiration) {
        this.perspiration = perspiration;
    }

    public int getNightSweats() {
        return nightSweats;
    }

    public void setNightSweats(int nightSweats) {
        this.nightSweats = nightSweats;
    }

    public int getLowerExtremityEdema() {
        return lowerExtremityEdema;
    }

    public void setLowerExtremityEdema(int lowerExtremityEdema) {
        this.lowerExtremityEdema = lowerExtremityEdema;
    }

    public int getFaceDull() {
        return faceDull;
    }

    public void setFaceDull(int faceDull) {
        this.faceDull = faceDull;
    }

    public int getEyeYellow() {
        return eyeYellow;
    }

    public void setEyeYellow(int eyeYellow) {
        this.eyeYellow = eyeYellow;
    }

    public int getBodyYellow() {
        return bodyYellow;
    }

    public void setBodyYellow(int bodyYellow) {
        this.bodyYellow = bodyYellow;
    }

    public int getSpiderNevus() {
        return spiderNevus;
    }

    public void setSpiderNevus(int spiderNevus) {
        this.spiderNevus = spiderNevus;
    }

    public int getLiverPalm() {
        return liverPalm;
    }

    public void setLiverPalm(int liverPalm) {
        this.liverPalm = liverPalm;
    }

    public int getAbdominalVeins() {
        return abdominalVeins;
    }

    public void setAbdominalVeins(int abdominalVeins) {
        this.abdominalVeins = abdominalVeins;
    }

    public int getYellowTumor() {
        return yellowTumor;
    }

    public void setYellowTumor(int yellowTumor) {
        this.yellowTumor = yellowTumor;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
