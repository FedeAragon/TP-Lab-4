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
import negocioimpl.NegocioimplCursos;
import negocioimpl.NegocioimplMaterias;

@WebServlet("/ServletProfesoresTablaCursos")
public class ServletProfesoresTablaCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletProfesoresTablaCursos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Docente prof = new Docente();
		prof =(Docente)request.getSession().getAttribute("profesor");
		if (prof.getNombreyAp() == "admin") {
			
			
			
		}
		
			NegocioimplCursos negociocursos = new NegocioimplCursos();
			
			ArrayList<Cursos> curso = (ArrayList<Cursos>) negociocursos.CursosProfe(prof.getLegajo());
			
			request.setAttribute("cursos", curso);
			RequestDispatcher rd = request.getRequestDispatcher("/ProfesoresTablaCursos.jsp");   
	        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("btnVerAlumnos")!= null)
		{
			Cursos c = new Cursos();
			Materias m = new Materias();
		    Docente d = new Docente(); 
		    NegocioimplMaterias negMateria = new NegocioimplMaterias();
		    NegocioimplCursos negCurso = new NegocioimplCursos();
		    
		    d = (Docente)request.getSession().getAttribute("profesor"); 
		    c = negCurso.saberCurso(Integer.parseInt(request.getParameter("CodCurso")));
			
			NegocioimplAlumnoXCurso negAluXCurso = new NegocioimplAlumnoXCurso();
			ArrayList<AlumnosXCursos> alumsXCursos = new ArrayList<AlumnosXCursos>();
			alumsXCursos =(ArrayList<AlumnosXCursos>)negAluXCurso.AlumnosdelCurso(c);
			request.setAttribute("CodCurso", c.getCodCurso());		
			request.setAttribute("cursos",alumsXCursos); 
			RequestDispatcher rd = request.getRequestDispatcher("/ProfesoresTablaAlumnosXCurso.jsp");   
	        rd.forward(request, response);
		}else {
		
		doGet(request, response);
		}
	}

}
