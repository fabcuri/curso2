package br.com.avaliacao.curso2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.curso2.entities.Aluno;






	@Repository
	public interface IAlunoRepository extends CrudRepository<Aluno,Integer>{
		@Query(value="Select * from aluno where id_turma=?1",nativeQuery= true)
		List<Aluno> findByIdTurma(Integer idTurma);

	}
