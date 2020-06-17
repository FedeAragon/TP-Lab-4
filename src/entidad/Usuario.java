package entidad;

public class Usuario {

	//Atributos
	int TipoCuenta;
	String NombreUsuario;
	String Password;
	
	//Constructores
	public Usuario(int tipoCuenta, String nombreUsuario, String password) {
		TipoCuenta = tipoCuenta;
		NombreUsuario = nombreUsuario;
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

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	//toString();
	@Override
	public String toString() {
		return "Usuario [TipoCuenta=" + TipoCuenta + ", NombreUsuario=" + NombreUsuario + ", Password="
				+ Password + "]";
	}
			
}
