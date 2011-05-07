<%@ page contentType="text/html"%>
<html>
  <head><title>Tus alertas de tráfico</title></head>
  <body>

      <g:each in="${incidencias}" var="incidencia">
            <div class="incidencia">
          Incidencia en ${incidencia.carretera.nombre}, con motivo de ${incidencia.causa.description}.

          Desde el kilómetro ${incidencia.pkInicial} hasta el ${incidencia.pkFinal},
          hay un nivel de circulación ${incidencia.nivelCirculacion.description}, en sentido ${incidencia.sentido}
          desde las <g:formatDate date="${incidencia.dateInicio}" format="hh:mm"/>.
            </div>
      </g:each>


        <p>
            Puedes eliminar tu suscripción a esta alerta pinchando <g:createLink controller="token" action="cancelarAlerta" params="${[token:alerta.token]}">aquí</g:createLink>.
        </p>

        <p>
            Puedes eliminar todas tus suscripciones pinchando <g:createLink controller="token" action="cancelarSuscripcion" params="${[email:alerta.email]}">aquí</g:createLink>.
        </p>

        <p>
            Puedes informar de un posible uso indebido pinchando <g:createLink controller="token" action="usoInadecuado" params="${[email:alerta.email]}">aquí</g:createLink>.
        </p>
  </body>
</html>