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
import entidad.AlumnosXCursos;
import entidad.Cursos;
import negocioimpl.NegocioimplAlumnoXCurso;
import negocioimpl.NegocioimplCursos;


@WebServlet("/ServletProfesoresTablaAlumnosXCurso")
public class ServletProfesoresTablaAlumnosXCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ServletProfesoresTablaAlumnosXCurso() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("btnConfirmar")!=null)
	      {
		int vueltas = Integer.parseInt(request.getParameter("vueltas"));	
		String[] notaPrimerParcial = request.getParameterValues("txtParcial1");
		String[] notaSegundoParcial = request.getParameterValues("txtParcial2");
		String[] notaRecuperatorio1 = request.getParameterValues("txtRec1");
		String[] notaRecuperatorio2 = request.getParameterValues("txtRec2");
		String[] Situacion = request.getParameterValues("estado");
		String[] legAlumno =request.getParameterValues("legAlumno"); 
		int codCurso = Integer.parseInt(request.getParameter("CodCurso").trim());		
		NegocioimplAlumnoXCurso negaluxcurso = new NegocioimplAlumnoXCurso();
		
		int parc1[] = new int[vueltas];
		int parc2[] = new int[vueltas];
		int rec1[] = new int [vueltas];
		int rec2[] = new int[vueltas];
		int legAl[] = new int [vueltas];
		String sit[] = new String[vueltas];
		
		int cont = 0;
		for(String notaparc1 : notaPrimerParcial)
		{
			parc1[cont] = Integer.parseInt(notaparc1);
			cont ++;
		}
		cont = 0;
		
		for(String notaparc2 : notaSegundoParcial)
		{
			parc2[cont] = Integer.parseInt(notaparc2);
			cont ++;
		}
		cont = 0;
		
		for(String recc1 : notaRecuperatorio1)
		{
			rec1[cont] = Integer.parseInt(recc1);
			cont ++;
		}
		cont = 0;
		
		for(String recc2 : notaRecuperatorio2)
		{
			rec2[cont] = Integer.parseInt(recc2);
			cont ++;
		}
		cont = 0;
		
		for(String leg : legAlumno)
		{
			legAl[cont] = Integer.parseInt(leg);
			cont ++; 
		}
		cont = 0;
		
		for(String situ : Situacion)
		{
			sit[cont] = situ;
			cont ++;
		}
	
	    for(int i=0 ; i<vueltas ; i++)
		{
			Alumno al = new Alumno();
			Cursos cur = new Cursos();
			AlumnosXCursos axc = new AlumnosXCursos();
			al.setLegajo(legAl[i]); 
			cur.setCodCurso(codCurso);
			axc.setAlumno(al);
			axc.setCurso(cur);
			axc.setPrimerParcial(parc1[i]);
			axc.setSegundoParcial(parc2[i]);
			axc.setRecuperatorio1(rec1[i]);
			axc.setRecuperatorio2(rec2[i]);
			axc.setSituacion(sit[i]);
			
			boolean funco =negaluxcurso.spAgregarNotas(axc);
			request.setAttribute("funco",funco);
		}

		Cursos cu = new Cursos();
		cu.setCodCurso(codCurso);
		ArrayList<AlumnosXCursos> alumsXCursos = new ArrayList<AlumnosXCursos>();
		alumsXCursos =(ArrayList<AlumnosXCursos>)negaluxcurso.AlumnosdelCurso(cu);
				
		request.setAttribute("cursos",alumsXCursos); 
		request.setAttribute("CodCurso",codCurso); 
		RequestDispatcher rd = request.getRequestDispatcher("/ProfesoresTablaAlumnosXCurso.jsp");   
        rd.forward(request, response);  					
	      }
	}

}
