<%@page import="java.util.List"%>
<%@page import="com.captton.model.Empleado"%>
<%@page import="com.captton.dao.EmpleadoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% List<Empleado> lista = EmpleadoDAO.listar(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border =1>
		<tr>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Departamento</td>
		</tr>
		<%for(Empleado emp : lista){ %>
		<tr>
			<td><%=emp.getNombre() %></td>
			<td><%=emp.getApellido() %></td>
			<td><%=emp.getDpto().getNombre() %></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>