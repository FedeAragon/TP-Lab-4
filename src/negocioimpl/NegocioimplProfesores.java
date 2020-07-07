package negocioimpl;

import java.util.List;

import daoimpl.DaoimplProfesores;
import entidad.Docente;
import negocio.NegocioProfesores;

public class NegocioimplProfesores implements NegocioProfesores {

	DaoimplProfesores daoprofesor = new DaoimplProfesores();
	
	public List <Docente> readAll()
	{
		return daoprofesor.readAll();
	}
	
	public boolean spAgregarProfesor(Docente docente)
	{
		boolean funco = daoprofesor.spAgregarProfesor(docente);	
		return funco ;
	}
	
	public boolean spModificarProfesor(Docente docente)
	{
		boolean funco =  daoprofesor.spModificarProfesor(docente);	
		return funco ;
	}
	
	public boolean spEliminarProfesor(Docente docente)
	{
		boolean funco = daoprofesor.spEliminarProfesor(docente);
		return funco ;
	}
	
	public Docente obtenerProfesor(int leg_profesor) 
	{
		
		return daoprofesor.obtenerProfesor(leg_profesor);
	}
	
	public int obtenerLegProfesor()
	{
		return daoprofesor.obtenerLegProfesor();
	}
	
	public boolean sPModificarUsuario(String Email,String contraseñanueva)
    {
		return daoprofesor.sPModificarUsuario(Email, contraseñanueva);
	}
	
	public boolean comprobarEmail(String email)
	{
		return daoprofesor.comprobarEmail(email);
	}
	
}
 