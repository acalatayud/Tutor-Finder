<%@ taglib prefix="c" uri ="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/stylesheet.css" />" rel="stylesheet">
    <title>Tu Teoria | <spring:message code="profile.title" /></title>
</head>

<body class="staticProfile">

<%@ include file="navbar.jsp" %>

<div class="content">
    <%--<img class="profile-picture" alt="Profile picture" src="<c:url value="/resources/images/logo_invert.jpg" />" />--%>
    <h1 class="profile-name"><c:out value="${professor.name} ${professor.lastname}" escapeXml="true"/></h1>
    <h3 class="profile-description"><c:out value="${professor.description}" escapeXml="true"/></h3>
    <div class="classes">
        <c:if test="${courses.results.size() == 0}">
            <h4><spring:message code="no.courses"/></h4>
        </c:if>
        <c:forEach var="course" items="${courses.results}">
            <div class="class">
                <a class="class-button" href="<c:url value="/Course/?professor=${course.professor.id}&subject=${course.subject.id}" />"></a>
                <div class="class-title"><c:out value="${course.subject.name}" escapeXml="true"/></div>
                <div class="class-description"><c:out value="${course.description}" escapeXml="true"/></div>
            </div>
        </c:forEach>

        <div class="paged-result-buttons">
            <c:url value="/Professor/${professor.id}?page=${page - 1}" var="previous"/>
            <c:url value="/Professor/${professor.id}?page=${page + 1}" var="next"/>

            <c:if test="${page > 1}">
                <a href="${previous}" class="previous round">&#8249;</a>
            </c:if>
            <c:if test="${courses.hasNext}">
                <a href="${next}" class="next round">&#8250;</a>
            </c:if>
        </div>
    </div>
</div>
<div class="footer">
</div>
</body>

</html>