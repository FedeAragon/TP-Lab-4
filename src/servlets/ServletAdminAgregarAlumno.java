package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.swing.plaf.synth.SynthSeparatorUI;

import entidad.Alumno;
import entidad.Localidades;
import entidad.Provincias;
import negocioimpl.NegocioimplAlumnos;
import negocioimpl.NegocioimplLocalidades;
import negocioimpl.NegocioimplProvincias;

/**
 * Servlet implementation class ServletAdminAgregarAlumno
 */
@WebServlet("/ServletAdminAgregarAlumno")
public class ServletAdminAgregarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAdminAgregarAlumno() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NegocioimplAlumnos negalu = new NegocioimplAlumnos();
		NegocioimplProvincias negProv = new NegocioimplProvincias();
		
		int ultlegajo = negalu.obtenerLegAlumno() + 1;
		List<Provincias> provincias =  negProv.readAll();
		
		request.setAttribute("ultLegajo", ultlegajo);
		request.setAttribute("provincias", provincias);
		

 	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String todaysdate = dateFormat.format(date);
        request.setAttribute("today", todaysdate);
		
		RequestDispatcher rd = request.getRequestDispatcher("/AdminAgregarAlumno.jsp");   
 	    rd.forward(request, response);
 	    
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean funco=false;
       	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date fecha = cal.getTime();
        String todaysdate = dateFormat.format(fecha);
        
        request.setAttribute("today", todaysdate);
		if(request.getParameter("btnAgregar")!=null)
	         {
			  NegocioimplAlumnos negocioalu = new NegocioimplAlumnos();
	       	  NegocioimplLocalidades negocioloca = new NegocioimplLocalidades();
	       	  NegocioimplProvincias negocioprov = new NegocioimplProvincias();
	       	  Alumno alu = new Alumno();
	       	  
	       	  	java.util.Date date = null;
	       	try {
				 date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DateNacimiento"));
					
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
         	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	        alu.setLegajo(0);
	        alu.setEstado(1);
	        alu.setDNI(Integer.parseInt(request.getParameter("txtDNI")));
	        alu.setDireccion(request.getParameter("txtDireccion").toString());
	        alu.setLocalidad(negocioloca.obtenerLocalidad(request.getParameter("ddlLocalidades").toString()));
	        alu.setProvincia(negocioprov.obtenerProvincia(request.getParameter("provincia").toString()));
	        alu.setFechaNacimiento(sqlDate);
	       	alu.setNombreyAp(request.getParameter("txtNombre").toString());
	        alu.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
	       	alu.setEmail(request.getParameter("txtEmail").toString());
	        funco = negocioalu.spAgregarAlumno(alu);
	       	 
	        int ultlegajo = negocioalu.obtenerLegAlumno() + 1;
			List<Provincias> provincias =  negocioprov.readAll();
			
			request.setAttribute("ultLegajo", ultlegajo);
			request.setAttribute("provincias", provincias);
	 		request.setAttribute("funco", funco);	
			RequestDispatcher rd = request.getRequestDispatcher("/AdminAgregarAlumno.jsp");   
	 	    rd.forward(request, response);
   	          }
		else
		{
			doGet(request, response);
		}

	         
		}

}
