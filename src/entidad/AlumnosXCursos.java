package entidad;

public class AlumnosXCursos {

	//Atributos
	int CodigoCurso;
	int LegajoAlumno;
	int PrimerParcial;
	int SegundoParcial;
	int Recuperatorio1;
	int Recuperatorio2;
	int Estado;
	int EstadoCurso;
	
	//Constructores
	public AlumnosXCursos(int codigoCurso, int legajoAlumno, int primerParcial, int segundoParcial, int recuperatorio1,
			int recuperatorio2, int estado, int estadoCurso) {
		super();
		CodigoCurso = codigoCurso;
		LegajoAlumno = legajoAlumno;
		PrimerParcial = primerParcial;
		SegundoParcial = segundoParcial;
		Recuperatorio1 = recuperatorio1;
		Recuperatorio2 = recuperatorio2;
		Estado = estado;
		EstadoCurso = estadoCurso;
	}
	
	public AlumnosXCursos() {
		
	}
	
	//Gets y sets
	public int getCodigoCurso() {
		return CodigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		CodigoCurso = codigoCurso;
	}

	public int getLegajoAlumno() {
		return LegajoAlumno;
	}

	public void setLegajoAlumno(int legajoAlumno) {
		LegajoAlumno = legajoAlumno;
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

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	public int getEstadoCurso() {
		return EstadoCurso;
	}

	public void setEstadoCurso(int estadoCurso) {
		EstadoCurso = estadoCurso;
	}

	//toString()
	@Override
	public String toString() {
		return "AlumnosXCursos [CodigoCurso=" + CodigoCurso + ", LegajoAlumno=" + LegajoAlumno + ", PrimerParcial="
				+ PrimerParcial + ", SegundoParcial=" + SegundoParcial + ", Recuperatorio1=" + Recuperatorio1
				+ ", Recuperatorio2=" + Recuperatorio2 + ", Estado=" + Estado + ", EstadoCurso=" + EstadoCurso + "]";
	}
	
}
