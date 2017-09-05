package app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * 患者一般资料
 *
 * @author JR
 */
@Entity
@Table(name = "patient")
public class PatientDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String identifier;
    private String abbreviation;//患者姓名拼音缩写
    private String name;
    private String gender;
    private String nation;
    private float height;
    private float weight;
    private String department;//科室
    private Date admissionDate;//入院日期
    private Date dischargeDate;//出院日期
    private String hospitalizedNumber;//住院号
    private String hospitalizedDepartment;//住院科室
    private int hospitalizedAge;//住院年龄
    private String career;//职业
    private boolean smoke;
    private boolean drink;
    private String familyHistory;
    private Date birthday;
    private int bmi;
    private String degreeOfEducation;
    private Date firstTimeLiverInjury;
    private String investigateHospital;
    private String telephone;
    private String durationOfVisit;
    private Long firstVisitAge;
    private Date firstVisitTime;
    private String smokeDrinkFamHis;
    private boolean concurrentAutoDisease;
    private Date concurrentAutoDate;
    private boolean conAutoDisFirstOrNot;
    private boolean complete;
    private Long hospitalId;
    private Long projectId;
    @OneToMany(mappedBy = "patientDO", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<AdmissionDiagnosisDO> admissionDiagnosisDOS;
    @OneToMany(mappedBy = "patientDO", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<DischargeDiagnosisDO> dischargeDiagnosisDOS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getHospitalizedNumber() {
        return hospitalizedNumber;
    }

    public void setHospitalizedNumber(String hospitalizedNumber) {
        this.hospitalizedNumber = hospitalizedNumber;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getHospitalizedDepartment() {
        return hospitalizedDepartment;
    }

    public void setHospitalizedDepartment(String hospitalizedDepartment) {
        this.hospitalizedDepartment = hospitalizedDepartment;
    }

    public int getHospitalizedAge() {
        return hospitalizedAge;
    }

    public void setHospitalizedAge(int hospitalizedAge) {
        this.hospitalizedAge = hospitalizedAge;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public boolean isConcurrentAutoDisease() {
        return concurrentAutoDisease;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getBmi() {
        return bmi;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    public String getDegreeOfEducation() {
        return degreeOfEducation;
    }

    public void setDegreeOfEducation(String degreeOfEducation) {
        this.degreeOfEducation = degreeOfEducation;
    }

    public Date getFirstTimeLiverInjury() {
        return firstTimeLiverInjury;
    }

    public void setFirstTimeLiverInjury(Date firstTimeLiverInjury) {
        this.firstTimeLiverInjury = firstTimeLiverInjury;
    }

    public String getInvestigateHospital() {
        return investigateHospital;
    }

    public void setInvestigateHospital(String investigateHospital) {
        this.investigateHospital = investigateHospital;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDurationOfVisit() {
        return durationOfVisit;
    }

    public void setDurationOfVisit(String durationOfVisit) {
        this.durationOfVisit = durationOfVisit;
    }

    public Long getFirstVisitAge() {
        return firstVisitAge;
    }

    public void setFirstVisitAge(Long firstVisitAge) {
        this.firstVisitAge = firstVisitAge;
    }

    public Date getFirstVisitTime() {
        return firstVisitTime;
    }

    public void setFirstVisitTime(Date firstVisitTime) {
        this.firstVisitTime = firstVisitTime;
    }

    public String getSmokeDrinkFamHis() {
        return smokeDrinkFamHis;
    }

    public void setSmokeDrinkFamHis(String smokeDrinkFamHis) {
        this.smokeDrinkFamHis = smokeDrinkFamHis;
    }

    public boolean getConcurrentAutoDisease() {
        return concurrentAutoDisease;
    }

    public void setConcurrentAutoDisease(boolean concurrentAutoDisease) {
        this.concurrentAutoDisease = concurrentAutoDisease;
    }

    public Date getConcurrentAutoDate() {
        return concurrentAutoDate;
    }

    public void setConcurrentAutoDate(Date concurrentAutoDate) {
        this.concurrentAutoDate = concurrentAutoDate;
    }

    public boolean isConAutoDisFirstOrNot() {
        return conAutoDisFirstOrNot;
    }

    public void setConAutoDisFirstOrNot(boolean conAutoDisFirstOrNot) {
        this.conAutoDisFirstOrNot = conAutoDisFirstOrNot;
    }

    public List<AdmissionDiagnosisDO> getAdmissionDiagnosisDOS() {
        return admissionDiagnosisDOS;
    }

    public void setAdmissionDiagnosisDOS(List<AdmissionDiagnosisDO> admissionDiagnosisDOS) {
        this.admissionDiagnosisDOS = admissionDiagnosisDOS;
    }

    public List<DischargeDiagnosisDO> getDischargeDiagnosisDOS() {
        return dischargeDiagnosisDOS;
    }

    public void setDischargeDiagnosisDOS(List<DischargeDiagnosisDO> dischargeDiagnosisDOS) {
        this.dischargeDiagnosisDOS = dischargeDiagnosisDOS;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
