package ua.upsite.nso.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.upsite.nso.model.User;
import ua.upsite.nso.repository.SecurityRepository;

import javax.inject.Inject;

/**
 *  Created by gregory on 11/14/15.
 */

@Service
public class SecurityService implements UserDetailsService {

    @Inject
    SecurityRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByUserNameWithRoles(s);
        if (user == null) {
            throw new UsernameNotFoundException("User " + s + " does not exist!");
        }

        return user;
    }
}
