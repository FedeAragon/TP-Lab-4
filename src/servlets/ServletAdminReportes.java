package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioimpl.NegocioimplAlumnoXCurso;
import negocioimpl.NegocioimplMaterias;
import entidad.AlumnosXCursos;

/**
 * Servlet implementation class ServletAdminReportes
 */
@WebServlet("/ServletAdminReportes")
public class ServletAdminReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminReportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NegocioimplAlumnoXCurso negAlumXCurso = new NegocioimplAlumnoXCurso();
		ArrayList<AlumnosXCursos> alumnosxcursos = (ArrayList<AlumnosXCursos>)negAlumXCurso.readAll();
		if(request.getParameter("materia")!=null) {
			int aprobados = 0;
			int desaprobados = 0;
			int materia = Integer.parseInt(request.getParameter("materia"));
			NegocioimplMaterias negMateria = new NegocioimplMaterias();
			for(AlumnosXCursos alumxcur:alumnosxcursos){
				if(alumxcur.getCurso().getMateria().getID()==materia) {
					if(alumxcur.getSituacion().equals("Regular")){
						aprobados++;
					}else{
						desaprobados++;
					}
				}
			}
			System.out.println(negMateria.obtenerMateria(materia).getDescripcion());
			System.out.println(aprobados);
			System.out.println(desaprobados);
			request.setAttribute("nombre", negMateria.obtenerMateria(materia).getDescripcion());
			request.setAttribute("aprobados", aprobados);
			request.setAttribute("desaprobados", desaprobados);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/AdminReportes.jsp");   
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
