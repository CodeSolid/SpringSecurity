SpringSecurity
==============

This is the source code for a forthcoming presentation about Spring Security.  Please pardon the very "in-the-interim" state of this repsitory.

The plan for the presentation is to include:

* A drop-dead-simple demo showing how to set up basic http authentication in a few minutes using Spring Boot.  This is already here as branches step1 - step3.
* A starter app for password-based security using a UserDetails service.  We will also add the ability to log in using Facebook or Twitter.  This code will 
be an abstraction of the security layer of [Goalboost](http://www.goalboost.com)'s use of Spring Security, which time permitting will be made more Spring-Boot like (use Java configuration in lieu of XML).
* Password-based security revisited:  now let's use Casandra, because the future belongs to DataStax.
* Information about role-based security (authorization) and security annotations.
* An Oauth2 demo "based on" (or perhaps consisting of), Roy Clarkson's [Spring Oauth REST Service](https://github.com/royclarkson/spring-rest-service-oauth) starter project (Also available here as spring-rest-service-oauth directory, using "git branch oauth").

And maybe:

* Some sort of LDAP example
