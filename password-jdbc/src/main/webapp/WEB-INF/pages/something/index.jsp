<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Untitled Document</title>
</head>
<body>

<h1>Your Killer App goes here</h1>
<p>Just add code.</p>

<% /* The following content tag currently must NOT be commented out.
    It causes a problem with the "who's logged in" display.
   Need to fix that. */
%>
<content tag="myJavascript">
    <script type="text/javascript">
    </script>
</content>

</body>
</html>
