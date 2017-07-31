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
        <tr>
            <td><c:out value="${searchResult.dateOfQuestion}" /></td>
            <td><c:out value="${searchResult.title}" /></td>
            <td><c:out value="${searchResult.username}" /></td>
            <td><a href="<c:out value="${searchResult.link}" />">Link</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>