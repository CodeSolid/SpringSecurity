package com.codesolid.securecassandra.model.dao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service(value="tokenDAO")
public class TokenDAO extends DAOBase {
    public enum TokenType { EMAIL_VERIFY, PASSWORD_RESET } ;

    public String getRandomToken(int len) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int c = rand.nextInt(52);
            char chRandom;
            if (c < 26)
                chRandom = (char) ('A' + c);
            else
                chRandom = (char) ('a' - 26  + c );
            sb.append(chRandom);
        }
        return sb.toString();
    }

    public String addTokenForUser(String userName, TokenType tokenType) {

        int typeNumber = tokenType.ordinal();
        // TODO implement
        String randToken = getRandomToken(30);
        /* getJdbcTemplate().update("INSERT into tokens(token, userName, tokenType) values (?, ?, ?)",
                new Object[] { randToken, userName, typeNumber} );
        */
        return randToken;
    }

    public String getUserForToken(String token, TokenType tokenType) {
        String trimmedToken = token.trim();
        int typeNumber = tokenType.ordinal();
        String user = null;
        try {
            /* TODO implement
            user = getJdbcTemplate().queryForObject("SELECT userName from tokens WHERE token = ? and tokenType = ?",
                new Object[] {trimmedToken, typeNumber}, String.class);
           */
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }
}
