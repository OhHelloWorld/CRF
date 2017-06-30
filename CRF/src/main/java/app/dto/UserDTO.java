package app.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String realName;
    private String password;
    private String account;
    private Long hospitalId;
    private List<SysPermissionDTO> permissionDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<SysPermissionDTO> getPermissionDTOS() {
        return permissionDTOS;
    }

    public void setPermissionDTOS(List<SysPermissionDTO> permissionDTOS) {
        this.permissionDTOS = permissionDTOS;
    }
}
