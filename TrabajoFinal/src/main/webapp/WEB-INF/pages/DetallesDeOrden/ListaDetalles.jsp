<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="../../resources/estilo.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles de orden</title>
</head>
<h1>Detalles de Orden ${id}</h1>
<body>
	<table>
		<tr>
			<th class="celda">Item</th>
			<c:if test="${orden.estado==true}">
				<th class="celda">Costo Unitario</th>
			</c:if>
			<th class="celda">Cantidad</th>
			<c:if test="${orden.estado==true}">
				<th class="celda">SubTotal</th>
			</c:if>

		</tr>
		<tr>
			<c:if test="${orden.estado==true}">
				<td class="celda">Mano de obra</td>
				<td class="celda">${orden.manoDeObra}</td>
				<td class="celda">${orden.horasTrabajadas}</td>
				<td class="celda">${orden.manoDeObra*orden.horasTrabajadas}</td>
			</c:if>

		</tr>
		<c:forEach var="detalle" items="${listaDetalles}">
			<tr>
				<td class="celda"><c:out value="${detalle.repuesto.nombre}"></c:out></td>
				<c:if test="${orden.estado==true}">
					<td class="celda"><c:out value="${detalle.repuesto.precio}"></c:out></td>
				</c:if>
				<td class="celda"><c:out value="${detalle.cantidadUsadaDeRepuesto}"></c:out></td>
				<c:if test="${orden.estado==true}">
					<td class="celda"><c:out value="${detalle.costo}"></c:out></td>
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