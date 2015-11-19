package ua.upsite.nso.model.security;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 *  Created by gregory on 11/18/15.
 */

@Entity
@Table(name = "auth_roles")
public class Role {

    Long id;
    String name;
    String description;
    Set<Permission> permissions;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany()
    @JoinTable(name = "auth_roles_permissions",
            joinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
