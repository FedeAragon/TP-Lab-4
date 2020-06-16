package entidad;

public class Localidades {

	//Atributos
	int CodLocalidad;
	int CodProvincia;
	String NombreLocalidad;
	
	//Constructores
	public Localidades(int codLocalidad, int codProvincia, String nombreLocalidad) {
		super();
		CodLocalidad = codLocalidad;
		CodProvincia = codProvincia;
		NombreLocalidad = nombreLocalidad;
	}
	
	public Localidades() {
		
	}

	//Gets y Sets
	public int getCodLocalidad() {
		return CodLocalidad;
	}

	public void setCodLocalidad(int codLocalidad) {
		CodLocalidad = codLocalidad;
	}

	public int getCodProvincia() {
		return CodProvincia;
	}

	public void setCodProvincia(int codProvincia) {
		CodProvincia = codProvincia;
	}

	public String getNombreLocalidad() {
		return NombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		NombreLocalidad = nombreLocalidad;
	}

	//toString()
	@Override
	public String toString() {
		return "Localidades [CodLocalidad=" + CodLocalidad + ", CodProvincia=" + CodProvincia + ", NombreLocalidad="
				+ NombreLocalidad + "]";
	}
	
	
}
