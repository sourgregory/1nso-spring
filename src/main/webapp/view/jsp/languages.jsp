<%@ page import="ua.upsite.nso.model.Language" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gregory
  Date: 11/11/15
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/site.css"/>" />
    <title>Test</title>
</head>
<body>
    <p>Доступные языки:</p>
        <c:forEach var="language" items="${languages}">
            <p>${language.name}</p>
            <p>${language.locale}</p>
        </c:forEach>
    <p><spring:message code="test.message"/></p>
</body>
</html>
