package negocio;

import java.util.List;

import entidad.Materias;

public interface NegocioMaterias {

	public List<Materias> readAll();
	public Materias obtenerMateria(int id_materia);
	
}
 