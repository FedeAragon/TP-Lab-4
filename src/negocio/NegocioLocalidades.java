package negocio;

import java.util.List;

import entidad.Localidades;

public interface NegocioLocalidades {

	public List<Localidades> readAll();
	public List<Localidades> LocalidadesXProv(String codProvincia);
}
