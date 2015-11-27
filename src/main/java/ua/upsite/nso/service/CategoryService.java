package ua.upsite.nso.service;

import ua.upsite.nso.model.statics.Category;

import java.util.List;

/**
 *  Created by gregory on 11/25/15.
 */
public interface CategoryService {
    Iterable<Category> getMenuCategories();

    List<Category> getPublishedCategories();
}
