package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoimpl.DaoimplUsuarios;
import negocioimpl.NegocioimplUsuarios;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		if(request.getParameter("btnIngresar")!=null)
		{   
			NegocioimplUsuarios negociousuario = new NegocioimplUsuarios();
			if(request.getParameter("txtUsuario") != null &&
			   request.getParameter("passContra") != null)
			{ 	
				String nombreU = request.getParameter("txtUsuario").toString();
				Float password = Float.parseFloat( request.getParameter("passContra"));
				
				if( negociousuario.ComprobarUsuario (nombreU, password) == 1)  
				{
					RequestDispatcher rd = request.getRequestDispatcher("/AdminAgregarProfesor.jsp");   
			                rd.forward(request, response);
				}
				else{
					String cartel = "Los datos de usuario son invalidos";
					request.setAttribute("Cartel", cartel);
				    	RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");   
			                rd.forward(request, response);
					
				}
			}
				
			
		}
		
	}

}
