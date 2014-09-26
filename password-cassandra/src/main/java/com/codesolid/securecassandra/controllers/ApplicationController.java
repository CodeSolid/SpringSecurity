package com.codesolid.securecassandra.controllers;

import com.codesolid.securecassandra.model.service.UserService;
import com.codesolid.securecassandra.security.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

//@Controller
// It's important that this controller not map any URLs since it serves as a base controller.
public class ApplicationController {
    // Todo implement
    @Autowired
    //protected UserService userService;

    protected SiteUser getSiteUser() {
        SiteUser user = null;
        // todo implement
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (! (authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            user = (SiteUser) userDetails;
        }
        */
        return user;
    }
}
