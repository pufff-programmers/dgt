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
                $('#config').slideDown();
                $('#step3').slideDown();
                $('#submit').show();
            } else {
                $('#config').slideUp();
                $('#step3').slideUp();
                $('#submit').hide();
            }
        }

        function showKilometers() {
            $('#kilometers').slideDown();
            $('#step2').slideDown();
        }
    </script>
  </head>
  <body>
  <div id="bar">
            <div class="wrap">
                <span class="step" id="step1"><a>1</a> Elige una carretera</span>
                <span class="step" id="step2" style="display:none"><a>2</a> Elige el tramo que te interesa</span>
                <span class="step" id="step3" style="display:none"><a>3</a> Configura tus alertas</span>
            </div>
	    </div>

  <div class="wrap">
        <g:form id="formu" name="formu" controller="home" action="createAlerta">
        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>
        <g:hasErrors bean="${cmd}">
            <div class="errors">
                <g:renderErrors bean="${cmd}" as="list" />
            </div>
        </g:hasErrors>

		<div class="col">
			<g:select name="carretera" from="${com.pufff.domain.trafico.Carretera.list(sort:'nombre')}" optionKey="id" optionValue="nombre" noSelection="['':'--']" onchange="javascript:showKilometers();"/>
		</div>
		<div class="col"  id="kilometers" style="display:none">
			Desde <g:textField id="pkInicial" name="pkInicial" size="8" onkeyup="javascript:testKilometersForm();"/> Km.<%-- value="${fieldValue(bean: alertaInstance, field: 'pkInicial')}" size="8"--%>
            hasta <g:textField id="pkFinal" name="pkFinal" size="8" onkeyup="javascript:testKilometersForm();"/> Km.
		</div>
		<div class="col last" id="config" style="display:none;">
			<h3>Alertas por  <span class="red">RSS</span></h3>
			<p>
                Con esto puedes ya acceder a un
                <a href="http://es.wikipedia.org/wiki/RSS">feed RSS</a> con información sobre incidencias en tiempo real
                (haz clic en el icono <g:actionSubmitImage value="goRss" action="goRss" src="${resource(dir:'images',file:'rss_icon.gif')}"/>
                y copia la dirección de la página que se abra en tu lector de feeds).
                Si prefieres recibir las alertas en tu email, sigue completando los siguientes pasos.
			</p>
            <h3>Alertas por <span class="red">Email</span></h3>
            <p>
                <div>Elige los días de la semana en los que quieres recibir tus alertas.</div> <br/>
                <g:each in="${diaSemanaBean}" var="day">
                    ${day.key} <g:checkBox name="diaSemana" value="${day.value}" checked="false"/>
                    <%-- ${day} --%>
                </g:each>
            </p>
            <p>
                <div>Elige las horas (máximo cuatro) a las que quieres recibir tus alertas.</div> <br/>
                <g:each in="${1..numHoras}" var="cont">
                    <div>
                        H ${cont}&nbsp;
                        <g:select name="horas" from="${0..23}" noSelection="['':'--']"/>
                        <g:select name="minutos" from="${0..60}" noSelection="['':'--']"/>
                    </div>
                </g:each>
            </p>
            <p>
                <div>Dinos tu dirección de correo electrónico</div>
                <g:textField name="email"/>
            </p>
            <p>
                <g:submitButton style="display:none" id="submit" name="submit" value="Crear alerta"/>
            </p>
		</div>
		</g:form>
	</div>

  </body>
</html>