package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoimpl.DaoimplAlumnos;
import entidad.Alumno;
import negocioimpl.NegocioimplAlumnos;

/**
 * Servlet implementation class ServletAdminTablaAlumnos
 */
@WebServlet("/ServletAdminTablaAlumnos")
public class ServletAdminTablaAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAdminTablaAlumnos() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!= null) {
			
			NegocioimplAlumnos negAlu = new NegocioimplAlumnos();
			ArrayList<Alumno> alumnos = (ArrayList<Alumno>) negAlu.readAll();
			request.setAttribute("alumnos", alumnos);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaAlumnos.jsp");   
	        rd.forward(request, response);
			}
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		
		if(request.getParameter("btnEliminar")!=null)
          {
        	  
          if(request.getParameter("LegajoAlu")!= null)
          {
        	  int legajo = Integer.parseInt(request.getParameter("LegajoAlu"));  
        	  NegocioimplAlumnos negocioalu = new NegocioimplAlumnos();
        	  negocioalu.spEliminarAlumno(negocioalu.obtenerAlumno(legajo)); 
        	  ArrayList<Alumno> alumnos = (ArrayList<Alumno>) negocioalu.readAll();
  			
        	  
            request.setAttribute("alumnos", alumnos); 
  			RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaAlumnos.jsp");   
  	        rd.forward(request, response);
          }
          
          }
	}

}
