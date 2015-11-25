package ua.upsite.nso.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.statics.Category;

import java.util.ArrayList;

/**
 *  Created by gregory on 11/25/15.
 */

@Repository
public interface CategoryRepository {

    @Query("select c from Category c where c.published = true and c.showInMenu = true")
    ArrayList<Category> findMenuCategories();
}
