<%@page import="java.util.List"%>
<%@page import="com.captton.model.Libro"%>
<%@page import="com.captton.dao.LibroDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<% List<Libro> lista = LibroDAO.listar(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Libreria</title>
</head>
<body>
	<table border =1>
		<tr>
			<th>Titulo</th>
			<th>Editorial</th>
			<th>Fecha</th>
		</tr>
		<%for(Libro libro : lista){ %>
		<tr>
			<td><%=libro.getTitulo() %></td>
			<td><%=libro.getEditorial().getNombre() %></td>
			<td><%=libro.getFecha()%></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>