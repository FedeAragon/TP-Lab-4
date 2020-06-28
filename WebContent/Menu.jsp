<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.HttpSession"%> 
    <%@ page import ="entidad.Usuario" %>
    <%@ page import ="entidad.Docente" %>
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
	Usuario usuario = new Usuario();
	Docente prof = new Docente();
   if(session.getAttribute("usuario") != null && session.getAttribute("profesor")!=null){
	  usuario = (Usuario)session.getAttribute("usuario");
	  prof = (Docente)session.getAttribute("profesor");
	 
   }
%>

  <header>
		<input type="checkbox" id="chc_menu" >
		<label for="chc_menu"><i class="material-icons" style="font-size:36px;">list</i></label>
		
		  <nav class="menu">
			  <ul>
			  <%if(usuario.getTipoCuenta()==1){ %>
				  <li>
				  	<a href="ServletAdminTablaProfesores">Profesores</a>
				  </li>
				  <li>
				  	<a href="ServletAdminTablaAlumnos">Alumnos</a>
				  </li>
				  <li>
				  	<a href="ServletAdminTablaCursos">Cursos</a>
				  </li>
				  <li>
				  	<a href="AdminReportes.jsp">Reportes</a>
				  </li>
				 <% }else { %> 
				 	<li>
				  	<a href="ServletAdminTablaCursos">Cursos</a>
				  </li>
				 <%} %>
			  </ul>
		  </nav>
  			<div class="logout">
	  			<%if(usuario.getTipoCuenta()==1){ %>
	  				<i class="material-icons" style="font-size:36px;">engineering</i>
				<% }else { %> 
					 <i class="material-icons" style="font-size:36px;">person</i>
		       	<%} %>
		  		<label id="Nombre"> <%= prof.getNombreyAp() %>  </label>
		  		<a href="ServletLogin">Salir</a>
			  </div>
  </header>
</body>
</html>