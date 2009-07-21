<html>
    <head>
        <title>YES Cloud</title>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1 style="margin-left:20px;">Welcome to YES Cloud</h1>
        <p style="margin-left:20px;width:80%">YES Cloud is a Service that allows any user on the net to create an
        information cloud from multiple sources and aggregate those results.  You can integrate your cloud into
        results any website with a simple url.  </p>
        %{--<div class="dialog" style="margin-left:20px;width:60%;">--}%
            %{--<ul>--}%
              %{--<g:each var="c" in="${grailsApplication.controllerClasses}">--}%
                    %{--<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>--}%
              %{--</g:each>--}%
            <!--</ul>-->
        <!--</div>-->
        <g:include></g:include>
    </body>
</html>