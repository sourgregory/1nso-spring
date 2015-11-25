package ua.upsite.nso.service;

import org.springframework.stereotype.Service;
import ua.upsite.nso.model.statics.Page;
import ua.upsite.nso.repository.PageRepository;

import javax.inject.Inject;

/**
 *  Created by gregory on 11/25/15.
 */

@Service
public class PageServiceImpl implements PageService{

    @Inject
    private PageRepository repository;

    @Override
    public Iterable<Page> getMenuPages() {
        return repository.findMenuPages();
    }
}
