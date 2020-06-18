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
  <label id ="lblUsuario">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Numero de Usuario</label>
  <br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="txtUsuario" class= "texts" style="width: 400px; ">
  <br>
  <label id ="lblContra">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Contraseña</label>
  <br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="password" name="passContra" class = "texts" style="width: 400px; ">
  <br><br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="submit" name="btnIngresar" value="Ingresar" class ="botones" style="width: 403px; "> 
  </form>
 </div>
 
  </div>
  
  <jsp:include page="Footer.html"></jsp:include>
  
</body>
</html>