package negocioimpl;

import java.util.List;

import daoimpl.DaoimplCursos;
import entidad.Cursos;
import negocio.NegocioCursos;

public class NegocioimplCursos implements NegocioCursos {
	DaoimplCursos daocurso = new DaoimplCursos();
	@Override
	public List<Cursos> readAll() {
		
		return daocurso.readAll();
	}

	@Override
	public boolean spAgregarCurso(Cursos curso) {
		 boolean anduvo=daocurso.spAgregarCurso(curso);
		return anduvo; 
		
	}

	@Override
	public boolean spModificarCurso(Cursos curso) {
		boolean funco =daocurso.spModificarCurso(curso);
		return funco;
	}

	@Override
	public boolean spEliminarCurso(Cursos curso) {
		boolean funco = daocurso.spEliminarCurso(curso);
		return funco;
	}
     public List<Cursos> CursosProfe(int Legajo_p) {
		
		return daocurso.CursosProfe(Legajo_p);
	}
 	public int ObtenerCodCurso() {
 		return daocurso.ObtenerCodCurso();
 	}
 	
 	public boolean obtenerCurso(Cursos curso)
 	{
 		return daocurso.obtenerCurso(curso);
 	}
 	public Cursos saberCurso(int CodCurso) {
 		return daocurso.saberCurso(CodCurso);
 	}
}
