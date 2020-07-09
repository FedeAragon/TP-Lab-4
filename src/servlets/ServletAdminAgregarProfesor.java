package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Docente;
import entidad.Provincias;
import negocioimpl.NegocioimplAlumnos;
import negocioimpl.NegocioimplLocalidades;
import negocioimpl.NegocioimplProfesores;
import negocioimpl.NegocioimplProvincias;

/**
 * Servlet implementation class ServletAdminAgregarProfesor
 */
@WebServlet("/ServletAdminAgregarProfesor")
public class ServletAdminAgregarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletAdminAgregarProfesor() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		NegocioimplProfesores negprofes = new NegocioimplProfesores();
		NegocioimplProvincias negProv = new NegocioimplProvincias();
		
		int ultlegajo = negprofes.obtenerLegProfesor() + 1;
		List<Provincias> provincias =  negProv.readAll();
		
		request.setAttribute("provincias", provincias); 
		request.setAttribute("ultlegajo", ultlegajo);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String todaysdate = dateFormat.format(date);
        request.setAttribute("today", todaysdate);
		
		RequestDispatcher rd = request.getRequestDispatcher("/AdminAgregarProfesor.jsp");   
        rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean funco = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date fecha = cal.getTime();
        String todaysdate = dateFormat.format(fecha);
        request.setAttribute("today", todaysdate);
		if(request.getParameter("btnAgregar")!=null)
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
       d.setLegajo(0);
       d.setEstado(1);
       d.setDNI(Integer.parseInt(request.getParameter("txtDNI")));
       d.setDireccion(request.getParameter("txtDireccion").toString());
       d.setLocalidad(negocioloca.obtenerLocalidad(request.getParameter("ddlLocalidades").toString()));
       d.setProvincia(negocioprov.obtenerProvincia(request.getParameter("provincia").toString()));
       d.setFechaNacimiento(sqlDate);
       d.setNombreyAp(request.getParameter("txtNombre").toString());
       d.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
       d.setEmail(request.getParameter("txtEmail").toString());
      
       if(negocioprofe.comprobarEmail(request.getParameter("txtEmail").toString()))
       {
    	  int repetido = 1;  
       	  request.setAttribute("repetido", repetido);
       }
       else 
       {
    	 funco = negocioprofe.spAgregarProfesor(d); 
       }    
      
		List<Provincias> provincias =  negocioprov.readAll();
 	    int ultlegajo = negocioprofe.obtenerLegProfesor() + 1;
 	    
 	    request.setAttribute("provincias", provincias); 
        request.setAttribute("ultlegajo", ultlegajo);
        request.setAttribute("doc", d); 
      	request.setAttribute("funco", funco);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminAgregarProfesor.jsp");   
        rd.forward(request, response);
	          }		
		else 
		{
			doGet(request, response);
		}
	}
}
