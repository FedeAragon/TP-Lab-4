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
	public List ObtenerAños(int inicio , int fin) {
		return daoAlumXCurso.ObtenerAños(inicio , fin);
	}
	public List ObtenerAprobados(int inicio , int fin) {
		return daoAlumXCurso.ObtenerAprobados(inicio , fin);
	}
	public List ObtenerDesaprobados(int inicio , int fin) {
		return daoAlumXCurso.ObtenerDesaprobados(inicio , fin); 
	}
}
