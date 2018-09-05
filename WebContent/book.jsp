<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="book" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Store</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/lib/bootstrap.min.css">
</head>
<body>
	<%
		if (session.getAttribute("email") == null) {
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="header2.jsp"></jsp:include>
	<%
		}
	%>
	<%
		if (request.getParameter("isbn") != null) {
	%>
	<jsp:useBean class="beans.BookBean" scope="page" id="bookBean"></jsp:useBean>
	<jsp:setProperty property="isbn" name="bookBean" />
	<book:set var="book" value="${bookBean.book}"></book:set>
	<div class="container mt-3 mb-3">
		<h3 class="text-uppercase">${book.title}</h3>
		<hr />
		<div class="row">
			<div class="col-12 mb-3">
				<img src="data:image/jpeg;base64,${book.cover}"
					class="img-fluid mx-auto d-block" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-12">
				<b>Name: </b> <span class="text-uppercase">${book.title}</span>
			</div>
			<div class="col-md-6 col-12">
				<b>Author: </b> <span class="text-capitalize">${book.author}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-12">
				<b>Publisher: </b> <span class="text-captalize">${book.publisher}</span>
			</div>
			<div class="col-md-6 col-12">
				<b>Category: </b> <span class="text-capitalize">${book.category}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<p>
					<b>Description:</b>
				</p>
				<p>${book.description}</p>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<b>Price:</b> <span>&#8377; ${book.price}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<form action="addToCart.jsp" method="post">
					<label for="quantity">Quantity</label>
					<fmt:parseNumber var="qtny" type="number"
						value="${book.qtyAvailable}" />
					<select name="quantity" id="quantity" class="form-control mb-3">
						<book:forEach begin="1" end="${qtny}" varStatus="loop">
							<option value="${loop.index}">${loop.index}</option>
						</book:forEach>
					</select> <input type="hidden" name="isbn" value="${book.isbn}" /> <input
						type="submit" class="btn btn-outline-primary mx-auto d-block"
						value="Add to Cart" />
				</form>
			</div>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>