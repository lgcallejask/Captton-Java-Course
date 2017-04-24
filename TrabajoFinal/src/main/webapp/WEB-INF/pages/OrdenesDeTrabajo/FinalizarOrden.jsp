<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Orden</title>
</head>
<body>
	
	<form:form modelAttribute="orden" action="../FinalizarOrden/${id}" method="post">  
		<form:input type="hidden" path="patente" value="${orden.patente}"/>
		<form:input type="hidden" path="fechaIngreso" value="${orden.fechaIngreso}"/>
		<form:input type="hidden" path="propietario.id" value="${orden.propietario.id}"/>
		<form:input type="hidden" path="marca" value="${orden.marca}"/>
		<form:input type="hidden" path="modelo" value="${orden.modelo}"/>
		<form:input type="hidden" path="descripcion" value="${orden.descripcion}"/>
		<form:input type="hidden" path="empleado.id" value="${orden.empleado.id}"/>
		<form:input type="hidden" path="estado" value="${true}"/>
		<form:label path="horasTrabajadas">Horas Trabajadas:</form:label>
		<form:input path="horasTrabajadas" />
		<br>
		<input type="submit" value="Enviar">
		<br>
	</form:form>
	<button type="button" name="back" onclick="history.back()">Volver</button>
</body>
</html>