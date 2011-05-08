<%--
  Created by IntelliJ IDEA.
  User: mnavas
  Date: 5/7/11
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.pufff.domain.trafico.Carretera" contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Las incidencias en tus rutas</title>
    <meta name="layout" content="main" />
    <script type="text/javascript">
        $(document).ready(function() {
            $('#pkInicial').numeric();
            $('#pkFinal').numeric();
        });

        function goRss() {
            //alert("Llama a la función ok")
            document.getElementById("isRss").value=true;
            document.getElementById("formu").submit();
        }

        function testKilometersForm() {
            var kmInicial = $('#pkInicial').val();
            var kmFinal = $('#pkFinal').val();
            if(kmInicial != '' && kmFinal != '') {
                $('#otherConfig').slideDown();
                $('#submit').show();
            } else {
                $('#otherConfig').slideUp();
                $('#submit').hide();
            }
        }

        function showKilometers() {
            $('#kilometers').slideDown();
        }
    </script>
  </head>
  <body>
    <p><h3>¿Cómo funciona?</h3></p>
    <br/>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${cmd}">
        <div class="errors">
            <g:renderErrors bean="${cmd}" as="list" />
        </div>
    </g:hasErrors>
    <%--  Fin Mensajes y errores --%>
    <g:form id="formu" name="formu" controller="home" action="createAlerta">
        <g:hiddenField name="isRss" value="false" id="isRss"/>
        <ol>
            <li>
                <h4>Elige una carretera a nivel nacional</h4>
                <br/>
                <g:select name="carretera" from="${com.pufff.domain.trafico.Carretera.list(sort:'nombre')}" optionKey="id" optionValue="nombre" noSelection="['':'--']" onchange="javascript:showKilometers();"/>
                <br/><br/>
            </li>
            <li id="kilometers" style="display:none">
                <h4>Selecciona los puntos kilométricos que te afectan</h4>
                <br/>
                Desde <g:textField id="pkInicial" name="pkInicial" size="8" onkeyup="javascript:testKilometersForm();"/> Km.<%-- value="${fieldValue(bean: alertaInstance, field: 'pkInicial')}" size="8"--%>
                hasta <g:textField id="pkFinal" name="pkFinal" size="8" onkeyup="javascript:testKilometersForm();"/> Km.
                <br/>
                <br/>
            </li>
            <div id="otherConfig" style="display:none">
            <li>
                <h4>
                    Con esto puedes ya acceder a un
                    <a href="http://es.wikipedia.org/wiki/RSS">feed RSS</a> con información sobre incidencias en tiempo real
                    (haz clic en el icono <g:actionSubmitImage value="goRss" action="goRss" src="${resource(dir:'images',file:'rss_icon.gif')}"/>
                    y copia la dirección de la página que se abra en tu lector de feeds).
                    Si prefieres recibir las alertas en tu email, sigue completando los siguientes pasos.
                </h4>
                <br/>
            </li>
            <li>
                <h4>Elige qué dias de la semana te interesa recibir alertas para esa zona</h4>
                <br/>
                    <g:each in="${diaSemanaBean}" var="day">
                        ${day.key} <g:checkBox name="diaSemana" value="${day.value}" checked="false"/>
                        <%-- ${day} --%>
                    </g:each>
                <br/>
                <br/>
            </li>
            <li>
                <h4>
                    Elige a qué horas (máximo ${numHoras}) para cada uno de estos días deseas recibir la alerta de la zona elegida
                    <br/>
                    Si no eliges ninguna, se te enviará la alerta a las 00.00 del/los dia/s seleccionado/s
                </h4>
                <br/>
                <table border="0" width="80%">
                    <tr>
                        <g:each in="${1..numHoras}" var="cont">
                            <td align="center">
                                H ${cont}&nbsp;
                                <g:select name="horas" from="${0..23}" noSelection="['':'--']"/>
                                <g:select name="minutos" from="${0..60}" noSelection="['':'--']"/>
                            </td>
                        </g:each>
                    </tr>
                </table>
                <br/>
                <br/>
            </li>
            <li>
                <h4>
                    Dinos la dirección de email a la que quieres que te lleguen las alertas<br/>
                </h4>
                <br/>
                <g:textField name="email"/>
            </li>
            </div>
        </ol>
        <br/>
        <g:submitButton style="display:none" id="submit" name="submit" value="Crear alerta"/>
    </g:form>
  </body>
</html>