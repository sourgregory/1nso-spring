package ua.upsite.nso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.upsite.nso.service.TestService;

/**
 *  Created by gregory on 11/9/15.
 */

@SuppressWarnings("unused")

@Controller
public class SiteController {

    @Autowired
    TestService service;

    @ResponseBody
    @RequestMapping(path = "/")
    public String hello() {
        return service.sayHello();
    }
}
