package app.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Entity(name = "medicine_liver_symptoms")
public class MedicineLiverSymptomsDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private int liverInjury;
    private int weak;//乏力
    @Column(name = "weak_begin_date")
    private Date weakBeginDate;//乏力出现时间
    @Column(name = "weak_disappear_date")
    private Date weakDisappearDate;//乏力消失时间
    private int weakDischarge;//乏力出院时表现
    private int anorexia;//纳差
    @Column(name = "anorexia_begin_date")
    private int anorexiaBeginDate;//纳差出现时间
    @Column(name = "anorexia_disappear_date")
    private Date anorexiaDisappearDate;//纳差消失时间
    private int anorexiaDischarge;//纳差出院表现
    private int abdominalDistention;//腹胀
    @Column(name = "abdominal_distention_begin_date")
    private Date abdominalDistentionBeginDate;//腹胀出现时间
    @Column(name = "abdominal_distention_disappear_date")
    private Date abdominalDistentionDisappearDate;//腹胀消失时间
    @Column(name = "abdominal_distention_discharge")
    private int abdominalDistentionDischarge;//腹胀出院表现
    private int jaundice;//黄疸
    @Column(name = "jaundice_begin_date")
    private Date jaundiceBeginDate;//黄疸出现时间
    @Column(name = "jaundice_disappear_date")
    private Date jaundiceDisappearDate;//黄疸消失时间
    private int jaundiceDischarge;//黄疸出院时表现
    private int nausea;//恶心
    @Column(name = "nausea_begin_date")
    private Date nauseaBeginDate;//恶心出现时间
    @Column(name = "nausea_disappear_date")
    private Date nauseaDisappearDate;//恶心消失时间
    private int nauseaDischarge;//恶心出院时表现
    private int vomit;//呕吐
    @Column(name = "vomit_begin_date")
    private Date vomitBeginDate;//呕吐出现时间
    @Column(name = "vomit_disappear_date")
    private Date vomitDisappearDate;//呕吐消失时间
    private int vomitDischarge;//呕吐出院时表现
    private int gingivalBleeding;//齿龈出血
    @Column(name = "gingival_bleeding_begin_date")
    private Date gingivalBleedingBeginDate;//齿龈出血出现时间
    @Column(name = "gingival_bleeding_disappear_date")
    private Date gingivalBleedingDisappearDate;//齿龈出血消失时间
    @Column(name = "gingival_bleeding_discharge")
    private int gingivalBleedingDischarge;//齿龈出血出院表现
    private int epistaxis;//鼻衄
    @Column(name = "epistaxis_begin_date")
    private Date epistaxis_begin_date;//鼻衄出现时间
    @Column(name = "epistaxis_disappear_date")
    private Date epistaxisDisappearDate;//鼻衄消失时间
    private int epistaxisDischarge;//鼻衄出院时表现
    private int liverPain;//肝区疼痛
    @Column(name = "liver_pain_begin_date")
    private int liverPainBeginDate;//肝区疼痛出现时间
    @Column(name = "liver_pain_disappear_date")
    private Date liverPainDisappearDate;//肝区疼痛消失时间
    @Column(name = "liver_pain_discharge")
    private int liverPainDischarge;//肝区疼痛出院表现
    private int hepatomegaly;//肝肿大
    @Column(name = "hepatomegaly_begin_date")
    private Date hepatomegalyBeginDate;//肝肿大出现时间
    @Column(name = "hepatomegaly_disappear_date")
    private Date hepatomegalyDisappearDate;//肝肿大消失时间
    private int hepatomegalyDischarge;//肝肿大出院表现
    private int splenomegaly;//脾肿大
    @Column(name = "splenomegaly_begin_date")
    private Date splenomegalyBeginDate;//脾肿大出现时间
    @Column(name = "splenomegaly_disappear_date")
    private Date splenomegalyDisappearDate;//脾肿大消失时间
    private int splenomegalyDischarge;//脾肿大出院表现
    private int fever;//发热
    @Column(name = "fever_begin_date")
    private Date feverBeginDate;//发热开始时间
    @Column(name = "fever_disappear_date")
    private Date feverDisappearDate;//发热消失时间
    private int feverDischarge;//发热出院表现
    private int rash;//皮疹
    @Column(name = "rash_begin_date")
    private Date rashBeginDate;//皮疹出现时间
    @Column(name = "rashDisappearDate")
    private Date rash_disappear_date;//皮疹消失时间
    private int rashDischarge;//皮疹出院表现
    private int arthralgia;//关节痛
    @Column(name = "arthralgia_begin_date")
    private Date arthralgiaBeginDate;//关节痛出现时间
    @Column(name = "arthralgia_disappear_date")
    private Date arthralgiaDisappearDate;//关节痛消失时间
    private int arthralgiaDischarge;//关节痛出院表现
    private int skinItch;//皮肤瘙痒
    @Column(name = "skin_itch_begin_date")
    private Date skinItchBeginDate;//皮肤瘙痒出现时间
    @Column(name = "skin_itch_disappear_date")
    private Date skinItchDisappearDate;//皮肤瘙痒消失时间
    private int skinItchDischarge;//皮肤瘙痒出院表现
    private boolean complete;
    @OneToMany(mappedBy = "medicineLiverSymptomsDO",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<MedicineLiverSymptomsOtherDO> medicineLiverSymptomsOtherDOs;

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

    public int getLiverInjury() {
        return liverInjury;
    }

    public void setLiverInjury(int liverInjury) {
        this.liverInjury = liverInjury;
    }

    public int getWeak() {
        return weak;
    }

    public void setWeak(int weak) {
        this.weak = weak;
    }

    public Date getWeakBeginDate() {
        return weakBeginDate;
    }

    public void setWeakBeginDate(Date weakBeginDate) {
        this.weakBeginDate = weakBeginDate;
    }

    public Date getWeakDisappearDate() {
        return weakDisappearDate;
    }

    public void setWeakDisappearDate(Date weakDisappearDate) {
        this.weakDisappearDate = weakDisappearDate;
    }

    public int getWeakDischarge() {
        return weakDischarge;
    }

    public void setWeakDischarge(int weakDischarge) {
        this.weakDischarge = weakDischarge;
    }

    public int getAnorexia() {
        return anorexia;
    }

    public void setAnorexia(int anorexia) {
        this.anorexia = anorexia;
    }

    public int getAnorexiaBeginDate() {
        return anorexiaBeginDate;
    }

    public void setAnorexiaBeginDate(int anorexiaBeginDate) {
        this.anorexiaBeginDate = anorexiaBeginDate;
    }

    public Date getAnorexiaDisappearDate() {
        return anorexiaDisappearDate;
    }

    public void setAnorexiaDisappearDate(Date anorexiaDisappearDate) {
        this.anorexiaDisappearDate = anorexiaDisappearDate;
    }

    public int getAnorexiaDischarge() {
        return anorexiaDischarge;
    }

    public void setAnorexiaDischarge(int anorexiaDischarge) {
        this.anorexiaDischarge = anorexiaDischarge;
    }

    public int getAbdominalDistention() {
        return abdominalDistention;
    }

    public void setAbdominalDistention(int abdominalDistention) {
        this.abdominalDistention = abdominalDistention;
    }

    public Date getAbdominalDistentionBeginDate() {
        return abdominalDistentionBeginDate;
    }

    public void setAbdominalDistentionBeginDate(Date abdominalDistentionBeginDate) {
        this.abdominalDistentionBeginDate = abdominalDistentionBeginDate;
    }

    public Date getAbdominalDistentionDisappearDate() {
        return abdominalDistentionDisappearDate;
    }

    public void setAbdominalDistentionDisappearDate(Date abdominalDistentionDisappearDate) {
        this.abdominalDistentionDisappearDate = abdominalDistentionDisappearDate;
    }

    public int getAbdominalDistentionDischarge() {
        return abdominalDistentionDischarge;
    }

    public void setAbdominalDistentionDischarge(int abdominalDistentionDischarge) {
        this.abdominalDistentionDischarge = abdominalDistentionDischarge;
    }

    public int getJaundice() {
        return jaundice;
    }

    public void setJaundice(int jaundice) {
        this.jaundice = jaundice;
    }

    public Date getJaundiceBeginDate() {
        return jaundiceBeginDate;
    }

    public void setJaundiceBeginDate(Date jaundiceBeginDate) {
        this.jaundiceBeginDate = jaundiceBeginDate;
    }

    public Date getJaundiceDisappearDate() {
        return jaundiceDisappearDate;
    }

    public void setJaundiceDisappearDate(Date jaundiceDisappearDate) {
        this.jaundiceDisappearDate = jaundiceDisappearDate;
    }

    public int getJaundiceDischarge() {
        return jaundiceDischarge;
    }

    public void setJaundiceDischarge(int jaundiceDischarge) {
        this.jaundiceDischarge = jaundiceDischarge;
    }

    public int getNausea() {
        return nausea;
    }

    public void setNausea(int nausea) {
        this.nausea = nausea;
    }

    public Date getNauseaBeginDate() {
        return nauseaBeginDate;
    }

    public void setNauseaBeginDate(Date nauseaBeginDate) {
        this.nauseaBeginDate = nauseaBeginDate;
    }

    public Date getNauseaDisappearDate() {
        return nauseaDisappearDate;
    }

    public void setNauseaDisappearDate(Date nauseaDisappearDate) {
        this.nauseaDisappearDate = nauseaDisappearDate;
    }

    public int getNauseaDischarge() {
        return nauseaDischarge;
    }

    public void setNauseaDischarge(int nauseaDischarge) {
        this.nauseaDischarge = nauseaDischarge;
    }

    public int getVomit() {
        return vomit;
    }

    public void setVomit(int vomit) {
        this.vomit = vomit;
    }

    public Date getVomitBeginDate() {
        return vomitBeginDate;
    }

    public void setVomitBeginDate(Date vomitBeginDate) {
        this.vomitBeginDate = vomitBeginDate;
    }

    public Date getVomitDisappearDate() {
        return vomitDisappearDate;
    }

    public void setVomitDisappearDate(Date vomitDisappearDate) {
        this.vomitDisappearDate = vomitDisappearDate;
    }

    public int getVomitDischarge() {
        return vomitDischarge;
    }

    public void setVomitDischarge(int vomitDischarge) {
        this.vomitDischarge = vomitDischarge;
    }

    public int getGingivalBleeding() {
        return gingivalBleeding;
    }

    public void setGingivalBleeding(int gingivalBleeding) {
        this.gingivalBleeding = gingivalBleeding;
    }

    public Date getGingivalBleedingBeginDate() {
        return gingivalBleedingBeginDate;
    }

    public void setGingivalBleedingBeginDate(Date gingivalBleedingBeginDate) {
        this.gingivalBleedingBeginDate = gingivalBleedingBeginDate;
    }

    public Date getGingivalBleedingDisappearDate() {
        return gingivalBleedingDisappearDate;
    }

    public void setGingivalBleedingDisappearDate(Date gingivalBleedingDisappearDate) {
        this.gingivalBleedingDisappearDate = gingivalBleedingDisappearDate;
    }

    public int getGingivalBleedingDischarge() {
        return gingivalBleedingDischarge;
    }

    public void setGingivalBleedingDischarge(int gingivalBleedingDischarge) {
        this.gingivalBleedingDischarge = gingivalBleedingDischarge;
    }

    public int getEpistaxis() {
        return epistaxis;
    }

    public void setEpistaxis(int epistaxis) {
        this.epistaxis = epistaxis;
    }

    public Date getEpistaxis_begin_date() {
        return epistaxis_begin_date;
    }

    public void setEpistaxis_begin_date(Date epistaxis_begin_date) {
        this.epistaxis_begin_date = epistaxis_begin_date;
    }

    public Date getEpistaxisDisappearDate() {
        return epistaxisDisappearDate;
    }

    public void setEpistaxisDisappearDate(Date epistaxisDisappearDate) {
        this.epistaxisDisappearDate = epistaxisDisappearDate;
    }

    public int getEpistaxisDischarge() {
        return epistaxisDischarge;
    }

    public void setEpistaxisDischarge(int epistaxisDischarge) {
        this.epistaxisDischarge = epistaxisDischarge;
    }

    public int getLiverPain() {
        return liverPain;
    }

    public void setLiverPain(int liverPain) {
        this.liverPain = liverPain;
    }

    public int getLiverPainBeginDate() {
        return liverPainBeginDate;
    }

    public void setLiverPainBeginDate(int liverPainBeginDate) {
        this.liverPainBeginDate = liverPainBeginDate;
    }

    public Date getLiverPainDisappearDate() {
        return liverPainDisappearDate;
    }

    public void setLiverPainDisappearDate(Date liverPainDisappearDate) {
        this.liverPainDisappearDate = liverPainDisappearDate;
    }

    public int getLiverPainDischarge() {
        return liverPainDischarge;
    }

    public void setLiverPainDischarge(int liverPainDischarge) {
        this.liverPainDischarge = liverPainDischarge;
    }

    public int getHepatomegaly() {
        return hepatomegaly;
    }

    public void setHepatomegaly(int hepatomegaly) {
        this.hepatomegaly = hepatomegaly;
    }

    public Date getHepatomegalyBeginDate() {
        return hepatomegalyBeginDate;
    }

    public void setHepatomegalyBeginDate(Date hepatomegalyBeginDate) {
        this.hepatomegalyBeginDate = hepatomegalyBeginDate;
    }

    public Date getHepatomegalyDisappearDate() {
        return hepatomegalyDisappearDate;
    }

    public void setHepatomegalyDisappearDate(Date hepatomegalyDisappearDate) {
        this.hepatomegalyDisappearDate = hepatomegalyDisappearDate;
    }

    public int getHepatomegalyDischarge() {
        return hepatomegalyDischarge;
    }

    public void setHepatomegalyDischarge(int hepatomegalyDischarge) {
        this.hepatomegalyDischarge = hepatomegalyDischarge;
    }

    public int getSplenomegaly() {
        return splenomegaly;
    }

    public void setSplenomegaly(int splenomegaly) {
        this.splenomegaly = splenomegaly;
    }

    public Date getSplenomegalyBeginDate() {
        return splenomegalyBeginDate;
    }

    public void setSplenomegalyBeginDate(Date splenomegalyBeginDate) {
        this.splenomegalyBeginDate = splenomegalyBeginDate;
    }

    public Date getSplenomegalyDisappearDate() {
        return splenomegalyDisappearDate;
    }

    public void setSplenomegalyDisappearDate(Date splenomegalyDisappearDate) {
        this.splenomegalyDisappearDate = splenomegalyDisappearDate;
    }

    public int getSplenomegalyDischarge() {
        return splenomegalyDischarge;
    }

    public void setSplenomegalyDischarge(int splenomegalyDischarge) {
        this.splenomegalyDischarge = splenomegalyDischarge;
    }

    public int getFever() {
        return fever;
    }

    public void setFever(int fever) {
        this.fever = fever;
    }

    public Date getFeverBeginDate() {
        return feverBeginDate;
    }

    public void setFeverBeginDate(Date feverBeginDate) {
        this.feverBeginDate = feverBeginDate;
    }

    public Date getFeverDisappearDate() {
        return feverDisappearDate;
    }

    public void setFeverDisappearDate(Date feverDisappearDate) {
        this.feverDisappearDate = feverDisappearDate;
    }

    public int getFeverDischarge() {
        return feverDischarge;
    }

    public void setFeverDischarge(int feverDischarge) {
        this.feverDischarge = feverDischarge;
    }

    public int getRash() {
        return rash;
    }

    public void setRash(int rash) {
        this.rash = rash;
    }

    public Date getRashBeginDate() {
        return rashBeginDate;
    }

    public void setRashBeginDate(Date rashBeginDate) {
        this.rashBeginDate = rashBeginDate;
    }

    public Date getRash_disappear_date() {
        return rash_disappear_date;
    }

    public void setRash_disappear_date(Date rash_disappear_date) {
        this.rash_disappear_date = rash_disappear_date;
    }

    public int getRashDischarge() {
        return rashDischarge;
    }

    public void setRashDischarge(int rashDischarge) {
        this.rashDischarge = rashDischarge;
    }

    public int getArthralgia() {
        return arthralgia;
    }

    public void setArthralgia(int arthralgia) {
        this.arthralgia = arthralgia;
    }

    public Date getArthralgiaBeginDate() {
        return arthralgiaBeginDate;
    }

    public void setArthralgiaBeginDate(Date arthralgiaBeginDate) {
        this.arthralgiaBeginDate = arthralgiaBeginDate;
    }

    public Date getArthralgiaDisappearDate() {
        return arthralgiaDisappearDate;
    }

    public void setArthralgiaDisappearDate(Date arthralgiaDisappearDate) {
        this.arthralgiaDisappearDate = arthralgiaDisappearDate;
    }

    public int getArthralgiaDischarge() {
        return arthralgiaDischarge;
    }

    public void setArthralgiaDischarge(int arthralgiaDischarge) {
        this.arthralgiaDischarge = arthralgiaDischarge;
    }

    public int getSkinItch() {
        return skinItch;
    }

    public void setSkinItch(int skinItch) {
        this.skinItch = skinItch;
    }

    public Date getSkinItchBeginDate() {
        return skinItchBeginDate;
    }

    public void setSkinItchBeginDate(Date skinItchBeginDate) {
        this.skinItchBeginDate = skinItchBeginDate;
    }

    public Date getSkinItchDisappearDate() {
        return skinItchDisappearDate;
    }

    public void setSkinItchDisappearDate(Date skinItchDisappearDate) {
        this.skinItchDisappearDate = skinItchDisappearDate;
    }

    public int getSkinItchDischarge() {
        return skinItchDischarge;
    }

    public void setSkinItchDischarge(int skinItchDischarge) {
        this.skinItchDischarge = skinItchDischarge;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<MedicineLiverSymptomsOtherDO> getMedicineLiverSymptomsOtherDOs() {
        return medicineLiverSymptomsOtherDOs;
    }

    public void setMedicineLiverSymptomsOtherDOs(List<MedicineLiverSymptomsOtherDO> medicineLiverSymptomsOtherDOs) {
        this.medicineLiverSymptomsOtherDOs = medicineLiverSymptomsOtherDOs;
    }
}
