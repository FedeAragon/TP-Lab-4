<%@page import="entidad.Provincias"%>
<%@page import="entidad.Localidades"%>
<%@page import="negocio.NegocioProvincias"%>
<%@ page import="entidad.Alumno" %>
<%@page import="negocioimpl.NegocioimplProvincias"%>
<%@page import="negocioimpl.NegocioimplLocalidades"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Alumno</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="contenedor">
<form class="fondo" method="post" action="">

<div class="titulo_div">
  <label id="titulo" class ="titulos" >Modificar Alumnos</label>
  </div>
  <hr>
<div class="cuadrado">
  
  
   <% 
  Alumno alu= new Alumno();
  if(request.getAttribute("alumno")!= null){
	  alu = (Alumno)request.getAttribute("alumno");
  }
  %>
  
  <br>
 <div class="contenido">
  <label id ="lblLegajo" class="subtitulos">Numero de legajo</label>
  <input type="text" name="txtLegajo" class= "texts" disabled="disabled" value="<%= alu.getLegajo() %>" style="color:white;">
  <label id ="lblDNI" class="subtitulos">DNI </label>
  <input type="text" name="txtDNI" class= "texts" value="<%= alu.getDNI() %>">
  <label id ="lblDireccion" class="subtitulos">Direccion</label>
  <input type="text" name="txtDireccion" class= "texts" value="<%= alu.getDireccion() %>" >
  <label id ="lblLocalidad" class="subtitulos">Localidad</label>
   <input type="text" name="txtLocalidad" class="texts"  value="ee">
    <label id ="lblTelefono" class="subtitulos">Telefono</label>
    <input type="text" name="txtTelefono" class= "texts" value="<%= alu.getTelefono() %>">
  
  </div>
  <div class="contenido">
  
  <label id ="lblNombreyap" class="subtitulos">Nombre y Apellido</label>
  <input type="text" name="txtNombre" class="texts" value="<%= alu.getNombreyAp() %>"  >
  <label id ="lblNacimiento" class = "subtitulos">Fecha de nacimiento</label>
  <input type="text" name="txtNacimiento" class= "texts" value="<%= alu.getFechaNacimiento() %>">
  <label id ="lblProvincia" class="subtitulos">Provincia</label>
 <select name="ddlProvincias" class = "Ddls">
					
 </select> 
  <label id ="lblEmail" class="subtitulos">Email</label>
  <input type="text" name="txtEmail" class= "texts" value="<%= alu.getEmail() %>">
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