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
	public List<AlumnosXCursos> readAll(){
		return daoAlumXCurso.readAll();
	}
	public List ObtenerA�os() {
		return daoAlumXCurso.ObtenerA�os();
	}
	public List ObtenerAprobados() {
		return daoAlumXCurso.ObtenerAprobados();
	}
	public List ObtenerDesaprobados() {
		return daoAlumXCurso.ObtenerDesaprobados();
	}
}
