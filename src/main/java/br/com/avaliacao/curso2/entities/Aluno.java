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
@Table(name="aluno")
public class Aluno{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "idaluno")
	private Integer idAluno;
	
	@Column(name= "nome",length=50, nullable=false)
	private String nome;
	
	@Column(name= "endereco", nullable=false)
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name="idTurma")
	private Turma turma;
	
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(Integer idAluno, String nome, String endereco) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.endereco = endereco;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
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

