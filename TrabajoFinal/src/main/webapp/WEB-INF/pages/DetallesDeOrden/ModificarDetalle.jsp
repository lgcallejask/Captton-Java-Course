<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="../../../resources/estilo.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar detalle</title>
</head>
<h1>Modificar detalle de Orden ${idOrden}</h1>
<body>
	<form:form modelAttribute="detalle" action="../../ModificarDetalle/${idOrden}/${idRepuesto}" method="POST">
		<input type="hidden" name="orden.id" value="${detalle.orden.id}">
		<br>
		<input type="hidden" name="repuesto.id" value="${detalle.repuesto.id}">
		<br>
		<form:label path="repuesto.nombre">Repuesto: ${detalle.repuesto.nombre}</form:label>
		<br>
		<form:label path="cantidadUsadaDeRepuesto">Cantidad usada de repuesto:</form:label>
		<form:input path="cantidadUsadaDeRepuesto" />
		<br>
		<input type="submit" value="Enviar">
	</form:form>	
	<a href="../../ListaDetalles/${idOrden}">Volver</a>
</body>
</html>