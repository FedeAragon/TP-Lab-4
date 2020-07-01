package negocioimpl;

import java.util.List;

import daoimpl.DaoimplAlumnoXCurso;
import entidad.AlumnosXCursos;
import entidad.Cursos;
import negocio.NegocioAlumnoXCurso;

public class NegocioimplAlumnoXCurso implements NegocioAlumnoXCurso {

	DaoimplAlumnoXCurso daoAlumXCurso = new DaoimplAlumnoXCurso();
	
	@Override
	public List<AlumnosXCursos> AlumnosdelCurso(Cursos curso) {
		return daoAlumXCurso.AlumnosdelCurso(curso);
	}

	@Override
	public boolean spAgregarAlumnoXCurso(AlumnosXCursos alumXCurso) {
		return daoAlumXCurso.spAgregarAlumnoXCurso(alumXCurso);
	}
	@Override
	public boolean spAgregarNotas(AlumnosXCursos alumXCurso) {
        return daoAlumXCurso.spAgregarNotas(alumXCurso);
	}

}
