package entidad;

public class AlumnosXCursos {

	//Atributos
	Cursos curso;
	Alumno alumno;
	int PrimerParcial;
	int SegundoParcial;
	int Recuperatorio1;
	int Recuperatorio2;
	
	public AlumnosXCursos(Cursos curso, Alumno alumno, int primerParcial, int segundoParcial, int recuperatorio1,
			int recuperatorio2) {
		super();
		this.curso = curso;
		this.alumno = alumno;
		PrimerParcial = primerParcial;
		SegundoParcial = segundoParcial;
		Recuperatorio1 = recuperatorio1;
		Recuperatorio2 = recuperatorio2;
	}
	
	public AlumnosXCursos() {
		
	}
	
	public AlumnosXCursos(Cursos curso , Alumno alumno) {
		
		super();
		this.alumno = alumno;
		this.curso =curso;
		this.PrimerParcial = 0;
		this.SegundoParcial = 0;
		this.Recuperatorio1 = 0;
		this.Recuperatorio2 = 0;
	}
	
	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getPrimerParcial() {
		return PrimerParcial;
	}

	public void setPrimerParcial(int primerParcial) {
		PrimerParcial = primerParcial;
	}

	public int getSegundoParcial() {
		return SegundoParcial;
	}

	public void setSegundoParcial(int segundoParcial) {
		SegundoParcial = segundoParcial;
	}

	public int getRecuperatorio1() {
		return Recuperatorio1;
	}

	public void setRecuperatorio1(int recuperatorio1) {
		Recuperatorio1 = recuperatorio1;
	}

	public int getRecuperatorio2() {
		return Recuperatorio2;
	}

	public void setRecuperatorio2(int recuperatorio2) {
		Recuperatorio2 = recuperatorio2;
	}

	@Override
	public String toString() {
		return "AlumnosXCursos [curso=" + curso + ", alumno=" + alumno + ", PrimerParcial=" + PrimerParcial
				+ ", SegundoParcial=" + SegundoParcial + ", Recuperatorio1=" + Recuperatorio1 + ", Recuperatorio2="
				+ Recuperatorio2 + "]";
	}
	
}
