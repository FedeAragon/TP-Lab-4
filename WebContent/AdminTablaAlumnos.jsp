<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>   
<%@ page import="entidad.Alumno" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos</title>
<link rel="stylesheet" type="text/css" href="css/Estilos.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.6.2/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript">
	$(document).ready( function () {
		 var table = $('#table_id').DataTable({
	        dom: 'Bfrtip',
	        select: true,
	        buttons: [
	            {
	            	text: '<i class="material-icons" style="font-size:36px; color:green;">person_add</i>',
	            	
	            	action: function(){
	            		 location.href="AdminAgregarAlumno.jsp";
	            	}
	            }
	        ]
	    } );
	} );
	</script>
</head>
<body>
	
	 <jsp:include page="Menu.jsp"></jsp:include>
	
	<div class="contenedor">
		<div class="fondo">
 <div class="titulo_div">
  <label id="titulo" class ="titulos" >Tabla Alumnos</label>
  </div>
  <hr>
  <br>
			<%
			List<Alumno> listaAlumnos = null;
			if(request.getAttribute("alumnos")!=null){
				listaAlumnos = (List<Alumno>)request.getAttribute("alumnos");
			}
			if(request.getAttribute("eliminado")!= null)
			{
				int eliminado = (int)request.getAttribute("eliminado");
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
		    </thead>
		    <tbody style="color:black">
		        <% if(listaAlumnos!=null)
		        	for(Alumno a : listaAlumnos){
		        	%>
		        <tr>
		        <form method="get" action="ServletAdminModificarAlumno">
		         <td><%= a.getLegajo() %> <input type="hidden" name="LegajoAlu" value="<%= a.getLegajo() %>"></td>
		        		 <td><%= a.getNombreyAp() %>   </td>
		        		 <td><%= a.getDNI() %>   </td>
		        		 <td><%= a.getFechaNacimiento() %>   </td>
		        		 <td><%= a.getDireccion() %>   </td>
		        		 <td><%= a.getLocalidad().getNombreLocalidad() %>   </td>
		        		 <td><%= a.getProvincia().getNombreProvincia() %>   </td>
		        		 <td><%= a.getTelefono() %>   </td>
		        		 <td><%= a.getEmail() %>   </td>
		            <td>
		            	<button type="submit" value="Modificar" name="btnModificar">
		            	<i class="material-icons" style="font-size:36px; color:black;">create</i>
		            	</button>
		            
		            </form>
		            <td>
		          <!-- <form method="post" action="ServletAdminTablaAlumnos">  -->  
		            <input type="hidden" name="LegajoAlu" value="<%= a.getLegajo() %>">
		            	<button type="submit" value="Eliminar" name="btnEliminar" onclick="mensaje(<%= a.getLegajo()%>)">
			            <i class="material-icons" style="font-size:36px; color:red;">delete_forever</i>
			            </button>
		            </td>
		        		<!--  </form>  -->
		        		</tr>
		        		
		        	<%  } %>
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
	
	<script type="text/javascript">
	function mensaje(legajo){
		var mensaje = confirm("Estas seguro que deseas eliminar este Alumno?");
		
		if(mensaje){
			$.ajax({
	 			  url: "ServletAdminTablaAlumnos",
	 			  data: {
	 				 LegajoAlu: legajo,
	 				 btnEliminar: true
	 			  },
	 			  type:"POST",
	 			 success: function(){
	  			    location.reload(true);
	  			  }
	 			});
		}
	}
	</script>
	 	
	
	
</body>
</html>