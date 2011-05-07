<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'cono_small.jpg')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div id="container">
            <div id="mainpic">
                <h1>Tus alertas<span class="lightblue">de tráfico</span></h1>
                <h2>Recibe diariamente en tu email las incidencias de tus rutas habituales</h2>
            </div>
        </div>
                <%--
        <div id="grailsLogo">
            <img src="${resource(dir:'images',file:'cono.jpg')}" alt="Tu avisador personal de incidencias" border="0" />
        </div>
        --%><div id="content">
            <g:layoutBody />
        </div>
        <div id="footer">
            <h3>
                Una aplicación de <a href="#">Mario Muñoz</a> y <a href="http://twitter.com/#!/marianongdev">Mariano Navas</a>
            </h3>
        </div>
    </body>
</html>