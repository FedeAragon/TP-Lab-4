<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="java.util.List"%>   
<%@ page import="entidad.Alumno" %>
<%@ page import="entidad.Cursos" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Alumnos a Curso</title>
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
			 pageLength : 5,
		        lengthMenu: [[5, 10, 20, -1], [5, 10, 20, 'Todos']],
	    } );
	} );
	</script>
</head>
<body>
	
	
	 <jsp:include page="Menu.jsp"></jsp:include>
	
	<div class="contenedor">
		<div class="fondo">
 <div class="titulo_div">
  <label id="titulo" class ="titulos" >Agregar Alumnos</label>
  </div>
  
  
			<%
             			
			 Cursos c = new Cursos();
			if(request.getAttribute("curso")!= null){
				
				c = (Cursos)request.getAttribute("curso");
			}
			
			
			List<Alumno> Alumnos = null;
			if(request.getAttribute("alumnos")!=null){
				Alumnos = (List<Alumno>)request.getAttribute("alumnos");
			}
			
			%>
  <hr>
  <br>
			<table id="table_id" class="display" >
				 <% 
  		if(request.getAttribute("funco")!=null){ 
  			 if((Boolean)request.getAttribute("funco")==true){	 
  			%>
  			<label style= "display:flex;justify-content: center;">El alumno se agrego correctamente</label>
  		<%} else{
  			 %>
  			<label style= "display:flex;justify-content: center;">No se pudo agregar el alumno</label>
  			 <%
  		} %>	 
  		
  <% }%>
			</div>
		    <thead >
		        <tr>
		            <th>Nº Legajo</th>
		            <th>Nombre</th>
		            <th>DNI</th>
		            <th><th>
		            
		   
		        </tr>
		    </thead>
		    <tbody style="color:black">
		    <% if(Alumnos!=null)
		        	for(Alumno a : Alumnos){
		        	%>
		        <tr>
		        <form method="post" action="ServletAdminAgregarAlumnoXCurso">
		             <td><%= a.getLegajo() %>   </td>
		              <td><%= a.getNombreyAp() %> </td>
		              <td><%= a.getDNI() %>   </td>
		          	<th><button type="submit" value="Agregar" name="btnAgregar">
			            <i class="material-icons" style="font-size:36px; color:green;">add</i>
			            </button><th>
		           <input type="hidden" name="LegajoAlu" value="<%= a.getLegajo()%>"> 
		              <input type="hidden" name="Materia" value="<%= c.getMateria().getID()%>">
		                <input type="hidden" name="Cuatri" value="<%= c.getCuatrimeste()%>">
		                <input type="hidden" name="Comision" value="<%= c.getComision()%>">
		                <input type="hidden" name="Anio" value="<%= c.getAnio()%>">
		                <input type="hidden" name="LegajoProf" value="<%= c.getDocente().getLegajo()%>">
		           
		            
		           
		          
		            </form>
		        </tr>
		      <%  } %>
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
	
	 
	 	
	
	
</body>
</html>