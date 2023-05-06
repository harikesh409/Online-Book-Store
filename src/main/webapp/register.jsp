<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/lib/bootstrap.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h2>Register</h2>
		<hr />
		<form action="register.jsp" method="post">
			<div class="form-group">
				<label for="name">Name</label> <input type="text" name="name"
					id="name" class="form-control" value="${param.name}"
					placeholder="Name" required />
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" name="email" id="email" value="${param.email}"
					placeholder="Email" required />
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Password" required />
			</div>
			<div class="form-group">
				<label for="cPassword">Confirm Password</label> <input
					type="password" class="form-control" id="cPassword"
					name="cPassword" placeholder="Confirm Password" required />
			</div>
			<div class="form-group">
				<label for="date">Date of Birth</label> <input type="date"
					class="form-control" id="date" name="date" required />
			</div>
			<div class="form-group">
				<p>
					Gender <span class="text-danger">*</span>
				</p>
				<div>
					<label for="male">Male</label> <input type="radio" name="gender"
						value="Male" id="male" required /> <label for="female">Female</label>
					<input type="radio" name="gender" value="female" id="femlae"
						required />
				</div>
			</div>
			<div class="form-group">
				<label for="city">City</label> <input type="text"
					class="form-control" id="city" name="city" placeholder="City"
					required />
			</div>
			<div class="form-group">
				<label for="country">Country</label> <input type="text"
					name="country" class="form-control" id="country"
					placeholder="Country" required />
			</div>
			<div class="form-group">
				<label for="address">Address</label>
				<textarea name="address" id="address" cols="30" rows="3"
					class="form-control" placeholder="Address" required></textarea>
			</div>
			<input type="submit" class="btn btn-outline-primary btn-block"
				value="Register" />
		</form>
	</div>
	<script src="assets/lib/jQuery.js"></script>
	<script src="assets/js/script.js"></script>
	<script src="assets/lib/popper.js"></script>
	<script src="assets/lib/bootstrap.min.js"></script>
</body>
</html>
<%
	if (request.getParameter("email") == null) {
		return;
	}
%>
<jsp:useBean class="com.example.beans.UserBean" scope="request" id="userBean"></jsp:useBean>
<jsp:setProperty property="*" name="userBean" />
<%
	if (userBean.register()) {
		out.println(
				"<h3 class='text-success text-center'>Registration was successful!. Please <a href='login.jsp'>login</a></h3>");
	} else {
		out.println(
				"<h3 class='text-danger text-center'>Sorry! Unable to process your registration. Try again!</h3>");
	}
%>