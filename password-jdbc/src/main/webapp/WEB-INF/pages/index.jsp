<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype>
<html>
<head>
    <title>GoalBoost.com - Track Your Goals, Share Your Progress</title>
</head>
<body>
<div class="container">
    <div class="home-widespan sixteen columns" >
        <h1>Something Something My Killer App </h1>
        <p>Do something awesome.  Start by making this page look like every other dumb bootstrap page.</p>

        <%
            /* <div style="text-align: right;padding-top:0px;padding-right:20px;"> */
            /* /signin/twitter and /signin/facebook from ProviderSignInController.
               http://docs.spring.io/spring-social/docs/1.0.x/api/org/springframework/social/connect/web/ProviderSignInController.html
             */
        %>

        <div style="text-align: right;padding-top:0px;padding-right:20px;">
            <form action="/register" method="GET"><button  type="submit" id="Register" class="styled_button" style="width:250px;font-size:14pt;">Create an Account</button><br />&nbsp;</form>
            <form id="tw_signin2" action="<c:url value="/signin/twitter"/>" method="POST"><button  id="Register" type="submit" class="signin_twitter" /></form><br />&nbsp;<br />
            <form action="<c:url value="/signin/facebook"/>" method="POST"><button  id="Register" type="submit" class="signin_facebook" /></form><br />&nbsp;<br />
        </div>
        <br />&nbsp;<br />
    </div>
</div>
<div class="container" >
    <%
        /* To do -- make your marketing team do some work.  Here's where */
    %>
    <div class="one-third column front_column " >
        <h3>Feature 1</h3>
        <p>It's Uber-Awesome!</p>

    </div>
    <div class="one-third column front_column" >
        <h3>Feature 2</h3>
        <p>Re-cycled electrons.  No global warming.</p>

    </div>
    <div class="one-third column front_column">
        <h3>Feature Need I Say It?  3!</h3>
        <p>Extra fracking.</p>
    </div>
</div>

<content tag="myJavascript">
    <script type="text/javascript"></script>
</content>

</body>
</html>