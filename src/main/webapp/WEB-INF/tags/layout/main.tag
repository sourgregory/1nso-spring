<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfToken"--%>
<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>

<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true" required="false" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true" required="false" %>
<%@ attribute name="headContent" fragment="true" required="false" %>
<%@ attribute name="navigationContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/view/jsp/base.jspf" %>

<jsp:useBean id="now" class="java.util.Date"/>

<!DOCTYPE html>

    <html lang="">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><spring:message code="1nso" /> :: <c:out value="${fn:trim(htmlTitle)}" /></title>
        <%--<link href="http://1nso.loc//assets/45b0e787/css/bootstrap.css" rel="stylesheet"/>--%>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/site.css" />" rel="stylesheet" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="/resources/javascript/script.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <jsp:invoke fragment="headContent" />
    </head>

    <body>
        <!-- Google Tag Manager -->
        <noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-THHVPM"
                      height="0" width="0" style="display:none;visibility:hidden"></iframe>
        </noscript>
        <script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
                new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
                j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
                '//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
                })(window,document,'script','dataLayer','GTM-THHVPM');
        </script>
        <!-- End Google Tag Manager -->

        <div class="wrap">
            <nav:pages/>
            <nav:categories/>
            <%--<?= CategoriesMenu::widget() ?>--%>

            <div class="container">
                <%--<?= Breadcrumbs::widget([--%>
                    <%--'links' => isset($this->params['breadcrumbs']) ? $this->params['breadcrumbs'] : [],--%>
                <%--'homeLink' => ['label' => Yii::t('common/pages', 'Социум'), 'url' => Url::home()],--%>
                <%--]) ?>--%>
                <%--<?= Alert::widget() ?>--%>

                <jsp:doBody />

            </div>
        </div>

        <footer class="footer">
            <div class="container">
                <p class="pull-left">
                    <a href="http://up-site.com.ua" target="_blank">&copy; Up-Site <fmt:formatDate value="${now}" dateStyle="long"/></a>
                </p>
            </div>
        </footer>
    </body>
</html>
