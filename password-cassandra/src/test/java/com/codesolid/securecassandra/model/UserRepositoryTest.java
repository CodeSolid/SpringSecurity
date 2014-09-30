package com.codesolid.securecassandra.model;

import com.codesolid.securecassandra.misc.TestConfiguration;
import com.codesolid.securecassandra.model.dto.User;
import com.codesolid.securecassandra.model.repository.UserRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    UserRepository repository;

    @Before
    public void Before()  {
        ApplicationContext ac = TestConfiguration.getAppContext();
        repository = (UserRepository) ac.getBean("userRepository");
    }
    @Test
    public void canSaveAndLoadOneUser() {
        User user = new User();
        user.setEmail("john.lockwood@DataStax.com");
        user.setPassword("Here's hoping 2014, hashed");
        user.setEnabled(true);
        repository.update(user);
        User user2 = repository.selectOne("john.lockwood@DataStax.com");
        assertEquals(user.getPassword(), user2.getPassword());
    }

}