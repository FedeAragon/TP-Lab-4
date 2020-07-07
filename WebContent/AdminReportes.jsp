<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entidad.Cursos" %> 
    <%@ page import="entidad.AlumnosXCursos" %> 
    <%@ page import="entidad.Materias" %> 
    <%@ page import="java.util.*"%>  
    <%@page import="negocioimpl.NegocioimplMaterias"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Reportes</title>
		<link rel="stylesheet" type="text/css" href="css/Estilos.css">
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		
		<%
   		int aprobadosXmateria =0;
		int desaprobadosXmateria=0;
		ArrayList años = new ArrayList();;
		ArrayList aprobados = new ArrayList();
		ArrayList desaprobados = new ArrayList();;
		String materia = "";
		
		if(request.getAttribute("aprobadosXmateria")!=null){
			aprobadosXmateria = (Integer)request.getAttribute("aprobadosXmateria");
			
		}
		if(request.getAttribute("desaprobadosXmateria")!=null){
			desaprobadosXmateria =(Integer)request.getAttribute("desaprobadosXmateria");
		}
		
		if(request.getAttribute("materia")!=null){
			materia = request.getAttribute("materia").toString();
		}
		
		if(request.getAttribute("años")!=null){
			años = (ArrayList)request.getAttribute("años");
			
		}
		if(request.getAttribute("aprobados")!=null){
			aprobados =(ArrayList)request.getAttribute("aprobados");
		}
		
		if(request.getAttribute("desaprobados")!=null){
			desaprobados = (ArrayList)request.getAttribute("desaprobados");
		}
		
     	%>
		
	</head>
	<body>
	
		<jsp:include page="Menu.jsp"></jsp:include>
		
		<div class="contenedor">
		
		<div class="fondo" style="width:80%; height: 700px;">
			<div style="display:flex; flex-direction:column;">
				<div id="graficos" style="display:flex; flex-direction:row;">
					<div style="margin: 10px 10px 10px 10px;width:100%;">
						<form method="get" action="ServletAdminReportes">
							<select name="ddlMaterias" required >
								<%
								NegocioimplMaterias negMateria = new NegocioimplMaterias();
								List<Materias> mat =  negMateria.readAll();
								int i = 0;
								for(Materias m : mat){
									%> <option value="<%=m.getID() %>" 
									> <%=m.getDescripcion()  %></option> <%
								}
								%>
							</select> 
							<input type="submit" id="btnAceptar" value="Aceptar" class="botones" style="width: auto; padding:10px 10px 10px 10px; margin:5px 5px 5px 5px;">
							<div id="piechart_3d" style="height: 300px;"></div>
						</form>
					</div>
					<div style="margin: 10px 10px 10px 10px; width:100%;">
					</div>
				</div>
				<div style="display:flex; flex-direction:row;">
					<div style="margin: 10px 10px 10px 10px; width:100%;">
						<div id="columnchart_material" style="height: 300px;"></div>
					</div>
				</div>
			</div>
		</div>
		
		</div>
		 
		<jsp:include page="Footer.html"></jsp:include>
		
		<script type="text/javascript">
	
		google.charts.load("current", {'packages':["corechart"]});
		google.charts.load('current', {'packages':['bar']});
	    google.charts.setOnLoadCallback(drawChartTorta);
	    google.charts.setOnLoadCallback(drawChartBar);
	    	
      	function drawChartTorta() {
	    	var data = new google.visualization.DataTable();
			data.addColumn('string','Estado');
			data.addColumn('number','Cantidad');
	              
            data.addRow(['Aprobados', <%=aprobadosXmateria%> ]);
            data.addRow(['Desaprobados', <%=desaprobadosXmateria%> ]);
	        
	        <% if(aprobadosXmateria==0 && desaprobadosXmateria==0){
	        	materia="No se encontraron calificaciones de " + materia;
	        }%>
	        
	        var options = {
	          title: '<%=materia%>' ,
	          is3D: true,
	          chart: {
	        	  title:"Aprobados y Desaprobados por Materia",
	          }
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
	        chart.draw(data, options);
	      }
			
        function drawChartBar() {
        	var data = new google.visualization.DataTable();
			data.addColumn('date','Año');
			data.addColumn('number','Aprobados');
			data.addColumn('number','Desaprobados');
			
			<%
			for(i = 0; i < años.size(); i++ ){
				%> 
				data.addRow([new Date(<%= (Integer)años.get(i) %>,1,1),<%= (Integer)aprobados.get(i) %>,<%= (Integer)desaprobados.get(i) %>]);
				<%
			}
			
			
			%>
			
          var options = {
            chart: {
              title: 'Aprobados y Desaproados por año',
            }
          };

          var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

          chart.draw(data, google.charts.Bar.convertOptions(options));
        }
   		 </script>
		
	</body>
	
</html>