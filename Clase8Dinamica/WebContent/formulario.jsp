<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar libro</title>
</head>
<body>
	<form action="index.jsp">
		<label>Titulo</label><input type="text" name="titulo" placeholder="Titulo del libro">
		<br>
		<label>Autor</label><input type="text" name="autor" placeholder="Nombre autor">
		<br>
		<label>Editorial</label><input type="text" name="editorial" placeholder="Nombre editorial">
		<br>
		<label>Año</label><input type="text" name="anio" placeholder="Año">
		<br>
		<input type="submit" value="Agregar libro">
	</form>
</body>
</html>