package com.codesolid.securecassandra.misc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;



public class ConfigurationTests {

    public ConfigurationTests() {
        super();
    }

    @Test
    public void TestConfigurationGetAppContext() {
        ApplicationContext ac = TestConfiguration.getAppContext();
        assertNotNull(ac);
    }


}
