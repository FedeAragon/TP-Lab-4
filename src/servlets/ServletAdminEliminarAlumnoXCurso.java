package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.AlumnosXCursos;
import entidad.Cursos;
import negocioimpl.NegocioimplAlumnoXCurso;
import negocioimpl.NegocioimplAlumnos;
import negocioimpl.NegocioimplCursos;

/**
 * Servlet implementation class ServletAdminEliminarAlumnoXCurso
 */
@WebServlet("/ServletAdminEliminarAlumnoXCurso")
public class ServletAdminEliminarAlumnoXCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminEliminarAlumnoXCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		if (request.getParameter("btnEliminar") != null) {
			Cursos c = new Cursos();
			NegocioimplAlumnoXCurso negalumXcurso = new NegocioimplAlumnoXCurso();
			NegocioimplCursos negC = new NegocioimplCursos();
		   
			c = negC.saberCurso(Integer.parseInt(request.getParameter("CodCurso").trim()));
			List<AlumnosXCursos> alumnos = (List<AlumnosXCursos>) negalumXcurso.AlumnosdelCurso(c);
			request.setAttribute("alumnos", alumnos);
			request.setAttribute("curso",c);
			rd = request.getRequestDispatcher("/AdminEliminarAlumnoXCurso.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnEliminar")!=null)
	      {
			
	    	  if( request.getParameter("CodCurso")!=null) 
	    	  {    
	    		 
	    		  
	    		  int Legajo = Integer.parseInt(request.getParameter("LegajoAlu").trim());
	    		  NegocioimplAlumnoXCurso negocioaxc = new NegocioimplAlumnoXCurso();
	    		  int CodCurso = Integer.parseInt(request.getParameter("CodCurso").trim());
	    		  NegocioimplCursos negcursos = new NegocioimplCursos();
	    		   Cursos c = negcursos.saberCurso(CodCurso);
	    		  NegocioimplAlumnoXCurso negAluXCurso = new NegocioimplAlumnoXCurso();
	    		 boolean funco = negAluXCurso.spEliminarAlumnoXCurso(CodCurso, Legajo);
	    			ArrayList<AlumnosXCursos> alumsXCursos = new ArrayList<AlumnosXCursos>();
	    			alumsXCursos =(ArrayList<AlumnosXCursos>)negAluXCurso.AlumnosdelCurso(c);
	    			
	    	    request.setAttribute("funco", funco);
	    		request.setAttribute("curso", c);
	    		request.setAttribute("alumnos", alumsXCursos);
	  			RequestDispatcher rd = request.getRequestDispatcher("/AdminEliminarAlumnoXCurso.jsp");   
	  	        rd.forward(request, response);
	    		      			  
	    	  } 
	      }	
	}

}
