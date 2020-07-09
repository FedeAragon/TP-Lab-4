package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Docente;
import entidad.Provincias;
import negocioimpl.NegocioimplLocalidades;
import negocioimpl.NegocioimplProfesores;
import negocioimpl.NegocioimplProvincias;
import negocioimpl.NegocioimplUsuarios;

/**
 * Servlet implementation class ServletAdminModificarProfesor
 */
@WebServlet("/ServletAdminModificarProfesor")
public class ServletAdminModificarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAdminModificarProfesor() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NegocioimplProfesores negocioprofesores = new NegocioimplProfesores();
		Docente docente = new Docente();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String todaysdate = dateFormat.format(date);
        request.setAttribute("today", todaysdate);
		if(request.getParameter("btnModificar")!=null)
		{   
			NegocioimplProvincias negProv = new NegocioimplProvincias();
			List<Provincias> provincias =  negProv.readAll();
			
			if(request.getParameter("LegajoProfe") != null) 
			{
				
			  docente = negocioprofesores.obtenerProfesor(Integer.parseInt(request.getParameter("LegajoProfe")));
		    }
			request.setAttribute("provincias", provincias);
			request.setAttribute("docente", docente);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarProfesor.jsp");   
	        rd.forward(request, response);
	   }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnModificar")!=null)
        {
		  NegocioimplProfesores negocioprofe = new NegocioimplProfesores();
      	  NegocioimplLocalidades negocioloca = new NegocioimplLocalidades();
      	  NegocioimplProvincias negocioprov = new NegocioimplProvincias();
      	  Docente d = new Docente();
      	  	java.util.Date date = null;
      	try {
			 date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DateNacimiento"));
				
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
    	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        d.setLegajo(Integer.parseInt(request.getParameter("txtLegajo")));
        d.setEstado(1);
        d.setDNI(Integer.parseInt(request.getParameter("txtDNI")));
        d.setDireccion(request.getParameter("txtDireccion").toString());
        d.setLocalidad(negocioloca.obtenerLocalidad(request.getParameter("ddlLocalidades").toString()));
        d.setProvincia(negocioprov.obtenerProvincia(request.getParameter("provincia").toString()));
        d.setFechaNacimiento(sqlDate);
        d.setNombreyAp(request.getParameter("txtNombre").toString());
        d.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
        d.setEmail(negocioprofe.obtenerProfesor(Integer.parseInt(request.getParameter("txtLegajo"))).getEmail());
       
      	boolean funco = false;
      	if(negocioprofe.spModificarProfesor(d) && negocioprofe.sPModificarUsuario(d.getEmail(),request.getParameter("txtContraseña"))) {
      		funco = true;
      	}
      	request.setAttribute("funco",funco);

	          }
		NegocioimplProfesores negocioprofesores = new NegocioimplProfesores();
		Docente docente = new Docente();
		ArrayList<Docente> docentes = (ArrayList<Docente>) negocioprofesores.readAll();
		
		request.setAttribute("docentes", docentes);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaProfesores.jsp");   
        rd.forward(request, response);
		
	}
}
