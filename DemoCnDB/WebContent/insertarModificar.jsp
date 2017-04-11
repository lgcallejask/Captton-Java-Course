<%@page import="com.captton.clases.Alumno"%>
<%@page import="com.captton.clases.Localidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.captton.clases.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Localidad> listaLoc = Database.listarLocalidad();

	if(request.getMethod().equals("POST"))
	{
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int idLoc = Integer.parseInt(request.getParameter("idLocalidad"));
		
		Database.insertarAlumno(new Alumno(nombre,apellido,edad,dni,idLoc));
		response.sendRedirect("index.jsp");
	}
	else
	{
		
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="#" method="POST">
	<label>Nombre</label><input type="text" name="nombre"></br>
	<label>Apellido</label><input type="text" name="apellido"></br>
	<label>Edad</label><input type="text" name="edad"></br>
	<label>Dni</label><input type="text" name="dni"></br>
	<label>Localidad</label>	
	<select name="idLocalidad">
	<%for(Localidad loc : listaLoc){ %>
		<option value="<%=loc.getId()%>"><%=loc.getNombre() %></option>
		<%} %>
	</select>
	</br>
	<input type="submit" value="Aceptar">

</form>
</body>
</html>