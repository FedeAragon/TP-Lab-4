package daoimpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.List;

import dao.DaoAlumnos;
import entidad.Alumno;
import entidad.Cursos;
import entidad.Docente;
import entidad.Localidades;
import entidad.Provincias;



public class DaoimplAlumnos implements DaoAlumnos{

	private static final String readall = "SELECT * FROM alumnos where Estado_a=true";
	private static final String obteneralumno ="SELECT * FROM alumnos WHERE legajo_a = ?";
	private static final String obtenerLegAlumno = "SELECT MAX(Legajo_a) from alumnos";
	
public int obtenerLegAlumno() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			Conexion conexion = Conexion.getConexion();
			int Legajo = 0;
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(obtenerLegAlumno);
				resultSet = statement.executeQuery();
				if(resultSet.next())
				{
					Legajo = resultSet.getInt(1);
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();  
			}
			return Legajo;
			
		}
	
	
	
	public List<Alumno> readAll() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			ArrayList<Alumno> alumno = new ArrayList<Alumno>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readall);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					alumno.add(getAlumno(resultSet));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			return alumno;
			
		}
	
	private Alumno getAlumno(ResultSet resultSet) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		int legajo = resultSet.getInt(1);
		int DNI = resultSet.getInt(2);
		String nombreyApellido = resultSet.getString(3);
		Date nacimiento = resultSet.getDate(4);
		String direccion = resultSet.getString(5);
		String codLocalidad = resultSet.getString(6);
		String codProvincia = resultSet.getString(7);
		String email = resultSet.getString(8);
	 	int telefono = resultSet.getInt(9);
		int estado = resultSet.getInt(10);
		
		DaoimplLocalidades daoimplocalidades = new DaoimplLocalidades();
		Localidades loca = new Localidades();
         if (daoimplocalidades.obtenerLocalidad(codLocalidad) != null) {
        
        	  loca =  daoimplocalidades.obtenerLocalidad(codLocalidad);
         }
        DaoimplProvincias daoimplprov = new DaoimplProvincias();
        Provincias prov = new Provincias();
         if(daoimplprov.obtenerProvincia(codProvincia) != null) {
        prov = daoimplprov.obtenerProvincia(codProvincia);
         }
		
	 	return new Alumno(legajo, DNI, nombreyApellido, nacimiento, direccion, loca,prov , email, telefono, estado);	
	}  
	
	public boolean spAgregarAlumno(Alumno alumno)
	{
		Conexion conexion = Conexion.getConexion();
		boolean funco = false;
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spAgregarAlumno(?,?,?,?,?,?,?,?) ");
	            proc.setInt("UDNI", alumno.getDNI());
	            proc.setString("UNombreApellido", alumno.getNombreyAp());
	            proc.setDate("UNacimiento", alumno.getFechaNacimiento());
	            proc.setString("UDireccion", alumno.getDireccion());
	            proc.setString("UCodLocalidad", alumno.getLocalidad().getCodLocalidad());
	            proc.setString("UCodProvincia", alumno.getProvincia().getCodProvincia());
	            proc.setString("UEmail", alumno.getEmail());
	            proc.setInt("UTelefono", alumno.getTelefono());
	            proc.execute();  
	            
	          funco = true;
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		return funco;
	}
		
	public boolean spModificarAlumno(Alumno alumno)
	{
		Conexion conexion = Conexion.getConexion();
		 boolean funco = false;
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spModificarAlumno(?,?,?,?,?,?,?,?,?) ");
	            proc.setInt("ULegajo_a", alumno.getLegajo()); 
	            proc.setInt("UDNI_a", alumno.getDNI());
	            proc.setString("UNombreApellido_a", alumno.getNombreyAp());
	            proc.setDate("UNacimiento_a", alumno.getFechaNacimiento());
	            proc.setString("UDireccion_a", alumno.getDireccion());
	            proc.setString("UCodLocalidad_a", alumno.getLocalidad().getCodLocalidad());
	            proc.setString("UCodProvincia_a", alumno.getProvincia().getCodProvincia());
	            proc.setString("UEmail_a", alumno.getEmail());
	            proc.setInt("UTelefono_a", alumno.getTelefono());
	            proc.execute(); 
	            funco = true;
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		return funco;
	}
	
	public boolean spEliminarAlumno(Alumno alumno)
	{
		Conexion conexion = Conexion.getConexion();
		 boolean funco = false;
		 
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spEliminarAlumno(?) ");
	            proc.setInt(1, alumno.getLegajo());
	            proc.execute();   
	            funco = true;
	        } 
		
	       catch (Exception e) {                  
	            System.out.println(e);
	       } 
		return funco;
	}
	
	public Alumno obtenerAlumno(int leg_alumno) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			Alumno alumno= new Alumno();
			DaoimplLocalidades daoloc= new DaoimplLocalidades();
			DaoimplProvincias daoprov= new DaoimplProvincias();
			
		 	PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		   try{
				
				statement = conexion.getSQLConexion().prepareStatement(obteneralumno);
				statement.setInt(1,leg_alumno);
				
				resultSet = statement.executeQuery();
				if(resultSet.next())
				{ 
					alumno.setLegajo(resultSet.getInt(1));
					alumno.setDNI(resultSet.getInt(2));
					alumno.setNombreyAp(resultSet.getString(3));
					alumno.setFechaNacimiento(resultSet.getDate(4));
					alumno.setDireccion(resultSet.getString(5));
					alumno.setLocalidad(daoloc.obtenerLocalidad(resultSet.getString(6)));
					alumno.setProvincia(daoprov.obtenerProvincia(resultSet.getString(7)));
					alumno.setEmail(resultSet.getString(8));
					alumno.setTelefono(resultSet.getInt(9));
					alumno.setEstado(resultSet.getInt(10));
					return alumno;
				}

			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
		
		  
		return null;
	}
	
	private static final String AlumnosAgregar = "SELECT * FROM alumnos where not exists(select * from alumnosxcurso where CodCurso_axc=? and LegajoAlumno_axc = Legajo_a) and Estado_a=1;";
	
	@Override
	public List<Alumno> AlumnosAgregar(Cursos curso) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			ArrayList<Alumno> alumno = new ArrayList<Alumno>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(AlumnosAgregar);
				statement.setInt(1, curso.getCodCurso());
				
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					alumno.add(getAlumno(resultSet));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			return alumno;
	}
	
}
