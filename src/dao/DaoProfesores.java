package dao;

import java.util.List;

import entidad.Docente;

public interface DaoProfesores {
 
	public List<Docente> readAll();
	public boolean spAgregarProfesor(Docente docente);
	public boolean spModificarProfesor(Docente docente);
	public boolean spEliminarProfesor(Docente docente);
	public Docente obtenerProfesor(int leg_profesor);
}
