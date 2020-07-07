package negocio;

import java.util.List;

import entidad.AlumnosXCursos;
import entidad.Cursos;

public interface NegocioAlumnoXCurso {
	public List<AlumnosXCursos> AlumnosdelCurso(Cursos curso);
	public boolean spAgregarAlumnoXCurso(AlumnosXCursos alumXCurso);
	public boolean spAgregarNotas(AlumnosXCursos alumXCurso);
	public List<AlumnosXCursos> readAll();
	public List ObtenerAños();
	public List ObtenerAprobados();
	public List ObtenerDesaprobados();
}
