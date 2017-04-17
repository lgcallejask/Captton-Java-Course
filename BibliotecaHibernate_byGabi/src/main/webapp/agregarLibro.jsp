<%@page import="javax.persistence.Temporal"%>
<%@page import="java.util.Date"%>
<%@page import="com.captton.model.Libro"%>
<%@page import="com.captton.model.Genero"%>
<%@page import="com.captton.dao.GeneroDAO"%>
<%@page import="com.captton.dao.LibroDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.captton.dao.EditorialDAO"%>
<%@page import="com.captton.model.Editorial"%>
<%@page import="com.captton.dao.AutorDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.captton.model.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Autor> listaAutor = AutorDAO.listarAutores();
   List<Editorial> listaEditorial = EditorialDAO.listarEditoriales();
   List<Genero> listaGenero = GeneroDAO.listarGeneros();
   
   if(request.getMethod().equals("POST"))
	{
		String titulo = request.getParameter("titulo");
		Date fecha = Date.parse(request.getParameter("fecha"));
		Editorial editorial = EditorialDAO.getEditorial(Long.parseLong(request.getParameter("idEditorial")));
		String[] listaIdAutor = request.getParameterValues("idAutor");
		String[] listaIdGenero = request.getParameterValues("idGenero");		
		
		List<Autor> listaAut_aux = new ArrayList();
		for(String id_a : listaIdAutor)
		{
			listaAut_aux.add(AutorDAO.getAutor(Long.parseLong(id_a)));
		}
		
		
		List<Genero> listaGen_aux = new ArrayList();
		for(String id_g : listaIdGenero)
		{
			listaGen_aux.add(GeneroDAO.getGenero(Long.parseLong(id_g)));
		}
		
		LibroDAO.agregarLibro(new Libro(titulo,editorial,fecha,listaGen_aux,listaAut_aux));
			response.sendRedirect("Index.jsp");
			return;
	}
	
   
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ingresar nuevo libro</title>
</head>
<body>
	<form action="#" method="post">
		
		
		<h2>Ingrese los datos del libro</h2>
		<br></br>
		<label>Titulo</label>
		<input type="text" name="titulo" placeholder="Ingrese el titulo" >
		<br></br>
		<label>Autor/es</label>
		<br></br>
		<select multiple name="idAutor">
			<%for(Autor aut : listaAutor){ %>
			<option value="<%=aut.getId()%>"><%=aut.getNombre() %></option>
			<%} %>
		</select>
		<br></br>
		<label>Fecha de edicion</label>
		<input type="text" name="fecha" placeholder="Ingrese el año de edicion" >
		<br></br>
		<label>Genero</label>
		<br></br>
		<select multiple name="idGenero">
			<%for(Genero gen : listaGenero){ %>
			<option value="<%=gen.getId()%>"><%=gen.getNombre() %></option>
			<%} %>
		</select>
		<br></br>
		<select name="idEditorial">
			<%for(Editorial edi : listaEditorial){ %>
			<option value="<%=edi.getId()%>"><%=edi.getNombre() %></option>
			<%} %>
		</select> <br></br>
		
		<input type="submit" value="Agregar">
	</form>
</body>
</html>