<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="book" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Books</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/lib/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/grid.css" />
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
	<div class="container mt-3">
		<h3>Search Books</h3>
		<hr />
		<form action="search.jsp" method="post" class="mb-3">
			<div class="input-group">
				<input type="search" class="form-control form-control-lg"
					name="query" placeholder="Title or Author" value="${param.query}"
					aria-describedby="searchBtn" />
				<div class="input-group-append">
					<input type="submit" value="Search"
						class="btn btn-outline-primary btn-lg" id="searchBtn" />
				</div>
			</div>
		</form>
		<book:if test="${!empty param.query}">
			<jsp:useBean class="beans.BookBean" scope="page" id="bookBean"></jsp:useBean>
			<jsp:setProperty property="title" name="bookBean" param="query" />
			<div id="books" class="row view-group">
				<book:set var="books" value="${bookBean.searchResults}"></book:set>
				<book:if test="${books.size() == 0}">
					<div class="col">
						<h3 class="text-danger text-center">Sorry! No books found</h3>
					</div>
				</book:if>
				<book:forEach var="book" items="${books}">
					<div class="item col-lg-4 col-4">
						<div class="thumbnail card">
							<div class="img-event">
								<img src="data:image/jpeg;base64,${book.cover}"
									class="img-fluid" />
							</div>
							<div class="caption card-body">
								<h4 class="card-title inner text-uppercase">${book.title}</h4>
								<h6
									class="card-subtitle text-capitalize font-weight-light text-right">
									- ${book.author}</h6>
								<p class="inner">${book.description}</p>
								<div class="row">
									<div class="col-md-6 col-12">
										<p class="lead">&#8377; ${book.price}</p>
									</div>
									<div class="col-md-6 col-12">
										<a href="book.jsp?isbn=${book.isbn}"
											class="btn btn-outline-primary">View Details</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</book:forEach>
			</div>
		</book:if>
	</div>
</body>
</html>