package daoimpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoUsuarios;
import entidad.Docente;
import entidad.Localidades;
import entidad.Provincias;
import entidad.Usuario;

public class DaoimplUsuarios implements DaoUsuarios
{
	private static final String readall = "SELECT * FROM usuarios";
	private static final String comprobar = "SELECT * FROM usuarios WHERE Usuario =? AND Contraseña =? AND Estado = true";
	private static final String tipo = "SELECT * FROM usuarios WHERE Usuario =? AND TipoCuenta = true";
	private static final String UsuarioDocente = "SELECT Legajo_p,DNI_p,NombreApellido_p,Nacimiento_p,Direccion_p,CodLocalidad_p,CodProvincia_p,Email_p,Telefono_p,Estado_p FROM profesores inner join usuarios on Usuario = Email_p where Usuario = ? ";
	
public List<Usuario> readAll() {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Usuario> usuario = new ArrayList<Usuario>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				usuario.add(getUsuario(resultSet));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return usuario;
		
	}
	
	
	private Usuario getUsuario(ResultSet resultSet) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		String Nombreu = resultSet.getString(1);
		String Contra = resultSet.getString(2);
		int tipoCuenta = resultSet.getInt(3); 
		int Estado = resultSet.getInt(4);
		return new Usuario(tipoCuenta , Nombreu , Contra , Estado);
	}  
		
	public int ComprobarUsuario(String nombre , String password)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		   int comprobado = 0;
		   PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		
		try{
			
			statement = conexion.getSQLConexion().prepareStatement(comprobar);
			statement.setString(1, nombre);
			statement.setString(2, password);
			resultSet = statement.executeQuery();

			if(resultSet.next())
			{ 
				comprobado ++;
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return comprobado;
	}
	
	public boolean TipoCuenta(String usuario) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		   PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		
		try{
			
			statement = conexion.getSQLConexion().prepareStatement(tipo);
			statement.setString(1, usuario);
			resultSet = statement.executeQuery();

			if(resultSet.next())
			{ 
				return true;
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return false;
	}
	
	public Docente getDocente(Usuario user)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Docente prof = new Docente();
		   PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		   try{
				
				statement = conexion.getSQLConexion().prepareStatement(UsuarioDocente);
				statement.setString(1, user.getUsuario());
				resultSet = statement.executeQuery();
				
				if(resultSet.next())
				{ 
					prof.setLegajo(resultSet.getInt(1));;
					prof.setDNI(resultSet.getInt(2));
					prof.setNombreyAp(resultSet.getString(3));
					prof.setFechaNacimiento(resultSet.getDate(4));
					prof.setDireccion(resultSet.getString(5));
					String codLocalidad = resultSet.getString(6);
					String codProvincia = resultSet.getString(7);
					DaoimplLocalidades daoimplocalidades = new DaoimplLocalidades();
					Localidades loca = new Localidades();
			         if (daoimplocalidades.obtenerLocalidad(codLocalidad) != null) {
			        	  loca =  daoimplocalidades.obtenerLocalidad(codLocalidad);
			         }
			        prof.setLocalidad(loca);
			        DaoimplProvincias daoimplprov = new DaoimplProvincias();
			        Provincias prov = new Provincias();
			         if(daoimplprov.obtenerProvincia(codProvincia) != null) {
			        	 prov = daoimplprov.obtenerProvincia(codProvincia);
			         }
			        prof.setProvincia(prov);
			        prof.setEmail(resultSet.getString(8));
					prof.setTelefono(resultSet.getInt(9));
					prof.setEstado(resultSet.getInt(10));
				}
			    
			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
	 	return prof;	
	}
}
