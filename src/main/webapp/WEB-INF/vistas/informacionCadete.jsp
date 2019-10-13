<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="../../../css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="../../../css/bootstrap-theme.min.css" rel="stylesheet">
    <title>Informacion del Cadete</title>
</head>

<body>
<div class = "container">
    <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

        <div class="text-center"><h2>Datos del Cadete Cargado</h2><br></div>
        <h4>
            <b>DNI</b>: ${dni}.<br>
            <b>Nombre</b>: ${nombre}.<br>
            <b>Apellido</b>: ${apellido}.
        </h4>

        <br><br>
        <div class="text-center"><a href="../../../cadete">Volver a cargar un nuevo cadete</a></div>

    </div>
</div>

</body>
</html>