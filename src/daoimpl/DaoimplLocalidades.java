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
	private static final String readall = "SELECT * FROM Localidades";

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
		int CodLocalidad = resultSet.getInt("CodLocalidad");
		int CodProvincia = resultSet.getInt("CodProvincia");
		String NombreLocalidad = resultSet.getString("Localidad");
		return new Localidades(CodLocalidad, CodProvincia, NombreLocalidad);
	}
	
	
}