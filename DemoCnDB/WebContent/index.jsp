<%@page import="com.captton.clases.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.captton.clases.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//	Database.insertarAlumno(new Alumno("Juana","LaCubana",37,"26582384",1));
	ArrayList<Alumno> lista = Database.listarAlumnos();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Edad</td>
			<td>Localidad</td>
		</tr>
		<%
			for (Alumno alu : lista) {
		%><tr>
			<td><%=alu.getNombre()%></td>
			<td><%=alu.getApellido()%></td>
			<td><%=alu.getEdad()%></td>
			<td><%=alu.getIdLocalidad()%></td>
			<td><a href="borrar.jsp?id=<%=alu.getId()%>">Borrar</a></td>
			<td><a href="insertarModificar.jsp?id=<%=alu.getId()%>">Modificar</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<a href="insertarModificar.jsp">DAR DE ALTA ALUMNO</a>
</body>
</html>