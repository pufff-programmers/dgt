<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'cono_small.jpg')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="jquery" plugin="jquery" />
    </head>
    <body>
        <a href="http://github.com/pufff-programmers/dgt"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://d3nwyuy0nl342s.cloudfront.net/img/e6bef7a091f5f3138b8cd40bc3e114258dd68ddf/687474703a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f7265645f6161303030302e706e67" alt="Fork me on GitHub"></a>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div id="container">
            <div id="mainpic">
                <h1>Tus alertas<span class="lightblue">de tráfico</span></h1>
                <h2>Recibe diariamente en tu email las incidencias de tus rutas habituales</h2>
            </div>
        </div>

        <div id="content">
            <%--  Mensajes y errores --%>
            <g:layoutBody />
        </div>
        <div id="footer">
            <h3>
                Una aplicación de <a href="http://twitter.com/#!/mariomgal">Mario Muñoz</a> y <a href="http://twitter.com/#!/marianongdev">Mariano Navas</a>
            </h3>
        </div>
    </body>
</html>