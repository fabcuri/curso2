package br.com.avaliacao.curso2.request;

public class ProfessorPutRequest {

	private Integer idProfessor;
	private String nome;
	private String endereco;
	public ProfessorPutRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfessorPutRequest(Integer idProfessor, String nome, String endereco) {
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
