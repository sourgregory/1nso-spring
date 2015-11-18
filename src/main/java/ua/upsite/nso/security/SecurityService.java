package ua.upsite.nso.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.upsite.nso.security.SecurityUser;
import ua.upsite.nso.model.User;
import ua.upsite.nso.repository.UserRepository;

import javax.inject.Inject;

/**
 *  Created by gregory on 11/14/15.
 */

@Service
public class SecurityService implements UserDetailsService {

    @Inject
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User " + s + " does not exist!");
        }

        return new SecurityUser(user);
    }
}
