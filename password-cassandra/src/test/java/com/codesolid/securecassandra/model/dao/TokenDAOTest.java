package com.codesolid.securecassandra.model.dao;

import com.codesolid.securecassandra.misc.TestConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

public class TokenDAOTest {
    private ApplicationContext ac = TestConfiguration.getAppContext();

    @Before
    public void beforeTest() {
    }

    @After
    public void afterTest() {
    }


    @Test
    public void twoTokensNotEqual()  {
        TokenDAO dao = (TokenDAO) ac.getBean("tokenDAO");
        int tokenLen = 30;
        String s1 = dao.getRandomToken(tokenLen);

        String s2 = dao.getRandomToken(tokenLen);
        String s3 = dao.getRandomToken(tokenLen);
        String s4 = dao.getRandomToken(tokenLen);
        assertEquals(s1.length(), tokenLen);
        assertEquals(s2.length(), tokenLen);
        assert(s1.compareTo(s2) != 0);
        assert(s1.compareTo(s3) != 0);
        assert(s1.compareTo(s4) != 0);
    }

    @Test
    public void canAddTokenForUser()   {
        /* TODO implement
        String user = "test@johntestusers.org";
        TokenDAO dao = (TokenDAO) ac.getBean("tokenDAO");
        String token = dao.addTokenForUser(user, TokenDAO.TokenType.EMAIL_VERIFY);
        String user2 = dao.getUserForToken(token, TokenDAO.TokenType.EMAIL_VERIFY);
        assertEquals(user, user2);
        */
    }


}