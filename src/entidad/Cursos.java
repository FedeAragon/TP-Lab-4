package entidad;

public class Cursos {

	//Atributos
	int Comision;
	Materias materia = new Materias();
	String Cuatrimeste;
	int Anio;
	Docente docente = new Docente();
	Boolean Estado;
	
	//Constructores	
	public Cursos(int comision, Materias materia, String cuatrimeste, int anio, Docente docente, Boolean estado) {
		super();
		Comision = comision;
		this.materia = materia;
		Cuatrimeste = cuatrimeste;
		Anio = anio;
		this.docente = docente;
		Estado = estado;
	}
		
	public Cursos() {
		
	}
		
	//Gets y Sets
	public int getComision() {
		return Comision;
	}
	
	public void setComision(int comision) {
		Comision = comision;
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
		return "Cursos [CodigoCurso=" + Comision + ", materia=" + materia + ", Cuatrimeste=" + Cuatrimeste
				+ ", Anio=" + Anio + ", docente=" + docente + ", Estado=" + Estado + "]";
	}	
}
