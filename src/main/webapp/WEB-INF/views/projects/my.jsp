<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@ include file="../fragments/header.jsp"  %>

<div class="container">
    <h3> <%= request.getSession().getAttribute("loggedEnabled") %></h3>
    <h5>upcomming events(${futureEvents.size()} / 5)</h5>
<table>
    <th>name</th>  <th>date</th> <th>details</th>

<c:forEach items="${project}" var="pr" begin="0" end="4">
    <tr>
        <td>${pr.getName()}</td><td>${pr.getDate()}</td><td><a href="/projects/my/${pr.getId()}">CLICK</a></td>
        <%--<td>${ev.date}</td> <td>${ev.till}</td> <td><a href="/event/details/${ev.id}">click</a></td>--%>
    </tr>
</c:forEach>

</table>
    <a href="/allupcomming">see all</a>
</div>

<%@ include file="../fragments/footer.jsp"  %>
</body>
</html>