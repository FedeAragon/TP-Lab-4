package entidad;

import java.sql.Date;

public class Alumno {

	//Atributos
	int Legajo;
	int DNI;
	String NombreyAp;
	Date FechaNacimiento;
	String Direccion;
	Localidades Localidad;
	Provincias Provincia;
	String Email;
	int Telefono;
	int Estado;
	
	//Constructores
	public Alumno(int legajo, int dNI, String nombreyAp, Date fechaNacimiento, String direccion, Localidades localidad,
			Provincias provincia, String email, int telefono , int estado) {
		Legajo = legajo;
		DNI = dNI;
		NombreyAp = nombreyAp;
		FechaNacimiento = fechaNacimiento;
		Direccion = direccion;
		Localidad=localidad;
		Provincia= provincia;
		Email = email;
		Telefono = telefono;
		Estado = estado;
	}	
	
	public Alumno() {
	
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

	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public Localidades getLocalidad() {
		return Localidad;
	}

	public Provincias getProvincia() {
		return Provincia;
	}
	
	public void setLocalidad(Localidades localidad) {
		Localidad = localidad;
	}

	public void setProvincia(Provincias provincia) {
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
		
	public int getEstado() {
		return Estado;
	}
	
	public void setEstado(int estado) {
		Estado = estado;
	}
	
	//toString();
	@Override
	public String toString() {
		return "Alumno [Legajo=" + Legajo + ", DNI=" + DNI + ", NombreyAp=" + NombreyAp + ", FechaNacimiento="
				+ FechaNacimiento + ", Direccion=" + Direccion + ", Localidad=" + Localidad.getNombreLocalidad() + ", Provincia=" + Provincia.getNombreProvincia()
				+ ", Email=" + Email + ", Telefono=" + Telefono + ", Estado=" + Estado + "]";
	}	
}
