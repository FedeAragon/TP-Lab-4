<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Estilos.css">
<script src="jquery-3.5.1.min.js"></script>
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
		        <tr>
		            <td>22220</td>
		            <td>Federico Aragon</td>
		            <td>42197455</td>
		            <td>03/11/1999</td>
		            <td>Row 1 Data 5</td>
		            <td>Row 1 Data 6</td>
		            <td>Row 1 Data 7</td>
		            <td>Row 1 Data 8</td>
		            <td>Row 1 Data 9</td>
		            <td><input type="submit" class="botones" value="Modificar">
		            <td><input type="submit" class="botones" value="Eliminar">
		        </tr>
		        <tr>
		            <td>Row 2 Data 1</td>
		            <td>Row 2 Data 2</td>
		            <td>Row 2 Data 3</td>
		            <td>Row 2 Data 4</td>
		            <td>Row 2 Data 5</td>
		            <td>Row 2 Data 6</td>
		            <td>Row 2 Data 7</td>
		            <td>Row 2 Data 8</td>
		            <td>Row 2 Data 9</td>
		            <td><input type="submit" class="botones" value="Modificar">
		            <td><input type="submit" class="botones" value="Eliminar">
		        </tr>
		        
		        <tr>
		            <td>Row 3 Data 1</td>
		            <td>Row 3 Data 2</td>
		            <td>Row 3 Data 3</td>
		            <td>Row 3 Data 4</td>
		            <td>Row 3 Data 5</td>
		            <td>Row 3 Data 6</td>
		            <td>Row 3 Data 7</td>
		            <td>Row 3 Data 8</td>
		            <td>Row 3 Data 9</td>
		            <td><input type="submit" class="botones" value="Modificar">
		            <td><input type="submit" class="botones" value="Eliminar">
		        </tr>
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
	
	 
	 	
	
	
</body>
</html>