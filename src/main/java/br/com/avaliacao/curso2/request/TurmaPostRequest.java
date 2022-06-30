package br.com.avaliacao.curso2.request;

public class TurmaPostRequest {
	private Integer semestre;
	private Integer ano;
	public TurmaPostRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TurmaPostRequest(Integer semestre, Integer ano) {
		super();
		this.semestre = semestre;
		this.ano = ano;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
