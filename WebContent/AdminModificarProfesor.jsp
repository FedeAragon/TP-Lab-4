<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entidad.Docente" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
<title>Modificar Profesor</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="contenedor">
<form class="fondo" method="post" action="">

<div class="titulo_div">
  <label id="titulo" class ="titulos" >Modificar Profesor</label>
  </div>
  <hr>
<div class="cuadrado">
  
  <% 
  Docente doc= new Docente();
  if(request.getAttribute("docente")!= null){
	  doc = (Docente)request.getAttribute("docente");
  }
  %>
  <br>
  <div class="contenido">
  <label id ="lblLegajo" class="subtitulos">Numero de legajo</label>
  <input type="text" name="txtLegajo" class= "texts" disabled="disabled" value="<%= doc.getLegajo() %>" style="color:white;">
  <label id ="lblDNI" class="subtitulos">DNI </label>
  <input type="text" name="txtDNI" class= "texts" value="<%= doc.getDNI() %>">
  <label id ="lblDireccion" class="subtitulos">Direccion</label>
  <input type="text" name="txtDireccion" class= "texts" value="<%= doc.getDireccion() %>" >
  <label id ="lblLocalidad" class="subtitulos">Localidad</label>
   <input type="text" name="txtLocalidad" class="texts"  value="<%= doc.getLocalidad().getNombreLocalidad()%>">
    <label id ="lblTelefono" class="subtitulos">Telefono</label>
    <input type="text" name="txtTelefono" class= "texts" value="<%= doc.getTelefono() %>">
  
  </div>
  <div class="contenido">
  
  <label id ="lblNombreyap" class="subtitulos">Nombre y Apellido</label>
  <input type="text" name="txtNombre" class="texts" value="<%= doc.getNombreyAp() %>"  >
  <label id ="lblNacimiento" class = "subtitulos">Fecha de nacimiento</label>
  <input type="text" name="txtNacimiento" class= "texts" value="<%= doc.getFechaNacimiento() %>">
  <label id ="lblProvincia" class="subtitulos">Provincia</label>
 <select name="ddlProvincias" class = "Ddls">
					
 </select> 
  <label id ="lblEmail" class="subtitulos">Email</label>
  <input type="text" name="txtEmail" class= "texts" value="<%= doc.getEmail() %>">
  </div>
  

   </div>
   <div class="boton">
 <input type ="submit" name = "btnModificar" value = "Modificar" class = "botones">
 </div>
  

</form>
 
    </div>




<jsp:include page="Footer.html"></jsp:include>
  



</body>
</html>