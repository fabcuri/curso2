package br.com.avaliacao.curso2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name="professor")
public class Professor{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "idprofessor")
	private Integer idProfessor;
	
	@Column(name= "nome",length=50, nullable=false)
	private String nome;
	
	@Column(name= "endereco", nullable=false)
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name="idCurso")
	private Curso curso;

	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professor(Integer idProfessor, String nome, String endereco) {
		super();
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.endereco = endereco;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	
	
}