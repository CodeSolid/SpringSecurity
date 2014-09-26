package com.codesolid.securecassandra.controllers;

import com.codesolid.securecassandra.configuration.SocialConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: John Lockwood
 * Date: 8/21/13
 * Time: 12:48 PM
 */
@Controller
public class SocialController {

    @Autowired
    SocialConfig socialConfig;

    @RequestMapping("/social")
    public String getIndex() {
        return "/social/index";
    }

    // Just sends a test tweet -- works well.
    @RequestMapping("/twitter/tweetSomething")
    public String getSomething() {

        Connection<Twitter> connection = socialConfig.connectionRepository().findPrimaryConnection(Twitter.class);
        if (connection != null)
        {
            Twitter twitter = connection.getApi();
            String tweetText = "Doing some basic tweet testing using SpringSocial from http://www.GoalBoost.com";
            twitter.timelineOperations().updateStatus(tweetText);
        }
        return "index";
    }

}
