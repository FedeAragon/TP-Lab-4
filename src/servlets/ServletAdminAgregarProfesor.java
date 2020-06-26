package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Docente;
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
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean funco = false;
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
      	 funco = negocioprofe.spAgregarProfesor(d);
	          }
		request.setAttribute("funco", funco);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminAgregarProfesor.jsp");   
        rd.forward(request, response);
        
	}
}
