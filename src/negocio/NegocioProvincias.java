package negocio;

import java.util.List;

import entidad.Provincias;

public interface NegocioProvincias {

	public List<Provincias> readAll();
	public Provincias obtenerProvincia(String id_provincia);
	
}
