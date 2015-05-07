<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>

Name: <c:out value="${entity.name}"/><br/>
Values:
<c:forEach items="${entity.values}" var="value">
    <c:out value="${value}"/><br/>
</c:forEach>


</body>
</html>
