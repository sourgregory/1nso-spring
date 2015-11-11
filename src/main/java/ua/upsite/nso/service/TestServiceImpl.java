package ua.upsite.nso.service;

import org.hibernate.criterion.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.upsite.nso.model.Language;
import ua.upsite.nso.repository.TestRepository;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 *  Created by gregory on 11/9/15.
 */
@Service
public class TestServiceImpl implements TestService {

    @Inject
    private TestRepository repository;

    @Override
    public String sayHello() {
        ArrayList<Language> langs = (ArrayList<Language>) repository.findAll();

        StringBuilder builder = new StringBuilder();
        for (Language lang : langs) {
            builder.append(lang.getLocale()).append("\n");
        }

        return builder.toString();
    }

    @Override
    public Iterable<Language> showLanguages() {
        Iterable<Language> languages = repository.findAll(new Sort(Sort.Direction.ASC, "locale"));
        return languages;
    }

}
