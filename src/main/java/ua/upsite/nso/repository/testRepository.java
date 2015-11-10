package ua.upsite.nso.repository;

import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.Language;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

/**
 *  Created by gregory on 11/10/15.
 */


public class testRepository {
    @PersistenceContext EntityManager entityManager;

    public ArrayList<Language> getAllLanguages() {
    }

}
