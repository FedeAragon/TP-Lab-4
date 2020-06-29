package entidad;

public class Cursos {

	//Atributos
	int CodCurso;
	Materias materia = new Materias();
	int Cuatrimeste;
	int Anio;
	Docente docente = new Docente();
	int Estado;
	
	public Cursos(int codCurso, Materias materia, int cuatrimeste, int anio, Docente docente, int estado) {
		super();
		CodCurso = codCurso;
		this.materia = materia;
		Cuatrimeste = cuatrimeste;
		Anio = anio;
		this.docente = docente;
		Estado = estado;
	}
	
	public Cursos() {
		// TODO Auto-generated constructor stub
	}

	public int getCodCurso() {
		return CodCurso;
	}
	public void setCodCurso(int codCurso) {
		CodCurso = codCurso;
	}
	public Materias getMateria() {
		return materia;
	}
	public void setMateria(Materias materia) {
		this.materia = materia;
	}
	public int getCuatrimeste() {
		return Cuatrimeste;
	}
	public void setCuatrimeste(int cuatrimeste) {
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
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	@Override
	public String toString() {
		return "Cursos [CodCurso=" + CodCurso + ", materia=" + materia + ", Cuatrimeste=" + Cuatrimeste + ", Anio="
				+ Anio + ", docente=" + docente + ", Estado=" + Estado + "]";
	}
	
	
}
