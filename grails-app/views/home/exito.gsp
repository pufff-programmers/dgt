<%--
  Created by IntelliJ IDEA.
  User: mnavas
  Date: 5/7/11
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <title>Las incidencias en tus rutas</title>
      <meta name="layout" content="main" />
  </head>
  <body>
    <div id="bar">
        <div class="wrap">
            <span class="step" id="step1"><a>&nbsp;&nbsp;</a>  !Enhorabuena!</span>
        </div>
    </div>
    <div class="wrap">
        <p>Creada correctamente alerta en ${carretera.nombre}, kilómetros ${cmd.pkInicial} a ${cmd.pkFinal}, a la dirección ${cmd.email}. Puedes crear más para otras carreteras y/o tramos que utilices habitualmente</p>
        <br/>
        <g:link action="index">Volver a la página de creación de alertas</g:link>
    </div>
  </body>
</html>