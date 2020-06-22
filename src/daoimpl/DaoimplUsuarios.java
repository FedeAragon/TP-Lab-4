package daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoUsuarios;
import entidad.Usuario;

public class DaoimplUsuarios implements DaoUsuarios
{
	private static final String readall = "SELECT * FROM usuarios";
	private static final String comprobar = "SELECT * FROM usuarios WHERE Usuario =? AND Contraseña =? AND Estado = true";

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
		int Contra = resultSet.getInt(2);
		int tipoCuenta = resultSet.getInt(3); 
		return new Usuario(tipoCuenta , Nombreu , Contra);
	}  
		
	public int ComprobarUsuario(String nombre , String password)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
	
	
	
	
}
