package negocio;

import java.util.List;
import entidad.Alumno;
import entidad.Docente;

public interface NegocioAlumnos {
	
    public List<Alumno> readAll();
    public void spAgregarAlumno(Alumno alumno);	
    public void spModificarAlumno(Alumno alumno);
    public void spEliminarAlumno(Alumno alumno);
    public Alumno obtenerAlumno(int leg_alumno);

}
