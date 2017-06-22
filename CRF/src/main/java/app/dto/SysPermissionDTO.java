package app.dto;

/**
 * Created by 52400 on 2017/6/20.
 */
public class SysPermissionDTO {

    private Long id;
    private String PermissionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return PermissionName;
    }

    public void setPermissionName(String permissionName) {
        PermissionName = permissionName;
    }
}
