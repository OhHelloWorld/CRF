package app.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
@Entity
@Table(name = "project")
public class ProjectDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String organizer;// 发起人

    private Date create_time;// 创建事件

    private String introduction;// 项目简介

    private String projectName;// 项目名称

    @Column(name = "is_collect")
    private boolean collect;

    @ManyToMany
    @JoinTable(name = "project_hospital", joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "hospital_id")})
    private List<HospitalDO> hospitalList;// 多个医院对应多个项目

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<HospitalDO> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<HospitalDO> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }
}
