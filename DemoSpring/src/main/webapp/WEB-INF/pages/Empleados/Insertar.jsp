<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<form:form modelAttribute="empleado" action="Nuevo" method="POST">
	<form:label path="nombre">Nombre</form:label>	<form:input path="nombre" /><br>
	<form:label path="telefono">Telefono</form:label>	<form:input path="telefono" /><br>
	<form:label path="apellido">Apellido</form:label> <form:input path="apellido" /><br>
	<form:label path="fecha_nacimiento">Fecha de Nacimiento</form:label>
	 <form:input path="fecha_nacimiento" /><br>
	<form:label path="dpto">Departamento</form:label> <br>
	<form:select path="dpto.id"><br>
			<c:forEach items="${departamentos}" var="depto">
				<form:option value="${depto.id}">
					<c:out value="${depto.nombre}"></c:out>
				</form:option>
			</c:forEach>
		</form:select>
	<br><br><br><br>
		<input type="submit" value="Enviar">

	</form:form>
</center>

</body>
</html>