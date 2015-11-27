<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav id="w0" class="navbar-inverse nlkvdavbar-fixed-top navbar" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" data-target="#w0-collapse" data-toggle="collapse" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">
                <img alt="[1nso]" src="/images/icons/logo_nso.png">
                1nso
            </a>
        </div>
        <div id="w0-collapse" class="collapse navbar-collapse">
            <ul id="w1" class="navbar-nav navbar-right nav">
                <c:forEach var="page" items="${menuPages}">
                    <li><a href="<c:url value="/page/${page.content.slug}"/>">${page.content.title}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</nav>