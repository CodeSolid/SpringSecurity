<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype>
<html>
    <body>

    <form action="/connect/facebook" method="POST">
    <p>You haven't created any connections with Twitter yet. Click the button to create
        a connection between your account and your Twitter profile.
        (You'll be redirected to Twitter where you'll be asked to authorize the connection.)</p>
    <p><button type="submit" class="signin_facebook" >
    </button></p>
    </form>
    </body>
</html>