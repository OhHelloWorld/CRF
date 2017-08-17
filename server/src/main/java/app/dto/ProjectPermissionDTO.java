package app.dto;

/**
 * Created by 52400 on 2017/6/21.
 */
public class ProjectPermissionDTO {

    private Long id;

    private String projectPermissionName;

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
}
