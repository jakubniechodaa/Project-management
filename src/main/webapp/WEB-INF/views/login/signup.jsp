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

    <table>
        <form:form method="post" modelAttribute="user" action="/login/registered" name="formulare">
            <tr>
                <td>username:</td>
                <td><form:input path="username" /></td>
                <form:errors path="username" cssStyle="color: red" element="td"/>
            </tr>
            <tr>
                <td>firstname:</td>
                <td><form:input path="firstname" /></td>
                <form:errors path="firstname" cssStyle="color: red" element="td"/>
            </tr>
            <tr>
                <td>lastname:</td>
                <td><form:input path="lastname" /></td>
                <form:errors path="lastname" cssStyle="color: red" element="td"/>
            </tr>
            <tr>
                <td>password:</td>
                <td><form:input type= "password" path="password" /></td>
                <form:errors path="password" cssStyle="color: red" element="td"/>
            </tr>
            <tr>
                <td>email:</td>
                <td><form:input path="email" /></td>
                <form:errors path="email" cssStyle="color: red" element="td"/>
            </tr>
            <tr>
                <td><input type="submit" value="Register"></td>
            </tr>
        </form:form>

</div>

<div>
    <%@ include file="../fragments/footer.jsp"  %>
</div>
</body>
</html>