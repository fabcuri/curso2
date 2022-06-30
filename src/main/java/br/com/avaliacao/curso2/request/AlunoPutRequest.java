package br.com.avaliacao.curso2.request;


public class AlunoPutRequest {
	private Integer idAluno;
	private String nome;
	private String endereco;
	public AlunoPutRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlunoPutRequest(Integer idAluno, String nome, String endereco) {
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
