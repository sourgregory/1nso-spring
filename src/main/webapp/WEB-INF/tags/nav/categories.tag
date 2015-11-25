<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfToken"--%>

<nav id="w2" class="navbar-inverse navbar-fixed-top navbar" role="navigation">
    <div class="container">

        <%--<div class="navbar-header">--%>
            <%--<input class="navbar-toggle" data-target="#w2-collapse" data-toggle="collapse" type="button">--%>
        <%--</div>--%>

        <div id="w2-collapse" class="collapse navbar-collapse">
            <ul id="w3" class="nav nav-tabs nav-justified ">
                <c:forEach var = "category" items="${menuCategories}">
                <li>
                    <a href="<c:url value="/category/${category.slug}">">
                        <img src="<c:url value="/resources/img/${category.content.icon}"/>" alt="[icon]"/>
                        ${}
                    </a> ('@web/images/icons/'.$category->getIcon(),
                    ['alt' => $category->getTitle()]).$category->getTitle(),
                    Url::to(['cat-articles/view', 'name' => $category->getSlug()])) ?>
                </li>
                <?php endforeach; ?>
            </ul>
        </div>
    </div>
</nav>