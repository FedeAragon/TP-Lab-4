package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cursos;
import entidad.Docente;
import entidad.Materias;
import negocioimpl.NegocioimplCursos;
import negocioimpl.NegocioimplMaterias;
import negocioimpl.NegocioimplProfesores;

@WebServlet("/ServletAdminModificarCurso")
public class ServletAdminModificarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAdminModificarCurso() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 if(request.getParameter("btnModificar")!=null)
	      {
	    	  if(request.getParameter("codMate")!= null && request.getParameter("codCuatri")!=null
	    	     && request.getParameter("anio")!=null && request.getParameter("legDocente")!=null
	    	     && request.getParameter("comision")!=null) 
	    	  {    
	    		  int codMate = Integer.parseInt(request.getParameter("codMate"));
	    		  int codCuatri = Integer.parseInt(request.getParameter("codCuatri"));
	    		  int anio = Integer.parseInt(request.getParameter("anio"));
	    		  int legDocente = Integer.parseInt(request.getParameter("legDocente"));
	    		  int comision = Integer.parseInt(request.getParameter("comision"));
	    		  
	    		  NegocioimplProfesores negocioProfe = new NegocioimplProfesores();
	    		  NegocioimplMaterias negocioMateria = new NegocioimplMaterias();
	    		  
	    		  Docente docente = negocioProfe.obtenerProfesor(legDocente);
	    		  Materias materia = negocioMateria.obtenerMateria(codMate);
	    		  Cursos curso = new Cursos(comision, materia, codCuatri, anio, docente, 1);   	
	    		  
	    		request.setAttribute("Curso", curso);
	    	    RequestDispatcher rd= request.getRequestDispatcher("/AdminModificarCursos.jsp");
	  			rd.forward(request, response);			  
	    	  } 
	      }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
