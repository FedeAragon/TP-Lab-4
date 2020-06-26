package dao;

import java.util.List;

import entidad.Cursos;

public interface DaoCursos {
	public List<Cursos> readAll();
	public boolean spAgregarCurso(Cursos curso);
	public boolean spModificarCurso(Cursos curso);
	public boolean spEliminarCurso(Cursos curso);
}
