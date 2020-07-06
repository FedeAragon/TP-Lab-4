<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entidad.Cursos" %> 
    <%@ page import="entidad.AlumnosXCursos" %> 
    <%@ page import="entidad.Materias" %> 
    <%@ page import="java.util.List"%>  
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
   		int aprobados =0;
		int desaprobados=0;
		String nombre = "";
		if(request.getAttribute("aprobados")!=null){
			aprobados = (Integer)request.getAttribute("aprobados");
			
		}
		if(request.getAttribute("desaprobados")!=null){
			desaprobados =(Integer)request.getAttribute("desaprobados");
		}
		
		if(request.getAttribute("nombre")!=null){
			nombre = request.getAttribute("nombre").toString();
		}

		System.out.println(nombre);
        System.out.println(aprobados);
        System.out.println(desaprobados);
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
						<select></select> 
						<div id="curve_chart" style="height: 300px;"></div>
					</div>
				</div>
				<div style="display:flex; flex-direction:row;">
					<div style="margin: 10px 10px 10px 10px; width:100%;">
						<select></select> 
						<div id="chart_div" style="height: 300px;"></div>
					</div>
					<div style="margin: 10px 10px 10px 10px; width:100%;">
						<select></select> 
						<div id="barchart_material" style="height: 300px;"></div>
					</div>
				</div>
			</div>
		</div>
		
		</div>
		 
		<jsp:include page="Footer.html"></jsp:include>
		
		<script type="text/javascript">
	
		google.charts.load("current", {'packages':["corechart"]});
	    google.charts.setOnLoadCallback(drawChartTorta);
	    	
      	function drawChartTorta() {
	    	var data = new google.visualization.DataTable();
			data.addColumn('string','Estado');
			data.addColumn('number','Cantidad');
	              
            data.addRow(['Aprobados', <%=aprobados%> ]);
            data.addRow(['Desaprobados', <%=desaprobados%> ]);
	        
	        <% if(aprobados==0 && desaprobados==0){
	        	nombre="No se encontraron calificaciones de " + nombre;
	        }%>
	        
	        var options = {
	          title: '<%=nombre%>' ,
	          is3D: true,
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
	        chart.draw(data, options);
	      }
	
   		 </script>
		
	</body>
	
</html>