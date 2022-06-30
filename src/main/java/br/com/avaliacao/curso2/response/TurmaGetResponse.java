package br.com.avaliacao.curso2.response;

public class TurmaGetResponse {
	private Integer idTurma;
	private Integer semestre;
	private Integer ano;
	public TurmaGetResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TurmaGetResponse(Integer idTurma, Integer semestre, Integer ano) {
		super();
		this.idTurma = idTurma;
		this.semestre = semestre;
		this.ano = ano;
	}
	public Integer getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
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
