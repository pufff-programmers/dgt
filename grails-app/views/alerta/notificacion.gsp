<%@ page contentType="text/html" %>
<html>
<head>
    <title>Tus alertas de tráfico</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}"/>
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'cono_small.jpg')}" type="image/x-icon"/>
    <g:javascript library="application"/>
</head>
<head><title>Tus alertas de tráfico</title></head>
<body>

<p><h3>Incidencias en ${alerta.carretera.nombre}</h3></p>

<ul>
<g:each in="${incidencias}" var="incidencia">
    <li>
        <h4>Incidencia con motivo de ${incidencia.causa.description}.</h4>

        Desde el kilómetro ${incidencia.pkInicial} hasta el ${incidencia.pkFinal},
        hay un nivel de circulación ${incidencia.nivelCirculacion.description}, en sentido ${incidencia.sentido}
        desde las <g:formatDate date="${incidencia.dateInicio}" format="hh:mm"/>.
    </li>
</g:each>
</ul>


<p>
    <h4>
        Puedes eliminar tu suscripción a esta alerta pinchando <g:link controller="token" action="cancelarAlerta" params="${[token:alerta.token]}" absolute="true">aquí</g:link>
    </h4>
</p>

<p>
    <h4>
        Puedes eliminar todas tus suscripciones pinchando <g:link controller="token" action="cancelarSuscripcion" params="${[email:alerta.email]}" absolute="true">aquí</g:link>
    </h4>
</p>

</body>
</html>