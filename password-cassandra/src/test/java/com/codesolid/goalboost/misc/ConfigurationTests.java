package com.codesolid.goalboost.misc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class ConfigurationTests {

    public ConfigurationTests() {
        super();
    }

    @Test
    public void TestConfigurationGetAppContext() {
        ApplicationContext ac = TestConfiguration.getAppContext();
        assertNotNull(ac);
    }

    @Test
    public void TestConfigurationGetDataSource() {
        DataSource ds  = TestConfiguration.getDataSource();
        assertNotNull(ds);
    }


    @Test
    public void TestConfigurationGetJdbcTemplate() {
        JdbcTemplate template = TestConfiguration.getJdbcTemplate();
        assertNotNull(template);
    }
}
