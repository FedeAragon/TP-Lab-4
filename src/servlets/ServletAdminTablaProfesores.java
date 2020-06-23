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

import entidad.Docente;
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
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("Param")!= null) {
		
		NegocioimplProfesores negocioprofesores = new NegocioimplProfesores();
		Docente docente = new Docente();
		ArrayList<Docente> docentes = (ArrayList<Docente>) negocioprofesores.readAll();
		
		request.setAttribute("docentes", docentes);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaProfesores.jsp");   
        rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("fedeputo")!= null) {
		NegocioimplProfesores negocioprofesores = new NegocioimplProfesores();
		Docente docente = new Docente();
		List<Docente> docentes = negocioprofesores.readAll();
		
		request.setAttribute("docentes", docentes);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaProfesores.jsp");   
        rd.forward(request, response);
		}
		
	}

}
