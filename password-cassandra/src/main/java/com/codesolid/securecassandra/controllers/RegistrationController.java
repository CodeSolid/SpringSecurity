package com.codesolid.securecassandra.controllers;

import com.codesolid.securecassandra.configuration.ApplicationConfiguration;
import com.codesolid.securecassandra.mail.SignOnEmailVerification;
import com.codesolid.securecassandra.model.dao.TokenDAO;
import com.codesolid.securecassandra.security.SiteUser;
import com.codesolid.securecassandra.security.SiteUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;

@Controller
public class RegistrationController {

    // TODO implement
    //@Autowired
    //private SiteUserDetailsService userDetailsService;

    @Autowired
    TokenDAO tokenDAO;

    @Autowired
    ApplicationConfiguration config;

    @Autowired
    SignOnEmailVerification signOnEmailVerification;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(@Valid @ModelAttribute("user") SiteUser user,
                              BindingResult result, ModelMap map) {
        /*
        // todo implement
        user.validate(result, userDetailsService);
        if (result.hasErrors())     {
            return "register/index";
        }
        */
        saveUser(user);
        String emailVerificationLink = saveTokenAndGetLink(user, config.getUrlBase());
        sendEmailConfirmation(user.getEmail(), emailVerificationLink);

        map.addAttribute("email", user.getEmail());

        return "register/success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String index(ModelMap model)  {
        model.addAttribute("user", new SiteUser());
        return "register/index";
    }

    private void saveUser(SiteUser user) {
        /*user.setEnabled(false);
        userDetailsService.createUser(user);
        */
        // TODO implement
    }

    private String saveTokenAndGetLink(SiteUser user, String rootURL) {
        String token = tokenDAO.addTokenForUser(user.getUsername(), TokenDAO.TokenType.EMAIL_VERIFY);
        return rootURL + "/register/verifyEmail/" + token;
    }

    @RequestMapping(value="/register/verifyEmail/{token}")
    public String verifyEmail(ModelMap map, @PathVariable("token") String token) {
        // TODO implement
        /*
        String userName = tokenDAO.getUserForToken(token, TokenDAO.TokenType.EMAIL_VERIFY);
        userDetailsService.enableUser(userName, true);
        map.addAttribute("message", "Email address verified.  You may now log in using the email address and password you created.");
        return "/login";
        */
        return "/login";
    }

    @Async
    public void sendEmailConfirmation(String email, String verificationLink) {

        signOnEmailVerification.setApplicationName(config.getApplicationName());
        signOnEmailVerification.setEmailFrom(config.getEmailFrom());
        signOnEmailVerification.sendEmail(email, verificationLink);
    }

}
