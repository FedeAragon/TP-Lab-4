<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="negocioimpl.NegocioimplMaterias"%>
    <%@page import="negocio.NegocioMaterias"%>
    <%@page import="entidad.Materias"%>
    <%@page import="negocioimpl.NegocioimplProfesores"%>
    <%@page import="negocioimpl.NegocioimplCursos"%>
    <%@page import="negocio.NegocioProfesores"%>
    <%@page import="entidad.Docente"%>
    <%@ page import="java.util.List"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Estilos.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
<title>Agregar Curso</title>
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
 
  <form class="contenido" method="get" action="ServletAdminAgregarCursos">
  <label id ="lblCodCurso" class="subtitulos">CodCurso</label>
  <%
  if(request.getAttribute("ultcod")!= null)
  {
   int ultcodcurso = (int) request.getAttribute("ultcod");
 %>
  <input type="text" name="txtCodCurso" class= "texts" readonly="readonly" value=<%=ultcodcurso %>>
  <% }  %>
 <label id ="lblMateria" class="subtitulos">Materia</label>
 <select name="ddlMaterias" class = "Ddls" required>
 <option value="0" >Seleccione una Materia</option>
						
						<%  if(request.getAttribute("mat")!= null)
						{
							List<Materias> mat = (List<Materias>) request.getAttribute("mat"); 
							for(Materias m : mat){ 
								%> <option value="<%=m.getID() %>"
								> <%=m.getDescripcion()  %></option> <%
							}
						%>
					<%} %>							
 </select> 
 <label id ="lblCuatrimestre" class="subtitulos">Cuatrimestre</label>
 <select name="ddlCuatrimestre" class = "Ddls" required>
 						<option value="0">Seleccione un cuatrimestre</option>
                        <option value="1">Primer Cuatrimestre</option>
						<option value="2">Segundo Cuatrimestre</option>
 </select> 
 <label id ="lblAnio" class="subtitulos">Año</label>
 <input type="number" name="txtAnio" class= "texts" min="2000" max="2070" required>
  
  <label id ="lblDocente" class="subtitulos">Docente</label>
   <select name="ddlDocentes" class = "Ddls" required>
   <option value="0" >Seleccione un Docente</option>
						
						<%  if(request.getAttribute("doc")!= null)
						{
							List<Docente> doc = (List<Docente>)request.getAttribute("doc");
							for(Docente d : doc){
								%> <option value="<%=d.getLegajo() %>"
								> <%=d.getLegajo()+"-"+d.getNombreyAp()  %></option> <%
							}
						%>
						<%} %>	
 </select> 
  <br>
  <input type="submit" name="btnAgregar" value="Agregar Curso" class= "botones">
  <% 
  		if(request.getAttribute("anduvo")!=null){ 
  			 if((Boolean)request.getAttribute("anduvo")==true){	 
  			%>
  			<label>El curso se agrego con exito</label>
  		<%} else{
  			 %>
  			 <label>El curso no se agrego </label>
  			 <%
  		} %>	 
  		
  <% } else if(request.getAttribute("repetido")!=null)
  {
   %>
  <label>El curso ya se encuentra registrado</label>
  <%
  }
  %>
  </form>
  
  

  </div>
  
  </div>
  
  </div>
  
 <jsp:include page="Footer.html"></jsp:include>
  
</body>
</html>