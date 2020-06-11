package entidad;

public class Docente {
	
	//Atributos
    int Legajo;
	int DNI;
	String NombreyAp;
	String FechaNacimiento;
	String Direccion;
	String Localidad;
	String Provincia;
	String Email;
	int Telefono;
	
	//Constructores
	public Docente(int legajo, int dNI, String nombreyAp, String fechaNacimiento, String direccion, String localidad,
			String provincia, String email, int telefono) {
		Legajo = legajo;
		DNI = dNI;
		NombreyAp = nombreyAp;
		FechaNacimiento = fechaNacimiento;
		Direccion = direccion;
		Localidad = localidad;
		Provincia = provincia;
		Email = email;
		Telefono = telefono;
	}
	
	public Docente() {
		
	}
	
	//Gets y Sets
	public int getLegajo() {
		return Legajo;
	}

	public void setLegajo(int legajo) {
		Legajo = legajo;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getNombreyAp() {
		return NombreyAp;
	}

	public void setNombreyAp(String nombreyAp) {
		NombreyAp = nombreyAp;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	
	//toString();
	@Override
	public String toString() {
		return "Docente [Legajo=" + Legajo + ", DNI=" + DNI + ", NombreyAp=" + NombreyAp + ", FechaNacimiento="
				+ FechaNacimiento + ", Direccion=" + Direccion + ", Localidad=" + Localidad + ", Provincia=" + Provincia
				+ ", Email=" + Email + ", Telefono=" + Telefono + "]";
	}	

}
