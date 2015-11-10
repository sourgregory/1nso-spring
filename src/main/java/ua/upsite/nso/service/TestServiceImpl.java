package ua.upsite.nso.service;

import ua.upsite.nso.model.Language;
import ua.upsite.nso.repository.TestRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  Created by gregory on 11/9/15.
 */
//@Service
public class TestServiceImpl implements TestService {

    @Inject
    private TestRepository repository;

    @Override
    public String sayHello() {
        ArrayList<Language> langs = (ArrayList<Language>) repository.getAllLanguages();

        StringBuilder builder = new StringBuilder();
        for (Language lang : langs) {
            builder.append(lang.getLocale()).append("\n");
        }

        return builder.toString();
    }
}
