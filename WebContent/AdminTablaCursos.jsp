<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>   
<%@ page import="entidad.Cursos" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos</title>
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
	        select: true,
	        pageLength : 5,
	        lengthMenu: [[5, 10, 20, -1], [5, 10, 20, 'Todos']],
	        buttons: [
	            {
	            	text: '<i class="material-icons" style="font-size:36px; color:green;">add</i>',
	            	action: function(){
	            		 location.href="AdminAgregarCursos.jsp";
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
  <label id="titulo" class ="titulos" >Tabla Cursos</label>
  </div>
  <hr>
  <br>
  <%List<Cursos> listacursos=null;
  	if(request.getAttribute("cursos")!=null){
  		listacursos = (List<Cursos>)request.getAttribute("cursos");
  	}
  %>
			<table id="table_id" class="display" >
			<div>
				 <% 
  		if(request.getAttribute("funco")!=null){ 
  			 if((Boolean)request.getAttribute("funco")==true){	 
  			%>
  			<label style= "display:flex;justify-content: center;">El curso se modifico correctamente</label>
  		<%} else{
  			 %>
  			<label style= "display:flex;justify-content: center;">No se pudo modificar el curso</label>
  			 <%
  		} %>	 
  		
  <% }%>
			</div>
		    <thead >
		        <tr>
		            <th>Materia</th>
		            <th>Cuatrimestre</th>
		            <th>Año</th>
		            <th>Docente</th>
		            <th>Alumnos</th>    	     
		            <th><th>
		        </tr>
		    </thead>
		    <tbody style="color:black">
		       
		       <% if(listacursos!=null)
		    	   for(Cursos  c: listacursos){
		    		   
		    	   %> <tr>
		            <form method="post" action="ServletAdminTablaAlumnosXCurso">
		            <td><%= c.getMateria().getDescripcion() %><input type="hidden" name="codMate" value="<%=c.getMateria().getID()%>"></td>
					<td><%=c.getCuatrimeste() %><input type="hidden" name="codCuatri" value="<%=c.getCuatrimeste()%>"></td>
					<td><%=c.getAnio() %><input type="hidden" name="anio" value="<%=c.getAnio()%>"></td>
					<td><%=c.getDocente().getNombreyAp() %><input type="hidden" name="legDocente" value="<%=c.getDocente().getLegajo()%>"></td>
					<input type="hidden" name="CodCurso" value=" <%= c.getCodCurso()  %> ">
		            <td>
		            	<button type="submit" value="Alumnos" name="btnAlumnos">
		            	<i class="material-icons" style="font-size:36px; color:black;">group</i>
		            	</button>
	            	</td>       	
	            	   
			             </form>
			         <form method="get" action="ServletAdminModificarCurso">
	            	<input type="hidden" name="codMate" value="<%=c.getMateria().getID()%>">
					<input type="hidden" name="codCuatri" value="<%=c.getCuatrimeste()%>">
					<input type="hidden" name="anio" value="<%=c.getAnio()%>">
					<input type="hidden" name="legDocente" value="<%=c.getDocente().getLegajo()%>">
					<input type="hidden" name="CodCurso" value=" <%= c.getCodCurso()  %> ">
	            	<td>
		            <button type="submit" value="Modificar" name="btnModificar">
		            	<i class="material-icons" style="font-size:36px; color:black;">create</i>
		            	</button>
		            	</td>
		            	   
			             </form>
		            	<form method="post" action="ServletAdminTablaCursos">
		            <input type="hidden" name="codMate" value="<%=c.getMateria().getID()%>">
					<input type="hidden" name="codCuatri" value="<%=c.getCuatrimeste()%>">
					<input type="hidden" name="anio" value="<%=c.getAnio()%>">
					<input type="hidden" name="legDocente" value="<%=c.getDocente().getLegajo()%>">
					<input type="hidden" name="CodCurso" value=" <%= c.getCodCurso()  %> ">
		          
		            	<td><button type="submit" value="Eliminar" name="btnEliminar" >
			            <i class="material-icons" style="font-size:36px; color:red;">delete_forever</i>
			            </button>
			            </td>
		          
		             </form>
		            
		        </tr>
		       <%} %>
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
	
		

	 	
	
	
</body>
</html>