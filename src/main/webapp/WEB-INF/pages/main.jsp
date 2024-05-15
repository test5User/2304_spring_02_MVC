<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Params page</title>
</head>
<body>
    <c:if test="${not empty strParam}">
        <h1>String parameter: ${strParam}
    </c:if>
    <c:if test="${not empty intParam}">
        <h1>Integer parameter: ${intParam}
    </c:if>
</body>
</html>
