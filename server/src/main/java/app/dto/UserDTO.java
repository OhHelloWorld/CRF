package app.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String realName;
    private String password;
    private String account;
    private HospitalDTO hospital;
    private String email;
    private List<SysPermissionDTO> permissionDTOS;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public HospitalDTO getHospital() {
        return hospital;
    }

    public void setHospital(HospitalDTO hospital) {
        this.hospital = hospital;
    }

    public List<SysPermissionDTO> getPermissionDTOS() {
        return permissionDTOS;
    }

    public void setPermissionDTOS(List<SysPermissionDTO> permissionDTOS) {
        this.permissionDTOS = permissionDTOS;
    }
}
