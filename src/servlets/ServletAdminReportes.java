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

import negocioimpl.NegocioimplAlumnoXCurso;
import negocioimpl.NegocioimplMaterias;
import entidad.AlumnosXCursos;
import entidad.Materias;

@WebServlet("/ServletAdminReportes")
public class ServletAdminReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAdminReportes() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NegocioimplAlumnoXCurso negAlumXCurso = new NegocioimplAlumnoXCurso();		
		ArrayList<AlumnosXCursos> alumnosxcursos = (ArrayList<AlumnosXCursos>)negAlumXCurso.readAll();
		
		if(request.getParameter("ddlMaterias")!=null) { // APROBADOS Y DESAPROBADOS POR MATERIA
			int aprobadosXmateria = 0;
			int desaprobadosXmateria = 0;
			int materia = Integer.parseInt(request.getParameter("ddlMaterias"));
			NegocioimplMaterias negMateria = new NegocioimplMaterias();
			for(AlumnosXCursos alumxcur:alumnosxcursos){
				if(alumxcur.getCurso().getMateria().getID()==materia) {
					if(alumxcur.getSituacion().equals("Regular")){
						aprobadosXmateria++;
					}else if(alumxcur.getSituacion().equals("Libre")) {
						desaprobadosXmateria++;
					}
				}
			}
			request.setAttribute("materia", negMateria.obtenerMateria(materia).getDescripcion());
			request.setAttribute("aprobadosXmateria", aprobadosXmateria);
			request.setAttribute("desaprobadosXmateria", desaprobadosXmateria);
		}else {
			int aprobadosXmateria = 0;
			int desaprobadosXmateria = 0;
			int materia = 1;
			NegocioimplMaterias negMateria = new NegocioimplMaterias();
			for(AlumnosXCursos alumxcur:alumnosxcursos){
				if(alumxcur.getCurso().getMateria().getID()==materia) {
					if(alumxcur.getSituacion().equals("Regular")){
						aprobadosXmateria++;
					}else if(alumxcur.getSituacion().equals("Libre")) {
						desaprobadosXmateria++;
					}
				}
			}
			request.setAttribute("materia", negMateria.obtenerMateria(materia).getDescripcion());
			request.setAttribute("aprobadosXmateria", aprobadosXmateria);
			request.setAttribute("desaprobadosXmateria", desaprobadosXmateria);
			
			
		}
		NegocioimplMaterias negMateria = new NegocioimplMaterias();
		List<Materias> mat =  negMateria.readAll();
		List años = negAlumXCurso.ObtenerAños();
		List aprobados = negAlumXCurso.ObtenerAprobados();
		List desaprobados = negAlumXCurso.ObtenerDesaprobados();
		
		request.setAttribute("mat", mat);
		request.setAttribute("años", años);
		request.setAttribute("aprobados", aprobados);
		request.setAttribute("desaprobados", desaprobados);
		
		RequestDispatcher rd = request.getRequestDispatcher("/AdminReportes.jsp");   
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
