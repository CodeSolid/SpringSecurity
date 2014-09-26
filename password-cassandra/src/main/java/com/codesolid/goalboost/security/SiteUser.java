package com.codesolid.goalboost.security;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Class SiteUser
 * Description:
 */
// @ValidSiteUser()
public class SiteUser extends User  {

    private boolean enabled;

    private String name;

    public SiteUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public SiteUser() {
        this("guest@guestaculous.net", "5950fdef2ec5e081d21b23e61f14340c006c9905da7038c109f9364deb3c6442121965af32ecfaf4", true, true, true, true, new ArrayList<GrantedAuthority>(1));

    }

    @NotEmpty(message = "Email address may not be empty")
    @Email(message = "Not a valid email address")
    private String email;       /* email and username are equivalent */

    @NotEmpty(message = "Password may not be empty")
    @Length(min=8, max=20, message="Password must contain between eight and twelve characters")
    private String password;

    @NotEmpty(message = "Password confirmation may not be empty")
    @Length(min=8, max=20, message="Password confirmation must contain between eight and twelve characters")
    private String passwordConfirmation;

    private long id;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail()  {
        return email;
    }

    public void setUsername(String username) {
        setEmail(username);
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    /* Does validation beyond what the JSR-style validations do */
    public void validate(BindingResult result, SiteUserDetailsService userDetailsService) {
        if (userDetailsService.userExists(getUsername())) {
            result.addError(new FieldError("user", "email", "An account already exists with the email address " + getUsername()));
        }

        if (getPassword().compareTo(getPasswordConfirmation()) != 0) {
            result.addError(new FieldError("user", "password", "The passwords you entered do not match"));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

