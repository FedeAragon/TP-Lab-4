package entidad;

public class Usuario {

	//Atributos
	String Usuario;
	int Password;
	int TipoCuenta;
	
	//Constructores
	public Usuario(int tipoCuenta, String nombreUsuario, int password) {
		TipoCuenta = tipoCuenta;
		Usuario = nombreUsuario;
		Password = password;
	}
	
	public Usuario() {
		
	}

	//Gets y Sets
	public int getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(int tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	
	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}


	//toString();
	@Override
	public String toString() {
		return "Usuario [TipoCuenta=" + TipoCuenta + ", NombreUsuario=" + Usuario + ", Password="
				+ Password + "]";
	}
			
}
