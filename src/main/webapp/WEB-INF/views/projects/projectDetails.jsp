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
    <th>name</th>  <th>date</th> <th>website</th> <th>description</th>
    <tr>
    <td>${project.getName()}</td>      <td>${project.getDate()}</td> <td>${project.getWebsite()}</td> <td>${project.getDescription()}</td>
    </tr>
<%--<c:forEach items="${project}" var="pr" begin="0" end="4">--%>
    <%--<tr>--%>
        <%--<td>${pr.getName()}</td><td>${pr.getDate()}</td><td>${pr.getId()}</td>--%>
        <%--&lt;%&ndash;<td>${ev.date}</td> <td>${ev.till}</td> <td><a href="/event/details/${ev.id}">click</a></td>&ndash;%&gt;--%>
    <%--</tr>--%>
<%--</c:forEach>--%>

</table>

    <a href="/tasks/add/${project.getId()}">ADD TASK</a>
    <a href="/allupcomming">see all</a>
</div>

<%@ include file="../fragments/footer.jsp"  %>
</body>
</html>