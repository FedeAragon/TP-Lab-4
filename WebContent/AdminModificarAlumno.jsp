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
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Modificar Alumno</title>
<SCRIPT >
     
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }
      
   </SCRIPT>
</head>
<body onload="CargarLocalidades()">
<jsp:include page="Menu.jsp"></jsp:include>
<div class="contenedor">
<form class="fondo" method="post" action="ServletAdminModificarAlumno">

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
  <input type="text" name="txtLegajo" readonly="readonly"  class= "texts"  value="<%= alu.getLegajo() %>" >
  <label id ="lblDNI" class="subtitulos" >DNI </label>
  <input type="text" name="txtDNI" class= "texts" value="<%= alu.getDNI() %>"required onkeypress="return isNumberKey(event)" maxlength="8">
  <label id ="lblDireccion" class="subtitulos">Direccion</label>
  <input type="text" name="txtDireccion" class= "texts" value="<%= alu.getDireccion() %>" required>
  <label id ="lblLocalidad" class="subtitulos">Localidad</label>
   <select name="ddlLocalidades" id="ddlLocalidades" class="Ddls" required>
  
   </select>
    <label id ="lblTelefono" class="subtitulos">Telefono</label>
    <input type="text" name="txtTelefono" class= "texts" value="<%= alu.getTelefono() %>"required onkeypress="return isNumberKey(event)" maxlength="11">
  
  </div>
  <div class="contenido">
  
  <label id ="lblNombreyap" class="subtitulos">Nombre y Apellido</label>
  <input type="text" name="txtNombre" class="texts" value="<%= alu.getNombreyAp() %>" required >
  <label id ="lblNacimiento" class = "subtitulos">Fecha de nacimiento</label>
  <input type="date" name="DateNacimiento" value="<%= alu.getFechaNacimiento() %>" required>
  <label id ="lblProvincia" class="subtitulos">Provincia</label>
 <script>
 	function CargarLocalidades(){
 		
 		var idProv = $("#provincia").val();
 		
 		$.ajax({
 			  url: "ServletLocalidades",
 			  data: {
 			    provincia: idProv
 			  },
 			  type:"POST",
 			  
 			  success: function( result ) {
 			    $( "#ddlLocalidades" ).html(result);
 			   $( "#ddlLocalidades option[value='<%=alu.getLocalidad().getCodLocalidad()%>'").attr("selected",true);
 			  }
 			});
 	}
 
 </script>
<select id="provincia" name="provincia" class = "Ddls" onchange="CargarLocalidades()"  required>
 					
						<%
							NegocioimplProvincias negProv = new NegocioimplProvincias();
							List<Provincias> provincias =  negProv.readAll();
							for(Provincias prov : provincias){
								
								if( alu.getProvincia().getCodProvincia() != prov.getCodProvincia()){
								
								%> <option value="<%=prov.getCodProvincia() %>"
							
								<%
                           		if(alu.getProvincia() != null){
									
									if( Integer.parseInt(prov.getCodProvincia()) == Integer.parseInt(alu.getProvincia().getCodProvincia()))
									{
										out.print("selected");
									}
								}
								
								%>
									> <%=prov.getNombreProvincia()  %></option> <%
								}}
						%>
 </select> 
  <label id ="lblEmail" class="subtitulos">Email</label>
  <input type="text" name="txtEmail" class= "texts" value="<%= alu.getEmail() %>"required>
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