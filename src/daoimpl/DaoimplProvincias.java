package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoProvincias;
import entidad.Provincias;

public class DaoimplProvincias implements DaoProvincias
{
	private static final String readall = "SELECT * FROM Provincias";

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
		int CodProvincia = resultSet.getInt("CodProvincia");
		String NombreProvincia = resultSet.getString("Provincia");
		return new Provincias(CodProvincia, NombreProvincia);
	}
}
