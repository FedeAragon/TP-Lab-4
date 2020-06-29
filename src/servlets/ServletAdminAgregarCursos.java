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

import daoimpl.DaoimplCursos;
import entidad.Alumno;
import entidad.AlumnosXCursos;
import entidad.Cursos;
import entidad.Docente;
import entidad.Materias;
import negocioimpl.NegocioimplAlumnoXCurso;
import negocioimpl.NegocioimplAlumnos;
import negocioimpl.NegocioimplCursos;

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
		boolean repetido = false;
		if(request.getParameter("btnAgregar")!=null) {
			Cursos c = new Cursos();
			Materias m= new  Materias();
			Docente d= new Docente();
			m.setID(Integer.parseInt(request.getParameter("ddlMaterias")));
			c.setMateria(m);
			c.setCuatrimeste(Integer.parseInt(request.getParameter("ddlCuatrimestre")));
			c.setAnio(Integer.parseInt(request.getParameter("txtAnio")));
			d.setLegajo(Integer.parseInt(request.getParameter("ddlDocentes")));
			c.setDocente(d);
			NegocioimplCursos negCurso = new NegocioimplCursos();
			if(negCurso.obtenerCurso(c)) 
			{
				repetido = true;
			}
			else 
			{
				anduvo = negCurso.spAgregarCurso(c); 
			}
			RequestDispatcher rd = null;
			
			if(repetido == true)
			{
				request.setAttribute("repetido", repetido);
				rd = request.getRequestDispatcher("/AdminAgregarCursos.jsp");
				rd.forward(request, response);
			}
		    else if(anduvo) {
			
				NegocioimplAlumnos negAlu = new NegocioimplAlumnos();
				c.setCodCurso(negCurso.ObtenerCodCurso());
				List<Alumno> alumnos = (List<Alumno>) negAlu.AlumnosAgregar(c);
				request.setAttribute("alumnos", alumnos);
				request.setAttribute("curso",c);
				
			rd = request.getRequestDispatcher("/AdminAgregarAlumnoXCurso.jsp");
			rd.forward(request, response);
			}else {
				request.setAttribute("anduvo", anduvo);
				rd = request.getRequestDispatcher("/AdminAgregarCursos.jsp");
				rd.forward(request, response);
				
			}
			
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
