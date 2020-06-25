<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
</head>
<body>

  <jsp:include page="Menu.jsp"></jsp:include>
  
  <div class="contenedor">
  
  <div class="fondo">

<div class="titulo_div">
  <label id="titulo" class ="titulos" >Agregar Cursos</label>
  </div>
  <hr>
<div class="cuadrado">
 
  <form class="contenido">
 <label id ="lblMateria" class="subtitulos">Materia</label>
 <select name="ddlMaterias" class = "Ddls">
 </select> 
 <label id ="lblCuatrimestre" class="subtitulos">Cuatrimestre</label>
 <select name="ddlCuatrimestre" class = "Ddls">
                        <option value="1">Primer Cuatrimestre</option>
						<option value="2">Segundo Cuatrimestre</option>
 </select> 
 <label id ="lblAnio" class="subtitulos">Año</label>
 <input type="text" name="txtAnio" class= "texts">
  <label id ="lblDocente" class="subtitulos">Docente</label>
   <select name="ddlDocentes" class = "Ddls">
 </select> 
  <br>
  <input type="submit" name="btnAgregar" value="Agregar Alumnos" class= "botones">
  </form>
  
  

  </div>
  
  </div>
  
  </div>
  
 <jsp:include page="Footer.html"></jsp:include>
  
</body>
</html>