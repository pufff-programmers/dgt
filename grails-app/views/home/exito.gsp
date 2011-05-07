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
    <h1>¡Enhorabuena!</h1>
    <h3>Creada correctamente alerta en ${carretera.nombre}, kilómetros ${cmd.pkInicial} a ${cmd.pkFinal}, a la dirección ${cmd.email}. Puedes crear más para otras carreteras y/o tramos que utilices habitualmente</h3>
    <br/>
    <g:link action="index">Volver a la página de creación de alertas</g:link>
  </body>
</html>