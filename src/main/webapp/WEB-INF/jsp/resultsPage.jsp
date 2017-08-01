<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<header>
    <style type="text/css">
        .container {
            width: 30%;
            float: left;
            text-align: center;
        }

        .container button {
            display: inline-block;
        }

        #btn1 {
            float: left;
        }

        #btn2 {
            float: right;
        }
    </style>
</header>
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
    <c:forEach var="searchResult" items="${resultsResponse.getSearchResults()}">
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

<div/>

<div class='container'>
    <c:if test="${resultsResponse.getCurrentPage() > 1}">
        <button id="btn1">
            <form id="form-previous-page" method="POST" action="/results/${resultsResponse.getCurrentPage() - 1}">
                <div>
                    <input type="hidden" id="perv-page" name="searchTitle" value="${resultsResponse.getSearchTitle()}"/>
                </div>
                <div>
                    <input type="submit" value="Previous page"/>
                </div>
            </form>
        </button>
    </c:if>

    <c:if test="${resultsResponse.isHasMore()}">
        <button id="btn2">
            <form id="form-next-page" method="POST" action="/results/${resultsResponse.getCurrentPage() + 1}">
                <div>
                    <input type="hidden" id="next=page" name="searchTitle" value="${resultsResponse.getSearchTitle()}"/>
                </div>
                <div>
                    <input type="submit" value="Next page"/>
                </div>
            </form>
        </button>
    </c:if>
</div>

</body>
</html>