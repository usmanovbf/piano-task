<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<body>
<a href="<spring:url value="/search" />"><spring:message code="back.to.form.message"/></a>


<table border="1" cellpadding="5">
    <caption><h2><spring:message code="results.message"/></h2></caption>
    <tr>
        <th>Date Of Question</th>
        <th>Title</th>
        <th>Username</th>
        <th>Link</th>
    </tr>
    <c:forEach var="searchResult" items="${searchResults}">
        <tr
        <c:if test="${searchResult.isAnswered()}">bgcolor="#C0D890"</c:if>
        <c:if test="${!searchResult.isAnswered()}">bgcolor="#F09C82"</c:if>

        >
        <td><c:out value="${searchResult.dateOfQuestion}"/></td>
        <td><c:out value="${searchResult.title}"/></td>
        <td><c:out value="${searchResult.username}"/></td>
        <td><a href="<c:out value="${searchResult.link}" />">Link</a></td>
        </tr>
    </c:forEach>
</table>


<%--&lt;%&ndash;For displaying Previous link except for the 1st page &ndash;%&gt;--%>
<%--<c:if test="${currentPage != 1}">--%>
    <%--<td><a href="employee.do?page=${currentPage - 1}">Previous</a></td>--%>
<%--</c:if>--%>

<%--&lt;%&ndash;For displaying Page numbers.--%>
<%--The when condition does not display a link for the current page&ndash;%&gt;--%>
<%--<table border="1" cellpadding="5" cellspacing="5">--%>
    <%--<tr>--%>
        <%--<c:forEach begin="1" end="${noOfPages}" var="i">--%>
            <%--<c:choose>--%>
                <%--<c:when test="${currentPage eq i}">--%>
                    <%--<td>${i}</td>--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<td><a href="employee.do?page=${i}">${i}</a></td>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        <%--</c:forEach>--%>
    <%--</tr>--%>
<%--</table>--%>

<%--&lt;%&ndash;For displaying Next link &ndash;%&gt;--%>
<%--<c:if test="${currentPage lt noOfPages}">--%>
    <%--<td><a href="employee.do?page=${currentPage + 1}">Next</a></td>--%>
<%--</c:if>--%>

</body>
</html>