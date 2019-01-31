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

        <%--<form:form method="post" action="/users/signin">--%>
            <%--<div><label> User Name : <input type="text" path="username" name="username"/> </label></div>--%>
            <%--<div><label> Password: <input type="password" path="password" name="password"/> </label></div>--%>
            <%--<div><input type="submit" value="Sign In"/></div>--%>
        <%--</form:form>--%>

            <form name='loginForm'
                  action="<c:url value='/login/' />" method='POST'>

                <table>
                    <tr>
                        <td>User:</td>
                        <td><input type='text' name='username'></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type='password' name='password' /></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit"
                                               value="submit" /></td>
                    </tr>
                </table>

                <%--<input type="hidden" name="${_csrf.parameterName}"--%>
                       <%--value="${_csrf.token}" />--%>

            </form>

</div>

<%@ include file="../fragments/footer.jsp"  %>
</body>
</html>