package servlets;

import java.io.IOException;

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

/**
 * Servlet implementation class ServletAdminModificarAlumno
 */
@WebServlet("/ServletAdminModificarAlumno")
public class ServletAdminModificarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletAdminModificarAlumno() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NegocioimplAlumnos negocioalumno = new NegocioimplAlumnos();
		Alumno alumno = new Alumno();
		if(request.getParameter("btnModificar")!=null)
		{   
			
			if(request.getParameter("LegajoAlu") != null) {
				
			  alumno = negocioalumno.obtenerAlumno(Integer.parseInt(request.getParameter("LegajoAlu")));
		}
	}
		
		request.setAttribute("alumno", alumno);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarAlumno.jsp");   
        rd.forward(request, response);
		
	}
	

}
