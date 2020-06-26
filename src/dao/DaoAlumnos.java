package dao;

import java.util.List;
import entidad.Alumno;

public interface DaoAlumnos {

	public List<Alumno> readAll();
	public boolean spAgregarAlumno(Alumno alumno);
	public boolean spModificarAlumno(Alumno alumno);
	public boolean spEliminarAlumno(Alumno alumno); 
	public Alumno obtenerAlumno(int leg_alumno);
}
