package ua.upsite.nso.model.security;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 *  Created by gregory on 11/18/15.
 */

@Entity
@Table(name = "auth_permissions")
public class Permission implements GrantedAuthority{

    private Long id;
    private String name;
    private String description;

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

    @Transient
    @Override
    public String getAuthority() {
        return name;
    }
}
