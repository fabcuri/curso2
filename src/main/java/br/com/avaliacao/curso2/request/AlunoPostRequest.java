package br.com.avaliacao.curso2.request;

public class AlunoPostRequest {
	private String nome;
	private String endereco;
	public AlunoPostRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlunoPostRequest(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
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