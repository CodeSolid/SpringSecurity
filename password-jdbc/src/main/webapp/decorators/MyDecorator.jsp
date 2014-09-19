<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<decorator:usePage id="thePage" />
<% String myJavascript = thePage.getProperty("page.myJavascript"); %>
<jsp:useBean id="now" class="java.util.Date" scope="page" />
<!DOCTYPE html>
<html>
<head>
    <title><decorator:title default="SiteMesh Integration"/></title>
    <link rel="stylesheet" type="text/css" href="${applicationConfiguration.urlBase}/resources/css/site.css?version=${now.time}" />
    <link href="${applicationConfiguration.urlBase}/resources/css/smoothness/jquery-ui-1.10.3.custom.css?version=${now.time}" type="text/css" rel="stylesheet">
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/favicon.ico" type="image/x-icon">
    <decorator:head/>
    ${pageContext.request.contextPath}
    ${applicationScope.pageContext.request.contextPath}
    ${requestScope.pageContext.servletContext.contextPath}
    <!-- Allow older IE versions to style semantic elements -->
    <!--[if lt IE 9]>
    <script>
        var e = ("abbr,article,aside,audio,canvas,datalist,details," +
                "figure,footer,header,hgroup,mark,menu,meter,nav,output," +
                "progress,section,time,video").split(',');
        for (var i = 0; i < e.length; i++) {
            document.createElement(e[i]);
        }
    </script>
    <![endif]-->
</head>
<body>

<nav class="nav_bordered">
    <sec:authorize access='isAnonymous() or hasRole("guest")'>
    <ul style="text-align:center">
        <li><a href="/">Home</a></li>
        <!--<li><a href="/projects">Projects</a></li>
        <li><a href="/goals">Goals</a></li> -->
    </ul>
        <span id="signin_out"><a href="/login">Sign In</a></span>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <ul style="text-align:center">
            <!-- <li><a href="/">Today</a></li> -->
            <li><a href="/something">Something</a></li>
            <li><a href="/projects">Projects</a></li>
        </ul>
        <sec:authentication var="userDetails" property="principal" />
        <span id="signin_out">Signed in as: ${userDetails.username}&nbsp;&nbsp;&nbsp;<a href="/j_spring_security_logout">Sign Out</a></span>
    </sec:authorize>
</nav>


<article class="container">
    <decorator:body/>
</article>

<footer>

</footer>

<% if(myJavascript != null){ %>
    <script src="${requestScope.applicationConfiguration.urlBase}/resources/js/jquery.min.js"></script>
    <script src="${requestScope.applicationConfiguration.urlBase}/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
    <decorator:getProperty property="page.myJavascript"/>
<% } %>
</body>
</html>