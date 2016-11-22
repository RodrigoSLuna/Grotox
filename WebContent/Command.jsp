<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Disciplina</title>
</head>
<body>
	<form action="swap2.jsp" method="get">	
	<%
		switch(request.getParameter("tipo"))
		{
		case "Estado": out.println("Codigo do Estado");
		out.println( " <input type=\"text\" name=\"nome\"> " );
		break;
		case "Professor" : out.println("Nome do Professor");
		out.println("<input type=\"text\" name=\"nome\">");
		break;
		case "Sala": out.println("Numero da Sala");
		out.println("<input type=\"text\" name=\"nome\">");
		break;
		case "Turma": out.println("Nome da Turma");
		out.println("<input type=\"text\" name=\"nome\">");
		default:;
		break;
 		}
		out.println(" <input type = \"hidden\" name = \"tipo\" value = \""+request.getParameter("tipo")+"\"> ");
		out.println(" <input type = \"hidden\" name = \"nome\" value = \""+request.getParameter("nome")+"\"> ");
	%>
	<br>
		<input type="submit" value="Adicionar" name = "acao">
		<input type="submit" value="Editar" name = "acao">
		<input type="submit" value="Excluir" name = "acao">
		<input type="submit" value="Consultar" name = "acao">
		
	</form>
</body>
</html>
