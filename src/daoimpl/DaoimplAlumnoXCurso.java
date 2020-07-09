package daoimpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoAlumnoXCurso;
import entidad.Alumno;
import entidad.AlumnosXCursos;
import entidad.Cursos;

public class DaoimplAlumnoXCurso implements DaoAlumnoXCurso {
	
	private static final String AlumnosDelCurso = "SELECT Legajo_a, PrimerParcial_axc,SegundoParcial_axc,Recuperatorio1_axc,Recuperatorio2_axc , SituacionAlumno_axc FROM bdtpintegrador.alumnosxcurso inner join alumnos on Legajo_a=LegajoAlumno_axc where Estado_axc=1 and CodCurso_axc=?;";
	private static final String readall = "SELECT * FROM alumnosxcurso where Estado_axc = 1; ";
	private static final String AprobDesaprXaño="SELECT Año_c, \r\n" + 
			"sum(case when SituacionAlumno_axc = 'Regular' then 1 else 0 end) AS Aprobados,\r\n" + 
			"sum(case when SituacionAlumno_axc = 'Libre' then 1 else 0 end) AS Desaprobados\r\n" + 
			"FROM alumnosxcurso INNER JOIN cursos ON CodCurso_c = CodCurso_axc \r\n" + 
			"WHERE Año_c >= ? AND Año_c <= ? GROUP BY Año_c";
	
	public List ObtenerAños(int inicio , int fin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList años = new ArrayList();
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(AprobDesaprXaño);
			statement.setInt(1, inicio);
			statement.setInt(2, fin); 
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				años.add(resultSet.getInt(1));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace(); 
		}
		return años;
	}
	
	public List ObtenerAprobados(int inicio , int fin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList Aprobados = new ArrayList();
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(AprobDesaprXaño);
			statement.setInt(1, inicio);
			statement.setInt(2, fin); 
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Aprobados.add(resultSet.getInt(2));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace(); 
		}
		return Aprobados;
	}
	
	public List ObtenerDesaprobados(int inicio , int fin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList Desaprobados = new ArrayList();
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(AprobDesaprXaño);
			statement.setInt(1, inicio);
			statement.setInt(2, fin); 
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Desaprobados.add(resultSet.getInt(3));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace(); 
		}
		return Desaprobados;
	}
	
	public List<AlumnosXCursos> readAll() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			ArrayList<AlumnosXCursos> aluxcur = new ArrayList<AlumnosXCursos>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readall);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					aluxcur.add(getAlumnoXCurso(resultSet));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			return aluxcur;
			
		}
	
	@Override
	public List<AlumnosXCursos> AlumnosdelCurso(Cursos curso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
			ArrayList<AlumnosXCursos> alumsXCursos = new ArrayList<AlumnosXCursos>();
			PreparedStatement statement;
		    ResultSet resultSet; 
		    Conexion conexion = Conexion.getConexion();
		    try{
				
				statement = conexion.getSQLConexion().prepareStatement(AlumnosDelCurso);
				statement.setInt(1,curso.getCodCurso());
				
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{ 
					alumsXCursos.add(getAlumnoXCurso(resultSet, curso));
				}

			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
		return alumsXCursos;
	}
	
	private AlumnosXCursos getAlumnoXCurso(ResultSet resultSet,Cursos curso) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DaoimplAlumnos daoAlum = new DaoimplAlumnos();
		AlumnosXCursos alumXCurso = new AlumnosXCursos();
		
		alumXCurso.setAlumno(daoAlum.obtenerAlumno(resultSet.getInt(1)));
		alumXCurso.setCurso(curso);
		alumXCurso.setPrimerParcial(resultSet.getInt(2));
		alumXCurso.setSegundoParcial(resultSet.getInt(3));
		alumXCurso.setRecuperatorio1(resultSet.getInt(4));
		alumXCurso.setRecuperatorio2(resultSet.getInt(5));
		alumXCurso.setSituacion(resultSet.getString(6));

	 	return alumXCurso;	
	}  
	
	private AlumnosXCursos getAlumnoXCurso(ResultSet resultSet) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DaoimplAlumnos daoAlum = new DaoimplAlumnos();
		DaoimplCursos daoCurso = new DaoimplCursos();
		AlumnosXCursos alumXCurso = new AlumnosXCursos();
		
		alumXCurso.setAlumno(daoAlum.obtenerAlumno(resultSet.getInt(1)));
		alumXCurso.setCurso(daoCurso.saberCurso(resultSet.getInt(2)));
		alumXCurso.setPrimerParcial(resultSet.getInt(3));
		alumXCurso.setSegundoParcial(resultSet.getInt(4));
		alumXCurso.setRecuperatorio1(resultSet.getInt(5));
		alumXCurso.setRecuperatorio2(resultSet.getInt(6));
		alumXCurso.setSituacion(resultSet.getString(8));

	 	return alumXCurso;	
	}  
	
	@Override
	public boolean spAgregarAlumnoXCurso(AlumnosXCursos alumXCurso) {
		
		Conexion conexion = Conexion.getConexion();
		boolean funco = false;
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" call spAgregarAlumnoxCurso(?,?) ");
	            proc.setInt(1, alumXCurso.getCurso().getCodCurso());
	            proc.setInt(2, alumXCurso.getAlumno().getLegajo());
	            proc.execute();  
	            
	            funco = true;
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		return funco;
	}
	
public boolean spAgregarNotas(AlumnosXCursos alumXCurso) {
		
		Conexion conexion = Conexion.getConexion();
		boolean funco = false;
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" call spAgregarNotas(?,?,?,?,?,?,?) ");
	            proc.setInt(1, alumXCurso.getCurso().getCodCurso());
	            proc.setInt(2, alumXCurso.getAlumno().getLegajo());
	            proc.setInt(3, alumXCurso.getPrimerParcial());
	            proc.setInt(4, alumXCurso.getSegundoParcial());
	            proc.setInt(5, alumXCurso.getRecuperatorio1());
	            proc.setInt(6, alumXCurso.getRecuperatorio2());
	            proc.setString(7, alumXCurso.getSituacion());
	            proc.execute();  
	            
	            funco = true;
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		return funco;
	}

@Override
public boolean spEliminarAlumnoXCurso(int CodCurso,int Legajo) {
	
	Conexion conexion = Conexion.getConexion();
	boolean funco = false;
	
	try {    	    
            CallableStatement proc = conexion.getSQLConexion().prepareCall(" call spEliminarAlumnoXCurso(?,?) ");
            proc.setInt(1, Legajo);
            proc.setInt(2, CodCurso);
            proc.execute();  
            
            funco = true;
        } 
       catch (Exception e) {                  
            System.out.println(e);
       }
	return funco;
}
	
}
