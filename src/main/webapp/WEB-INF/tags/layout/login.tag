<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ include file="/WEB-INF/view/jsp/base.jspf" %>

<layout:main htmlTitle="${htmlTitle}" bodyTitle="${bodyTitle}">
    <jsp:attribute name="headContent">
        <link rel="stylesheet"
              href="<c:url value="/resources/css/login.css" />" />
    </jsp:attribute>
        <jsp:attribute name="navigationContent" />
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:main>
