package servlets;

import java.io.IOException;
import java.sql.Date;
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
		if(request.getParameter("btnAceptar2")!= null)
		{
			int inicio = Integer.parseInt(request.getParameter("txtInicio"));
			int fin = Integer.parseInt(request.getParameter("txtFinal"));
		
			List años = negAlumXCurso.ObtenerAños(inicio , fin);
			List aprobados = negAlumXCurso.ObtenerAprobados(inicio , fin);
			List desaprobados = negAlumXCurso.ObtenerDesaprobados(inicio , fin);
			request.setAttribute("años", años);
			request.setAttribute("aprobados", aprobados);
			request.setAttribute("desaprobados", desaprobados);
		}
		
		NegocioimplMaterias negMateria = new NegocioimplMaterias();
		List<Materias> mat =  negMateria.readAll();		
		request.setAttribute("mat", mat);
		
		RequestDispatcher rd = request.getRequestDispatcher("/AdminReportes.jsp");   
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
