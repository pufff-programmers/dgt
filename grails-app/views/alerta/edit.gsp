

<%@ page import="com.pufff.domain.user.Alerta" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'alerta.label', default: 'Alerta')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${alertaInstance}">
            <div class="errors">
                <g:renderErrors bean="${alertaInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${alertaInstance?.id}" />
                <g:hiddenField name="version" value="${alertaInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="carretera"><g:message code="alerta.carretera.label" default="Carretera" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: alertaInstance, field: 'carretera', 'errors')}">
                                    <g:select name="carretera.id" from="${com.pufff.domain.trafico.Carretera.list()}" optionKey="id" value="${alertaInstance?.carretera?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="pkFinal"><g:message code="alerta.pkFinal.label" default="Pk Final" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: alertaInstance, field: 'pkFinal', 'errors')}">
                                    <g:textField name="pkFinal" value="${fieldValue(bean: alertaInstance, field: 'pkFinal')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="pkInicial"><g:message code="alerta.pkInicial.label" default="Pk Inicial" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: alertaInstance, field: 'pkInicial', 'errors')}">
                                    <g:textField name="pkInicial" value="${fieldValue(bean: alertaInstance, field: 'pkInicial')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="user"><g:message code="alerta.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: alertaInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.pufff.domain.user.User.list()}" optionKey="id" value="${alertaInstance?.user?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
