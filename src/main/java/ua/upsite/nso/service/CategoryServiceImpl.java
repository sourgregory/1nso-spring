package ua.upsite.nso.service;

import org.springframework.stereotype.Service;
import ua.upsite.nso.model.statics.Category;

import javax.inject.Inject;

/**
 *  Created by gregory on 11/25/15.
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Inject
    CategoryRepository repository;

    @Override
    public Iterable<Category> getMenuCategories() {
        return repository.findMenuCategories();
    }
}
