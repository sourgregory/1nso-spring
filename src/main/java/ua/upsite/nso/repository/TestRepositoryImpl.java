package ua.upsite.nso.repository;

import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.Language;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *  Created by upsite on 10.11.15.
 */

@Repository
public class TestRepositoryImpl implements TestRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Iterable<Language> getAllLanguages() {
        return this.entityManager.createQuery(
                "select l from Language l order by l.name", Language.class
        ).getResultList();
    }
}
