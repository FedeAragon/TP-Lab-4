<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Reportes</title>
		<link rel="stylesheet" type="text/css" href="css/Estilos.css">
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	    <script type="text/javascript">
	      google.charts.load("current", {packages:["corechart"]});
	      google.charts.setOnLoadCallback(drawChartTorta);
	      google.charts.setOnLoadCallback(drawChartCurva);
	      google.charts.setOnLoadCallback(drawChartLinea);
	      google.charts.setOnLoadCallback(drawChartBarras);
	      function drawChartTorta() {
	        var data = google.visualization.arrayToDataTable([
	          ['Task', 'Hours per Day'],
	          ['Laboratorio IV',     11],
	          ['Programacion III',      2],
	          ['Metodologia de Sistemas I',  2],
	          ['Legislacion',    7]
	        ]);
	
	        var options = {
	          title: 'Aprobados por Materia',
	          is3D: true,
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
	        chart.draw(data, options);
	      }
      function drawChartCurva() {
        var data = google.visualization.arrayToDataTable([
          ['Año', 'Regulares', 'Libres'],
          ['2004',  1000,      400],
          ['2005',  1170,      460],
          ['2006',  660,       1120],
          ['2007',  1030,      540]
        ]);

        var options = {
          title: 'Condicion de Alumnos',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
      function drawChartLinea(){
          var data = google.visualization.arrayToDataTable([
              ['Año', 'Inscripciones'],
              ['2013',  1000],
              ['2014',  1170],
              ['2015',  660],
              ['2016',  1030]
            ]);

            var options = {
              title: 'Inscripciones',
              hAxis: {title: 'Año',  titleTextStyle: {color: '#333'}},
              vAxis: {minValue: 0}
            };

            var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
            chart.draw(data, options);
          }
      function drawChartBarras() {

          var data = google.visualization.arrayToDataTable([
            ['Materia', 'Aprobados',],
            ['2019', 817],
            ['2018', 379],
            ['2017', 269],
            ['2016', 209],
            ['2015', 152]
          ]);

          var options = {
            title: 'Materia por Año',
            chartArea: {width: '50%'},
            hAxis: {
              title: 'Cantidad de Aprobados',
              minValue: 0
            },
            vAxis: {
              title: 'Materia'
            }
          };

          var chart = new google.visualization.BarChart(document.getElementById('barchart_material'));

          chart.draw(data, options);
        }
    </script>
	</head>
	<body>
	
		<jsp:include page="Menu.html"></jsp:include>
		
		<div class="contenedor">
		
		<div class="fondo" style="width:80%; height: 700px;">
			<div style="display:flex; flex-direction:column;">
				<div id="graficos" style="display:flex; flex-direction:row;">
					<div style="margin: 10px 10px 10px 10px;width:100%;">
						<input type="date">
						<input type="date">
						<select></select> 
						<div id="piechart_3d" style="height: 300px;"></div>
					</div>
					<div style="margin: 10px 10px 10px 10px; width:100%;">
						<input type="date">
						<input type="date">
						<select></select> 
						<div id="curve_chart" style="height: 300px;"></div>
					</div>
				</div>
				<div style="display:flex; flex-direction:row;">
					<div style="margin: 10px 10px 10px 10px; width:100%;">
						<input type="date">
						<input type="date">
						<select></select> 
						<div id="chart_div" style="height: 300px;"></div>
					</div>
					<div style="margin: 10px 10px 10px 10px; width:100%;">
						<input type="date">
						<input type="date">
						<select></select> 
						<div id="barchart_material" style="height: 300px;"></div>
					</div>
				</div>
			</div>
		</div>
		
		</div>
		 
		<jsp:include page="Footer.html"></jsp:include>
		
	</body>
</html>