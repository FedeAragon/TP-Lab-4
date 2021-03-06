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
	            
	        ]
	    } );
	} );
	</script>
</head>
<body>
	
	
	 <jsp:include page="Menu.jsp"></jsp:include>
	
	<div class="contenedor">
		<div class="fondo" style="display:block; height:870px;  overflow: auto;">
 <div class="titulo_div">
  <label id="titulo" class ="titulos" >Tabla Alumnos del Curso</label>
  </div>
  <hr>
  <br>
  
	            			<div style="display:flex; flex-direction:row; ">
   <%  
  List<AlumnosXCursos> listacursos=null;
	if(request.getAttribute("cursos")!=null){
		listacursos = (List<AlumnosXCursos>)request.getAttribute("cursos");
	}
       
       %>
       <%  Usuario user = new Usuario(); 
       if(request.getSession().getAttribute("usuario")!=null){
	            		 user = (Usuario)session.getAttribute("usuario");
	            		if(user.getTipoCuenta()==1){
	            			if(request.getAttribute("CodCurso")!=null){
	            			int c = Integer.parseInt(request.getParameter("CodCurso").trim());
	            			%>
	            			
	            			
	            			<form method="get" action="ServletAdminAgregarAlumnoXCurso" style="margin-right:8px;">
	            			<input type ="submit" name = "btnAgregar" value = "Agregar Alumnos" class = "botones" >
	            			<input type="hidden" name="CodCurso" value=" <%= c %> ">
	            			</form>
	            			
	            			<form method="get" action="ServletAdminEliminarAlumnoXCurso" style="margin-right:8px;">
	            			<input type ="submit" name = "btnEliminar" value = "Eliminar Alumnos" class = "botones" >
	            			<input type="hidden" name="CodCurso" value=" <%= c %> ">
	            			</form>
	            			<%
	            			}
	            		}
	            		%>
	            			
	            	<%
	            		} %><input type ="button" name = "Confirmar" id="Confirmar"value = "Confirmar" class = "botones">
	            		</div>
			<table id="table_id" class="display" >
			<% 
  		if(request.getAttribute("funco")!=null){ 
  			 if((Boolean)request.getAttribute("funco")==true){	 
  			%>
  			<label style= "display:flex;justify-content: center;">Las notas se cargaron correctamente</label>
  		<%} else{
  			 %>
  			<label style= "display:flex;justify-content: center;">No se pudo agregar las notas</label>
  			 <%
  		} %>	 
  		
  <% }%>
		    <thead >
		        <tr>
		            <th>N� Legajo</th>
		            <th>Nombre</th>
		            <th>DNI</th>
		            <th>Email</th>
		            <th>Parcial 1</th>
		            <th>Parcial 2</th>
		            <th>Recuperatorio 1</th>
		            <th>Recuperatorio 2</th>
		            <th>Situacion</th>
		       
		         
		        </tr>
		    </thead>
		    <tbody style="color:black">		
		     <form id="AlumnosXCurso" method="post" action="ServletProfesoresTablaAlumnosXCurso">       
		       <%int vueltas = 0;
		       if(listacursos!=null)
		    	   for(AlumnosXCursos axc : listacursos){
		    		   
		    	   %>
		        <tr>		       
		            <td><%= axc.getAlumno().getLegajo() %> <input type="hidden" name="legAlumno" value= <%= axc.getAlumno().getLegajo()%> > </td>
		            <td><%= axc.getAlumno().getNombreyAp() %></td>
		            <td><%= axc.getAlumno().getDNI() %></td>
		            <td><%= axc.getAlumno().getEmail() %></td>

		            <td><input type="number" min="0" max="10" name="txtParcial1" class="texts" style="width: 67px;" value =<%= axc.getPrimerParcial() %> required></td>
		            <td><input type="number" min="0" max="10" name="txtParcial2" class="texts" style="width: 67px;" value =<%=axc.getSegundoParcial()%> required ></td>
		            <td><input type="number" min="0" max="10" name="txtRec1" class="texts" style="width: 67px;"     value =<%=axc.getRecuperatorio1()%> required ></td>
		            <td><input type="number" min="0" max="10" name="txtRec2" class="texts" style="width: 67px;"    value =<%=axc.getRecuperatorio2()%> required></td>
		            <td><select name="estado" class="Ddls" style="width: 110px; ">
		                    <option value="Cursando"
		                    <% 
		                    if(axc.getSituacion().trim().equals("Cursando"))
		                    { 
		                    	 out.print("selected");
		                    }
		               	     %>
		                    >Cursando</option>
		            		<option value="Regular"
		            		 <%if(axc.getSituacion().trim().equals("Regular"))
		                    { 
		                    	 out.print("selected");
		                    }
		               	     %>
		            		>Regular</option>
		            		<option value="Libre"
		            		 <%if(axc.getSituacion().trim().equals("Libre"))
		                    { 
		                    	 out.print("selected");
		                    }
		               	     %>
		            		>Libre</option>
		            </select>
		            </td>
		                                 
		        </tr>	  
		        <%
		        vueltas ++ ;
		        } 
		        %>   
		         <tr>
		         <td style="background-color: black"> <input  type ="submit" name="btnConfirmar" id="btnConfirmar" value="confimar" style="display:none;"></td>
		          </tr>		
		          
		          <input type="hidden" name="vueltas" value="<%= vueltas %>">	           
		          <%
		          if(request.getAttribute("CodCurso")!=null){
		          int c = Integer.parseInt(request.getParameter("CodCurso").trim());
          			%>	         
		          <input type="hidden" name="CodCurso" value=" <%= c %> ">
		          <%} %>		          
		     </form>
		    </tbody>
		</table>
		</div>
	</div>
	
	<jsp:include page="Footer.html"></jsp:include>
	
	 <script type="text/javascript">
     $(document).ready(function() {
    $("#Confirmar").click(function(event) {
     document.getElementById("btnConfirmar").click();
    });
       });
</script>
	 	
	<script type="text/javascript">
	function mensaje(Legajo,Codigo){
		var mensaje = confirm("Estas seguro que deseas eliminar este Curso?");
		
		if(mensaje){
			$.ajax({
	 			  url: "ServletEliminarAlumnoXCurso",
	 			  data: {
	 				 CodCurso:Codigo,
	 				 LegajoAlu:Legajo,
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