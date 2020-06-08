<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	        select: true,
	        buttons: [
	            {
	            	text: '<i class="material-icons" style="font-size:36px; color:green;">person_add</i>',
	            	action: function(){
	            		
	            	}
	            }
	        ]
	    } );
	} );
	</script>
</head>
<body>
	
	
	 <jsp:include page="Menu.html"></jsp:include>
	
	<div class="contenedor">
		<div class="fondo">
 <div class="titulo_div">
  <label id="titulo" class ="titulos" >Tabla Alumnos</label>
  </div>
  <hr>
  <br>
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
		            <td>
		            	<button type="submit">
		            	<i class="material-icons" style="font-size:36px; color:black;">create</i>
		            	</button>
		            <td>
		            	<button type="submit">
			            <i class="material-icons" style="font-size:36px; color:red;">delete_forever</i>
			            </button>
		            </td>
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
		            <td>
		            	<button type="submit">
		            	<i class="material-icons" style="font-size:36px; color:black;">create</i>
		            	</button>
		            <td>
		            	<button type="submit">
			            <i class="material-icons" style="font-size:36px; color:red;">delete_forever</i>
			            </button>
		            </td>
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
		            <td>
		            	<button type="submit">
		            	<i class="material-icons" style="font-size:36px; color:black;">create</i>
		            	</button>
		            <td>
		            	<button type="submit">
			            <i class="material-icons" style="font-size:36px; color:red;">delete_forever</i>
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