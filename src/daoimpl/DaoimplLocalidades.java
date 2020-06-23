package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoLocalidades;
import daoimpl.Conexion;
import entidad.Localidades;


public class DaoimplLocalidades implements DaoLocalidades
{
	private static final String readall = "SELECT * FROM localidades";
	private static final String Completa = "SELECT * FROM localidades WHERE IDLocalidad_loc = ?";

	public List<Localidades> readAll() {
	
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Localidades> localidades = new ArrayList<Localidades>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidades.add(getLocalidad(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidades;
		
	}
	
	
	private Localidades getLocalidad(ResultSet resultSet) throws SQLException
	{
		String CodLocalidad = resultSet.getString ("IDLocalidad_loc");
		String CodProvincia = resultSet.getString("IDProvincia_loc");
		String NombreLocalidad = resultSet.getString("Descripcion_loc");
		return new Localidades(CodLocalidad, CodProvincia, NombreLocalidad);
	}
	
	public Localidades obtenerLocalidad(String id_localidad) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		   
		Localidades loca = new Localidades();
		   PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		
		try{
			
			statement = conexion.getSQLConexion().prepareStatement(Completa);
			statement.setString(1,id_localidad);
			
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{ 
				
				loca.setCodLocalidad(resultSet.getString(1));
				loca.setNombreLocalidad(resultSet.getString(2));
				loca.setCodProvincia(resultSet.getString(3));
				return loca;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
	
		
		return null;
	}
	
}