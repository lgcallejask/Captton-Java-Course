<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Ordenes de trabajo</title>
</head>
<body>
	<table border=3>
		<tr>
			<th>Patente</th>
			<th>Fecha Ingreso</th>
			<th>Propietario</th>
			<th>Marca</th>
			<th>Modelo</th>
			<th>Descripcion</th>
			<th>Empleado</th>
			<th>Estado</th>
			<th>Horas Trabajadas</th>
		</tr>
		<c:forEach var="orden" items="${listaOrdenes}">
			<tr>
				<td><c:out value="${orden.patente}"></c:out></td>
				<td><c:out value="${orden.fechaIngreso}"></c:out></td>
				<td><c:out value="${orden.propietario.getNombre()}"></c:out></td>
				<td><c:out value="${orden.marca}"></c:out></td>
				<td><c:out value="${orden.modelo}"></c:out></td>
				<td><c:out value="${orden.descripcion}"></c:out></td>
				<td><c:out value="${orden.empleado.getNombre()}"></c:out></td>
				<c:if test="${orden.estado==false}">
					<td><c:out value="En progreso"></c:out></td>
				</c:if>
				<c:if test="${orden.estado==true}">
					<td><c:out value="Completa"></c:out></td>
				</c:if>
				</td>
				<td><c:out value="${orden.horasTrabajadas}"></c:out></td>
				<td><a href="ModificarOrden/${orden.id}">Modificar</a></td>
				<!-- <td><a href="Borrar/${emple.id}">Borrar</a></td>
			<td><a href="../DetallesEmpleado/Detalles/${emple.id}">Ver Detalles</a></td> -->

			</tr>

		</c:forEach>


	</table>
	<br>
	<a href="NuevaOrden">Crear nueva orden</a>
	<br>
	<button type="button" name="back" onclick="history.back()">Volver</button>
</body>
</html>