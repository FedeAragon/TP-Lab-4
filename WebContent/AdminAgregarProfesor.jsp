<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Agregar Profesor</title>
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
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="contenedor">
<form class="fondo" method="post" action="ServletAdminAgregarProfesor">

<div class="titulo_div">
  <label id="titulo" class ="titulos" >Agregar Profesor</label>
  </div>
  <hr>
<div class="cuadrado">
  
  
  <br>
  <div class="contenido">
  <label id ="lblLegajo" class="subtitulos">Numero de legajo</label>
  <input type="text" name="txtLegajo" class= "texts" disabled="disabled">
  <label id ="lblDNI" class="subtitulos">DNI </label>
  <input type="text" name="txtDNI" class= "texts" required onkeypress="return isNumberKey(event)" maxlength="8">
  <label id ="lblDireccion" class="subtitulos">Direccion</label>
  <input type="text" name="txtDireccion" class= "texts" required>
  <label id ="lblLocalidad" class="subtitulos">Localidad</label>
  <select name="ddlLocalidades" id="ddlLocalidades" class="Ddls" required>
  
  </select>
    <label id ="lblTelefono" class="subtitulos">Telefono</label>
    <input type="text" name="txtTelefono" class= "texts" required onkeypress="return isNumberKey(event)" maxlength="11">
  
  </div>
  <div class="contenido">
  
  <label id ="lblNombreyap" class="subtitulos">Nombre y Apellido</label>
  <input type="text" name="txtNombre" class="texts" required>
  <label id ="lblNacimiento" class = "subtitulos">Fecha de nacimiento</label>
  <input type="date" name="DateNacimiento"  required>
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
 			  }
 			});
 	}
 
 </script>
 
 <select id="provincia" name="provincia" class = "Ddls" onchange="CargarLocalidades()"  required>
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
  <input type="text" name="txtEmail"  class="texts"   required>
  </div>
  

   </div>
   <div class="boton">
 <input type ="submit" name = "btnAgregar" value = "Agregar" class = "botones">
 </div>
  <% 
  		if(request.getAttribute("funco")!=null){ 
  			 if((Boolean)request.getAttribute("funco")==true){	 
  			%>
  			<label>El Profesor se agrego con exito</label>
  		<%} else{
  			 %>
  			 <label>No se pudo agregar el Profesor</label>
  			 <%
  		} %>	 
  		
  <% }%>
  

</form>
 
    </div>




<jsp:include page="Footer.html"></jsp:include>
  



</body>
</html>