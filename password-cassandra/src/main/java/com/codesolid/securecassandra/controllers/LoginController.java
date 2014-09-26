package com.codesolid.securecassandra.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Scope("session")
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @Scope("session")
    @RequestMapping(value = "/api/login", method=RequestMethod.GET)
    public String apiLogin(ModelMap model) {
        return "/api/login";
    }

    @RequestMapping(value="/error_login", method=RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("error", true);
        return modelAndView;
    }

}
