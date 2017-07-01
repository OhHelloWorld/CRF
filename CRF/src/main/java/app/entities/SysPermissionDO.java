package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 52400 on 2017/6/20.
 */
@Entity
@Table(name = "sys_permission")
//此处为与系统有关的权限
public class SysPermissionDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sysPermissionName;

    @ManyToMany
    @JoinTable(
            name = "sys_role_permission",
            joinColumns = {@JoinColumn(name = "sys_permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_role_id")})
    private List<SysRoleDO> listRole;

    public List<SysRoleDO> getListRole() {
        return listRole;
    }

    public void setListRole(List<SysRoleDO> listRole) {
        this.listRole = listRole;
    }

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
