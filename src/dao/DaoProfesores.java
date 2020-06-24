package dao;

import java.util.List;

import entidad.Docente;

public interface DaoProfesores {
 
	public List<Docente> readAll();
	public void spAgregarProfesor(Docente docente);
	public void spModificarProfesor(Docente docente);
	public void spEliminarProfesor(Docente docente);
	public Docente obtenerProfesor(int leg_profesor);
}
