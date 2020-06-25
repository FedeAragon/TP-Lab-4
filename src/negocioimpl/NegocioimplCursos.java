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
	public void spModificarCurso(Cursos curso) {
		daocurso.spModificarCurso(curso);
		
	}

	@Override
	public void spEliminarCurso(Cursos curso) {
		daocurso.spEliminarCurso(curso);
		
	}

}
