<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<%@ include file="../fragments/header.jsp"  %>

<div class="container">

    <p>ONLY ADMIN</p>

</div>

<div class="d-flex p-2">
    <security:authorize access="isAuthenticated()">
        authenticated as: <security:authentication property="principal.username" />
    </security:authorize>
</div>


<%@ include file="../fragments/footer.jsp"  %>
</body>
</html>