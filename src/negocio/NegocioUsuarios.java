package negocio;

import java.util.List;

import entidad.Docente;
import entidad.Usuario;

public interface NegocioUsuarios {

	public List<Usuario> readAll(); 
	public int ComprobarUsuario(String usuario , String password);
	public boolean TipoCuenta(String usuario);
	public Docente getDocente(Usuario user);
}
