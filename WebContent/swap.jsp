<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@page import="model.Estado" %>
<%@page import ="action.Dispatcher" %>
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

</head>
<body>

<form action ="Controller" method ="get" >
	<%
	/*
		Nao Automatizado!, se instanciar um novo parametro na Classe nao ira modificar!
	*/
		String a = request.getParameter("tipo");
		out.println(" <input type = \"hidden\" name = \"acao\" value = \""+request.getParameter("acao")+"\"> ");
		out.println(" <input type = \"hidden\" name = \"nome\" value = \""+request.getParameter("nome")+"\"> ");
		out.println("Voce deseja " + request.getParameter("acao") + " a " + request.getParameter("tipo") + "<br>" +request.getParameter("nome") + "?" );
		out.println(" <input type = \"hidden\" name = \"tipo\" value = \""+request.getParameter("tipo")+"\"> ");
		
		switch(request.getParameter("acao"))
		{
		case "Adicionar":
			out.println("Complete os dados por favor! <br><br>");
			if(a.equals("Disciplina")){ // automatizar isso
				out.println("Codigo  <input type=\"text\" name=\"codigo\"> <br><br>");
				out.println("Ementa  <input type=\"text\" name=\"ementa\"> <br><br>");
				out.println(" <input type=\"submit\" tipo= Disciplina value=\"Adicionar\">  ");
				
			}else if(a.equals("Professor")){
				//out.println(" <input type = \"hidden\" name = \"tipo\" value = \""+request.getParameter("tipo")+"\"> ");
				out.println("Email  <input type=\"text\" name=\"email\"> <br><br>");
				out.println(" <input type=\"submit\" value=\"Adicionar\">  ");
			}else if(a.equals("Sala")){
				
				out.println(" <input type = \"hidden\" name = \"tipo\" value = \""+request.getParameter("tipo")+"\"> ");
				out.println("Capacidade <input type =\"test\" name =\"capacidade\"> <br><br>");
				out.println(" <input type=\"submit\" value=\"Adicionar\">  ");
			
			}else if(a.equals("Turma")){
			
				out.println("Professor <input type =\"test\" name =\"professor\"> <br><br>");
				out.println("Disciplina <input type =\"test\" name =\"disciplina\"> <br><br>");
				out.println("Sala <input type =\"test\" name =\"sala\"> <br><br>");
				out.println("Horario <input type =\"test\" name =\"horario\"> <br><br>");
				out.println(" <input type=\"submit\" value=\"Adicionar\">  ");
			}
		break;
		case "Editar":
			out.println("Digite os novos campos! <br>");
			if(a.equals("Disciplina")){
				
				out.println("Codigo  <input type=\"text\" name=\"codigo\"> <br><br>");
				out.println("Ementa  <input type=\"text\" name=\"ementa\"> <br><br>");
				out.println(" <input type=\"submit\" tipo= Disciplina value=\"Editar\">  ");
				
			}else if(a.equals("Professor")){
				
				out.println("Email  <input type=\"text\" name=\"email\"> <br><br>");
				out.println(" <input type=\"submit\" value=\"Editar\">  ");
			
			}else if(a.equals("Sala") ){
				
				out.println("Capacidade <input type =\"test\" name =\"capacidade\"> <br><br>");
				out.println(" <input type=\"submit\" tipo= Sala value=\"Editar\">  ");
				
			}else if(a.equals("Turma")){
				
				out.println("Professor <input type =\"test\" name =\"professor\"> <br><br>");
				out.println("Disciplina <input type =\"test\" name =\"disciplina\"> <br><br>");
				out.println("Sala <input type =\"test\" name =\"sala\"> <br><br>");
				out.println("Horario <input type =\"test\" name =\"horario\"> <br><br>");
				out.println(" <input type=\"submit\" value=\"Editar\">  ");
			}
		break;
		case "Excluir":
				out.println(" <input type=\"submit\" value=\"Excluir\">  ");
		break;
		case "Consultar":
			// Consultar depois
				out.println(" <input type=\"submit\" value=\"Consultar\">");
		break;
		
		}
	%>
</form>
</body>
</html>