<%--
  ~ Copyright LGPL3
  ~ YES Technology Association
  ~ http://yestech.org
  ~
  ~ http://www.opensource.org/licenses/lgpl-3.0.html
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" autoFlush="true" buffer="none" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>CSS Speech Bubbles</title>
	<link rel="stylesheet" href="bubbles.css" type="text/css" media="screen" charset="utf-8" />
	<script type="text/JavaScript" src="rounded_corners.inc.js"></script>
	<script type="text/JavaScript">
	  window.onload = function() {
	      settings = {
	          tl: { radius: 10 },
	          tr: { radius: 10 },
	          bl: { radius: 10 },
	          br: { radius: 10 },
	          antiAlias: true,
	          autoPad: true
	      }
	      var myBoxObject = new curvyCorners(settings, "rounded");
	      myBoxObject.applyCornersToAll();
	  }
	</script>
</head>

<body>
<h1 style="margin-left:20px;">Welcome to YES Cloud</h1>
<p style="margin-left:20px;width:80%">YES Cloud is a Service that allows any user on the net to create an
information cloud from multiple sources and aggregate those results.  You can integrate your cloud into
results any website with a simple url.  </p>


	<div class="bubble">
		<div class="rounded">
			<blockquote>
				<p>Customize colors and styling to your taste from within the CSS, then simply edit the pointer tip image. Works on any background to fit with your design.</p>
			</blockquote>
		</div>
		<cite class="rounded"><strong>Rounded Bubble</strong> using <a href="http://www.curvycorners.net/">curvy corners</a></cite>
	</div>


</body>
</html>
