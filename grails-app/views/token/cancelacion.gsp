<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <title>Las incidencias en tus rutas</title>
      <meta name="layout" content="main" />
  </head>
  <body>
    <div id="bar">
        <div class="wrap">
            <span class="step" id="step1"><a>&nbsp;</a>  !Alerta cancelada!</span>
        </div>
    </div>
    <div class="wrap">
        <h3>Has cancelado correctamente tu suscripción a la alerta ${nombre}</h3>
        <br/>
        Puedes volver a crear otra alerta en cualquier momento <g:link controller="home" action="index">aquí</g:link>
    </div>
  </body>
</html>

