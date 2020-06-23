package daoimpl;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import dao.DaoAlumnos;
import entidad.Alumno;
import entidad.Localidades;
import entidad.Provincias;



public class DaoimplAlumnos implements DaoAlumnos{

	private static final String readall = "SELECT * FROM alumnos";
	
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
        
        Localidades loca =  daoimplocalidades.obtenerLocalidad(codLocalidad);
        DaoimplProvincias daoimplprov = new DaoimplProvincias();
        Provincias prov = daoimplprov.obtenerProvincia(codProvincia);
		
	 	return new Alumno(legajo, DNI, nombreyApellido, nacimiento, direccion, loca,prov , email, telefono, estado);	
	}  
	
	public void spAgregarAlumno(Alumno alumno)
	{
		Conexion conexion = Conexion.getConexion();
		
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
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		
	}
		
	public void spModificarAlumno(Alumno alumno)
	{
		Conexion conexion = Conexion.getConexion();
		
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
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		
	}
	
	public void spEliminarAlumno(Alumno alumno)
	{
		Conexion conexion = Conexion.getConexion();
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spEliminarAlumno(?) ");
	            proc.setInt("ULegajo", alumno.getLegajo());
	            proc.execute();             
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		
	}
	
}
