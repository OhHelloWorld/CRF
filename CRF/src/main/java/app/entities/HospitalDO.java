package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
@Table(name = "hospital")
@Entity
public class HospitalDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hospitalName;//医院名字

    @OneToMany(mappedBy = "hospital")
    private List<UserDO> userList;//一个医院对应多个用户

    @ManyToMany
    @JoinTable(
            name = "project_hospital",
            joinColumns = {@JoinColumn(name = "hospital_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<ProjectDO> projectList;//多个项目对应多个医院

    private String address;//地址

    private String addressDetail;//详细地址

    private String telephone;//电话

    private String specialMajor;//特色专科

    private String manageRange;//经营范围

    private String image_url;//图片地址

    private String introduction;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<UserDO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDO> userList) {
        this.userList = userList;
    }

    public List<ProjectDO> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectDO> projectList) {
        this.projectList = projectList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSpecialMajor() {
        return specialMajor;
    }

    public void setSpecialMajor(String specialMajor) {
        this.specialMajor = specialMajor;
    }

    public String getManageRange() {
        return manageRange;
    }

    public void setManageRange(String manageRange) {
        this.manageRange = manageRange;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
