package entidad;

public class Cursos {

	//Atributos
	int CodigoCurso;
	Materias materia = new Materias();
	String Cuatrimeste;
	int Anio;
	Docente docente = new Docente();
	Boolean Estado;
	
	//Constructores	
	public Cursos(int codigoCurso, Materias materia, String cuatrimeste, int anio, Docente docente, Boolean estado) {
		super();
		CodigoCurso = codigoCurso;
		this.materia = materia;
		Cuatrimeste = cuatrimeste;
		Anio = anio;
		this.docente = docente;
		Estado = estado;
	}
		
	public Cursos() {
		
	}
		
	//Gets y Sets
	public int getCodigoCurso() {
		return CodigoCurso;
	}
	
	public void setCodigoCurso(int codigo) {
		CodigoCurso = codigo;
	}
	
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
	
	public Boolean getEstado() {
		return Estado;
	}
	
	public void setEstado(Boolean estado) {
		Estado = estado;
	}

	//toString();
	@Override
	public String toString() {
		return "Cursos [CodigoCurso=" + CodigoCurso + ", materia=" + materia + ", Cuatrimeste=" + Cuatrimeste
				+ ", Anio=" + Anio + ", docente=" + docente + ", Estado=" + Estado + "]";
	}	
}
