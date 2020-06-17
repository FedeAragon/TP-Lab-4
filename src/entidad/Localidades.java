package entidad;

public class Localidades {

	//Atributos
	String CodLocalidad;
	String CodProvincia;
	String NombreLocalidad;
	
	//Constructores
	public Localidades(String codLocalidad, String codProvincia, String nombreLocalidad) {
		super();
		CodLocalidad = codLocalidad;
		CodProvincia = codProvincia;
		NombreLocalidad = nombreLocalidad;
	}
	
	public Localidades() {
		
	}

	//Gets y Sets
	public String getCodLocalidad() {
		return CodLocalidad;
	}

	public void setCodLocalidad(String codLocalidad) {
		CodLocalidad = codLocalidad;
	}

	public String getCodProvincia() {
		return CodProvincia;
	}

	public void setCodProvincia(String codProvincia) {
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
