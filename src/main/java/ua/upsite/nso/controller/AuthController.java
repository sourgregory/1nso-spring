package ua.upsite.nso.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.upsite.nso.model.security.LoginForm;

/**
 * Created by gregory on 11/16/15.
 */

@Controller
public class AuthController {

    @RequestMapping(value = "login"/*, method = RequestMethod.GET*/)
    public ModelAndView login()
    {
        if(SecurityContextHolder.getContext().getAuthentication() instanceof UserDetails )
            return new ModelAndView(new RedirectView("/admin", true, false));

        ModelAndView model = new ModelAndView();
        model.addObject("loginForm", new LoginForm());
        model.setViewName("login");

        return model;
    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");

        return model;

    }

}
