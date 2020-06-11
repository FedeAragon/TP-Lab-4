package entidad;

public class Usuario {

	//Atributos
	int ID;
	int TipoCuenta;
	String NombreUsuario;
	String Password;
	
	//Constructores
	public Usuario(int iD, int tipoCuenta, String nombreUsuario, String password) {
		super();
		ID = iD;
		TipoCuenta = tipoCuenta;
		NombreUsuario = nombreUsuario;
		Password = password;
	}
	
	public Usuario() {
		
	}

	//Gets y Sets
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

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
		return "Usuario [ID=" + ID + ", TipoCuenta=" + TipoCuenta + ", NombreUsuario=" + NombreUsuario + ", Password="
				+ Password + "]";
	}
			
}
