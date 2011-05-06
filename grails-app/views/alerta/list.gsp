
<%@ page import="com.pufff.domain.user.Alerta" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'alerta.label', default: 'Alerta')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'alerta.id.label', default: 'Id')}" />
                        
                            <th><g:message code="alerta.carretera.label" default="Carretera" /></th>
                        
                            <g:sortableColumn property="pkFinal" title="${message(code: 'alerta.pkFinal.label', default: 'Pk Final')}" />
                        
                            <g:sortableColumn property="pkInicial" title="${message(code: 'alerta.pkInicial.label', default: 'Pk Inicial')}" />
                        
                            <th><g:message code="alerta.user.label" default="User" /></th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${alertaInstanceList}" status="i" var="alertaInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${alertaInstance.id}">${fieldValue(bean: alertaInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: alertaInstance, field: "carretera")}</td>
                        
                            <td>${fieldValue(bean: alertaInstance, field: "pkFinal")}</td>
                        
                            <td>${fieldValue(bean: alertaInstance, field: "pkInicial")}</td>
                        
                            <td>${fieldValue(bean: alertaInstance, field: "user")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${alertaInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
