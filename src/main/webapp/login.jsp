<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/lib/bootstrap.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h2>Login</h2>
		<hr />
		<form action="login.jsp" method="post">
			<div class="form-group">
				<label for="email">Email address</label> <input type="email"
					name="email" id="email" class="form-control" placeholder="Email"
					value="${param.email}" required />
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					name="password" class="form-control" id="password"
					placeholder="Password" required />
			</div>
			<input type="submit" value="Login"
				class="btn btn-outline-primary btn-block" /><br />
			<div class="text-center">
				<a href="register.jsp">Not yet registered?</a>
			</div>
		</form>
	</div>
	<script src="assets/js/script.js"></script>
</body>
<%
	if (request.getParameter("email") == null || request.getParameter("password") == null)
		return;
%>
<jsp:useBean class="com.example.beans.UserBean" scope="session" id="userBean" />
<jsp:setProperty name="userBean" property="*" />

<%
	String email = request.getParameter("email");
	if (userBean.login()) {
		session.setAttribute("email", email);
		response.sendRedirect("index.jsp");
	} else
		out.println("<br><h3 class='text-danger text-center'>Invalid Login. Please try again!</h3>");
%>
</html>