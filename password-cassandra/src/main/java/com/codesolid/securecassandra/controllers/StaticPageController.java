package com.codesolid.securecassandra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticPageController {
    @RequestMapping("/template")
        public String getTemplate() {
            return "/static/template";
        }

    @RequestMapping("/benefit1")
    public String benefit1() {
        return "/static/benefit1";
    }

    @RequestMapping("/benefit2")
    public String benefit2() {
        return "/static/benefit2";
    }

    @RequestMapping("/benefit3")
    public String benefit3() {
        return "/static/benefit3";
    }

}
