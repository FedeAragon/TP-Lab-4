package negocioimpl;

import java.util.List;

import daoimpl.DaoimplProfesores;
import entidad.Docente;

public class NegocioimplProfesores {

	DaoimplProfesores daoprofesor = new DaoimplProfesores();
	
	public List <Docente> readAll()
	{
		return daoprofesor.readAll();
	}
	
	public void spAgregarProfesor(Docente docente)
	{
	    daoprofesor.spAgregarProfesor(docente);	
	}
	
	public void spModificarProfesor(Docente docente)
	{
	    daoprofesor.spModificarProfesor(docente);	
	}
	
	public void spEliminarProfesor(Docente docente)
	{
	    daoprofesor.spEliminarProfesor(docente);
	}
	
	public Docente obtenerProfesor(int leg_profesor) 
	{
		
		return daoprofesor.obtenerProfesor(leg_profesor);
	}
	
	
}
 