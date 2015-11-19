package ua.upsite.nso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.Language;

/**
 *  Created by gregory on 11/10/15.
 */

@Repository
public interface TestRepository extends JpaRepository<Language, Long>{

}
