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
			<th>Item</th>
			<th>Costo Unitario</th>
			<th>Cantidad</th>
			<th>Costo Total</th>
		</tr>
		<c:forEach var="detalle" items="${listaDetalles}">
			<tr>
				<td><c:out value="${detalle.repuesto.nombre}"></c:out></td>
				<td><c:out value="${detalle.repuesto.precio}"></c:out></td>
				<td><c:out value="${detalle.cantidadUsadaDeRepuesto}"></c:out></td>
				<td><c:out value="${detalle.costo}"></c:out></td>
				
				<td><a href="../../DetalleDeOrden/ModificarDetalle/${detalle.orden.id}/${detalle.repuesto.id}">Modificar</a></td>
				<td><a href="../../DetalleDeOrden/BorrarDetalle/${detalle.orden.id}/${detalle.repuesto.id}">Borrar</a></td>

			</tr>

		</c:forEach>


	</table>
	<br>
	
	<!-- descomentar y terminar esto el lunes
	<form:form modelAttribute="detalle" action="NuevoDetalle" method="post">
		<input type="hidden" name="orden" value="${detalle.orden}">
		<br>
		<form:label path="repuesto">Repuesto:</form:label>
		<form:select path="repuesto">
			<c:forEach items="${repuestos}" var="repuesto">
				<form:option value="${repuesto}">
					<c:out value="${repuesto.getNombre()}"></c:out>
				</form:option>
			</c:forEach>
		</form:select>
		<br>
		<form:label path="cantidadUsadaDeRepuesto">Cantidad usada de repuesto:</form:label>
		<form:input path="cantidadUsadaDeRepuesto" />
		<br>
		<input type="submit" value="Enviar">
	</form:form>  -->
	
	
	<a href="../../DetalleDeOrden/NuevoDetalle">Crear nuevo detalle</a>
	<br>
	<td><a var="detalle" href="../../OrdenDeTrabajo/ListaOrdenes">Volver</a></td>
</body>
</html>