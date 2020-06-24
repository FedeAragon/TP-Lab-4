package dao;

import java.util.List;
import entidad.Localidades;

public interface DaoLocalidades {

	public List<Localidades> readAll();
	
	public Localidades obtenerLocalidad(String id_localidad);
	public List<Localidades> LocalidadesXProv(String codProvincia);
}
