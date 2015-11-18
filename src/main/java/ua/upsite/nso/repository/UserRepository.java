package ua.upsite.nso.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.upsite.nso.model.User;

/**
 *  Created by gregory on 11/13/15.
 */
public interface UserRepository {
    Iterable<User> findOrderByUserName();

    User findByName(String s);
}
