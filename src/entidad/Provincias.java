package entidad;

public class Provincias {

	//Atributos
	String CodProvincia;
	String NombreProvincia;
	
	//Constructores 
	public Provincias(String codProvincia, String nombreProvincia) {
		super();
		CodProvincia = codProvincia;
		NombreProvincia = nombreProvincia;
	}
	
	public Provincias() {
		
	}

	//Gets y Sets
	public String getCodProvincia() {
		return CodProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		CodProvincia = codProvincia;
	}

	public String getNombreProvincia() {
		return NombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		NombreProvincia = nombreProvincia;
	}

	//toString()
	@Override
	public String toString() {
		return "Provincias [CodProvincia=" + CodProvincia + ", NombreProvincia=" + NombreProvincia + "]";
	}
	
	
}
