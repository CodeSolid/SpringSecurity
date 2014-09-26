/*
package com.codesolid.goalboost.security;

import sun.reflect.annotation.AnnotationType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target( {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SiteUserValidator.class)
@Documented
public @interface ValidSiteUser {

    String message() default "{validator.validSiteUser}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
*/