package com.codesolid.securecassandra.model.dto;

import com.datastax.driver.mapping.annotations.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.Column.*;



/**
 * Created by john on 9/28/14.
 */
@Table(value = "users")
public class User {

    @PrimaryKey
    private String email;

    @org.springframework.data.cassandra.mapping.Column(value = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}


