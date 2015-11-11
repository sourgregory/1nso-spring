package ua.upsite.nso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.upsite.nso.model.Language;
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

    @RequestMapping(path = "/")
    public String hello(ModelMap model) {
        model.addAttribute("languages", service.showLanguages());
        return "languages";
    }
}
