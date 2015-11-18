package ua.upsite.nso.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *  Created by gregory on 11/13/15.
 */

@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Iterable<User> findOrderByUserName() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        System.out.println("INFO: Selecting all users from db... ");
        return query.getResultList();
    }

    public User findByName(String name) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.userName = :name", User.class);
        query.setParameter("name", name);
        Object result = query.getSingleResult();
        if (result != null) {
            return (User) result;
        }
        return null;
    }
}
