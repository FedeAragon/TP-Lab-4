package negocioimpl;

import java.util.List;

import daoimpl.DaoimplUsuarios;
import entidad.Usuario;
import negocio.NegocioUsuarios;

public class NegocioimplUsuarios implements NegocioUsuarios {
    DaoimplUsuarios daousuario = new DaoimplUsuarios();
	
    public List<Usuario> readAll() {
    return daousuario.readAll();
	}

	public int ComprobarUsuario(String nombreUsuario, int password) {
    return daousuario.ComprobarUsuario(nombreUsuario, password);
	}

}
 