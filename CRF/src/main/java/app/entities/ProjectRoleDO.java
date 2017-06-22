package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */

@Table(name = "project_role")
@Entity
public class ProjectRoleDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String projectRoleName;//项目中的角色名字


    @ManyToMany
    @JoinTable(
            name = "project_role_permission",
            joinColumns = {@JoinColumn(name = "project_role_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_permission_id")})
    private List<ProjectPermissionDO> projectPermissionDOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectRoleName() {
        return projectRoleName;
    }

    public void setProjectRoleName(String projectRoleName) {
        this.projectRoleName = projectRoleName;
    }

    public List<ProjectPermissionDO> getProjectPermissionDOS() {
        return projectPermissionDOS;
    }

    public void setProjectPermissionDOS(List<ProjectPermissionDO> projectPermissionDOS) {
        this.projectPermissionDOS = projectPermissionDOS;
    }
}
