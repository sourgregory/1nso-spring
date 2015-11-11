package ua.upsite.nso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.upsite.nso.model.Language;

/**
 *  Created by gregory on 11/10/15.
 */

public interface TestRepository extends JpaRepository<Language, Long>{

}
