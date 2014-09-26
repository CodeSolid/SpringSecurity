package com.codesolid.goalboost.controllers;

import com.codesolid.goalboost.configuration.SocialConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
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
