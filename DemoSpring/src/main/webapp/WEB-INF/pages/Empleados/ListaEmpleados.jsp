<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de todos los empleado</title>
</head>
<body>
	<table>
		<tr>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Fecha Nacimiento</td>
			<td>Departamento</td>
			<td>Borrar</td>
		</tr>
		<c:forEach var="empleado" items="${listaEmp}">
			<tr>
				<td><c:out value="${empleado.nombre}"></c:out></td>
				<td><c:out value="${empleado.apellido}"></c:out></td>
				<td><c:out value="${empleado.fecha_nacimiento}"></c:out></td>
				<td><c:out value="${empleado.dpto.nombre}"></c:out></td>
				<td><a href="Borrar/${empleado.id}">Borrar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br>
	<a href="Nuevo">Dar de alta nuevo empleado</a>
</body>
</html>