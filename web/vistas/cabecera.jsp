<header class="container">
	<h1>Academia</h1>
</header>
<nav class="container navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="http://localhost:8080/Academy/">Academia</a>
	</div>
	<ul class="nav navbar-nav">
		<li><a href="http://localhost:8080/Academy/">Home</a></li>
		<li><a href="http://localhost:8080/Academy/quien.html">Quienes
				Somos</a></li>
		<li><a href="http://localhost:8080/Academy/donde.html">Donde
				estamos</a></li>
		<li><a href="http://localhost:8080/Academy/blog.html">Blog</a></li>
		<li><a href="#">Hola <i><%=session.getAttribute("login") %> <%=session.getAttribute("rol") %></i></a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>           
</nav>
