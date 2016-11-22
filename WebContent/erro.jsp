<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
	<form action="index.html" method="get">
	<% 
		
		Map<String,String[]> parametros = request.getParameterMap();
		Map<String,String> getParametros = new HashMap<String,String>();
		String nomeDaClasse = parametros.get("tipo")[0];
		String Metodo = parametros.get("acao")[0];
		
		for(String a : parametros.keySet()){
			getParametros.put(a, parametros.get(a)[0]);
		}
		
		Dispatcher dis = new Dispatcher();
		
		Map<String, Method > MyMap = new HashMap<String,Method>();
		Object O = dis.cria("model."+nomeDaClasse);
		MyMap = dis.buscaSetters(O.getClass());
		
		for(String key : MyMap.keySet()){ //MyMap.get(key) == Metodo, key - nome do metodo
        	for(String door : getParametros.keySet()){
        		if( key.contains(door) ){
        			java.lang.reflect.Field field = O.getClass().getDeclaredField(key.substring(3, key.length()));
                    field.setAccessible(true);
                    
        			if( field.getAnnotation(action.Obrigatorio.class).parametros() && getParametros.get(door).equals("") ){
        				out.println("O campo: " + door + " è obrigatório"+ "<br>");
        			}
        			
        			//if( field.getAnnotation(action.Obrigatorio.class ).parametros() == true){ // erro aqui
        			//	out.println(key + "<br>");
        			//}
                    
        		}
        	}
		}
				
		
		
		%>
		
		<input type="submit" value="Home" name = "acao">
		</form>
</body>
</html>