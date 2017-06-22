package app.dto;

/**
 * Created by 52400 on 2017/6/20.
 */
public class SysPermissionDTO {

    private Long id;
    private String sysPermissionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysPermissionName() {
        return sysPermissionName;
    }

    public void setSysPermissionName(String sysPermissionName) {
        this.sysPermissionName = sysPermissionName;
    }
}
