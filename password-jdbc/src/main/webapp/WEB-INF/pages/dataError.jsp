<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype>
<html>
<head>
    <title>Not Found</title>
</head>
<body>
<div class="container">
    <div class="sixteen columns" >
        <h1>Object not found</h1>
        <p>Sorry, but it looks like what you're looking for isn't in the database.</p>
</div>

<% /* If you need scripts, uncomment this and remove from JSP tag.  I.e. remove this line and matching.
<content tag="myJavascript">
    <script type="text/javascript">
    </script>
</content>
*/ %>
</body>
</html>