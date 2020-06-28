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
import negocioimpl.NegocioimplCursos;

/**
 * Servlet implementation class ServletProfesoresTablaCursos
 */
@WebServlet("/ServletProfesoresTablaCursos")
public class ServletProfesoresTablaCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfesoresTablaCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Docente prof = new Docente();
		prof =(Docente)request.getSession().getAttribute("profesor");
		
			NegocioimplCursos negociocursos = new NegocioimplCursos();
			
			ArrayList<Cursos> curso = (ArrayList<Cursos>) negociocursos.CursosProfe(prof.getLegajo());
			
			request.setAttribute("cursos", curso);
			RequestDispatcher rd = request.getRequestDispatcher("/ProfesoresTablaCursos.jsp");   
	        rd.forward(request, response);
			}
		
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
