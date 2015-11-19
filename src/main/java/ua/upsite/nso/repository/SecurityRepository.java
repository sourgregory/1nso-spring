package ua.upsite.nso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.User;

/**
 *  Created by gregory on 11/18/15.
 */
@SuppressWarnings("unused")
@Repository
public interface SecurityRepository extends JpaRepository<User, Long>{

    @Query(value= "SELECT u FROM User u LEFT JOIN FETCH u.roles r LEFT JOIN FETCH r.permissions where u.userName = :name")
    User findByUserNameWithRoles(@Param("name") String name);
}
