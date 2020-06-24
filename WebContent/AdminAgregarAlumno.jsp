<%@page import="entidad.Provincias"%>
<%@page import="entidad.Localidades"%>
<%@page import="negocio.NegocioProvincias"%>
<%@page import="negocioimpl.NegocioimplProvincias"%>
<%@page import="negocioimpl.NegocioimplLocalidades"%>
<%@ page import="java.util.List"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Agregar Alumno</title>
</head>
<body>
<jsp:include page="Menu.html"></jsp:include>
<div class="contenedor">
<form class="fondo" method="post" action="">

<div class="titulo_div">
  <label id="titulo" class ="titulos" >Agregar Alumnos</label>
  </div>
  <hr>
<div class="cuadrado">
  
  
  <br>
  <div class="contenido">
  <label id ="lblLegajo" class="subtitulos">Numero de legajo</label>
  <input type="text" name="txtLegajo" class= "texts" disabled="disabled">
  <label id ="lblDNI" class="subtitulos">DNI </label>
  <input type="text" name="txtDNI" class= "texts" >
  <label id ="lblDireccion" class="subtitulos">Direccion</label>
  <input type="text" name="txtDireccion" class= "texts" >
  <label id ="lblLocalidad" class="subtitulos">Localidad</label>
  <select id="ddlLocalidades" class="Ddls">
  
  </select>
    <label id ="lblTelefono" class="subtitulos">Telefono</label>
    <input type="text" name="txtTelefono" class= "texts">
  
  </div>
  <div class="contenido">
  
  <label id ="lblNombreyap" class="subtitulos">Nombre y Apellido</label>
  <input type="text" name="txtNombre" class="texts">
  <label id ="lblNacimiento" class = "subtitulos">Fecha de nacimiento</label>
  <input type="text" name="txtNacimiento" class= "texts" >
  <label id ="lblProvincia" class="subtitulos">Provincia</label>
 

 <script>
 	function CargarLocalidades(){
 		
 		var idProv = $("#provincia").val();
 		
 		$.ajax({
 			  url: "ServletAdminAgregarAlumno",
 			  data: {
 			    provincia: idProv
 			  },
 			  type:"POST",
 			  
 			  success: function( result ) {
 			    $( "#ddlLocalidades" ).html(result);
 			  }
 			});
 	}
 
 </script>
 
 <select name="provincia" id="provincia" class = "Ddls" onchange="CargarLocalidades()">
 						<option value="0">Seleccione una provincia</option>
						
						<%
							NegocioimplProvincias negProv = new NegocioimplProvincias();
							List<Provincias> provincias =  negProv.readAll();
							for(Provincias prov : provincias){
								%> <option value="<%=prov.getCodProvincia() %>"
								
								
								<%

								if(request.getParameter("provincia")!=null){
									
									if( Integer.parseInt(prov.getCodProvincia()) == Integer.parseInt(request.getParameter("provincia")))
									{
										out.print("selected");
									}
								}
								
								%>
								
								
								> <%=prov.getNombreProvincia()  %></option> <%
							}
						%>
 </select> 
  <label id ="lblEmail" class="subtitulos">Email</label>
  <input type="text" name="txtEmail" class= "texts">
  </div>
  

   </div>
   <div class="boton">
 <input type ="submit" name = "btnAgregar" value = "Agregar" class = "botones">
 </div>
  

</form>
 
    </div>




<jsp:include page="Footer.html"></jsp:include>
  



</body>
</html>