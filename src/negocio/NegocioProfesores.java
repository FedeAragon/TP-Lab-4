package negocio;

import java.util.List;
import entidad.Docente;

public interface NegocioProfesores {

	public List<Docente> readAll();
	public boolean spAgregarProfesor(Docente docente);
	public boolean spModificarProfesor(Docente docente);
	public boolean spEliminarProfesor(Docente docente);
	public Docente obtenerProfesor(int leg_profesor);
}
