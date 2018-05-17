<%-- 
    Document   : index
    Created on : 27-abr-2018, 19:02:54
    Author     : vcaruncho
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Academia</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/theme.css"">
<script src="js/funciones.js" type="text/javascript"></script>
</head>
<body onload="initMap()">
	<header class="container-fluid">
		<h1></h1>
	</header>
	<nav class="container navbar navbar-default">

		<div class="navbar-header">
			<a class="navbar-brand" href="http://localhost:8080/Academia/">Academia</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="http://localhost:8080/Academia/">Home</a></li>
			<li><a href="http://localhost:8080/Academia/quien.html">Quienes
					Somos</a></li>
			<li><a href="http://localhost:8080/Academia/donde.html">Donde
					estamos</a></li>
			<li><a href="http://localhost:8080/Academia/blog.html">Blog</a></li>
		</ul>
	</nav>
	<div class="container">
		<div class="row">
			<div class="informacion col-sm-8">
				<div class="noticia">
					<h3 class="titulo_noticia">Nueva promoción de cursos!</h3>
					<hr class="linea_noticia">
					<img class="pull-left" src="images/noticia1.jpg"
						alt="promoción de cursos" />
					<p class="cuerpo_noticia">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Nunc non eleifend quam. Sed vitae
						fringilla orci. Fusce eu neque convallis, ornare lectus a,
						lobortis massa. Vestibulum at consectetur sem. Cras iaculis diam
						ex, non dignissim nunc ultricies at. Vestibulum ac condimentum
						turpis. In dignissim, sem ac auctor vehicula, sem neque aliquet
						nisl, non sagittis dui purus a nunc. Ut id nunc orci. Quisque in
						consequat tortor. Suspendisse potenti. Fusce congue at nibh ac
						lacinia. Cras vel dui efficitur, lobortis turpis nec, luctus est</p>
				</div>
				<div class="noticia">
					<h3 class="titulo_noticia">Premios anuales Academias Españolas</h3>
					<hr class="linea_noticia">
					<img class="pull-left" src="images/noticia2.jpg"
						alt="Premios anuales" />

					<p class="cuerpo_noticia">Aenean tellus purus, lacinia quis
						erat et, porta aliquet urna. Morbi in diam sit amet quam fringilla
						viverra sit amet vitae dui. Nam nec turpis tincidunt, luctus ante
						sed, tempor tortor. Nulla eros felis, sagittis sit amet quam ac,
						pellentesque iaculis magna. Suspendisse cursus et diam nec tempor.
						Pellentesque nulla justo, congue ac eleifend sit amet, imperdiet
						eget nisl. Nam eros lorem, consectetur nec sollicitudin at,
						consectetur at tortor. Donec fermentum non justo ac tristique.
						Suspendisse potenti. Ut quis vulputate lorem, in gravida est. Nunc
						auctor tempus tortor, vel mollis felis auctor ac. Pellentesque
						habitant morbi tristique senectus et netus et malesuada fames ac
						turpis egestas. Proin vestibulum sed mi et maximus. Quisque id
						quam tempor, luctus quam sagittis, vestibulum magna. Nullam
						suscipit elit eget justo maximus maximus. Integer eget dolor eu mi
						bibendum venenatis.</p>
				</div>
				<div class="noticia">
					<h3 class="titulo_noticia">Participa en el Sorteo</h3>
					<hr class="linea_noticia">
					<img class="pull-left" src="images/noticia3.jpg" alt="Sorteo" />

					<p class="cuerpo_noticia">Aenean tellus purus, lacinia quis
						erat et, porta aliquet urna. Morbi in diam sit amet quam fringilla
						viverra sit amet vitae dui. Nam nec turpis tincidunt, luctus ante
						sed, tempor tortor. Nulla eros felis, sagittis sit amet quam ac,
						pellentesque iaculis magna. Suspendisse cursus et diam nec tempor.
						Pellentesque nulla justo, congue ac eleifend sit amet, imperdiet
						eget nisl. Nam eros lorem, consectetur nec sollicitudin at,
						consectetur at tortor. Donec fermentum non justo ac tristique.
						Suspendisse potenti. Ut quis vulputate lorem, in gravida est. Nunc
						auctor tempus tortor, vel mollis felis auctor ac. Pellentesque
						habitant morbi tristique senectus et netus et malesuada fames ac
						turpis egestas. Proin vestibulum sed mi et maximus. Quisque id
						quam tempor, luctus quam sagittis, vestibulum magna. Nullam
						suscipit elit eget justo maximus maximus. Integer eget dolor eu mi
						bibendum venenatis.</p>
				</div>

			</div>
			<div class="derecha col-sm-4">
				<div>
					<div class="login">
						<h4>Bienvenido a la Academia. Logueate!!</h4>
						<s:form class="form-horizontal" role="form" action="login">
                                                    <s:textfield class="form-control" name="usuario" label="Usuario" />
                                                    <s:password class="form-control" name="contrasena" label="Password" />
                                                    <s:submit/>
                                                </s:form>
					</div>
					<div class="mapa">
						<h4>Donde encontrarnos</h4>

						<script async defer
							src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCtjplVvvGq514g4FWk9zxRj6Z9jYoyFeg&callback=initMap">
							
						</script>
						<div id="map"></div>
					</div>
					<div class="rrss">
						<a class="twitter-timeline" href="https://twitter.com/vcaruncho"
							data-widget-id="383545000434221057">Tweets por el @vcaruncho.</a>
						<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>

					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="container">
		<div class="datos_footer col-sm-6">
			<img class="imagen_pie" src="images/pie2.png"">
		</div>
		<div class="links_footer col-sm-6">
			<ul class="list-inline">
				<li><a href="#"> Sobre Nosotros</a></li>
				<li><a href="#">Privacidad</a></li>
				<li><a href="#">Accesibilidad</a></li>
				<li><a href="#">Aviso Legal</a></li>
			</ul>
		</div>

	</footer>
</body>
</html>
