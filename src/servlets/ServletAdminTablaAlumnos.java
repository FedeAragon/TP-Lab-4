package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import negocioimpl.NegocioimplAlumnos;

/**
 * Servlet implementation class ServletAdminTablaAlumnos
 */
@WebServlet("/ServletAdminTablaAlumnos")
public class ServletAdminTablaAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminTablaAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!= null) {
			
			NegocioimplAlumnos negAlu = new NegocioimplAlumnos();
			Alumno alu = new Alumno();
			ArrayList<Alumno> alumnos = (ArrayList<Alumno>) negAlu.readAll();
			
			request.setAttribute("alumnos", alumnos);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaAlumnos.jsp");   
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
