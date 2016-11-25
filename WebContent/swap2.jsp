
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
<%@page import ="java.util.HashMap" %>
<%@page import ="java.util.Map" %>
<%@page import ="java.lang.reflect.Method "%>


</head>
<body>
<form action ="Controller" method ="get" >
	<%
	
		/*
		Tentativa de automatizar o web site, no entanto faltou tempo para setar
		os parametros no arquivo txt, bastava criar outros Dispatchers nos Forms.
		Falta de tempo =(
		swap2 (Beta)!
		*/
		//String a = request.getParameter("tipo");
		out.println(" <input type = \"hidden\" name = \"acao\" value = \""+request.getParameter("acao")+"\"> ");
		out.println(" <input type = \"hidden\" name = \"nome\" value = \""+request.getParameter("nome")+"\"> ");
		//out.println("Voce deseja " + request.getParameter("acao") + " a " + request.getParameter("tipo") + "<br>" +request.getParameter("nome") + "?" );
		//out.println(" <input type = \"hidden\" name = \"tipo\" value = \""+request.getParameter("nome")+"\"> ");
		
		Map<String,String[]> parametros = request.getParameterMap(); 
		Map<String,String> getParametros = new HashMap<String,String>();
		String nomeDaClasse = parametros.get("tipo")[0];
		
		for(String a : parametros.keySet()){
			getParametros.put(a, parametros.get(a)[0]);
		}
		
		Dispatcher dis = new Dispatcher();
		Map<String, Method > MyMap = new HashMap<String,Method>();
		Object O = dis.cria("model."+nomeDaClasse);
		MyMap = dis.buscaSetters(O.getClass());
		
		if(!request.getParameter("acao").equals("Consultar") && !request.getParameter("acao").equals("Excluir")){
			for(String key : MyMap.keySet()){
				if(!key.equals("setcodigo")){
					out.println(key.subSequence(3, key.length()) + " <input type=\"text\" name = \""+key.substring(3, key.length())+"\"> ");
					out.println("<br>");
				}
			}
			}
		//out.println(" <input type=\"submit\" value=\""+request.getParameter("acao") +"\">  ");


	%>
	
</form>
</body>
</html>