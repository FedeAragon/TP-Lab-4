package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoimpl.DaoimplCursos;
import entidad.Cursos;
import entidad.Docente;
import entidad.Materias;

/**
 * Servlet implementation class ServletAdminAgregarCursos
 */
@WebServlet("/ServletAdminAgregarCursos")
public class ServletAdminAgregarCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminAgregarCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean anduvo=false;
		if(request.getParameter("btnAgregar")!=null) {
			Cursos c = new Cursos();
			Materias m= new  Materias();
			Docente d= new Docente();
			m.setID(Integer.parseInt(request.getParameter("ddlMaterias")));
			c.setMateria(m);
			c.setCuatrimeste(Integer.parseInt(request.getParameter("ddlCuatrimestre")));
			c.setAnio(Integer.parseInt(request.getParameter("txtAnio")));
			c.setComision(Integer.parseInt(request.getParameter("txtComision")));
			d.setLegajo(Integer.parseInt(request.getParameter("ddlDocentes")));
			c.setDocente(d);
			DaoimplCursos daoCurso = new DaoimplCursos();
			anduvo=daoCurso.spAgregarCurso(c);
			request.setAttribute("anduvo", anduvo);
			RequestDispatcher rd= request.getRequestDispatcher("/AdminAgregarCursos.jsp");
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
