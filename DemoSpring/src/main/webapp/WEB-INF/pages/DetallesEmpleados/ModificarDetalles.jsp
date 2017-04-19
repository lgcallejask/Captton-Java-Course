<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Detalles</title>
</head>
<body>
	<form:form modelAttribute="detalle" action="../ModificarDetalles/${detalle.id}" method="post">
		<form:label path="direccion">Direccion</form:label><form:input path="direccion" maxlength="50"/> <br>
		<form:label path="provincia">Provincia</form:label><form:input path="provincia" maxlength="50"/> <br>
		<form:label path="pais">Pais</form:label><form:input path="pais" maxlength="10"/> <br>

		<input type="submit" value="Enviar">
	</form:form>

</body>
</html>