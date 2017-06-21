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

    private String hospitalName;

    @OneToMany
    private List<UserDO> userList;

    @ManyToMany
    @JoinTable(
            name = "project_hospital",
            joinColumns = {@JoinColumn(name = "hospital_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<ProjectDO> projectList;

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
}
