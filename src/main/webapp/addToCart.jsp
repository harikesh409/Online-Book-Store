<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="com.example.beans.CartBean" scope="page" id="cartBean"></jsp:useBean>
	<jsp:setProperty property="isbn" name="cartBean"
		value='<%=request.getParameter("isbn")%>' />
	<jsp:setProperty property="quantity" name="cartBean"
		value='<%=Integer.parseInt(request.getParameter("quantity"))%>' />
	<%
		cartBean.addToCart();
		response.sendRedirect("cart.jsp");
	%>
</body>
</html>