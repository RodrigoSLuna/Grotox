<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.Disciplina" %>
<%@page import="model.Professor" %>
<%@page import ="model.Sala" %>
<%@page import ="action.Dispatcher" %>
<%@page import = "model.Turma" %>
<%@page import="java.io.BufferedReader" %>
<%@page import="java.io.File" %>
<%@page import="java.io.FileReader" %>
<%@page import="java.io.FileWriter" %>
<%@page import="java.io.IOException" %>
<%@page import="java.io.PrintWriter" %>
<%@page import ="javax.servlet.ServletException"%>
<%@page import ="javax.servlet.annotation.WebServlet"%>
<%@page import ="javax.servlet.http.HttpServlet"%>
<%@page import ="javax.servlet.http.HttpServletRequest"%>
<%@page import ="javax.servlet.http.HttpServletResponse"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar</title>
</head>
<body>
	<form action="index.html" method="get">	
		<br>Consulta: <br/>
		<input type="submit" value="Home" name = "acao">
		<%
		request.getParameter("tipo");
		BufferedReader buffRead = new BufferedReader(new FileReader(request.getParameter("tipo")+".txt"));
		String linha = "";
		while (true) {
			if (linha != null) {
				out.println(linha +"<br>");
				
			} else
				break;
			linha = buffRead.readLine();
		}
		out.close();
		buffRead.close();
		%>
		
		
		<input type="submit" value="Home" name = "acao">
		</form>
</body>
</html>