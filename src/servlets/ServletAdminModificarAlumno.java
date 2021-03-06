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

import entidad.Alumno;
import entidad.Docente;
import entidad.Provincias;
import negocioimpl.NegocioimplAlumnos;
import negocioimpl.NegocioimplLocalidades;
import negocioimpl.NegocioimplProfesores;
import negocioimpl.NegocioimplProvincias;

/**
 * Servlet implementation class ServletAdminModificarAlumno
 */
@WebServlet("/ServletAdminModificarAlumno")
public class ServletAdminModificarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletAdminModificarAlumno() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NegocioimplAlumnos negocioalumno = new NegocioimplAlumnos();
		Alumno alumno = new Alumno();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String todaysdate = dateFormat.format(date);
        request.setAttribute("today", todaysdate);
		if(request.getParameter("btnModificar")!=null)
		{   
			NegocioimplProvincias negProv = new NegocioimplProvincias();
			List<Provincias> provincias =  negProv.readAll();
			
			if(request.getParameter("LegajoAlu") != null) {
				
			  alumno = negocioalumno.obtenerAlumno(Integer.parseInt(request.getParameter("LegajoAlu")));
			}
			request.setAttribute("provincias", provincias); 
			request.setAttribute("alumno", alumno);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarAlumno.jsp");   
	        rd.forward(request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnModificar")!=null)
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
       
    	alu.setLegajo(Integer.parseInt(request.getParameter("txtLegajo")));
       alu.setDNI(Integer.parseInt(request.getParameter("txtDNI")));
       alu.setDireccion(request.getParameter("txtDireccion").toString());
       alu.setLocalidad(negocioloca.obtenerLocalidad(request.getParameter("ddlLocalidades").toString()));
       alu.setProvincia(negocioprov.obtenerProvincia(request.getParameter("provincia").toString()));
       alu.setFechaNacimiento(sqlDate);
      	alu.setNombreyAp(request.getParameter("txtNombre").toString());
       alu.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
      	alu.setEmail(request.getParameter("txtEmail").toString());
        
      	alu.setEstado(1);
      	boolean funco = false;
      	funco = negocioalu.spModificarAlumno(alu);
      	request.setAttribute("funco", funco);
	          
        }

		NegocioimplAlumnos negAlu = new NegocioimplAlumnos();
		ArrayList<Alumno> alumnos = (ArrayList<Alumno>) negAlu.readAll();
		request.setAttribute("alumnos", alumnos);
	
		RequestDispatcher rd = request.getRequestDispatcher("/AdminTablaAlumnos.jsp");   
        rd.forward(request, response);
		}
}
