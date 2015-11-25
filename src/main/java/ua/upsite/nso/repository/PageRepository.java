package ua.upsite.nso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.statics.Page;

import java.util.ArrayList;

/**
 *  Created by gregory on 11/25/15.
 */

@Repository
public interface PageRepository extends JpaRepository<Page, Long>{

    @Query("select p from Page p where p.published=true and p.showInMenu=true order by p.sortWeight asc")
    ArrayList<Page> findMenuPages();
}
