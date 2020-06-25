<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	
	 <jsp:include page="Menu.jsp"></jsp:include>
	
	<div class="contenedor">
		<div class="fondo">
 <div class="titulo_div">
  <label id="titulo" class ="titulos" >Cursos</label>
  </div>
  <hr>
  <br>
			<table id="table_id" class="display" >
		    <thead >
		        <tr>
		            <th>Materia</th>
		            <th>Cuatrimestre</th>
		            <th>Año</th>
		           
		            <th>Alumnos</th>    
		          
		        </tr>
		    </thead>
		    <tbody style="color:black">
		        <tr>
		            <td>Programacion III</td>
		            <td>Segundo Cuatrimestre</td>
		            <td>2019</td>
		         
		            <td>
		            	<button type="submit">
		            	<i class="material-icons" style="font-size:36px; color:black;">group</i>
		            	</button>
	            	</td>
		           
		        </tr>
		        <tr>
		            <td>Row 2 Data 1</td>
		            <td>Row 2 Data 2</td>
		            <td>Row 2 Data 3</td>
		            
		            <td>
		            	<button type="submit">
		            	<i class="material-icons" style="font-size:36px; color:black ;">group</i>
		            	</button>
	            	</td>
		           
		        </tr>
		        
		        <tr>
		            <td>Row 3 Data 1</td>
		            <td>Row 3 Data 2</td>
		            <td>Row 3 Data 3</td>
		           
		            <td>
		            	<button type="submit">
		            	<i class="material-icons" style="font-size:36px; color:black;">group</i>
		            	</button>
	            	</td>
	            	
		        </tr>
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
	
	 
	 	
	
	
</body>
</html>