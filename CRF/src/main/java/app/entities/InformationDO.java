package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "information")
public class InformationDO {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String informationName;
    private int projectId;
    private int hospitalId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInformationName() {
        return informationName;
    }

    public void setInformationName(String informationName) {
        this.informationName = informationName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }


}
