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
import entidad.Docente;
import negocioimpl.NegocioimplAlumnos;
import negocioimpl.NegocioimplProfesores;
import negocioimpl.NegocioimplUsuarios;

/**
 * Servlet implementation class ServletAdminTablaProfesores
 */
@WebServlet("/ServletAdminTablaProfesores")
public class ServletAdminTablaProfesores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAdminTablaProfesores() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		NegocioimplProfesores negocioprofesores = new NegocioimplProfesores();
		Docente docente = new Docente();
		ArrayList<Docente> docentes = (ArrayList<Docente>) negocioprofesores.readAll();
		
		request.setAttribute("docentes", docentes);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaProfesores.jsp");   
        rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("btnEliminar")!=null)
         {
       	  
         if(request.getParameter("LegajoProfe")!= null)
         {
       	  int legajo = Integer.parseInt(request.getParameter("LegajoProfe"));  
       	  NegocioimplProfesores negocioProfe = new NegocioimplProfesores();
       	  boolean funco = negocioProfe.spEliminarProfesor(negocioProfe.obtenerProfesor(legajo));
          ArrayList<Docente> docentes = (ArrayList<Docente>) negocioProfe.readAll();
       	   	request.setAttribute("funco", funco);
            request.setAttribute("docentes", docentes);
 			RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaProfesores.jsp");   
 	        rd.forward(request, response);
         }
         
         }
	}

}
