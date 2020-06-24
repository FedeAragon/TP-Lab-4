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
import entidad.Localidades;
import entidad.Provincias;

public class DaoimplProfesores implements DaoProfesores {
	
	private static final String readall = "Select * from profesores inner join usuarios on usuarios.Usuario= profesores.Email_p where Estado_p= true and TipoCuenta = false; ";
	private static final String obtenerprofesor ="Select * from profesores where legajo_p = ?";
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
         
	 	return new Docente(legajo, DNI, nombreyApellido, nacimiento, direccion, loca, prov, email, telefono, estado);	
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
	            proc.setString("UCodLocalidad", docente.getLocalidad().getCodLocalidad());
	            proc.setString("UCodProvincia", docente.getProvincia().getCodProvincia());
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
	            proc.setString("UCodLocalidad", docente.getLocalidad().getCodLocalidad());
	            proc.setString("UCodProvincia", docente.getProvincia().getCodProvincia());
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


	@Override
	public Docente obtenerProfesor(int leg_profesor) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			Docente doc= new Docente();
			DaoimplLocalidades daoloc= new DaoimplLocalidades();
			DaoimplProvincias daoprov= new DaoimplProvincias();
			
		 	PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		   try{
				
				statement = conexion.getSQLConexion().prepareStatement(obtenerprofesor);
				statement.setInt(1,leg_profesor);
				
				resultSet = statement.executeQuery();
				if(resultSet.next())
				{ 
					doc.setLegajo(resultSet.getInt(1));
					doc.setDNI(resultSet.getInt(2));
					doc.setNombreyAp(resultSet.getString(3));
					doc.setFechaNacimiento(resultSet.getDate(4));
					doc.setDireccion(resultSet.getString(5));
					doc.setLocalidad(daoloc.obtenerLocalidad(resultSet.getString(6)));
					doc.setProvincia(daoprov.obtenerProvincia(resultSet.getString(7)));
					doc.setEmail(resultSet.getString(8));
					doc.setTelefono(resultSet.getInt(9));
					doc.setEstado(resultSet.getInt(10));
					return doc;
				}

			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
		
		  
		return null;
	}


}
