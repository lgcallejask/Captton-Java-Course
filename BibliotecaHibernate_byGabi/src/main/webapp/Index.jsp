<%@page import="com.captton.model.Genero"%>
<%@page import="com.captton.model.Autor"%>
<%@page import="com.captton.dao.LibroDAO"%>
<%@page import="com.captton.model.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Libro> listaLibros = LibroDAO.listarLibros();


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Biblioteca</title>
</head>
<body>
	<table border="2">
		<tr>
			<td>Titulo</td>
			<td>Autor/es</td>
			<td>Genero</td>
			<td>Fecha de edicion</td>
			<td>Editorial</td>
		</tr>
		<% for(Libro lib : listaLibros){ %>
		<tr>
			<td><%=lib.getTitulo()%></td>
			<td>
			<%for(Autor aut: lib.getListaAutor()){ %>
			<%=aut.getNombre()%>
			<%if(lib.getListaAutor().indexOf(aut)!=lib.getListaAutor().size()-1){%>
			<%=";"%>			
			<%}} %>
			</td>
			<td>
			<%for(Genero gen: lib.getListaGenero()){ %>
			<%=gen.getNombre()%>
			<%if(lib.getListaGenero().indexOf(gen)!=lib.getListaGenero().size()-1){%>
			<%=";"%>			
			<%}} %>
			</td>
			<td><%=lib.getFecha()%>	</td>
			<td><%=lib.getEditorial().getNombre()%>
		</tr>
		<%} %>
	</table>
	<form action="agregarLibro.jsp"><input type="submit" value="Nuevo libro"></form>
</body>
</html>