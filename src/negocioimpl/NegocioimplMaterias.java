package negocioimpl;

import java.util.List;

import daoimpl.DaoimplMaterias;
import entidad.Materias;
import negocio.NegocioMaterias;

public class NegocioimplMaterias implements NegocioMaterias{

	DaoimplMaterias daomateria = new DaoimplMaterias();
	
	public List<Materias> readAll()
	{
		return daomateria.readAll();
	}
	
	public Materias obtenerMateria(int id_materia)
	{
		return daomateria.obtenerMateria(id_materia);
	}
}
