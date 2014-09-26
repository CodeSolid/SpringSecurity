/*
 *  ApplicationConfiguration object.
 *  To use in a JSP, use ${requestScope.applicationConfiguration}, for example,
 *  <p>requestScope.applicationConfiguration.urlBase</p> will display
  *  <p>http://localhost:8080</p> when running in test.
 */

package com.codesolid.securecassandra.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value="applicationConfiguration")
public class ApplicationConfiguration {

    private String applicationName;
    private String databaseUser;
    private String emailFrom;
    private String urlBase;

    // This property is set in common.properties and will be the same
    // for all environments, test, production, etc.
    @Value("${application.name}")
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    // In contrast, this property and other database related properties
    // are quite likely different in test and production.
    @Value("${database.username}")
    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getApplicationName() {
        return applicationName;
    }

    @Value("${email.from}")
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public String getUrlBase() {
        return urlBase;
    }

    @Value("${url.base}")
    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }
}
