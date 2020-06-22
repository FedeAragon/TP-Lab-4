package dao;

import java.util.List;

import entidad.Usuario;

public interface DaoUsuarios {

	public List<Usuario> readAll(); 
	public int ComprobarUsuario(String usuario , String password);
}
