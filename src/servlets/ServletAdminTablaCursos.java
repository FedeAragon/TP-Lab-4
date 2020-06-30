package servlets;

import java.io.IOException;
import java.util.ArrayList;

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


/**
 * Servlet implementation class ServletAdminTablaCursos
 */
@WebServlet("/ServletAdminTablaCursos")
public class ServletAdminTablaCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAdminTablaCursos() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			NegocioimplCursos negociocursos = new NegocioimplCursos();
			
			ArrayList<Cursos> curso = (ArrayList<Cursos>) negociocursos.readAll();
			
			request.setAttribute("cursos", curso);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaCursos.jsp");   
	        rd.forward(request, response);
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if(request.getParameter("btnEliminar")!=null)
      {
    	  if( request.getParameter("CodCurso")!=null) 
    	  {    
    		 
    		
    		  
    		  NegocioimplCursos negocioCurso = new NegocioimplCursos();
    		Cursos curso = new Cursos();
    		curso = negocioCurso.saberCurso(Integer.parseInt(request.getParameter("CodCurso").trim()));
    		  negocioCurso.spEliminarCurso(curso);
    		  
    		ArrayList<Cursos> cursos = (ArrayList<Cursos>) negocioCurso.readAll();
  			
  			request.setAttribute("cursos", cursos); 
  			RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaCursos.jsp");   
  	        rd.forward(request, response);
    		      			  
    	  } 
      }
		
	}

}
