package negocio;

import java.util.List;

import entidad.Usuario;

public interface NegocioUsuarios {

	public List<Usuario> readAll(); 
	public int ComprobarUsuario(String usuario , String password);
	public boolean TipoCuenta(String usuario);
}
