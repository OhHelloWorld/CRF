package app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 患者一般资料
 * 
 * @author JR
 *
 */
@Entity
@Table(name = "patient")
public class PatientDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String identifier;//编号
    private String name;// 姓名
    private String gender;// 性别
    private int age;// 年龄
    private float height;// 身高
    private float weight;// 体重
    private boolean smoke;// 是否吸烟
    private boolean drink;// 是否饮酒
    private boolean familyHistory;// 是否有家族病史
    private Date hepatitisDiagnosisTime;// 肝炎确诊时间
    private Date cirrhosisDiagnosisTime;// 肝硬化确诊时间
    private String westernMedicineDiagnosis;// 西医诊断
    private String chineseMedicineDiagnosis;// 中医辨证
    private String westernMedicineTreatment;// 西医治疗
    private String chineseMedicineTreatment;// 中医治疗
    private boolean complete;// 是否完成

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public boolean isDrink() {
        return drink;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    public boolean isFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(boolean familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Date getHepatitisDiagnosisTime() {
        return hepatitisDiagnosisTime;
    }

    public void setHepatitisDiagnosisTime(Date hepatitisDiagnosisTime) {
        this.hepatitisDiagnosisTime = hepatitisDiagnosisTime;
    }

    public Date getCirrhosisDiagnosisTime() {
        return cirrhosisDiagnosisTime;
    }

    public void setCirrhosisDiagnosisTime(Date cirrhosisDiagnosisTime) {
        this.cirrhosisDiagnosisTime = cirrhosisDiagnosisTime;
    }

    public String getWesternMedicineDiagnosis() {
        return westernMedicineDiagnosis;
    }

    public void setWesternMedicineDiagnosis(String westernMedicineDiagnosis) {
        this.westernMedicineDiagnosis = westernMedicineDiagnosis;
    }

    public String getChineseMedicineDiagnosis() {
        return chineseMedicineDiagnosis;
    }

    public void setChineseMedicineDiagnosis(String chineseMedicineDiagnosis) {
        this.chineseMedicineDiagnosis = chineseMedicineDiagnosis;
    }

    public String getWesternMedicineTreatment() {
        return westernMedicineTreatment;
    }

    public void setWesternMedicineTreatment(String westernMedicineTreatment) {
        this.westernMedicineTreatment = westernMedicineTreatment;
    }

    public String getChineseMedicineTreatment() {
        return chineseMedicineTreatment;
    }

    public void setChineseMedicineTreatment(String chineseMedicineTreatment) {
        this.chineseMedicineTreatment = chineseMedicineTreatment;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }



}
