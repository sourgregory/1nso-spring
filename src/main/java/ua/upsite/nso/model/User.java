package ua.upsite.nso.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.upsite.nso.model.security.Permission;
import ua.upsite.nso.model.security.Role;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 *  Created by gregory on 11/13/15.
 */

@Entity
@Table(name = "\"user\"")
public class User implements UserDetails{
    private Long id;
    private String userName;
    private String authKey;
    private String passwordHash;
    private String email;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private String passwordResetToken;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "auth_key")
    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authkey) {
        this.authKey = authkey;
    }

    @Column(name = "password_hash")
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Column(name = "password_reset_token")
    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    //////////////////////////User details interface implementation////////////////////////////

    private static final long serialVersionUID = 1L;
    private Set<Role> roles;

    @ManyToMany()
    @JoinTable(name = "auth_roles_users",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")
            })
    Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<Permission> authorities = new ArrayList<>();
        Collection<Role> userRoles = this.getRoles();

        if (userRoles != null) {

            for (Role role : userRoles) {
                authorities.addAll(role.getPermissions());
            }
        }
        return authorities;
    }

    @Transient
    @Override
    public String getPassword() {
        return getPasswordHash();
    }

    @Transient
    @Override
    public String getUsername() {
        return getUserName();
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }
}
