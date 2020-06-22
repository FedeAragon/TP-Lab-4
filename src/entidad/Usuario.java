package entidad;

public class Usuario {

	//Atributos
	String Usuario;
	int Password;
	int TipoCuenta;
	int Estado;
	
	//Constructores
	public Usuario(int tipoCuenta, String usuario, int password , int estado) {
		TipoCuenta = tipoCuenta;
		Usuario = usuario;
		Password = password;
		Estado = estado;
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

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	//toString();
	@Override
	public String toString() {
		return "Usuario [Usuario=" + Usuario + ", Password=" + Password + ", TipoCuenta=" + TipoCuenta + ", Estado="
				+ Estado + "]";
	}		
}
