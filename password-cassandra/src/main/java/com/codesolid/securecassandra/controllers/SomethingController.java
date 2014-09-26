package com.codesolid.securecassandra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class SomethingController
 * Map to default home page and have "/something" to get to when user logs in.
 */

@Controller
public class SomethingController {
    @RequestMapping("/")
    public String getHomePage() {
        return "index";
    }

    // Change to Widgets, EyeWidgets, or what have you.
    @RequestMapping("/something")
    public String getMainApplicationPage() {
        return "something/index";
    }
}
