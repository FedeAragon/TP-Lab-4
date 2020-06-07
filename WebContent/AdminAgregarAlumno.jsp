<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
<title>Agregar Alumno</title>
</head>
<body>
<jsp:include page="Menu.html"></jsp:include>
<div class="contenedor">
<div class="fondo">

<div class="titulo_div">
  <label id="titulo" class ="titulos" >Agregar Alumnos</label>
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
  <select name="pais" class = "Ddls">
						<option value="1">Buenos Aires</option>
						<option value="2">Catamarca</option>
						<option value="3">Chaco</option>
						<option value="4">Chubut</option>
						<option value="5">Córdoba</option>
						<option value="6">Corrientes</option>
						<option value="7">Entre rios</option>
						<option value="8">Formosa</option>
						<option value="9">Jujuy</option>
						<option value="10">La Pampa</option>
						<option value="11">La Rioja</option>
						<option value="12">Mendoza</option>
						<option value="13">Misiones</option>
						<option value="14">Neuquén</option>
						<option value="15">Rio Negro</option>
						<option value="16">Salta</option>
						<option value="17">San Juan</option>
						<option value="18">San Luis</option>
						<option value="19">Santa Cruz</option>
						<option value="20">Santa Fe</option>
						<option value="21">Santiago del Estero</option>
						<option value="22">Tierra del Fuego</option>
						<option value="23">Tucuman</option>
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