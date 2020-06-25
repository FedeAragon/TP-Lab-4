<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
<title>Agregar Profesor</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="contenedor">
<div class="fondo">

<div class="titulo_div">
  <label id="titulo" class ="titulos" >Agregar Profesores</label>
  </div>
  <hr>
<div class="cuadrado">
  
  
  <br>
  <form class="contenido">
  <label id ="lblLegajo" class="subtitulos">Numero de legajo</label>
  <input type="text" name="txtLegajo" class= "texts" disabled="disabled">
  <label id ="lblDNI" class="subtitulos">DNI </label>
  <input type="text" name="txtDNI" class= "texts" >
  <label id ="lblDireccion" class="subtitulos">Direccion</label>
  <input type="text" name="txtDireccion" class= "texts" >
  <label id ="lblLocalidad" class="subtitulos">Localidad</label>
   <input type="text" name="txtLocalidad" class="texts">
    <label id ="lblTelefono" class="subtitulos">Telefono</label>
    <input type="text" name="txtTelefono" class= "texts">
  
  </form>
  <form class="contenido">
  
  <label id ="lblNombreyap" class="subtitulos">Nombre y Apellido</label>
  <input type="text" name="txtNombre" class="texts">
  <label id ="lblNacimiento" class = "subtitulos">Fecha de nacimiento</label>
  <input type="text" name="txtNacimiento" class= "texts" >
  <label id ="lblProvincia" class="subtitulos">Provincia</label>
 <select name="ddlProvincias" class = "Ddls">
						<option value="Buenos Aires">Buenos Aires</option>
						<option value="Catamarca">Catamarca</option>
						<option value="Chaco">Chaco</option>
						<option value="Chubut">Chubut</option>
						<option value="Córdoba">Córdoba</option>
						<option value="Corrientes">Corrientes</option>
						<option value="Entre rios">Entre rios</option>
						<option value="Formosa">Formosa</option>
						<option value="Jujuy">Jujuy</option>
						<option value="La Pampa">La Pampa</option>
						<option value="La Rioja">La Rioja</option>
						<option value="Mendoza">Mendoza</option>
						<option value="Misiones">Misiones</option>
						<option value="Neuquén">Neuquén</option>
						<option value="Rio Negro">Rio Negro</option>
						<option value="Salta">Salta</option>
						<option value="San Juan">San Juan</option>
						<option value="San Luis">San Luis</option>
						<option value="Santa Cruz">Santa Cruz</option>
						<option value="Santa Fe">Santa Fe</option>
						<option value="Santiago del Estero">Santiago del Estero</option>
						<option value="Tierra del Fuego">Tierra del Fuego</option>
						<option value="Tucuman">Tucuman</option>
 </select> 
  <label id ="lblEmail" class="subtitulos">Email</label>
  <input type="text" name="txtEmail" class= "texts">
  </form>
  

   </div>
   <div class="boton">
 <input type ="submit" name = "btnAgregar" value = "Agregar" class = "botones">
 </div>
  

</div>
 
    </div>




<jsp:include page="Footer.html"></jsp:include>
  



</body>
</html>