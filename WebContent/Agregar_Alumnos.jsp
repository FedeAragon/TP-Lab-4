<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
</head>
<body>
  <header>
	 <input type="checkbox" id="chc_menu" >
	 <label for="chc_menu"><i class="material-icons" alt="">list</i></label>
	  
	  <nav class="menu">
	  <ul>
	  <li><a href="">Item 1</a></li>
	  <li><a href="">Item 2</a></li>
	  <li><a href="">Item 3</a></li>
	  <li><a href="">Item 4</a></li>
	  
	
	  </ul>
	  </nav>
  </header>
  
  <div class="contenedor">
  <br><br>
   <div class="cuadro">
  <form>
  <p id="titulo" class ="titulos" >Agregar Alumnos</p>
  <hr>
  <br>
  <!-- PARTE DERECHA DEL CUADRO -->
  <label id ="lblLegajo">Numero de legajo</label>
   <label id ="lblNombreyap" class="subtitulos2">   Nombre y Apellido</label>
  <br>
  <input type="text" name="txtLegajo" class= "texts" disabled="disabled">
  <input type="text" name="txtNombre" class="texts2"><br>
  <br>
  <label id ="lblDNI">DNI </label>
  <label id ="lblNacimiento" class = "subtitulos2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Fecha de nacimiento</label>
   <br>
  <input type="text" name="txtDNI" class= "texts" >
   <input type="text" name="txtNacimiento" class= "texts2" >
  <br>
  <label id ="lblDireccion">Direccion</label>
  <label id ="lblProvincia" class="subtitulos2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Provincia</label>
   <br>
   <input type="text" name="txtDireccion" class= "texts" >
   <select name="pais" class = "Ddls2">
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
   <br>
   <label id ="lblLocalidad">Localidad</label>
   <label id ="lblEmail" class="subtitulos2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   Email</label>
   <br>
  <input type="text" name="txtLocalidad" class="texts">
  <input type="text" name="txtEmail" class= "texts2">
  <br>
  <label id ="lblTelefono">Telefono</label>
  <br>
  <input type="text" name="txtTelefono" class= "texts">
  <br><br>
  <input type ="submit" name = "btnAgregar" value = "Agregar" class = "botones">
  
  
  <% 
  
 %>
  
  </form>
   </div>
    </div>
    
  
   <!--<input type="text" name="txtNombre" style="width: 165px; ">  -->
  
  <div class="footer">
  </div>
  
</body>
</html>