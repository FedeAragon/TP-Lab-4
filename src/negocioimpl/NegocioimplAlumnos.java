package negocioimpl;

import java.util.List;

import daoimpl.DaoimplAlumnos;
import entidad.Alumno;
import entidad.Cursos;
import entidad.Docente;
import negocio.NegocioAlumnos;

public class NegocioimplAlumnos implements NegocioAlumnos {

	DaoimplAlumnos daoalumno = new DaoimplAlumnos();
	
	public List <Alumno> readAll()
	{ 
		return daoalumno.readAll();
	}
	
	public boolean spAgregarAlumno(Alumno alumno)
	{
		boolean funco = daoalumno.spAgregarAlumno(alumno);
	      return funco;
	}
	
	public boolean spModificarAlumno(Alumno alumno) 
	{
		boolean funco = daoalumno.spModificarAlumno(alumno);
		return funco;
	}
	
    public boolean spEliminarAlumno(Alumno alumno)
    {
    	boolean funco = daoalumno.spEliminarAlumno(alumno);
    	return funco;
    }
    public Alumno obtenerAlumno(int leg_alumno) 
	{
		
		return daoalumno.obtenerAlumno(leg_alumno);
	}
    
    public List<Alumno> AlumnosAgregar(Cursos curso)
    {
		return daoalumno.AlumnosAgregar(curso);
	}
}
 