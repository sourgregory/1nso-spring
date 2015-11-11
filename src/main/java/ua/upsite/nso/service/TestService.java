package ua.upsite.nso.service;

import ua.upsite.nso.model.Language;

/**
 *  Created by gregory on 11/9/15.
 */
public interface TestService {
    String sayHello();

    Iterable<Language> showLanguages();
}
