package negocio;

import java.util.List;

import entidad.Cursos;

public interface NegocioCursos {
	public List<Cursos> readAll();
	public boolean spAgregarCurso(Cursos curso);
	public void spModificarCurso(Cursos curso);
	public void spEliminarCurso(Cursos curso);
}
