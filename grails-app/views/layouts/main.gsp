<!DOCTYPE html>
<html>
    <head>
        <g:javascript library="jquery" plugin="jquery" />
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main2.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.png')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript src="jquery-ui-1.8.12.custom.min.js"/>
        <g:javascript src="jquery.alphanumeric.pack.js"/>
        <g:javascript src="easing.js"/>
    </head>
    <body>
        <div id="header">
		<h1><a href="#">Tus alertas de tráfico</a></h1>
		%{--<ul id="menu">--}%
			%{--<li class="active"><a href="#">about application</a></li>--}%
			%{--<li><a href="#">register</a></li>--}%
			%{--<li><a href="#">demo</a></li>--}%
			%{--<li><a href="#">help</a></li>--}%
			%{--<li><a href="#">contact</a></li>--}%
		%{--</ul>--}%
	</div>

	<div id="teaser">
		<div class="wrap">
			<div id="image"></div>
			<div class="box">
				<h2>Alertas de tráfico personalizadas</h2>
				<p>Crea tus alertas de tráfico y recíbelas en tu dirección de correo electrónico cuando quieras, o consúltalas en tu lector de RSS.
                   ¡No hace falta registrarse!</p>
                <p>
                    Esta aplicación ha sido desarrollada durante el <a href="http://www.abredatos.es/">Desafío Abredatos 2011</a>,
                usando <a href="http://www.grails.org">grails</a>, <a href="http://jquery.com">jQuery</a> y <a href="http://github.com">github</a>.
                    Los datos de incidencias de tráfico se obtienen de la <a href="http://www.dgt.es/incidencias.xml">Dirección General de Tráfico</a>.
                </p>
			</div>
		</div>
	</div>


        <a href="http://github.com/pufff-programmers/dgt"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://d3nwyuy0nl342s.cloudfront.net/img/e6bef7a091f5f3138b8cd40bc3e114258dd68ddf/687474703a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f7265645f6161303030302e706e67" alt="Fork me on GitHub"></a>


        <div id="content">
            <g:layoutBody />
        </div>

        <div id="footer">
            <p>Una aplicación de <a href="http://twitter.com/#!/mariomgal">Mario Muñoz</a> y <a href="http://twitter.com/#!/marianongdev">Mariano Navas</a>
                para el desafío <a href="http://www.abredatos.es/">Abredatos 2011</a>.</p>
        </div>
    </body>
</html>