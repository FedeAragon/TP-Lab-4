package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.AlumnosXCursos;
import entidad.Cursos;
import entidad.Materias;
import negocioimpl.NegocioimplAlumnoXCurso;
import negocioimpl.NegocioimplAlumnos;
import negocioimpl.NegocioimplProfesores;

/**
 * Servlet implementation class ServletAdminAgregarAlumnoXCurso
 */
@WebServlet("/ServletAdminAgregarAlumnoXCurso")
public class ServletAdminAgregarAlumnoXCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletAdminAgregarAlumnoXCurso() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		if (request.getParameter("btnAgregar") != null) {
		Cursos c = new Cursos();
		Materias m = new Materias();
		Alumno alu = new Alumno();
		NegocioimplProfesores negocioprofe = new NegocioimplProfesores();
		NegocioimplAlumnos negAlu = new NegocioimplAlumnos();
		m.setID(Integer.parseInt(request.getParameter("Materia")));
		c.setMateria(m);
		c.setCuatrimeste(Integer.parseInt(request.getParameter("Cuatri")));
		c.setAnio(Integer.parseInt(request.getParameter("Anio")));
		c.setComision(Integer.parseInt(request.getParameter("Comision")));
		c.setDocente(negocioprofe.obtenerProfesor(Integer.parseInt(request.getParameter("LegajoProf"))));		
		alu = negAlu.obtenerAlumno(Integer.parseInt(request.getParameter("LegajoAlu")));
		AlumnosXCursos aluXcursos = new AlumnosXCursos(c,alu);
		NegocioimplAlumnoXCurso negaluxcurso = new NegocioimplAlumnoXCurso();
		boolean funco= false;
		funco = negaluxcurso.spAgregarAlumnoXCurso(aluXcursos);
		request.setAttribute("funco",funco);
		List<Alumno> alumnos = (List<Alumno>) negAlu.AlumnosAgregar(c);
		request.setAttribute("alumnos", alumnos);
		request.setAttribute("curso",c);
		rd = request.getRequestDispatcher("/AdminAgregarAlumnoXCurso.jsp");
		rd.forward(request, response);

		}
		
	}

}
