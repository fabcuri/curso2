package br.com.avaliacao.curso2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.curso2.entities.Curso;








	@Repository
	public interface ICursoRepository extends CrudRepository<Curso,Integer>{

	}
