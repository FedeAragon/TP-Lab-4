package negocio;

import java.util.List;

import entidad.Cursos;

public interface NegocioCursos {
	public List<Cursos> readAll();
	public boolean spAgregarCurso(Cursos curso);
	public boolean spModificarCurso(Cursos curso);
	public boolean spEliminarCurso(Cursos curso);
	public List<Cursos> CursosProfe(int Legajo_p);
	public int ObtenerCodCurso() ;
	public boolean obtenerCurso(Cursos curso);
	public Cursos saberCurso(int CodCurso);
}
