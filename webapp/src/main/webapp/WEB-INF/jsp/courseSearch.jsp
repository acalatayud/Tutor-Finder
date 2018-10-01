<c:forEach var="result" items="${pagedResults.results}">
        <div class="search-course-result">
            <a class="conversation-link" href = "<c:url value="/Course/?professor=${result.professor.id}&subject=${result.subject.id}" />"/>
            <a class="search-result-img"><img src="<c:url value="/resources/images/search.png" />"/></a>
            <a class="search-result-title">
                <c:out value="${result.subject.area.name} - ${result.subject.name}" escapeXml="true" /></a>
            <a class="search-result-professor" >
                <c:out value="${result.professor.name}" escapeXml="true" /></a>
            <a class="search-result-specs"><spring:message code="course.specs" arguments="${result.price}" htmlEscape="true" /></a>
            <a class="search-result-description">
                <c:out value="${result.description}" escapeXml="true" /></a>
        </div>
</c:forEach>
