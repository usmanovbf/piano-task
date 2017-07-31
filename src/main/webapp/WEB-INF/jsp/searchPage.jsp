<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<body>
<spring:message code="form.welcome.message"/>
<form:form method="POST" action="/results" modelAttribute="form" >
    <div>
        <form:input path="searchTitle"/>
        <form:errors path="searchTitle"/>
    </div>
    <div>
        <input type="submit" value="Submit" />
    </div>
</form:form>

</body>
</html>