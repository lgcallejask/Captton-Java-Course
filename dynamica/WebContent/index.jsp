<%@page import="com.Captton.ejemplo.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%ArrayList<Persona> listaPersonas = new ArrayList(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%Persona persona1 = new Persona("p1"); %>
<%Persona persona2 = new Persona("p2"); %>
<%Persona persona3 = new Persona("p3"); %>
<%listaPersonas.add(persona1); %>
<%listaPersonas.add(persona2); %>
<%listaPersonas.add(persona3); %>
<body>
	<table border=1>	
		<tr><td>Nombre Persona</td></tr>
		<%for (Persona p : listaPersonas){%>
			<tr>
				<td><%=p.getNombre() %></td>
			</tr>
		<%}%>
	</table>
</body>
</html>