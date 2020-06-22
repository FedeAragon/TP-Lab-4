package negocio;

import java.util.List;
import entidad.Docente;

public interface NegocioProfesores {

	public List<Docente> readAll();
	public void spAgregarProfesor(Docente docente);
	public void spModificarProfesor(Docente docente);
	public void spEliminarProfesor(Docente docente);
}
