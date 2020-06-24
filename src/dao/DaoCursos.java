package dao;

import java.util.List;

import entidad.Cursos;

public interface DaoCursos {
	public List<Cursos> readAll();
	public void spAgregarCurso(Cursos curso);
	public void spModificarCurso(Cursos curso);
	public void spEliminarCurso(Cursos curso);
}
