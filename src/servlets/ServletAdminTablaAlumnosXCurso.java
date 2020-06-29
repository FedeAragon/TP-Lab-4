package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.AlumnosXCursos;
import entidad.Cursos;
import entidad.Docente;
import entidad.Materias;
import negocioimpl.NegocioimplAlumnoXCurso;
import negocioimpl.NegocioimplProfesores;

/**
 * Servlet implementation class ServletAdminTablaAlumnosXCurso
 */
@WebServlet("/ServletAdminTablaAlumnosXCurso")
public class ServletAdminTablaAlumnosXCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAdminTablaAlumnosXCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("btnAlumnos")!=null) {
		
		Cursos c = new Cursos();
		Materias m = new Materias();
	    Docente d = new Docente(); 
	    NegocioimplProfesores negprofe= new NegocioimplProfesores();
	    d = negprofe.obtenerProfesor(Integer.parseInt(request.getParameter("legDocente")));
		
		m.setID(Integer.parseInt(request.getParameter("codMate")));
		c.setMateria(m);
		c.setDocente(d);
		c.setAnio(Integer.parseInt(request.getParameter("anio")));
		c.setCuatrimeste(Integer.parseInt(request.getParameter("codCuatri")));
		c.setComision(Integer.parseInt(request.getParameter("comision"))); 
		
		NegocioimplAlumnoXCurso negAluXCurso = new NegocioimplAlumnoXCurso();
		ArrayList<AlumnosXCursos> alumsXCursos = new ArrayList<AlumnosXCursos>();
		alumsXCursos =(ArrayList<AlumnosXCursos>)negAluXCurso.AlumnosdelCurso(c);
		
		request.setAttribute("cursos",alumsXCursos); 
		RequestDispatcher rd = request.getRequestDispatcher("/ProfesoresTablaAlumnosXCurso.jsp");   
        rd.forward(request, response);
		
		
	}
		
	}

}
