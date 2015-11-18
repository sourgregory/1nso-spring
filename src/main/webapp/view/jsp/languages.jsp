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
    <spring:message code="ruslan.for" var="ruslan"/>
    <p><spring:message code="test.message" arguments="${ruslan}"/></p>
    <br>

    <p>Users registered</p>
    <c:forEach var="user" items="${users}">
        <p>${user.userName}</p>
        <p>${user.email}</p>
        <p>${user.createdAt}</p>
        <p>--------------------------</p>
    </c:forEach>
</body>
</html>
