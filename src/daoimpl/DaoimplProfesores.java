package daoimpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import dao.DaoProfesores;
import entidad.Docente;

public class DaoimplProfesores implements DaoProfesores {
	
	private static final String readall = "SELECT * FROM profesores";

public List<Docente> readAll() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			ArrayList<Docente> docente = new ArrayList<Docente>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readall);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					docente.add(getDocente(resultSet));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();  
			}
			return docente;
			
		}
	
	
	private Docente getDocente(ResultSet resultSet) throws SQLException
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
		
	 	return new Docente(legajo, DNI, nombreyApellido, nacimiento, direccion, codLocalidad, codProvincia, email, telefono, estado);	
	}   
	
	public void spAgregarProfesor(Docente docente)
	{
		Conexion conexion = Conexion.getConexion();
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spAgregarProfesor(?,?,?,?,?,?,?,?) ");
	            proc.setInt("UDNI", docente.getDNI());
	            proc.setString("UNombreApellido", docente.getNombreyAp());
	            proc.setDate("UNacimiento", docente.getFechaNacimiento());
	            proc.setString("UDireccion", docente.getDireccion());
	            proc.setString("UCodLocalidad", docente.getLocalidad());
	            proc.setString("UCodProvincia", docente.getProvincia());
	            proc.setString("UEmail", docente.getEmail());
	            proc.setInt("UTelefono", docente.getTelefono());
	            proc.execute();             
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		
	}
	
	public void spModificarProfesor(Docente docente)
	{ 
		Conexion conexion = Conexion.getConexion();
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spModificarProfesor(?,?,?,?,?,?,?,?,?) ");
	            proc.setInt("ULegajo_p", docente.getLegajo()); 
	            proc.setInt("UDNI_P", docente.getDNI());
	            proc.setString("UNombreApellido", docente.getNombreyAp());
	            proc.setDate("UNacimiento", docente.getFechaNacimiento());
	            proc.setString("UDireccion", docente.getDireccion());
	            proc.setString("UCodLocalidad", docente.getLocalidad());
	            proc.setString("UCodProvincia", docente.getProvincia());
	            proc.setString("UEmail", docente.getEmail());
	            proc.setInt("UTelefono", docente.getTelefono());
	            proc.execute();             
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		
	}
	
	public void spEliminarProfesor(Docente docente)
	{
		Conexion conexion = Conexion.getConexion();
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spEliminarProfesor(?) ");
	            proc.setInt("ULegajo", docente.getLegajo());
	            proc.execute();             
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		
	}
}
