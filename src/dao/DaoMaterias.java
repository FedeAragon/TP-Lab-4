package dao;

import java.util.List;

import entidad.Materias;

public interface DaoMaterias {

	public List<Materias> readAll();
	public Materias obtenerMateria(int id_materia);
	
}
