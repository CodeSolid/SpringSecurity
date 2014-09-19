

package com.codesolid.goalboost.misc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 */
public class TestConfiguration {
    static ApplicationContext appContext = null;
    static DriverManagerDataSource dataSource;

    static public ApplicationContext getAppContext() {
        if (appContext == null)
            appContext = new FileSystemXmlApplicationContext("file:src/main/webapp/WEB-INF/spring-config.xml");
        return appContext;
    }

    static public DriverManagerDataSource getDataSource() {
        ApplicationContext ac = getAppContext();
        if (dataSource == null)
            dataSource = (DriverManagerDataSource) ac.getBean("dataSource");
        return dataSource;
    }

    static public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(TestConfiguration.getDataSource());
    }

    static public String getTestUserEmail() {
        return "test@johntestusers.org";
    }

    static public String getTestUserPassword() {
        return "6kenpBYxZ5#";
    }

}
