<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class = "container">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <form:form action="validar-cadete" method="POST" modelAttribute="cadete">
                <h3 class="form-signin-heading">Cadete</h3>
                <hr class="colorgraph"><br>

                <form:input path="dni" id="dni" type="number" class="form-control" />
                <form:input path="nombre" id="nombre" type="text" class="form-control" />
                <form:input path="apellido" type="apellido" id="text" class="form-control"/>
                <form:input path="email" id="email" type="email" class="form-control" />
                <form:input path="domicilio" id="domicilio" type="text" class="form-control" />


                <button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Login</button>
            </form:form>

            <c:if test="${not empty error}">
                <h4><span>${error}</span></h4>
                <br>
            </c:if>
        </div>
    </div>
</body>
</html>
