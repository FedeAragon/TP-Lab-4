<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
</head>
<body>
  <div class="contenedor">
 <br><br><br><br><br><br><br><br>
 <div class="fondo">
 <form method ="post" action="ServletLogin">
 <p id="titulo" class ="titulos" >Login</p>
  <hr>
  <br>
  <label id ="lblUsuario">
  Numero de Usuario</label>
  <br>
  <input type="text" name="txtUsuario" class= "texts" style="width: 400px; ">
  <br>
  <label id ="lblContra">
  Contraseņa</label>
  <br>
  <input type="password" name="passContra" class = "texts" style="width: 400px; ">
  <br>
  <br>
  <input type="submit" name="btnIngresar" value="Ingresar" class ="botones" style="width: 403px; "> 
  <%
	if(request.getAttribute("error")!=null){
		%>
		 <div style="display:flex; margin-top:10px;">
		 <i class="material-icons" style="font-size:24px; color:red">highlight_off</i>
		 &nbsp;
		 <p>Usuario o Contraseņa incorrecta</p>
		 </div>
		 <%
	}
  %>
  </form>
 </div>
 
  </div>
  
  <jsp:include page="Footer.html"></jsp:include>
  
</body>
</html>