package ua.upsite.nso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.upsite.nso.service.SecurityService;
import ua.upsite.nso.service.TestService;

import javax.inject.Inject;

/**
 *  Created by gregory on 11/9/15.
 */

@SuppressWarnings("unused")

@Controller
public class SiteController{

    @Inject
    TestService service;

    @Inject
    SecurityService securityService;

    @Transactional()
    @RequestMapping(path = "/")
    public String hello(ModelMap model) {
        model.addAttribute("languages", service.showLanguages());
        model.addAttribute("users", service.showUsers());
        model.addAttribute("currentUser", securityService.loadUserByUsername("sourgregory"));
        model.addAttribute("articles", service.showArticles());
        return "languages";
    }
}
