package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoProvincias;
import entidad.Localidades;
import entidad.Provincias;

public class DaoimplProvincias implements DaoProvincias
{
	private static final String readall = "SELECT * FROM provincias";
	private static final String obtenerprovincia = "SELECT * FROM provincias WHERE IDProvincia_p = ?";

	public List<Provincias> readAll() {
		
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Provincias> provincias = new ArrayList<Provincias>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				provincias.add(getProvincia(resultSet));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return provincias;
		
	}
	
	private Provincias getProvincia(ResultSet resultSet) throws SQLException
	{
		String CodProvincia = resultSet.getString("IDProvincia_p");
		String NombreProvincia = resultSet.getString("NombreProvincia_p");
		return new Provincias(CodProvincia, NombreProvincia);
	}
	
   public Provincias obtenerProvincia(String id_provincia) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		   
		Provincias prov = new Provincias();
		   PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		
		try{
			
			statement = conexion.getSQLConexion().prepareStatement(obtenerprovincia);
			statement.setString(1,id_provincia);
			
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{ 
				
				
				prov.setCodProvincia(resultSet.getString(1));
				prov.setNombreProvincia(resultSet.getString(2));
				return prov;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
	
		
		return null;
	}
}
