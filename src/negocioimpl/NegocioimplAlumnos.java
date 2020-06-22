package negocioimpl;

import java.util.List;

import daoimpl.DaoimplAlumnos;
import entidad.Alumno;
import negocio.NegocioAlumnos;

public class NegocioimplAlumnos implements NegocioAlumnos {

	DaoimplAlumnos daoalumno = new DaoimplAlumnos();
	
	public List <Alumno> readAll()
	{ 
		return daoalumno.readAll();
	}
	
	public void spAgregarAlumno(Alumno alumno)
	{
		daoalumno.spAgregarAlumno(alumno);
	}
	
	public void spModificarAlumno(Alumno alumno) 
	{
		daoalumno.spModificarAlumno(alumno);
	}
	
    public void spEliminarAlumno(Alumno alumno)
    {
    	daoalumno.spEliminarAlumno(alumno);
    }

}
 