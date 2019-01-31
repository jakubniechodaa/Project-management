<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <title></title>
</head>

<body>
<%@ include file="fragments/header.jsp"  %>

<div class="container">
    <h3> <%= request.getSession().getAttribute("loggedEnabled") %></h3>
    <h5>upcomming events(${futureEvents.size()} / 5)</h5>
<table>
    <th>name</th>  <th>date</th> <th>till</th> <th>details</th>

<%--<c:forEach items="${futureEvents}" var="ev" begin="0" end="4">--%>
    <%--<tr>--%>
        <%--<td>${ev.name}</td><td>${ev.date}</td> <td>${ev.till}</td> <td><a href="/event/details/${ev.id}">click</a></td>--%>
    <%--</tr>--%>
<%--</c:forEach>--%>

</table>
    <a href="/allupcomming">see all</a>
</div>

<%@ include file="fragments/footer.jsp"  %>
</body>
</html>