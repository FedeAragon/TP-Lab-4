<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entidad.Docente" %> 
    <%@page import="entidad.Provincias"%>
<%@page import="entidad.Localidades"%>
<%@page import="negocio.NegocioProvincias"%>
<%@page import="negocioimpl.NegocioimplProvincias"%>
<%@page import="negocioimpl.NegocioimplLocalidades"%>
<%@ page import="java.util.List"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Modificar Profesor</title>
</head>
<body onload="CargarLocalidades()">
<jsp:include page="Menu.jsp"></jsp:include>
<div class="contenedor">
<form class="fondo" method="post" action="ServletAdminModificarProfesor">

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
  <input type="text" name="txtLegajo" class= "texts"  readonly="readonly" value="<%= doc.getLegajo() %>" >
  <label id ="lblDNI" class="subtitulos">DNI </label>
  <input type="text" name="txtDNI" class= "texts" value="<%= doc.getDNI() %>" required>
  <label id ="lblDireccion" class="subtitulos">Direccion</label>
  <input type="text" name="txtDireccion" class= "texts" value="<%= doc.getDireccion() %>" required >
  <label id ="lblLocalidad" class="subtitulos">Localidad</label>
  <select name="ddlLocalidades" id="ddlLocalidades" class="Ddls" required>
  
   </select>
   
    <label id ="lblTelefono" class="subtitulos">Telefono</label>
    <input type="text" name="txtTelefono" class= "texts" value="<%= doc.getTelefono() %>" required>
  
  </div>
  <div class="contenido">
  
  <label id ="lblNombreyap" class="subtitulos">Nombre y Apellido</label>
  <input type="text" name="txtNombre" class="texts" value="<%= doc.getNombreyAp() %>" required >
  <label id ="lblNacimiento" class = "subtitulos">Fecha de nacimiento</label>
  <<input type="date" name="DateNacimiento" value="<%= doc.getFechaNacimiento() %>" required>
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
 			   $( "#ddlLocalidades option[value='<%=doc.getLocalidad().getCodLocalidad()%>'").attr("selected",true);
 			  }
 			});
 	}
 
 </script>
<select id="provincia" name="provincia" class = "Ddls" onchange="CargarLocalidades()"  required>
 						
	
					<%
							NegocioimplProvincias negProv = new NegocioimplProvincias();
							List<Provincias> provincias =  negProv.readAll();
							for(Provincias prov : provincias){
								%> <option value="<%=prov.getCodProvincia() %>"
							
								<%
                           		if(doc.getProvincia() != null){
									
									if( Integer.parseInt(prov.getCodProvincia()) == Integer.parseInt(doc.getProvincia().getCodProvincia()))
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
  <input type="text" name="txtEmail" class= "texts" value="<%= doc.getEmail() %>"required >
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