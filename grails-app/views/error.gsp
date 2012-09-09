<!doctype html>
<html>
	<head>
		<title>Grails Runtime Exception</title>
		<meta name="layout" content="main">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css">
	</head>
	<g:if env="production">
        <body>
            <h1>不明なエラーが発生しました</h1>
        </body>
	</g:if>
	<g:else>
        <body>
            <g:renderException exception="${exception}" />
        </body>
	</g:else>
</html>