package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 52400 on 2017/6/20.
 */
@Entity
@Table(name = "permission")
public class PermissionDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String PermissionName;

    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = {@JoinColumn(name = "permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<RoleDO> listRole;

    public List<RoleDO> getListRole() {
        return listRole;
    }

    public void setListRole(List<RoleDO> listRole) {
        this.listRole = listRole;
    }

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
