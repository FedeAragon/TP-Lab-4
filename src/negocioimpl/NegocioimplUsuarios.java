package negocioimpl;

import java.util.List;

import daoimpl.DaoimplUsuarios;
import entidad.Docente;
import entidad.Usuario;
import negocio.NegocioUsuarios;

public class NegocioimplUsuarios implements NegocioUsuarios {
    DaoimplUsuarios daousuario = new DaoimplUsuarios();
	
    public List<Usuario> readAll() {
    return daousuario.readAll();
	}

	public int ComprobarUsuario(String nombreUsuario, String password) {
    return daousuario.ComprobarUsuario(nombreUsuario, password);
	}
	
	public boolean TipoCuenta(String usuario){
	return daousuario.TipoCuenta(usuario);
	}
	
	public Docente getDocente(Usuario user) {
	return daousuario.getDocente(user);
	}
}
 