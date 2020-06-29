package servlets;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import entidad.Docente;
import entidad.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		request.getSession().removeAttribute("usuario");
		request.getSession().removeAttribute("profesor");
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
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
				String password = request.getParameter("passContra").toString();
				
				if( negociousuario.ComprobarUsuario (nombreU, password) == 1)  
				{
					NegocioimplUsuarios negUser = new NegocioimplUsuarios();
					Docente prof = new Docente();
					
					if(negociousuario.TipoCuenta(nombreU)) {
						Usuario usuario = new Usuario(1, nombreU,Integer.parseInt(password), 1);
						request.getSession().setAttribute("usuario", usuario);
						prof = negUser.getDocente(usuario);
						request.getSession().setAttribute("profesor", prof);
						RequestDispatcher rd = request.getRequestDispatcher("/AdminReportes.jsp");   
		                rd.forward(request, response);
					}else {
						Usuario usuario = new Usuario(0, nombreU,Integer.parseInt(password), 1);
						request.getSession().setAttribute("usuario", usuario);
						prof = negUser.getDocente(usuario);
						request.getSession().setAttribute("profesor", prof);
						RequestDispatcher rd = request.getRequestDispatcher("/ServletProfesoresTablaCursos");   
		                rd.forward(request, response);
					}	
					
				}
				else{
					boolean error = true;
					request.setAttribute("error", error);
				    RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");   
			        rd.forward(request, response);
				}
			}
				
			
		}
		
	}

}
