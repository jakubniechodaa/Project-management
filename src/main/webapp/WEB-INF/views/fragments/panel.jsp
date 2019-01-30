<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%--<div class="wrapper">--%>
<%--<marquee bg="white" style="color:white;width:540px;" onmouseover="this.stop()" onmouseout="this.start()""><br /> <b>--%>
    <%--<a href="/">manage your projects</a> </b> <br />--%>
<%--</marquee>--%>
<%--</div>--%>

<%--zrobić navbar   https://getbootstrap.com/docs/4.0/components/navbar/--%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Users
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/users/signin">Sign In</a>
                    <a class="dropdown-item" href="/users/signup">Sign Up</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/logout">Sing Out</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
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
