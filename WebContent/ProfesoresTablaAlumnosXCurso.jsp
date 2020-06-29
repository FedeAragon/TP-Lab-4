<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%> 
        <%@ page import ="entidad.Usuario" %>
    <%@ page import="entidad.AlumnosXCursos"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	        pageLength : 5,
	        lengthMenu: [[5, 10, 20, -1], [5, 10, 20, 'Todos']],
	        buttons: [
	            
	            	
	            	<% if(request.getSession().getAttribute("usuario")!=null){
	            		Usuario user = (Usuario)session.getAttribute("usuario");
	            		if(user.getTipoCuenta()==1){
	            			%>
	            			{
	            			text: '<input type ="submit" name = "btnAgregar" value = "Agregar" class = "botones">',
	    	            	action: function(){
	    	            		location.href = "ServletAdminAgregarAlumnoXCurso";
	    	            	}
	            			},
	            			<%
	            		}
	            	} %>
	            
	        	
	        	
	        	{
	            	
	            	text: '<input type ="submit" name = "btnModificar" value = "Confirmar" class = "botones">',
	            	action: function(){
	            		
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
  <label id="titulo" class ="titulos" >Tabla Alumnos del Curso</label>
  </div>
  <hr>
  <br>
  
   <%  
  List<AlumnosXCursos> listacursos=null;
	if(request.getAttribute("cursos")!=null){
		listacursos = (List<AlumnosXCursos>)request.getAttribute("cursos");
	}
       
       %>
			<table id="table_id" class="display" >
		    <thead >
		        <tr>
		            <th>Nº Legajo</th>
		            <th>Nombre</th>
		            <th>DNI</th>
		            <th>Email</th>
		            <th>Parcial 1</th>
		            <th>Parcial 2</th>
		            <th>Recuperatorio 1</th>
		            <th>Recuperatorio 2</th>
		            <th>Estado</th>
		         
		        </tr>
		    </thead>
		    <tbody style="color:black">		       
		       <% if(listacursos!=null)
		    	   for(AlumnosXCursos axc : listacursos){
		    		   
		    	   %>
		        <tr>
		            <td><%= axc.getAlumno().getLegajo() %></td>
		            <td><%= axc.getAlumno().getNombreyAp() %></td>
		            <td><%= axc.getAlumno().getDNI() %></td>
		            <td><%= axc.getAlumno().getEmail() %></td>
		            <td><input type="number" min="1" max="10" name="txtParcial1" class="texts" style="width: 67px;" value =<%=axc.getPrimerParcial()  %>></td>
		            <td><input type="number" min="1" max="10" name="txtParcial2" class="texts" style="width: 67px; " value =<%=axc.getSegundoParcial()  %> ></td>
		            <td><input type="number" min="1" max="10" name="txtRec1" class="texts" style="width: 67px; "value =<%=axc.getRecuperatorio1()  %>></td>
		            <td><input type="number" min="1" max="10" name="txtRec2" class="texts" style="width: 67px; "value =<%=axc.getRecuperatorio2()  %>></td>
		            <td><select name="estado" class="Ddls" style="width: 110px; ">
		                    <option value="0">En Curso</option>
		            		<option value="1">Regular</option>
		            		<option value="2">Libre</option>
		            </select></td>
		        </tr>	  
		        <%} %>      
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
	
	 
	 	
	
	
</body>
</html>