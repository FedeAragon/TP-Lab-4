<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entidad.Docente" %> 
    <%@ page import="entidad.Cursos" %> 
    <%@ page import="java.util.List"%> 
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
	    	pageLength : 5,
	        lengthMenu: [[5, 10, 20, -1], [5, 10, 20, 'Todos']]
	    });
	    
	} );
	</script>
</head>
<body>
	
	
	 <jsp:include page="Menu.jsp"></jsp:include>
	
	<div class="contenedor">
		<div class="fondo">
 <div class="titulo_div">
  <label id="titulo" class ="titulos" >Cursos</label>
  </div>
  <hr>
  <br>
  
  <%  
  List<Cursos> listacursos=null;
	if(request.getAttribute("cursos")!=null){
		listacursos = (List<Cursos>)request.getAttribute("cursos");
	}
       
       %>
  
			<table id="table_id" class="display" >
		    <thead >
		        <tr>
		            <th>Materia</th>
		            <th>Cuatrimestre</th>
		            <th>A�o</th>
		            <th>Alumnos</th>    
		       </tr>
		 </thead>
		    <tbody style="color:black">
		       
		       <% if(listacursos!=null)
		    	   for(Cursos  c: listacursos){
		    		   
		    	   %> <tr>
		            <form method="post" action="ServletProfesoresTablaCursos">
		            <td><%= c.getMateria().getDescripcion() %><input type="hidden" name="codMate" value="<%=c.getMateria().getID()%>"></td>
					<td><%=c.getCuatrimeste() %><input type="hidden" name="codCuatri" value="<%=c.getCuatrimeste()%>"></td>
					<input type="hidden" name="CodCurso" value="<%=c.getCodCurso()%>">
					<td><%=c.getAnio() %><input type="hidden" name="anio" value="<%=c.getAnio()%>"></td>
				    <td>
		            	<button type="submit" name ="btnVerAlumnos">
		            	<i class="material-icons" style="font-size:36px; color:black;">group</i>
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
	
	 
	 	<script>



		 </script>
	
	
</body>
</html>