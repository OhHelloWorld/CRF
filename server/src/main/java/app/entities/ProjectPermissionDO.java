package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */

@Entity
@Table(name = "project_permission")
public class ProjectPermissionDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String projectPermissionName;

    @ManyToMany
    @JoinTable(
            name = "project_role_permission",
            joinColumns = {@JoinColumn(name = "project_permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_role_id")})
    private List<ProjectRoleDO> projectRoleDOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectPermissionName() {
        return projectPermissionName;
    }

    public void setProjectPermissionName(String projectPermissionName) {
        this.projectPermissionName = projectPermissionName;
    }

    public List<ProjectRoleDO> getProjectRoleDOS() {
        return projectRoleDOS;
    }

    public void setProjectRoleDOS(List<ProjectRoleDO> projectRoleDOS) {
        this.projectRoleDOS = projectRoleDOS;
    }
}
