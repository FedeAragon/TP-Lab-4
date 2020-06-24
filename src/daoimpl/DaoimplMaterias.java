package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoMaterias;
import entidad.Docente;
import entidad.Materias;

public class DaoimplMaterias implements DaoMaterias {

	private static final String readall = "SELECT * FROM materias";
	private static final String obtenermateria="SELECT * FROM materias where CodMateria_m=?";
	
public List<Materias> readAll() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			ArrayList<Materias> materia = new ArrayList<Materias>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readall);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					materia.add(getMateria(resultSet));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();  
			}
			return materia;
			 
		}
	
	
	private Materias getMateria(ResultSet resultSet) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		int codMateria = resultSet.getInt(1);
		String descripcion = resultSet.getString(2);
		return new Materias(codMateria, descripcion);	 	
	}


	@Override
	public Materias obtenerMateria(int id_materia) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			Materias mat= new Materias();
			
		 	PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		   try{
				
				statement = conexion.getSQLConexion().prepareStatement(obtenermateria);
				statement.setInt(1,id_materia);
				
				resultSet = statement.executeQuery();
				if(resultSet.next())
				{ 
					mat.setID(resultSet.getInt(1));
					mat.setDescripcion(resultSet.getString(2));
					return mat;
				}

			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
		
		return null;
	} 
}
