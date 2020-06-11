package entidad;

public class Cursos {

	//Atributos
	Materias materia = new Materias();
	String Cuatrimeste;
	int Anio;
	Docente docente = new Docente();
	
	//Constructores
	public Cursos(Materias materia, String cuatrimeste, int anio, Docente docente) {
		this.materia = materia;
		Cuatrimeste = cuatrimeste;
		Anio = anio;
		this.docente = docente;
	}
	
	public Cursos() {
		
	}
		
	//Gets y Sets
	public Materias getMateria() {
		return materia;
	}

	public void setMateria(Materias materia) {
		this.materia = materia;
	}

	public String getCuatrimeste() {
		return Cuatrimeste;
	}

	public void setCuatrimeste(String cuatrimeste) {
		Cuatrimeste = cuatrimeste;
	}

	public int getAnio() {
		return Anio;
	}

	public void setAnio(int anio) {
		Anio = anio;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	//toString();
	@Override
	public String toString() {
		return "Cursos [materia=" + materia + ", Cuatrimeste=" + Cuatrimeste + ", Anio=" + Anio + ", docente=" + docente
				+ "]";
	}	
	
}
