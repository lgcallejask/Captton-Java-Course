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
			<th>Numero de Orden</th>
			<th>Patente</th>
			<th>Fecha Ingreso</th>
			<th>Propietario</th>
			<th>Marca</th>
			<th>Modelo</th>
			<th>Descripcion</th>
			<th>Empleado</th>
			<th>Estado</th>
			<th>Horas Trabajadas</th>
			<th>Costo Total</th>
		</tr>
		<c:forEach var="orden" items="${listaOrdenes}">
			<tr>
				<td><c:out value="${orden.id}"></c:out></td>
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
					<td><c:out value="Finalizada"></c:out></td>
				</c:if>
				<c:if test="${orden.estado==false}">
					<td><c:out value="Orden sin finalizar"></c:out></td>
				</c:if>
				<c:if test="${orden.estado==true}">
					<td><c:out value="${orden.horasTrabajadas}"></c:out></td>
				</c:if>
				<c:if test="${orden.estado==false}">
					<td><c:out value="Orden sin finalizar"></c:out></td>
				</c:if>
				<c:if test="${orden.estado==true}">
					<td><c:out value="${orden.costo}"></c:out></td>
				</c:if>
				</td>
				<td><a href="../DetalleDeOrden/ListaDetalles/${orden.id}">Ver Detalles</a></td>
				<c:if test="${orden.estado==false}">
					<td><a href="ModificarOrden/${orden.id}">Modificar</a></td>
				</c:if>
				<c:if test="${orden.estado==false}">
					<td><a href="FinalizarOrden/${orden.id}">Finalizar</a></td>
				</c:if>
			</tr>

		</c:forEach>


	</table>
	<br>
	<a href="NuevaOrden">Crear nueva orden</a>
	<br>
	<a href="/TrabajoFinal">Volver</a>
</body>
</html>