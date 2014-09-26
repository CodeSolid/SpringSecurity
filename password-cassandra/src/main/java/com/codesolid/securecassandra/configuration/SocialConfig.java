package com.codesolid.securecassandra.configuration;

import com.codesolid.securecassandra.security.SiteUserDetailsService;
import com.codesolid.securecassandra.social.SimpleSignInAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import javax.inject.Inject;

@Configuration
public class SocialConfig {

    //@Autowired
    //SiteUserDetailsService siteUserDetailsService;

    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }

    @Bean
    @Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES)
    public UsersConnectionRepository usersConnectionRepository() {
//        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(),
//                textEncryptor());
        return null;
    }



    @Bean
    @Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();

        registry.addConnectionFactory(new TwitterConnectionFactory(
                "<yourTwitterConsumerKey>", "<yourTwitterConsumerSecret>"));

        registry.addConnectionFactory(new FacebookConnectionFactory("<yourFacebookConsumerKey>",
                "<yourFacebookConsumerSecret>"));

        return registry;
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
        }

        return usersConnectionRepository().createConnectionRepository(authentication.getName());
    }

    @Bean
    public ConnectController connectController() {
        ConnectController c = new ConnectController(connectionFactoryLocator(),
                connectionRepository());
        c.setApplicationUrl("http://www.securecassandra.com");
        return c;
    }

    @Bean
    public ProviderSignInController providerSignInController() {
        /* todo implement
        RequestCache requestCache = new HttpSessionRequestCache();
        ProviderSignInController controller = new ProviderSignInController(connectionFactoryLocator(),
                usersConnectionRepository(), new SimpleSignInAdapter(requestCache, siteUserDetailsService));
        controller.setSignInUrl("/login");
        controller.setSignUpUrl("/register");
        return controller;

        */
        return null;
    }


    @Inject
    private Environment environment;
}
