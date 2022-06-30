package br.com.avaliacao.curso2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.curso2.entities.Turma;








	@Repository
	public interface ITurmaRepository extends CrudRepository<Turma,Integer>{

	}
