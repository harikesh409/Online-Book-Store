<%@page import="jdk.management.resource.internal.TotalResourceContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="book" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/lib/bootstrap.min.css">
</head>
<body>
	<jsp:include page="header2.jsp"></jsp:include>
	<jsp:useBean class="beans.CartBean" scope="session" id="cartBean"></jsp:useBean>
	<div class="container mt-3 mb-3">
		<h3>Cart</h3>
		<hr />
		<book:set var="cartItems" value="${cartBean.cartItems}"></book:set>
		<book:set var="total" value="0"></book:set>
		<book:if test="${cartItems.size() > 0}">
			<div class="responsive">
				<table class="table table-striped table-hover">
					<thead class="table-primary">
						<tr>
							<th scope="col">Sr. No.</th>
							<th scope="col">Product</th>
							<th scope="col">Price</th>
							<th scope="col">Quantity</th>
							<th scope="col">Total</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<book:forEach var="item" items="${cartItems}" varStatus="loop">
							<tr>
								<th scope="row">${loop.index +1}</th>
								<td><img src="data:image/jpeg;base64,${item.cover}"
									class="img-fluid mx-auto d-block" width="150" height="150" /></td>
								<td>${item.price}</td>
								<td>${item.quantity}</td>
								<td>${item.price * item.quantity}</td>
								<td><a href="cart.jsp?remove=${item.isbn}">X</a></td>
							</tr>
						</book:forEach>
					</tbody>
				</table>
				<button class="bnt btn-outline-primary">Proceed to checkout</button>
			</div>
		</book:if>
		<book:if test="${cartItems.size() <= 0}">
			<h3 class="text-center">No Items in Cart</h3>
		</book:if>
	</div>
</body>
<%
	if (request.getParameter("remove") != null) {
		cartBean.removeItem(request.getParameter("remove"));
		response.sendRedirect("cart.jsp");
	}
%>
</html>
