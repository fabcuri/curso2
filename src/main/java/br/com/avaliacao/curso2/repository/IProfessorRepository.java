package br.com.avaliacao.curso2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.curso2.entities.Aluno;
import br.com.avaliacao.curso2.entities.Professor;






	@Repository
	public interface IProfessorRepository extends CrudRepository<Professor,Integer>{
		@Query(value="Select * from professor where id_curso=?1",nativeQuery= true)
		List<Professor> findByIdCurso(Integer idCurso);
	}
