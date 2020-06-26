<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.HttpSession"%> 
    <%@ page import ="entidad.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Menu.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
<title>Login</title>
</head>
<body>

<% 
HttpSession misession= (HttpSession) request.getSession();
Usuario usuario= (Usuario) misession.getAttribute("Usuario");
%>

  <header>
		<input type="checkbox" id="chc_menu" >
		<label for="chc_menu"><i class="material-icons" style="font-size:36px;">list</i></label>
		
		  <nav class="menu">
			  <ul>
				  <li><a href="ServletAdminTablaProfesores?Param=1">Profesores</a>
				   </li>
				  <li><a href="ServletAdminTablaAlumnos?Param=1">Alumnos</a>
				  </li>
				  <li><a href="ServletAdminTablaCursos?Param=1">Cursos</a>
				  
				  </li>
				  
				  <li><a href="">Item 4</a></li>
			  </ul>
		  </nav>
  			<div class="logout">
  				<i class="material-icons" style="font-size:36px;">engineering</i>
  				<i class="material-icons" style="font-size:36px;">person</i>
		  		<label id="Nombre"> <%= usuario.getUsuario() %>  </label>
		  		<a href="">Salir</a>
			  </div>
  </header>
</body>
</html>