package app.dto;

/**
 * Created by 52400 on 2017/6/22.
 */
public class ProjectUsersDTO {

    private String userName;

    private String projectRoleName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectRoleName() {
        return projectRoleName;
    }

    public void setProjectRoleName(String projectRoleName) {
        this.projectRoleName = projectRoleName;
    }
}
