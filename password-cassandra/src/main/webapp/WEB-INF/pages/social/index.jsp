<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype>
<html>
<head>
    <title>Connect to Twitter</title>
</head>
<body>
<div>
    <h1>Connect</h1>
    <a href="<c:url value="/connect/twitter/" />">Connect to Twitter</a>
</body>
</html>