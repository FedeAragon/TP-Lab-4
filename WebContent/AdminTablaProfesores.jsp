<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>   
<%@ page import="entidad.Docente" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Estilos.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
	<script type="text/javascript">
	$(document).ready( function () {
	    $('#table_id').DataTable({
	    	"language":{
	    	    "sProcessing":     "Procesando...",
	    	    "sLengthMenu":     "Mostrar _MENU_ registros",
	    	    "sZeroRecords":    "No se encontraron resultados",
	    	    "sEmptyTable":     "Ningún dato disponible en esta tabla",
	    	    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	    	    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	    	    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	    	    "sInfoPostFix":    "",
	    	    "sSearch":         "Buscar:",
	    	    "sUrl":            "",
	    	    "sInfoThousands":  ",",
	    	    "sLoadingRecords": "Cargando...",
	    	    "oPaginate": {
	    	        "sFirst":    "Primero",
	    	        "sLast":     "Último",
	    	        "sNext":     "Siguiente",
	    	        "sPrevious": "Anterior"
	    	    },
	    	    "oAria": {
	    	        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	    	        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	    	    },
	    	    "buttons": {
	    	        "copy": "Copiar",
	    	        "colvis": "Visibilidad"
	    	    }
	    	}
	    });
	} );
	</script>
</head>
<body>
	
	
	 <jsp:include page="Menu.html"></jsp:include>
	
	<div class="contenedor">
		<div class="fondo">
 <div class="titulo_div">
  <label id="titulo" class ="titulos" >Tabla Profesores</label>
  </div>
  <hr>
  <br>
  
  <form method="post" action="ServletAdminTablaProfesores" >
  <input type="submit" name="fedeputo" value="fedeputo">
  </form>
  <%   
  
   List<Docente> listadocentes = null;
  
       if(request.getAttribute("Docentes")!= null )
       {
    	   
    	   
    	  
    	   listadocentes = (List<Docente>)request.getAttribute("Docentes");
       }
  
  
  %>
			<table id="table_id" class="display" >
		    <thead >
		        <tr>
		            <th>Nº Legajo</th>
		            <th>Nombre</th>
		            <th>DNI</th>
		            <th>Nacimiento</th>
		            <th>Direccion</th>
		            <th>Localidad</th>
		            <th>Provincia</th>
		            <th>Telefono</th>
		            <th>Email</th>
		            
		            <th><th>
		            
		            
		          
		        </tr>
		       
		        
		          <%   if(listadocentes != null)
		        	  for(Docente d : listadocentes){
		        		 %>  <tr><form method="post" action="servletAdminTablaProfesores"> 
		        		 <td><%= d.getLegajo() %> <input type="hidden" name="LegajoProfe" value="<%= d.getLegajo() %>"> </td>
		        		 <td><%= d.getNombreyAp() %>   </td>
		        		 <td><%= d.getDNI() %>   </td>
		        		 <td><%= d.getFechaNacimiento() %>   </td>
		        		 <td><%= d.getDireccion() %>   </td>
		        		 <td><%= d.getLocalidad() %>   </td>
		        		 <td><%= d.getProvincia() %>   </td>
		        		 <td><%= d.getTelefono() %>   </td>
		        		 <td><%= d.getEmail() %>   </td>
		        		  <td><input type="submit" class="botones" value="Modificar">
		                  <td><input type="submit" class="botones" value="Eliminar">
		        		 </form> 
		        		      <tr>
		        	<%  } %>
		    </thead>
		    <tbody style="color:black">
		        
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
	
	 
	 	
	
	
</body>
</html>