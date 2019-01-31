<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%--zrobić navbar   https://getbootstrap.com/docs/4.0/components/navbar/--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Users
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/login/">Sign In</a>
                    <a class="dropdown-item" href="/login/signup">Sign Up</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/logout">Sing Out</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Projects
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/projects/add">Add project</a>
                    <a class="dropdown-item" href="#">My projects</a>
                    <a class="dropdown-item" href="#">All projects</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link dis${loggedEnabled}abled" href="/">Disabled</a>
            </li>
            <li class="nav-item-inline my-2 my-lg-0">
                <a class="nav-link" href="/admin/">Admin</a>
            </li>
        </ul>
        <%--<form class="form-inline my-2 my-lg-0">--%>
            <%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
        <%--</form>--%>
    </div>

</nav>


</body>
</html>
