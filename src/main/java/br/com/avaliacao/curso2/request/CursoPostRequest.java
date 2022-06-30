package br.com.avaliacao.curso2.request;

public class CursoPostRequest {
	private String nome;
	private String sigla;
	public CursoPostRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CursoPostRequest(String nome, String sigla) {
		super();
		this.nome = nome;
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
