<%@page import="com.captton.libros.clases.Biblioteca"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%	String title = request.getParameter("titulo");
    	String author = request.getParameter("autor");
    	String edit = request.getParameter("editorial");
    	String year = request.getParameter("anio");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Libreria</title>
</head>
<body>
	<% Biblioteca.agregarLibro(title, author, edit, year); %>
	<table border="1">
		<tr>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Editorial</th>
			<th>Año</th>
		</tr>
		<%String asd = Biblioteca.leerLibro();
		  Integer posicion = 0;
		  String[] txt = asd.split(";");%>
		<%while(txt.length != posicion ){%>
		<tr>
			<td><%=txt[posicion]%></td>
			<td><%=txt[posicion+ 1]%></td>
			<td><%=txt[posicion+ 2]%></td>
			<td><%=txt[posicion+ 3]%></td>
			<%posicion = posicion + 4;%>
		</tr>
		 <% }%>
	</table>
	<form action="formulario.jsp">
		<input type = "submit" value = "Agregar otro libro">
	</form>

</body>
</html>