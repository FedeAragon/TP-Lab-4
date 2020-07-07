<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="entidad.Provincias"%>
<%@page import="entidad.Localidades"%>
<%@page import="entidad.Docente"%>
<%@page import="negocio.NegocioProvincias"%>
<%@page import="negocioimpl.NegocioimplProvincias"%>
<%@page import="negocioimpl.NegocioimplLocalidades"%>
<%@page import="negocioimpl.NegocioimplProfesores"%>
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
<%
 if(request.getAttribute("ultlegajo") != null)
 {
   int ultlegajo =(int)request.getAttribute("ultlegajo");
%>
  <input type="text" name="txtLegajo" class= "texts" readonly="readonly"  value=<%= ultlegajo %>>
  <%} %>   
  <label id ="lblDNI" class="subtitulos">DNI </label>
  <input type="text" id="txtDNI" name="txtDNI" class= "texts" required onkeypress="return isNumberKey(event)" maxlength="8">
  <label id ="lblDireccion" class="subtitulos">Direccion</label>
  <input type="text" id="txtDireccion" name="txtDireccion" class= "texts" required>
  <label id ="lblProvincia" class="subtitulos">Provincia</label>
 <select id="provincia" name="provincia" class = "Ddls" onchange="CargarLocalidades()"  required>
 						<option value="0">Seleccione una provincia</option>
						
						<%if(request.getAttribute("provincias")!=null)
						{

							List<Provincias> provincias =  (List<Provincias>)request.getAttribute("provincias");
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
							
						<%} %>
 </select> 
    <label id ="lblTelefono" class="subtitulos">Telefono</label>
    <input type="text" id="txtTelefono" name="txtTelefono" class= "texts" required onkeypress="return isNumberKey(event)" maxlength="10">
  
  </div>
  <div class="contenido">
  
  <label id ="lblNombreyap" class="subtitulos">Nombre y Apellido</label>
  <input type="text" id="txtNombre" name="txtNombre" class="texts" required>
  <label id ="lblNacimiento" class = "subtitulos">Fecha de nacimiento</label>
  <input type="date" name="DateNacimiento"  required min="1960-01-01" max="2005-01-01">
   <label id ="lblLocalidad" class="subtitulos">Localidad</label>
  <select name="ddlLocalidades" id="ddlLocalidades" class="Ddls" required >
  
  </select>
  
  
 <script type="text/javascript">
 
 function comprobarDNI(valor, campo) {
	  
	  var mensaje = "";
	  
	  // comprobar los posibles errores
	  if (this.value == "") {
	    mensaje = "Ingrese un DNI";
	  } else if (this.value.length < 8) {
	    mensaje = "El DNI debe tener 8 caracteres";
	  } 
	  
	  // mostrar/resetear mensaje (el mensaje se resetea poniendolo a "")
	  this.setCustomValidity(mensaje);
	}

	var DNI = document.querySelector("#txtDNI");

	// cuando se cambie el valor del campo o sea incorrecto, mostrar/resetear mensaje
	DNI.addEventListener("invalid", comprobarDNI);
	DNI.addEventListener("input", comprobarDNI);
 </script>

<script type="text/javascript">
 function comprobarDireccion(valor,campo){
	 var mensaje="";
	 if(this.value==""){
		 mensaje="Ingrese una direccion";
	 }
	 this.setCustomValidity(mensaje);
	 
 }
 var direccion=document.querySelector("#txtDireccion");
    direccion.addEventListener("invalid", comprobarDireccion);
	direccion.addEventListener("input", comprobarDireccion);

</script>
<script type="text/javascript">
 function comprobarNombre(valor,campo){
	 var mensaje="";
	 if(this.value==""){
		 mensaje="Ingrese un Nombre y Apellido";
	 }
	 
	 this.setCustomValidity(mensaje);
	 
 }
 var nombre=document.querySelector("#txtNombre");
    nombre.addEventListener("invalid", comprobarNombre);
	nombre.addEventListener("input", comprobarNombre);

</script>
<script type="text/javascript">
	function comprobarTelefono(valor,campo){
		var msj= "";
		
		if(this.value==""){
			msj="Ingrese un telefono";
		}
		else if(this.value.length <8){
			msj="El telefono debe tener entre 8 y 10 caracteres";
		}
		this.setCustomValidity(msj);
	}
	var tel= document.querySelector("#txtTelefono");
	tel.addEventListener("invalid",comprobarTelefono);
	tel.addEventListener("input",comprobarTelefono);


</script>

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
 
 
  <label id ="lblEmail" class="subtitulos">Email</label>
  <input type="email" id ="txtEmail" name="txtEmail"  class="texts"   required>
  <script type="text/javascript">
	function comprobarMail(valor,campo){
		var msj= "";
		
		if(this.value==""){
			msj="Ingrese un email";
		}
		else if(this.value.indexOf(".com", this.value.indexOf("@")) < 0){
			msj="El mail debe seguir luego del @ y terminar en .com";
		}
		this.setCustomValidity(msj);
	}
	var mail= document.querySelector("#txtEmail");
	mail.addEventListener("invalid",comprobarMail);
	mail.addEventListener("input",comprobarMail);


</script>
  </div>
  

   </div>
   <div class="boton">
 <input type ="submit" name = "btnAgregar" value = "Agregar" class = "botones">
 </div>
  <% 
  if(request.getAttribute("repetido")!= null)
	 { %>
		 <label>El email ya se encuentra registrado</label>
	<% } 
  else if(request.getAttribute("funco")!=null){ 
  			 if((Boolean)request.getAttribute("funco")==true){	 
  			%>
  			<label>El Profesor se agrego con exito</label>
  		<%} else{
  			 %>
  			 <label>No se pudo agregar el Profesor</label>
  			 <%
  		} %>	 
  		
  <% } %>
</form>
 
    </div>




<jsp:include page="Footer.html"></jsp:include>
  



</body>
</html>