package ua.upsite.nso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  Created by gregory on 11/16/15.
 */

@Controller
public class AdminController {

    @ResponseBody
    @RequestMapping("/admin")
    String test() {
        return "Successful";
    }
}
