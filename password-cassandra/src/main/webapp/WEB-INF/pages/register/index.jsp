<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div id="plain_header">
    <h1>Register</h1>
</div>
<div class="plain_small_centered">
<form:form id="registrationForm" modelAttribute="user" method="POST" action="/register" >

    <div class="container clearfix formelem_bottom_margin">
        <div class="three columns bottom_align"><label>Email address:</label></div>
        <div class="five columns">
            <form:input path="email" type="text" size="45" maxlength="240" id="email" />
            <form:errors path="email" cssClass="error_block" />
        </div>
    </div>

    <div class="container clearfix formelem_bottom_margin">
        <div class="three columns"><label>Password:</label></div>
        <div class="five columns">
            <form:input path="password" type="password" showPassword="true" size="45" maxlength="240" id="password" />
            <label>(Between 6 and 20 characters)</label>
            <form:errors path="password" cssClass="error_block" />
        </div>
    </div>

    <div class="container clearfix formelem_bottom_margin">
        <div class="three columns"><label>Re-enter password:</label></div>
        <div class="five columns">
            <form:input path="passwordConfirmation" type="password" showPassword="true" size="45" maxlength="240" id="passwordConfirmation" />
            <form:errors path="passwordConfirmation" cssClass="error_block" />
        </div>
    </div>

    <div class="container clearfix">
        <div class="five columns offset-by-three">
            <form:button type="submit" id="register" class="styled_button">Register</form:button>
        </div>
    </div>

</form:form>
</div>
</body>
</html>
