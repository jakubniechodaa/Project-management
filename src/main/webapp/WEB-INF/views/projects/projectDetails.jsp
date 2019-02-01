<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@ include file="../fragments/header.jsp"  %>

<div class="container">
    <h5>Your project:</h5>
<table>
    <th>name</th>  <th>date</th> <th>website</th> <th>description</th>
    <tr>
    <td>${project.getName()}</td>      <td>${project.getDate()}</td> <td>${project.getWebsite()}</td> <td>${project.getDescription()}</td>
    </tr>


</table>
    <h5>Tasks:</h5>
    <table>
        <th>subject</th> <th>status</th> <th>date</th> <th>user</th>

        <c:forEach items="${tasks}" var="tsk">
            <%--//begin="0" end="4"--%>
        <tr>
        <td>${tsk.getSubject()}</td> <td>${tsk.getStatus()}</td> <td>${tsk.getDate()}</td><td>${tsk.getUser().getUsername()}</td>
        <%--<td>${ev.date}</td> <td>${ev.till}</td> <td><a href="/event/details/${ev.id}">click</a></td>--%>
        </tr>
        </c:forEach>
    </table>
    <a href="/projects/adduser/${project.getId()}">EDIT</a>
    <a href="/tasks/add/${project.getId()}">ADD TASK</a>
</div>

<%@ include file="../fragments/footer.jsp"  %>
</body>
</html>