package dao;

import java.util.List;

import entidad.Alumno;
import entidad.AlumnosXCursos;
import entidad.Cursos;

public interface DaoAlumnoXCurso {
	
	public List<AlumnosXCursos> AlumnosdelCurso(Cursos curso);
	public boolean spAgregarAlumnoXCurso(AlumnosXCursos alumXCurso);
	public boolean spAgregarNotas(AlumnosXCursos alumXCurso);
	public List<AlumnosXCursos> readAll();
	public List ObtenerAños(int inicio ,int fin);
	public List ObtenerAprobados(int inicio , int fin);
	public List ObtenerDesaprobados(int inicio , int fin);
	public boolean spEliminarAlumnoXCurso(int CodCurso,int Legajo);
}
