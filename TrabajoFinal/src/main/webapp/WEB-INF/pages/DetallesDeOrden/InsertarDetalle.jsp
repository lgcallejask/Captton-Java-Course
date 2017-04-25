<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="../../resources/estilo.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo Detalle</title>
</head>
<h1>Nuevo Detalle</h1>
<body>
	<form:form modelAttribute="detalle" action="../NuevoDetalle" method="POST">
		<input type="hidden" name="orden.id" value="${detalle.orden.id}">
		<form:label path="repuesto.id">Repuesto:</form:label>
		<form:select path="repuesto.id">
			<c:forEach items="${repuestos}" var="repuesto">
				<form:option value="${repuesto.id}">
					<c:out value="${repuesto.getNombre()}"></c:out>
				</form:option>
			</c:forEach>
		</form:select>
		<br>
		<form:label path="cantidadUsadaDeRepuesto">Cantidad usada de repuesto:</form:label>
		<form:input path="cantidadUsadaDeRepuesto" />
		<br>
		<br>
		<input type="submit" value="Enviar" class="button">
	</form:form>
	<a href="../ListaDetalles/${id}">Volver</a>
</body>
</html>