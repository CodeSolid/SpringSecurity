

package com.codesolid.securecassandra.misc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 *
 */
public class TestConfiguration {
    static ApplicationContext appContext = null;

    static public ApplicationContext getAppContext() {
        if (appContext == null)
            appContext = new FileSystemXmlApplicationContext("file:src/main/webapp/WEB-INF/spring-config.xml");
        return appContext;
    }


    static public String getTestUserEmail() {
        return "test@johntestusers.org";
    }

    static public String getTestUserPassword() {
        return "6kenpBYxZ5#";
    }

}
