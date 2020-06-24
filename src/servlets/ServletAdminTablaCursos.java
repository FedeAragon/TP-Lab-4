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
import negocioimpl.NegocioimplCursos;


/**
 * Servlet implementation class ServletAdminTablaCursos
 */
@WebServlet("/ServletAdminTablaCursos")
public class ServletAdminTablaCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminTablaCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!= null) {
			
			NegocioimplCursos negociocursos = new NegocioimplCursos();
			
			ArrayList<Cursos> curso = (ArrayList<Cursos>) negociocursos.readAll();
			
			request.setAttribute("cursos", curso);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaCursos.jsp");   
	        rd.forward(request, response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
