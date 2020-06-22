package negocioimpl;

import java.util.List;

import daoimpl.DaoimplProvincias;
import entidad.Provincias;
import negocio.NegocioProvincias;

public class NegocioimplProvincias implements NegocioProvincias{

	DaoimplProvincias daoprovincia = new DaoimplProvincias();
	
	public List<Provincias> readAll() 
	{
		return daoprovincia.readAll();
	}
}
