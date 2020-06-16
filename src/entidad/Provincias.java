package entidad;

public class Provincias {

	//Atributos
	int CodProvincia;
	String NombreProvincia;
	
	//Constructores 
	public Provincias(int codProvincia, String nombreProvincia) {
		super();
		CodProvincia = codProvincia;
		NombreProvincia = nombreProvincia;
	}
	
	public Provincias() {
		
	}

	//Gets y Sets
	public int getCodProvincia() {
		return CodProvincia;
	}

	public void setCodProvincia(int codProvincia) {
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
