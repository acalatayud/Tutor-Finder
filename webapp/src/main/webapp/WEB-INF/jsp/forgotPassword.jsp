<%@ taglib prefix="c" uri ="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/css/stylesheet.css" />">
    <title>Tu Teoria | <spring:message code="forgotPassword"/></title>
</head>

<body class="register">

<div class="navbar">
    <a href="<c:url value="/" />" class="logo-box">
        <img alt="Tu Teoria" class="logo" src="<c:url value="/resources/images/logo_invert.jpg" />" />
    </a>
</div>

<div class="content">
    <div class="button-container">
        <h2 class="label"><spring:message code="restorePassword" /> </h2>
    </div>
    <c:url value="/forgotPassword" var="postPath"/>
    <form:form cssClass="form" modelAttribute="resetPasswordForm" action="${postPath}" method="post">
        <div>
            <form:label cssClass="label" path="email"><spring:message code="user.email"/></form:label>
            <form:input cssClass="input-request" type="text" path="email"/>
            <form:errors cssClass="error-text" path="email" element="p"/>
        </div>
        <div>
            <form:hidden path="successMessage" />
            <form:errors cssClass="success-text" path="successMessage" element="p"/>
        </div>

        <div class="button-container">
            <input class="button-2" type="submit" value="<spring:message code="restorePassword"/>"/>
        </div>
    </form:form>
</div>
<div class="footer">
</div>
</body>

</html>