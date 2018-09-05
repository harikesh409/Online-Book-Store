<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp">Online Book Store</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
				<li class="nav-item"><a href="search.jsp" class="nav-link">Search
						Books</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Categories </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="category.jsp?cat=Novel">Novel</a> <a
							class="dropdown-item" href="category.jsp?cat=Engineering">Engineering</a>
						<a href="category.jsp?cat=Medical" class="dropdown-item">Medical</a>
						<a href="category.jsp?cat=Arts" class="dropdown-item">Arts
							&amp; Photography</a> <a href="category.jsp?cat=Cooking"
							class="dropdown-item">Cooking</a> <a
							href="category.jsp?cat=Others" class="dropdown-item">Others</a>
					</div></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a href="login.jsp" class="nav-link">Login</a></li>
				<li class="nav-item"><a href="register.jsp" class="nav-link">Register</a></li>
			</ul>
		</div>
	</nav>
	<script src="assets/lib/jQuery.js"></script>
	<script src="assets/js/menu.js"></script>
	<script src="assets/lib/popper.js"></script>
	<script src="assets/lib/bootstrap.min.js"></script>
</body>
</html>