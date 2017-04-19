<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de empleados</title>
</head>
<body>
	<table border = 3>
		<tr>
			<th>Direcion</th>
			<th>Provincia</th>
			<th>Pais</th>

			
		</tr>

			<tr>
			<td><c:out value="${Detalle.getDireccion()}"></c:out></td>
			<td><c:out value="${Detalle.getProvincia()}"></c:out></td>
			<td><c:out value="${Detalle.getPais()}"></c:out></td>
			<td><a href="../ModificarDetalles/${Detalle.getId()}">Modificar detalles</a></td>
			</tr>
		
	

	</table>
	<a href="../../Empleado/Lista">Volver a la lista de empleados</a>
</body>
</html>