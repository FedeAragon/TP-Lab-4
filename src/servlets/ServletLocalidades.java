package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Localidades;
import negocioimpl.NegocioimplLocalidades;


@WebServlet("/ServletLocalidades")
public class ServletLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletLocalidades() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
				
					if(request.getParameter("provincia")!=null) {
					
						String idProv = (String)request.getParameter("provincia");
						
						NegocioimplLocalidades negLoc = new NegocioimplLocalidades();
						List<Localidades> localidades = negLoc.LocalidadesXProv(idProv);
						
					for(Localidades loc : localidades) {
						out.println("<option value=" + loc.getCodLocalidad() + " >" + loc.getNombreLocalidad() + "</option>" );
					}
			}
		}
	}

}
