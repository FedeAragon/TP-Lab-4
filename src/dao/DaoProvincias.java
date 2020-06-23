package dao;

import java.util.List;
import entidad.Provincias;

public interface DaoProvincias {

	public List<Provincias> readAll();
	public Provincias obtenerProvincia(String id_provincia);
}
