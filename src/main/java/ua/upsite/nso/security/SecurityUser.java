package ua.upsite.nso.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.upsite.nso.model.User;

import javax.persistence.*;
import java.util.*;

/**
 *  Created by gregory on 11/14/15.
 */


@Entity
@Table(name = "\"user\"")
@MappedSuperclass
public class SecurityUser extends User implements UserDetails {

    private static final long serialVersionUID = 1L;
    private List<Role> roles;

    public SecurityUser() {
    }

    public SecurityUser(User user) {
        this.setUserName(user.getUserName());
        this.setEmail(user.getEmail());
        this.setPasswordHash(user.getPasswordHash());
        this.setId(user.getId());
    }

    @ManyToMany(targetEntity = Role.class)
    List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<Permission> authorities = new ArrayList<>();
        List<Role> userRoles = this.getRoles();

        if (userRoles != null) {

            for (Role role : userRoles) {
                authorities.addAll((Collection<Permission>) role.getPermissions());
            }
        }
        return authorities;
    }

    @Transient
    @Override
    public String getPassword() {
        return super.getPasswordHash();
    }

    @Transient
    @Override
    public String getUsername() {
        return super.getUserName();
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

    @Controller
    public static class AuthenticationController
    {
        @RequestMapping(value = "login"/*, method = RequestMethod.GET*/)
        public ModelAndView login(Map<String, Object> model)
        {
            if(SecurityContextHolder.getContext().getAuthentication() instanceof
                    SecurityUser)
                return new ModelAndView(new RedirectView("/admin", true, false));

            model.put("loginForm", new LoginForm());
            return new ModelAndView("login");
        }

        public static class LoginForm
        {
            private String username;
            private String password;

            public String getUsername()
            {
                return username;
            }

            public void setUsername(String username)
            {
                this.username = username;
            }

            public String getPassword()
            {
                return password;
            }

            public void setPassword(String password)
            {
                this.password = password;
            }
        }
    }
}
