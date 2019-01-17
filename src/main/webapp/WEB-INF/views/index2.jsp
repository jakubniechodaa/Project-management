<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="fragments/header.jsp"  %>

<div class="container">
    <h5>upcomming events(all)</h5>
<table>
    <th>name</th>  <th>date</th> <th>till</th>  <th>details</th>
<c:forEach items="${futureEvents}" var="ev">
    <tr>
        <td>${ev.name}</td><td>${ev.date}</td><td>${ev.till}</td><td><a href="/event/details/${ev.id}">click</a></td>
    </tr>
</c:forEach>
</table>

</div>



<%@ include file="fragments/footer.jsp"  %>
</body>
</html>