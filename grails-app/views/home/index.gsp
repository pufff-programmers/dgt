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
  </head>
  <body>
    <div id="content">
        <p><h3>¿Cómo funciona?</h3></p>
        <%--
        <p>
            Todo lo que tienes que hacer es dar de alta alertas. Selecciona una carretera a nivel nacional (España), un tramo kilométrico
        </p>
        --%>
        <g:form controller="home" action="createAlerta">
            <ol>
                <li>
                    <h4>Elige una carretera a nivel nacional</h4>
                    <br/>
                    <g:select name="carretera.id" from="${com.pufff.domain.trafico.Carretera.list().sort()}" optionKey="id" value="${alertaInstance?.carretera?.id}"  />
                    <br/><br/>
                </li>
                <li>
                    <h4>Selecciona los puntos kilométricos que te afectan</h4>
                    <br/>
                    Desde <g:textField name="pkInicial" value="${fieldValue(bean: alertaInstance, field: 'pkInicial')}" /> Km.
                    hasta <g:textField name="pkFinal" value="${fieldValue(bean: alertaInstance, field: 'pkFinal')}" /> Km.
                    <br/>
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
                    <h4>Elige a qué horas (máximo ${numHoras}) para cada uno de estos días deseas recibir la alerta de la zona elegida</h4>
                    <br/>
                        Aquí me he quedado (Mariano)
                        <%--
                                        TODO Mariano, trabajando aquí, completando formulario de entrada de alertas
                                        <g:each in="[0..${numHoras}]" var="cont">
                                            H ${cont} <g:textField name="hora${cont}" value="${fieldValue(bean: alertaInstance, field: 'horas[${cont}]')}" />&nbsp;
                                        </g:each>
                                        --%>
                    <br/>
                    <br/>
                </li>
            </ol>
            <g:submitButton name="submit" value="Crear alerta"/>
        </g:form>
    </div>
  </body>
</html>