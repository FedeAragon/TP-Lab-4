package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Docente;
import negocioimpl.NegocioimplProfesores;
import negocioimpl.NegocioimplUsuarios;

/**
 * Servlet implementation class ServletAdminModificarProfesor
 */
@WebServlet("/ServletAdminModificarProfesor")
public class ServletAdminModificarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAdminModificarProfesor() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NegocioimplProfesores negocioprofesores = new NegocioimplProfesores();
		Docente docente = new Docente();
		if(request.getParameter("btnModificar")!=null)
		{   
			
			if(request.getParameter("LegajoProfe") != null) {
				
			  docente = negocioprofesores.obtenerProfesor(Integer.parseInt(request.getParameter("LegajoProfe")));
		}
	}
		
		request.setAttribute("docente", docente);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarProfesor.jsp");   
        rd.forward(request, response);
		
	}
}
