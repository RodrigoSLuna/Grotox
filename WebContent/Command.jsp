<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
  body {
  padding-top: 0px;
  text-align: center;
  font-family: Verdana,sans-serif;
  font-size: 15px;
  line-height: 1.5;
  background: url(https://s-media-cache-ak0.pinimg.com/originals/0d/e7/f6/0de7f6f548d42ce594e8a91d9a7e8cb7.gif) 50%;
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center; 
  margin: 0;
  margin-top: 0;
  
}

.top {
  position:relative;
  background-color:#ffffff;
  height:100px;
  padding-top:10px;
  line-height:60px;
  overflow:hidden;
  z-index:2;
  margin-top: 0;
}

.top-right {
  position:relative;
  float: right!important;
  padding-right:80;
  padding-top:15;
  font-weight: bold;
  font-size:120%;
}

.top-left {
  float: left!important;
  position:relative;
  padding-left:30;
  width:110px;
  height:95px;
}

.bg-text {
    float: right!important;
    overflow: hidden;
    margin-bottom: 20px;
    padding: 0px 50px 0px 0px;
    position: relative;
    width: 440px;
    z-index: -1;
}
.bg-text::after {
    content: attr(data-bg-text);
    display: block;
    font-size:130px;
    font-family: "Segoe UI",Arial,sans-serif;
    color: white;
    font-weight: bold;
    line-height: 1;
    position: fixed;
    bottom: 20px;
    right: 70px;
    z-index: -1;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    /*background-color: #4CAF50;*/
    background-color: #333;
}

li {
    text-align: center;
    float: center;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 15px 30px;
    text-decoration: none;
    font-size:110%;
}

li a:hover, .dropdown:hover .dropbtn {
    /*background-color: #333;*/
    background-color: #4CAF50;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    /*#f9f9f9*/
    background-color: #f2f2f2;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
  background-color: #4CAF50;
  color: white;
  }

.dropdown:hover .dropdown-content {
    display: block;
}

.center{
    margin: auto;
    width: 30%;
}

textarea {
    width: 100%;
    height: 150px;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    background-color: #f8f8f8;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
    color: black;
    resize: none;
    z-index:1;
}

input[type=text] {
    width: 100%;
    padding: 12px 0px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
    z-index:1;
    text-align: center;
}

input[type=pktext] {
    width: 100%;
    padding: 12px 0px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
    background-color:#FFF7CC;
    color: black;
    text-align: center;
}


input[type=submit] {
    width: 20%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 5px;
    margin-top: 20px;
    margin-bottom: 5px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

input[type=text]:focus {
    border: 3px solid #555;
}

input[type=pktext]:focus {
    border: 3px solid #555;
}

textarea:focus {
    border: 3px solid #555;
}

.box {
    margin-top: 5%;
    border-radius: 5px;
    border: 5px solid #ccc;
    background-color: #f2f2f2;
    border-color:#333;
    padding: 20px;
    z-index:2;
}

.blackbox {
    background-color:#333;
    padding: 15px;
    color:white;
    margin:-20px;
    z-index:2;
    font-size:40px;
    font-family: "Segoe UI",Arial,sans-serif;
    font-weight:bold;
    margin-bottom: 20px;
}


</style>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Bem vindo ao Centro de Comercialização IBAMA</title>
</head>
<body>
	<form action="swap2.jsp" method="get">	
	<%
		out.println(" <input type = \"hidden\" name = \"tipo\" value = \""+request.getParameter("tipo")+"\"> ");
		out.println(" <input type = \"hidden\" name = \"nome\" value = \""+request.getParameter("nome")+"\"> ");
	%>
	
	
	
	
    <div class="top">
      <div class="top-right"> Bem vindo ao Centro de Comercialização IBAMA</div>
      <img class="top-left" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Logo_IBAMA.svg/1052px-Logo_IBAMA.svg.png" alt="IBAMA logo">
    </div>
    <ul>
      <li class="dropdown">
        <a class="dropbtn" href="./index.html">Home</a></li>
      <li class="dropdown">
        <a href="#" class="dropbtn">Cadastro</a>
        <div class="dropdown-content">
         <a href="Command.jsp?tipo=Empresa">Empresa</a>
          <a href="Command.jsp?tipo=Produto">Produto</a>
          <a href="Command.jsp?tipo=Estado">Estado</a>
          <a href="Command.jsp?tipo=Regiao">Regiao</a>
          <a href="./cadastro/classe.html">Classe do Produto</a>
          <a href="./cadastro/ingrediente.html">Ingrediente Ativo</a>
          <a href="./cadastro/venda.html">Venda</a>
      </li> 
      <li class="dropdown">
        <a href="#" class="dropbtn">Consulta</a>
        <div class="dropdown-content">
          <a href="Consulta.jsp?tipo=Consulta_one">Consulta 1</a>
          <a href="Consulta.jsp?tipo=Consulta_two">Consulta 2</a>
          <a href="Consulta.jsp?tipo=Consulta_three">Consulta 3</a>
          <a href="Consulta.jsp?tipo=Consulta_four">Consulta 4</a>
          <a href="Consulta.jsp?tipo=Consulta_five">Consulta 5</a>
          <a href="Consulta.jsp?tipo=Consulta_six">Consulta 6</a>
          <a href="Consulta.jsp?tipo=Consulta_seven">Consulta 7</a>
          <a href="Consulta.jsp?tipo=Consulta_eight">Consulta 8</a>
          <a href="Consulta.jsp?tipo=Consulta_nine">Consulta 9</a>
          <a href="Consulta.jsp?tipo=Consulta_ten">Consulta 10</a>
        </div>
      </li>
    </ul>
    <div class="center box">
      <div class="blackbox"><% out.println( request.getParameter("tipo") );  %> </div>
        <input type="submit" value="Adicionar" name = "acao">
        <input type="submit" value="Editar"    name ="acao">
        <input type="submit" value="Excluir"   name = "acao">
        <input type="submit" value="Consultar" name = "acao">
      </form>
    </div>
        
    </div>
    <div class="bg-text" data-bg-text="Grotox"></div>
    
	
	<br>
	</form>
</body>
</html>
