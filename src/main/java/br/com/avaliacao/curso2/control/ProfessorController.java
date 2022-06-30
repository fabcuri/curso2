package br.com.avaliacao.curso2.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacao.curso2.entities.Professor;
import br.com.avaliacao.curso2.repository.IProfessorRepository;
import br.com.avaliacao.curso2.request.AlunoPostRequest;
import br.com.avaliacao.curso2.request.ProfessorGetResponse;
import br.com.avaliacao.curso2.request.ProfessorPutRequest;
import io.swagger.annotations.ApiOperation;


@Controller
@RestController
@Transactional
public class ProfessorController {
	@Autowired
	private IProfessorRepository professorRepository;
	//metodo para
	private static final String ENDPOINT= "api/professores";



	
	@RequestMapping(value=ENDPOINT, method=RequestMethod.POST)
	@ApiOperation("Serviço para cadastro de professores")
	@CrossOrigin
	public ResponseEntity<String>post(@RequestBody AlunoPostRequest request){
		try {
			Professor professor= new Professor();
			professor.setNome(request.getNome());
			professor.setEndereco(request.getEndereco());
		

			professorRepository.save(professor);

			return ResponseEntity.status(HttpStatus.OK).body("Professor cadastrado com sucesso.");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}
	}

	@RequestMapping(value=ENDPOINT, method=RequestMethod.PUT)
    @ApiOperation("Serviço para edição do Professor")
    @CrossOrigin
    public ResponseEntity<String>put(@RequestBody ProfessorPutRequest request){
        try {

            Optional<Professor> item= professorRepository.findById(request.getIdProfessor());
            if(item.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor não encontrado");
            }else {
                Professor professor= item.get();
                professor.setNome(request.getNome());
                professor.setEndereco(request.getEndereco());



                professorRepository.save(professor);
                return ResponseEntity.status(HttpStatus.OK).body("Professor atualizado com sucesso");

            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
        }
    }
	
	@RequestMapping(value=ENDPOINT + "/{idProfessor}", method=RequestMethod.DELETE)
	@ApiOperation("Serviço para exclusão de professor")
	@CrossOrigin
	public ResponseEntity<String>delete(@PathVariable("idProfessor") Integer idProfessor){
		try {
			
			Optional<Professor> item= professorRepository.findById(idProfessor);
			
			if(item.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor não encontrado");
			}else {
				Professor professor= item.get();
				professorRepository.delete(professor);
				return ResponseEntity.status(HttpStatus.OK).body("Professor excluido com sucesso");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}

	}
	
	@RequestMapping(value=ENDPOINT, method=RequestMethod.GET)
	@ApiOperation("Serviço para consulta de Professor")
	@CrossOrigin
	public ResponseEntity<List<ProfessorGetResponse>>get() {
		List<ProfessorGetResponse> response= new ArrayList<ProfessorGetResponse>();
		for(Professor professor: professorRepository.findAll()) {
			ProfessorGetResponse item= new ProfessorGetResponse();
			item.setIdProfessor(professor.getIdProfessor());
			item.setNome(professor.getNome());
			item.setEndereco(professor.getEndereco());
		
		
		

			response.add(item);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	
	@RequestMapping(value=ENDPOINT + "/{idProfessor}", method=RequestMethod.GET)
	@ApiOperation("Serviço para consulta de Professor")
	@CrossOrigin
	public ResponseEntity<ProfessorGetResponse>getById(@PathVariable("idProfessor") Integer idProfessor) {
		Optional<Professor> item= professorRepository.findById(idProfessor);
		if(item.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			ProfessorGetResponse response= new ProfessorGetResponse();
			Professor professor= item.get();
			response.setIdProfessor(professor.getIdProfessor());
			response.setNome(professor.getNome());
			response.setEndereco(professor.getEndereco());
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}
	}
}
