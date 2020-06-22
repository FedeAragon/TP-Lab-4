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
	
}
