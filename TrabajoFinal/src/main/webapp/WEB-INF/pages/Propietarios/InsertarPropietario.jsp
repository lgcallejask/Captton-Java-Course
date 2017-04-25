<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="../resources/estilo.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo Propietario</title>
</head>
<h1>Cargar Propietario</h1>
<body>
	<form:form modelAttribute="propietario" action="NuevoPropietario" method="post">
		<form:label path="Dni">DNI:</form:label>
		<form:input path="dni" />
		<br>
		<form:label path="Nombre">Nombre:</form:label>
		<form:input path="nombre" />
		<br>
		<form:label path="Apellido">Apellido:</form:label>
		<form:input path="apellido" />
		<br>
		<form:label path="Direccion">Direccion:</form:label>
		<form:input path="direccion" />
		<br>
		<form:label path="Telefono">Telefono:</form:label>
		<form:input path="telefono" />
		<br>
		<br>
		<input type="submit" value="Enviar" class="button">
		<br>
	</form:form>
	<a href="../OrdenDeTrabajo/NuevaOrden">Volver</a>
</body>
</html>