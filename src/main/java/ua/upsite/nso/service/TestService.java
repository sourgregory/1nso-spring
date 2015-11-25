package ua.upsite.nso.service;

import ua.upsite.nso.model.Language;
import ua.upsite.nso.model.User;
import ua.upsite.nso.model.statics.Article;

/**
 *  Created by gregory on 11/9/15.
 */
public interface TestService {
    String sayHello();

    Iterable<Language> showLanguages();
    Iterable<User> showUsers();

    Iterable<Article> showArticles();

}
