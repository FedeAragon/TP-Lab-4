package negocioimpl;

import java.util.List;

import daoimpl.DaoimplLocalidades;
import entidad.Localidades;
import negocio.NegocioLocalidades;

public class NegocioimplLocalidades implements NegocioLocalidades{

	DaoimplLocalidades daolocalidad = new DaoimplLocalidades();
	
	public List<Localidades> readAll()
	{
		return daolocalidad.readAll();
	}
	
	public List<Localidades> LocalidadesXProv(String codProvincia){
		return daolocalidad.LocalidadesXProv(codProvincia);
	}
	
	public Localidades obtenerLocalidad(String id_localidad) {
		return daolocalidad.obtenerLocalidad(id_localidad);
	}
}
