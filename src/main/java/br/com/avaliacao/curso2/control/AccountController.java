package br.com.avaliacao.curso2.control;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.avaliacao.curso2.entities.Usuario;
import br.com.avaliacao.curso2.repository.IUsuarioRepository;
import br.com.avaliacao.curso2.request.AccountPostRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@Transactional
public class AccountController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	private static final String ENPOINT = "/api/account";
	@ApiOperation("Serviço de criação de conta de usuário.")
	@RequestMapping(value = ENPOINT, method = RequestMethod.POST)
	@CrossOrigin
	
	public ResponseEntity<String> post(@RequestBody AccountPostRequest request){
		
		
		try {		
			
			//verificar se o login informando existe no banco de dados
			if(usuarioRepository.findByLogin(request.getLogin()) != null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("O login informando já está cadastrado no sistema, tente outro");
			}
			
			
			
			
			//cadastrar usuário
			Usuario usuario = new Usuario();
			usuario.setNome(request.getNome());
			usuario.setLogin(request.getLogin());	
			//Aqui chamaremos o método de criptografia
			//modificar depois de criar o método
			
			usuario.setSenha(request.getSenha());//atribuindo a criptografia
						
			usuarioRepository.save(usuario);
			
			return ResponseEntity.status(HttpStatus.OK).body("Conta de usuario criada com sucesso");
			
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			
			
		}
				
	}

}

