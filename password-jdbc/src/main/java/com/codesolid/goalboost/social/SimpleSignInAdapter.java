package com.codesolid.goalboost.social;

/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codesolid.goalboost.security.SiteUser;
import com.codesolid.goalboost.security.SiteUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class SimpleSignInAdapter implements SignInAdapter {

    private final RequestCache requestCache;
    SiteUserDetailsService siteUserDetailsService;


    @Inject
    public SimpleSignInAdapter(RequestCache requestCache, SiteUserDetailsService siteUserDetailsService) {
        this.siteUserDetailsService = siteUserDetailsService;
        this.requestCache = requestCache;
    }

    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
        Logger logger = LoggerFactory.getLogger(SimpleSignInAdapter.class);
        logger.info("Inside SimpleSignInAdapter.signIn, localUserId = " + localUserId == null ? "NULL" : localUserId);
        logger.info("Getting security context.");
        SecurityContext context = SecurityContextHolder.getContext();
        logger.info("Calling loadUserByUserName.");
        UserDetails user = siteUserDetailsService.loadUserByUsername(localUserId);
        logger.info("Creating UserPasswordAuthenticationToken.");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, null);
        logger.info("Setting token on context");
        context.setAuthentication(token);
        logger.info("Returning null");
        return null;
        //return extractOriginalUrl(request);
    }

    private String extractOriginalUrl(NativeWebRequest request) {
        HttpServletRequest nativeReq = request.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse nativeRes = request.getNativeResponse(HttpServletResponse.class);
        SavedRequest saved = requestCache.getRequest(nativeReq, nativeRes);
        if (saved == null) {
            return null;
        }
        requestCache.removeRequest(nativeReq, nativeRes);
        removeAuthenticationAttributes(nativeReq.getSession(false));
        return saved.getRedirectUrl();
    }

    private void removeAuthenticationAttributes(HttpSession session) {
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

}