package negocio;

import java.util.List;

import entidad.AlumnosXCursos;
import entidad.Cursos;

public interface NegocioAlumnoXCurso {
	public List<AlumnosXCursos> AlumnosdelCurso(Cursos curso);
	public boolean spAgregarAlumnoXCurso(AlumnosXCursos alumXCurso);
	public boolean spAgregarNotas(AlumnosXCursos alumXCurso);
}
