package ua.upsite.nso.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.upsite.nso.service.CategoryService;
import ua.upsite.nso.service.PageService;

import javax.inject.Inject;

/**
 *  Created by gregory on 11/20/15.
 */

@ControllerAdvice
public class PublicControllersAdvisor {

    @Inject
    PageService pageService;

    @Inject
    CategoryService categoryService;

    @ModelAttribute
    public void getMenuCategories(Model model) {
        model.addAttribute("menuPages", pageService.getMenuPages());
    }

    @ModelAttribute
    public void getMenuPages(Model model) {
        model.addAttribute("menuCategories", categoryService.getMenuCategories());
    }
}
