package ua.upsite.nso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.statics.Category;

import java.util.List;

/**
 *  Created by gregory on 11/25/15.
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("select c from Category c where c.published = true and c.showInMenu = true")
    List<Category> findMenuCategories();

    @Query("select c from Category c join fetch c.content where c.published = true")
    List<Category> findAllByPublishedIsTrue();
}
