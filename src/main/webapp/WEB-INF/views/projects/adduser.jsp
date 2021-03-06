<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%@ include file="../fragments/header.jsp"  %>

<div class="container">

    <%--<table>--%>
        <%--<form:form method="post" modelAttribute="project" action="/tasks/added">--%>
            <%--<form:input path="subject" />--%>
            <%--<form:input path="description" />--%>
            <%--<form:input type="hidden" path="project.id" value="${project.id}"/>--%>
            <%--<form:input type="hidden" path="user.id" value="${user.id}"/>--%>
        <%--status:<form:select itemLabel="name" path="status"--%>
                            <%--itemValue="id"  items="${statuses}"/>--%>
            <%--<form:errors path="status" cssStyle="color: red" element="td"/>--%>

        <%--<button>send</button>--%>
        <%--</form:form>--%>

    <%--</table>--%>

        <table>
            <form:form method="post" modelAttribute="project" action="/projects/edited">
                <%--itemLabel="username" path="users"--%>
                <%--itemValue="id"--%>
                <%--<form:errors path="users" cssStyle="color: red" element="td"/>--%>

                <td>users:</td><td><form:select itemLabel="name" path="users"
                                                itemValue="id"  items="${users1}"/></td>
                <form:errors path="users" cssStyle="color: red" element="td"/>
                <form:hidden path="id" value="${id}"/>



                <tr>
                    <td><input type="submit" value="Register"></td>
                </tr>

            </form:form>
        </table>

</div>

<div>
    <%@ include file="../fragments/footer.jsp"  %>
</div>
</body>
</html>