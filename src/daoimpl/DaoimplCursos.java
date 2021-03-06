package daoimpl;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoCursos;
import entidad.Alumno;
import entidad.Cursos;
import entidad.Docente;
import entidad.Materias;

public class DaoimplCursos implements DaoCursos{

	private static final String readall ="Select * from cursos where Estado_c=true";
	private static final String cursosProfe= "Select * from cursos where LegajoProfesor_c = ?";
	private static final String obtenerCodCurso = "SELECT MAX(CodCurso_c) from cursos";
	private static final String readCurso ="Select * from cursos where CodMateria_c = ? AND  LegajoProfesor_c = ? AND A�o_c = ? AND Cuatrimestre_c = ? AND Estado_c = true";
	private static final String obtenerCurso ="SELECT * FROM cursos WHERE CodCurso_c = ? and Estado_c = true";
	
	public boolean obtenerCurso(Cursos curso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readCurso);
				statement.setInt(1,curso.getMateria().getID());
				statement.setInt(2,curso.getDocente().getLegajo());
				statement.setInt(3,curso.getAnio());
				statement.setInt(4,curso.getCuatrimeste());
				resultSet = statement.executeQuery();
				
				if(resultSet.next())
				{
					return true;
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();  
			}
			return false;
			
		}
	
	public int ObtenerCodCurso() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			int CodCurso = -1;
     		PreparedStatement statement;
			ResultSet resultSet; 
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(obtenerCodCurso);
				resultSet = statement.executeQuery();
				
				if(resultSet.next())
				{ 
				CodCurso = resultSet.getInt(1);
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();  
			}
			return CodCurso;
	}
	
	@Override
	public List<Cursos> readAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			ArrayList<Cursos> curso = new ArrayList<Cursos>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readall);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					curso.add(getCurso(resultSet));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();  
			}
			return curso;
			
		}


	private Cursos getCurso(ResultSet resultset) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int codCurso = resultset.getInt(1);
		int codmateria = resultset.getInt(2);
		int LegDocente = resultset.getInt(3) ;
		int Anio = resultset.getInt(4);
		int Cuatrimestre =resultset.getInt(5);
		int Estado= resultset.getInt(6);
		
		DaoimplProfesores daoimplProfes= new  DaoimplProfesores();
		Docente profe =new Docente();
		DaoimplMaterias daoimplMates = new DaoimplMaterias();
		Materias mat = new Materias();
		if(daoimplProfes.obtenerProfesor(LegDocente)!=null) {
			profe= daoimplProfes.obtenerProfesor(LegDocente);
		}
		if(daoimplMates.obtenerMateria(codmateria)!=null) {
			mat = daoimplMates.obtenerMateria(codmateria);
		}
		
		return new Cursos(codCurso,mat,Cuatrimestre,Anio,profe, Estado);
		
	}

	@Override
	public boolean spAgregarCurso(Cursos curso) {
		Conexion conexion = Conexion.getConexion();
		boolean anduvo=false;
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spAgregarCurso(?,?,?,?) ");
	            proc.setInt(1, curso.getMateria().getID());
	            proc.setInt(2, curso.getDocente().getLegajo());
	            proc.setInt(3, curso.getAnio());
	            proc.setInt(4, curso.getCuatrimeste());
	            proc.execute();
	            anduvo = true;             
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
	
		
		return anduvo;
		
		
	}




	@Override
	public boolean spModificarCurso(Cursos curso) {
		Conexion conexion = Conexion.getConexion();
		 boolean funco = false;
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spModificarCurso(?,?,?,?,?) ");
	            proc.setInt(1, curso.getMateria().getID());
	            proc.setInt(2, curso.getDocente().getLegajo());
	            proc.setInt(3, curso.getAnio());
	            proc.setInt(4, curso.getCuatrimeste());
	            proc.setInt(5, curso.getCodCurso());
	            proc.execute();   
	            funco = true;
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		return funco;
	}




	@Override
	public boolean spEliminarCurso(Cursos curso) {
      Conexion conexion = Conexion.getConexion();
             boolean funco = false;
		
		try {    	    
	            CallableStatement proc = conexion.getSQLConexion().prepareCall(" CALL spEliminarCurso(?) ");
	            proc.setInt(1, curso.getCodCurso());
	            proc.execute();    
	            funco = true;
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
		return funco;
	}
	
	public List<Cursos> CursosProfe(int Legajo_p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
     		PreparedStatement statement;
			ResultSet resultSet; 
			ArrayList<Cursos> curso = new ArrayList<Cursos>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(cursosProfe);
				statement.setInt(1,Legajo_p);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					curso.add(getCurso(resultSet));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();  
			}
			return curso;
			
		}
	
	public Cursos saberCurso(int CodCurso) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			Cursos curso = new Cursos();
			DaoimplProfesores daoimplProfes= new  DaoimplProfesores();
			Docente profe =new Docente();
			DaoimplMaterias daoimplMates = new DaoimplMaterias();
			Materias mat = new Materias();
			
		 	PreparedStatement statement;
		   ResultSet resultSet; 
		   Conexion conexion = Conexion.getConexion();
		   try{
				
				statement = conexion.getSQLConexion().prepareStatement(obtenerCurso);
				statement.setInt(1,CodCurso);
				
				resultSet = statement.executeQuery();
				if(resultSet.next())
				{ 
					curso.setCodCurso(resultSet.getInt(1));
					curso.setMateria(daoimplMates.obtenerMateria(resultSet.getInt(2)));
					curso.setDocente(daoimplProfes.obtenerProfesor(resultSet.getInt(3)));
					curso.setAnio(resultSet.getInt(4));
					curso.setCuatrimeste(resultSet.getInt(5));
					curso.setEstado(resultSet.getInt(6));
				
					resultSet = statement.executeQuery();
					return curso;
				}

			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
		
		  
		return null;
	}
	

}
