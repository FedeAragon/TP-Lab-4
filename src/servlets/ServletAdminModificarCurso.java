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
import entidad.Cursos;
import entidad.Docente;
import entidad.Materias;
import negocioimpl.NegocioimplCursos;
import negocioimpl.NegocioimplMaterias;
import negocioimpl.NegocioimplProfesores;

@WebServlet("/ServletAdminModificarCurso")
public class ServletAdminModificarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAdminModificarCurso() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 if(request.getParameter("btnModificar")!=null)
	      {
	    	  if(request.getParameter("codMate")!= null && request.getParameter("codCuatri")!=null
	    	     && request.getParameter("anio")!=null && request.getParameter("legDocente")!=null
	    	     && request.getParameter("CodCurso")!=null) 
	    	  {    
	    		  
	    		  int codMate = Integer.parseInt(request.getParameter("codMate"));
	    		  int codCuatri = Integer.parseInt(request.getParameter("codCuatri"));
	    		  int anio = Integer.parseInt(request.getParameter("anio"));
	    		  int legDocente = Integer.parseInt(request.getParameter("legDocente"));
	    		  int CodCurso = Integer.parseInt(request.getParameter("CodCurso").trim());
	    		  
	    		  NegocioimplProfesores negocioProfe = new NegocioimplProfesores();
	    		  NegocioimplMaterias negocioMateria = new NegocioimplMaterias();
	    		  NegocioimplMaterias negMateria = new NegocioimplMaterias();
	    		  NegocioimplProfesores negProfesores = new NegocioimplProfesores();
	    				
	    		  List<Materias> mat =  negMateria.readAll();
	    		  List<Docente> doc =  negProfesores.readAll();	    				    		    		  
	    		  Docente docente = negocioProfe.obtenerProfesor(legDocente);
	    		  Materias materia = negocioMateria.obtenerMateria(codMate);
	    		  Cursos curso = new Cursos(CodCurso, materia, codCuatri, anio, docente, 1);   	
	    		  
	    		request.setAttribute("doc", doc);
	    		request.setAttribute("mat", mat);  
	    		request.setAttribute("Curso", curso);
	    	    RequestDispatcher rd= request.getRequestDispatcher("/AdminModificarCursos.jsp");
	  			rd.forward(request, response);			  
	    	  } 
	      }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnModificar")!=null) {
			
			boolean funco = false;
			boolean repetido = false;
			Cursos curso = new Cursos();
			NegocioimplProfesores negocioProfe = new NegocioimplProfesores();
  		    NegocioimplMaterias negocioMateria = new NegocioimplMaterias();
  		    NegocioimplCursos negocioCurso = new NegocioimplCursos();
  		    
  		    Docente docente = negocioProfe.obtenerProfesor(Integer.parseInt(request.getParameter("ddlDocentes")));
  		    Materias materia = negocioMateria.obtenerMateria(Integer.parseInt(request.getParameter("ddlMaterias")));
  		    curso.setMateria(materia);
  		    curso.setDocente(docente);
  		    curso.setCodCurso(Integer.parseInt(request.getParameter("CodCurso")));
  		    curso.setAnio(Integer.parseInt(request.getParameter("txtAnio")));
  		    curso.setCuatrimeste(Integer.parseInt(request.getParameter("ddlCuatrimestre")));
  		    curso.setEstado(1);
  		    
  		    if(negocioCurso.obtenerCurso(curso))
  		    {
  		    	repetido = true;
  		    	request.setAttribute("repetido", repetido);
  		    	request.setAttribute("Curso", curso);
  				RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCursos.jsp");   
  		        rd.forward(request, response);
  		    }
  		    else
  		    {
  		        funco = negocioCurso.spModificarCurso(curso);
  	  		    System.out.println(curso);
  	  		    System.out.println(funco);
  	  		    request.setAttribute("funco", funco);
  	  		    NegocioimplCursos negocioCursos = new NegocioimplCursos();
  			    List<Cursos> cursos = (List<Cursos>) negocioCursos.readAll();
  			
  			   request.setAttribute("cursos", cursos);
  			   RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaCursos.jsp");   
  	           rd.forward(request, response);
  		    }		   
		}
		
	}

}
