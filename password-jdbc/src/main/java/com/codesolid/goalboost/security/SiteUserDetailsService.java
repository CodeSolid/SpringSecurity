package com.codesolid.goalboost.security;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.dao.NonTransientDataAccessResourceException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class SiteUserDetailsService
 * Description:
 */
public class SiteUserDetailsService extends JdbcUserDetailsManager {
    /*  TODO: At this point we need to use our jdbcTemplate member variable
        using not RowMapper but the more custom one?  Or see below
     */


    @Override
    // TODO Note it is the caller's responsibility to ensure user does not already
    // exist.  -- Need to review code to ensure compliance and / or change.
    public void createUser(UserDetails userDetails){
        SiteUser siteUser = (SiteUser) userDetails;
        if (siteUser.getId() != 0)
        {
            throw new UnsupportedOperationException("SiteUserDetailsService.createUser: user with id " + new Long(siteUser.getId()).toString() + " has already been created!  CreateUser not supported, use updateUser instead.");
        }

        String password = new StandardPasswordEncoder().encode(siteUser.getPassword());
        String sql = "INSERT INTO users(username, password, enabled) values(?, ?, ?)";
        getJdbcTemplate().update(sql, siteUser.getUsername(), password, siteUser.isEnabled());
    }

    public void enableUser(String userName, boolean enabled) {
        String sql = "UPDATE users set enabled = ? where username = ?";
        getJdbcTemplate().update(sql, new Object[] {enabled, userName});
    }

    @Override
    public void updateUser(UserDetails details) {
        super.updateUser(details);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        List <SiteUser> users = new ArrayList<SiteUser>();
        try {
        String sql = "select id, name, username, password, enabled from users where username = ?";
        SiteUserRowMapper mapper = new SiteUserRowMapper();
        mapper.setJdbcTemplate(getJdbcTemplate());
        users = getJdbcTemplate().query(sql, new Object[] {username}, mapper);
        }
        catch(Exception e) {
            throw new NonTransientDataAccessResourceException("There was an error connecting to the database.  Please try again later.");
        }
        if (users.size() == 0) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }

        return users.get(0);
    }

}

class SiteUserRowMapper implements RowMapper<SiteUser>
{
    JdbcTemplate jdbcTemplate;  // To use AccountDao to retrive nested object

    public void setJdbcTemplate(JdbcTemplate template) {
        jdbcTemplate = template;
    }


    @Override
    public SiteUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        SiteUser user = new SiteUser();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setEnabled(rs.getBoolean("enabled"));
        user.setPassword(rs.getString("password"));
        return user;
    }


}

