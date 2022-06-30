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

import br.com.avaliacao.curso2.entities.Aluno;
import br.com.avaliacao.curso2.entities.Turma;
import br.com.avaliacao.curso2.repository.IAlunoRepository;
import br.com.avaliacao.curso2.repository.ITurmaRepository;
import br.com.avaliacao.curso2.request.TurmaPostRequest;
import br.com.avaliacao.curso2.request.TurmaPutRequest;
import br.com.avaliacao.curso2.response.TurmaAlunosGetResponse;
import br.com.avaliacao.curso2.response.TurmaGetResponse;
import io.swagger.annotations.ApiOperation;


@Controller
@RestController
@Transactional
public class TurmaController {
	@Autowired
	private ITurmaRepository turmaRepository;
	@Autowired
	private IAlunoRepository alunoRepository;
	//metodo para
	private static final String ENDPOINT= "api/turmas";



	
	@RequestMapping(value=ENDPOINT, method=RequestMethod.POST)
	@ApiOperation("Serviço para cadastro de turmas")
	@CrossOrigin
	public ResponseEntity<String>post(@RequestBody TurmaPostRequest request){
		try {
			Turma turma= new Turma();
			turma.setSemestre(request.getSemestre());
			turma.setAno(request.getAno());
		

			turmaRepository.save(turma);

			return ResponseEntity.status(HttpStatus.OK).body("Turma cadastrada com sucesso.");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}
	}

	@RequestMapping(value=ENDPOINT, method=RequestMethod.PUT)
    @ApiOperation("Serviço para edição da Turma")
    @CrossOrigin
    public ResponseEntity<String>put(@RequestBody TurmaPutRequest request){
        try {

            Optional<Turma> item= turmaRepository.findById(request.getIdTurma());
            if(item.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Turma não encontrada");
            }else {
                Turma turma= item.get();
                turma.setSemestre(request.getSemestre());
                turma.setAno(request.getAno());



                turmaRepository.save(turma);
                return ResponseEntity.status(HttpStatus.OK).body("Turma atualizada com sucesso");

            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
        }
    }
	@RequestMapping(value=ENDPOINT + "/{idTurma}", method=RequestMethod.DELETE)
	@ApiOperation("Serviço para exclusão da turma")
	@CrossOrigin
	public ResponseEntity<String>delete(@PathVariable("idTurma") Integer idTurma){
		try {
			
			Optional<Turma> item= turmaRepository.findById(idTurma);
			
			if(item.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Turma não encontrado");
			}else {
				Turma turma= item.get();
				turmaRepository.delete(turma);
				return ResponseEntity.status(HttpStatus.OK).body("Turma excluido com sucesso");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}

	}
	
	@RequestMapping(value=ENDPOINT, method=RequestMethod.GET)
	@ApiOperation("Serviço para consulta de turma")
	@CrossOrigin
	public ResponseEntity<List<TurmaGetResponse>>get() {
		List<TurmaGetResponse> response= new ArrayList<TurmaGetResponse>();
		for(Turma turma: turmaRepository.findAll()) {
			TurmaGetResponse item= new TurmaGetResponse();
			item.setIdTurma(turma.getIdTurma());
			item.setSemestre(turma.getSemestre());
			item.setAno(turma.getAno());
		
		
		

			response.add(item);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	
	@RequestMapping(value=ENDPOINT + "/{idTurma}", method=RequestMethod.GET)
	@ApiOperation("Serviço para consulta de turma")
	@CrossOrigin
	public ResponseEntity<TurmaAlunosGetResponse>getById(@PathVariable("idTurma") Integer idTurma) {
		Optional<Turma> item= turmaRepository.findById(idTurma);
		if(item.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			TurmaAlunosGetResponse response= new TurmaAlunosGetResponse();
			Turma turma= item.get();		
			response.setSemestre(turma.getSemestre());
			List<Aluno> alunos = alunoRepository.findByIdTurma(turma.getIdTurma());
			for(Aluno aluno:alunos) {
				response.getNomesAlunos().add(aluno.getNome());
			}
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		}
	}
	
}
