<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div id="plain_header">
    <h1>Log In</h1>
</div>

<div class="plain_small_centered">
    <c:if test="${not empty error}">
        <div class="error_block">
            <p>Your login attempt was not successful, try again.  Error reason:<br />
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
            <c:if test= "${sessionScope[\"SPRING_SECURITY_LAST_EXCEPTION\"].message eq 'User is disabled'}">
                If you're seeing the "User is disabled" message, please make sure you have verified your email address.
                (A verification message was sent when you created your account).
            </c:if>
            <br />
        </div>
    </c:if>

<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
<c:if test="${not empty message}">
<div class="bottom-em">
    ${message}
</div>
</c:if>


    <div class="container clearfix formelem_bottom_margin">
        <div class="three columns bottom_align"><label>Email address:</label></div>
        <div class="five columns">
            <input type='text' name='j_username' size="60">
        </div>
    </div>
    <div class="container clearfix formelem_bottom_margin">
        <div class="three columns bottom_align"><label>Password:</label></div>
        <div class="five columns">
            <input type='password' name='j_password' size="60"/>
        </div>
    </div>
    <div class="container clearfix formelem_bottom_margin">
    <div class="column offset-by-three">
        <button name="submit" type="submit" value="submit" class="styled_button" />Submit</button>
    </div>
        </div>
    </table>
</form>
    </div>
</body>
</html>