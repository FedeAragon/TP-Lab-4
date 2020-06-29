<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>   
<%@ page import="entidad.Docente" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profesores</title>
<link rel="stylesheet" type="text/css" href="css/Estilos.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.6.2/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript">
	$(document).ready( function () {
		 var table = $('#table_id').DataTable({
	        dom: 'Bfrtip',
	        pageLength : 5,
	        lengthMenu: [[5, 10, 20, -1], [5, 10, 20, 'Todos']],
	        select: true,
	        buttons: [
	            {
	            	text: '<i class="material-icons" style="font-size:36px; color:green;">person_add</i>',
	            	action: function(){
	            		 location.href="AdminAgregarProfesor.jsp";
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
  <label id="titulo" class ="titulos" >Tabla Profesores</label>
  </div>
  <hr>
  <br>

  <%   
  
   List<Docente> listadocentes = null;
 
       if(request.getAttribute("docentes")!= null )
       {
    	   listadocentes = (List<Docente>)request.getAttribute("docentes");
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
		        <%   if(listadocentes != null)
		        	  for(Docente d : listadocentes){
		        		 %><tr><form method="get" action="ServletAdminModificarProfesor"> 
		        		 <td><%= d.getLegajo() %> <input type="hidden" name="LegajoProfe" value="<%= d.getLegajo() %>"></td>
		        		 <td><%= d.getNombreyAp() %>   </td>
		        		 <td><%= d.getDNI() %>   </td>
		        		 <td><%= d.getFechaNacimiento() %>   </td>
		        		 <td><%= d.getDireccion() %>   </td>
		        		 <td><%= d.getLocalidad().getNombreLocalidad() %>   </td>
		        		 <td><%= d.getProvincia().getNombreProvincia() %>   </td>
		        		 <td><%= d.getTelefono() %>   </td>
		        		 <td><%= d.getEmail() %>   </td>
		        		  <td>
		            	<button type="submit" value="Modificar" name="btnModificar">
		            	<i class="material-icons" style="font-size:36px; color:black;">create</i>
		            	</button>
		            
		            </form>
		            <td>
		            
		            <input type="hidden" name="LegajoProfe" value="<%= d.getLegajo() %>">
		            	<button type="submit" value="Eliminar" name="btnEliminar" onclick="mensaje(<%= d.getLegajo()%>)">
			            <i class="material-icons" style="font-size:36px; color:red;">delete_forever</i>
			            </button>
		            </td>
		        	
		        		</tr>
		        		
		        	<%  } %>
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
		
		<script type="text/javascript">
	function mensaje(legajo){
		var mensaje = confirm("Estas seguro que deseas eliminar este Profesor?");
		
		if(mensaje){
			$.ajax({
	 			  url: "ServletAdminTablaProfesores",
	 			  data: {
	 				 LegajoProfe: legajo,
	 				 
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