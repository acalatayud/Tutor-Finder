<c:forEach var="result" items="${pagedResults.results}">
        <div class="search-course-result">
            <a class="conversation-link" href = "<c:url value="/Course/?professor=${result.professor.id}&subject=${result.subject.id}" />"></a>
            <a class="search-result-img"><img class="search-result-picture" src="<c:url value="data:image/jpeg;base64,${result.subject.area.image}"/>"/></a>
            <a class="search-result-title">
                <c:out value="${result.subject.area.name} - ${result.subject.name}" escapeXml="true" /></a>
            <a class="search-result-professor" >
                <c:out value="${result.professor.name}" escapeXml="true" /></a>
            <a class="search-result-specs"><spring:message code="course.specs" arguments="${result.price}" htmlEscape="true" /></a>
            <a class="search-result-description">
                <c:out value="${result.description}" escapeXml="true" /></a>
        </div>
</c:forEach>
