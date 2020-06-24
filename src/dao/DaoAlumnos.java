package dao;

import java.util.List;
import entidad.Alumno;

public interface DaoAlumnos {

	public List<Alumno> readAll();
	public void spAgregarAlumno(Alumno alumno);
	public void spModificarAlumno(Alumno alumno);
	public void spEliminarAlumno(Alumno alumno); 
	public Alumno obtenerAlumno(int leg_alumno);
}
