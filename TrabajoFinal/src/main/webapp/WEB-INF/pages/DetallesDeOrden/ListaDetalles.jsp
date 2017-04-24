<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles de orden</title>
</head>
<body>
	<table border=3>
		<tr>
			<th>Item</th>
			<c:if test="${orden.estado==true}">
				<th>Costo Unitario</th>
			</c:if>
			<th>Cantidad</th>
			<c:if test="${orden.estado==true}">
				<th>SubTotal</th>
			</c:if>

		</tr>
		<tr>
			<c:if test="${orden.estado==true}">
				<td>Mano de obra</td>
				<td>${orden.manoDeObra}</td>
				<td>${orden.horasTrabajadas}</td>
				<td>${orden.manoDeObra*orden.horasTrabajadas}</td>
			</c:if>

		</tr>
		<c:forEach var="detalle" items="${listaDetalles}">
			<tr>
				<td><c:out value="${detalle.repuesto.nombre}"></c:out></td>
				<c:if test="${orden.estado==true}">
					<td><c:out value="${detalle.repuesto.precio}"></c:out></td>
				</c:if>
				<td><c:out value="${detalle.cantidadUsadaDeRepuesto}"></c:out></td>
				<c:if test="${orden.estado==true}">
					<td><c:out value="${detalle.costo}"></c:out></td>
				</c:if>
				<c:if test="${orden.estado==false}">
					<td><a
						href="../../DetalleDeOrden/ModificarDetalle/${detalle.orden.id}/${detalle.repuesto.id}">Modificar</a></td>
				</c:if>
				<c:if test="${orden.estado==false}">
					<td><a
						href="../../DetalleDeOrden/BorrarDetalle/${detalle.orden.id}/${detalle.repuesto.id}">Borrar</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${orden.estado==true}">
		<label>Costo total: ${orden.costo}</label>
	</c:if>

	<br>
	<br>
	<c:if test="${orden.estado==false}">
		<a href="../../DetalleDeOrden/NuevoDetalle/${id}">Cargar nuevo repuesto</a>
	</c:if>
	<br>
	<a var="detalle" href="../../OrdenDeTrabajo/ListaOrdenes">Volver</a>
</body>
</html>