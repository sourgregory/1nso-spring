package ua.upsite.nso.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *  Created by gregory on 11/13/15.
 */

@Entity
@Table(name = "\"user\"")
public class User {
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

}
