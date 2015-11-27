package ua.upsite.nso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.upsite.nso.service.CategoryService;
import ua.upsite.nso.service.PageService;

import javax.inject.Inject;

/**
 *  Created by gregory on 11/9/15.
 */

@SuppressWarnings("unused")

@Controller
public class SiteController{

    @Inject
    CategoryService categoryService;

    @Inject
    PageService pageService;

    @Transactional()
    @RequestMapping(path = {"/", "/index"})
    public String hello(ModelMap model) {
        model.addAttribute("categories", categoryService.getPublishedCategories());
        model.addAttribute("indexPage", pageService.getIndexPage());
        return "statics/index";
    }
}
