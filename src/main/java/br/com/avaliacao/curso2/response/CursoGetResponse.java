package br.com.avaliacao.curso2.response;

public class CursoGetResponse {
	private Integer idCurso;
	private String nome;
	private String sigla;
	public CursoGetResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CursoGetResponse(Integer idCurso, String nome, String sigla) {
		super();
		this.idCurso = idCurso;
		this.nome = nome;
		this.sigla = sigla;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
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
